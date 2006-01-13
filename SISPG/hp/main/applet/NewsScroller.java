package applet;

/**
* An applet that reads "news" from a text file with headlines and URLs and
* presents the information in a vertical scroll. Each message may have,
* independent of the others, a URL (and optional target) to jump to when it is
* clicked upon.
* <P>
* This program is copyrighted 1999 by the author under the GNU Public License
* (GPL). Full text of this license is available at
* <A HREF="http://www.gnu.org">GNU.org</A>.
* <P>
* For full usage information, see
* <A HREF="http://www.io.com/~crackers">my web pages</A>.
*
* @author E. A. Graham, Jr. (crackers@io.com)
* @version 2.0
* @see WebBase
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class NewsScroller extends WebBase implements MouseListener
{
	/**
	* The font to use for headlines.
	*/
	private Font fontHeadline;
	/**
	* The font to use for the message body.
	*/
	private Font fontMessage;
	/**
	* The color used for "clickable" messages.
	*/
	private Color clickColor;
	/**
	* The color used for headlines.
	*/
	private Color headColor;
	/**
	* The current "top" message: used for pausing.
	*/
	private NewsMessage msgTop = null;
	/**
	* The file (actually a URL) to read the news items from.
	*/
	private String fileName = null;
	/**
	* Contains all of the currently loaded news items.
	*/
	private Vector vMessages = new Vector();
	/**
	* Contains all of the newly read news items.
	*/
	private Vector vNewMessages = null;
	/**
	* The gap, in pixels, between messages. This hardcoded value seems
	* adequate.
	*/
	private int gap = 15;
	/**
	* Flag to indicate that scrolling should stop when the mouse is over the
	* applet.
	*/
	private boolean mouse_pause = false;
	/**
	* Flag to indicate that the scrolling should stop (mouse is over the
	* applet).
	*/
	private boolean pause_now = false;
	/**
	* The duration in milliseconds that scrolling should stop when a message
	* reaches the top of the applet.
	*/
	private long top_pause = 0;

	/**
	* Applet initialization.
	*/
	public void init()
	{
		// a lot of the parameters and such are read in the base class, so do
		// that setup first (required)
		super.init();

		String  sp;

		// Retrieve the PARAMs specific for this applet incarnation or set to
		// the defaults.
		fileName = readParam("DATAFILE","news.txt");
		clickColor = readColor("CLICKCOLOR",Color.blue);
		headColor = readColor("HEADCOLOR",Color.red);
		mouse_pause = (readParam("MOUSEPAUSE") != null);
		top_pause = readLong("TOPPAUSE",0);
		int fontSize = readInteger("FONTSIZE",12);
		String fontName = readParam("FONT","Serif");

		// listen myself for the mouse
		addMouseListener(this);

		// Create the fonts, dropping back to the defaults if they can't be
		// created.
		try
		{
			fontMessage = new Font(fontName,Font.PLAIN,fontSize);
		}
		catch (Exception e)
		{
			fontMessage = new Font("Serif",Font.PLAIN,fontSize);
		}
		try
		{
			fontHeadline = new Font(fontName,Font.BOLD,fontSize);
		}
		catch (Exception e)
		{
			fontMessage = new Font("Serif",Font.BOLD,fontSize);
		}
	}

	/**
	* Called when the applet starts. Over-rides the base class, but also calls
	* the base start to initialize the animation. Does the initial load of
	* messages.
	*/
	public void start()
	{
		super.start();
		updateNews();
	}

	/**
	* Draws the messages onto the off-screen image and places the off-screen
	* image onto the on-screen image (double-buffering).
	*/
	public synchronized void update(Graphics g)
	{
		if(!loaded) return;

		// The base class as a couple of things to do, like painting the background
		super.update(g);

		// Loop over the loaded news items and draw them onto the off-screen
		// image. Note that we're being somewhat sloppy and letting the
		// clipping of the image contexts take care of where we run over the
		// size of the image.
		for (Enumeration e = vMessages.elements() ; e.hasMoreElements() ;)
		{
			((NewsMessage)e.nextElement()).draw(appGC,borderWidth,headColor,foreColor,clickColor);
		}

		// Draw the border
		drawBorder();

		// Transfer to the visible image context
		g.drawImage(appImage,0,0,this);
	}

	/**
	* Required method for MouseListener: fired when the mouse button is
	* released. Not used.
	* @see mouseClicked
	*/
	public void mouseReleased(MouseEvent e)
	{
	}
	/**
	* Required method for MouseListener: fired when the mouse leaves the
	* applet. Sets mouse-over paused to false.
	*/
	public void mouseExited(MouseEvent e)
	{
		pause_now = false;
	}
	/**
	* Required method for MouseListener: fired when the mouse button is clicked
	* (up and down). Check the message at the location of the event and, if there's a
	* URL to jump to, do so.
	*/
	public void mouseClicked(MouseEvent event)
	{
		for (Enumeration e = vMessages.elements() ; e.hasMoreElements() ;)
		{
			NewsMessage m = (NewsMessage)e.nextElement();
			URL clicked = m.click(event.getY());
			if (clicked != null)
			{
				getAppletContext().showDocument(clicked,m.getTarget());
				break;
			}
		}
	}
	/**
	* Required method for MouseListener: fired when the mouse enters the
	* applet. If mouse-over pausing is enabled, set the flag to stop the
	* scrolling.
	*/
	public void mouseEntered(MouseEvent e)
	{
		if (mouse_pause) pause_now = true;
	}
	/**
	* Required method for MouseListener: fired when the mouse button is pressed
	* down. Not used.
	* @see mouseClicked
	*/
	public void mousePressed(MouseEvent e)
	{
	}

	/**
	* (Re)read the data file. We're trusting that the data file is not too huge
	* as this could be time consuming otherwise.
	*/
	private synchronized void updateNews()
	{
		// No data? shouldn't happen but it never hurts to make sure.
		if (fileName==null) return;

		// First, assume we're running in a browser, so construct the input
		// stream based on a URL. Note the nested try-catch to grab possible
		// errors along the way.
		InputStream inStream = null;
		try				// <-- catch IO problems
		{
			try			// <-- catch bad URL
			{
				URL theURL = null;
				// A specific URL was specified.
				// Note: applets can only read data in this fashion from the web
				// server that they were served from.
				if (fileName.indexOf("http://") >= 0 )
				{
					theURL = new URL(fileName);
				}
				// Not a specific URL, so assume it's relative to the HTML page the
				// applet is on.
				else
				{
					theURL = new URL(getDocumentBase(),fileName);
				}
				inStream = theURL.openStream();
			}
			// the URL was bad, so try to make it a "local" file
			catch (MalformedURLException eUrl)
			{
				inStream = new FileInputStream(fileName);
			}

			// If we've made it this far, we can probably read the data file.
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(inStream));

			// We expect the data to be in a certain format, with the tags in a
			// specific order. The "mode" flag is used to allow/disallow
			// certain lines from being processed, depending upon what has
			// preceeded the line being read.
			int	mode = 0;
			vNewMessages = new Vector();

			// This variable keeps track of the location of the last message in
			// terms of pixels. Start with all the messages basically off the
			// screen.
			int lastbottom = maxHeight;
			
			NewsMessage m = null;
			String  line;
			// width to calc line wrapping
			int width = maxWidth - (2 * borderWidth);

			// Read until there ain't no more...
			while( (line=reader.readLine()) != null)
			{
				// Ignore comment lines.
				if (line.startsWith("#")) continue;
				// if the line is empty
				if (line.length() < 4)
				{
					// if not in headline or body modes, skip it
					if (m != null)
					{
						if (mode == 1) m.addHeadLine(line);
						if (mode == 2) m.addMessageLine(line);
					}
					continue;
				}

				// "@END" always ends a message, even if it's never been started.
				if (line.substring(0,4).equalsIgnoreCase("@END")) {
					if (m!=null) {
						if (m.getTarget()==null) m.setTarget(frameTarget);
						lastbottom = m.getBottom() + gap;
						vNewMessages.addElement(m);
					}
					mode = 0;
					continue;
				}

				// What "mode" are we in?
				switch (mode)
				{
					// Looking for a "@HEAD" tag - throw out anything else
					case 0:
						if (line.substring(0,5).equalsIgnoreCase("@HEAD")) {
							// Change to next mode; create a new message
							mode = 1;
							m = new NewsMessage(lastbottom,width,appGC,fontHeadline,fontMessage);
							m.addHeadLine(line.substring(5));
						}
						break;
					// The HEAD has been read: accept "@URL","@FRAME", or "@MSG"
					case 1:
						if (line.substring(0,4).equalsIgnoreCase("@URL"))
						{
							m.setLink(getDocumentBase(),line.substring(4));
							break;
						}
						if (line.substring(0,6).equalsIgnoreCase("@FRAME"))
						{
							m.setTarget(line.substring(6));
							break;
						}
						// Found the start of the message! Time to switch modes
						// again...
						if (line.substring(0,4).equalsIgnoreCase("@MSG")) {
							mode = 2;
							m.addMessageLine(line.substring(4));
						}
						// Don't know what else it could be, so add it to the
						// header.
						else
							m.addHeadLine(line);
						break;
					// Anything else gets added to the message body
					default:
						m.addMessageLine(line);
						break;
				}
			}		// end of line reading-loop
			// Close up shop.
			reader.close();
			inStream.close();
		}
		// Something blew up big time in stream creation or reading. Abort
		// all operations.
		catch (IOException e){
			System.err.println("IO Exception on the data file: " +
								e.getMessage());
			e.printStackTrace();
			stop();
		}
	}

	/**
	* This method, required by the base class, implements the animation/timing
	* of the applet. Basically, it updates each message's location (Y) by the
	* given amount.
	*/
	protected synchronized void doAppThing()
	{
		// the sizes of the current and new message vectors
		int	sizeCurrent = vMessages.size();
		int sizeNew = (vNewMessages == null ? 0 : vNewMessages.size());
		// the position of the last current message, in pixels
		int lastBottom;
		// beginning and end of the current messages
		NewsMessage first,last;

		// There are no current messages (initial load).
		if (sizeCurrent == 0)
		{
			if (sizeNew > 0)
			{
				vMessages = vNewMessages;
				vNewMessages = null;
			}
			else
				return;
		}

		// Check the position of the current first message: if it's moved off
		// of the visible area, put it at the end to acheive the continuous
		// effect.
		first = (NewsMessage)vMessages.firstElement();
		last = (NewsMessage)vMessages.lastElement();
		if (first.getBottom() + scrollUnit <= 0)
		{
			vMessages.removeElement(first);
			lastBottom = last.getBottom() + gap;
			first.resetTop(lastBottom);
			vMessages.addElement(first);
		}

		// Check for the mouse pause condition: if set, don't update the
		// message positions.
		if (pause_now) return;

		// Update all of the message positions.
		for (Enumeration e = vMessages.elements() ; e.hasMoreElements() ;)
		{
			first = (NewsMessage)e.nextElement();
			first.movePosition(scrollUnit);
		}

		// If the "pause at top" feature is enabled (non-zero) and the current
		// first message is at the top of the applet, freeze for the specified
		// time.
		if (top_pause > 0)
		{
			first = (NewsMessage)vMessages.firstElement();
			// If it's at the top and it's not the same message (because we
			// don't want to get stuck in an infinite loop vis-a-vis the
			// mouse-over pause), go to sleep. Note that in this case, we're
			// ignoring any exceptions because it simply doesn't matter all
			// that much.
			if (first.getTop() <= (Math.abs(borderWidth)+1) && !first.equals(msgTop)) {
				try
				{
					Thread.sleep(top_pause);
					msgTop = first;
				}
				catch (InterruptedException e) {}
			}
		}
	}
}

