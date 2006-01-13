package applet;

/**
* A basic horizontal scrolling text applet. This was written under the
* influence of the examples provided by Sun and copyright by them.
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
*/

import java.awt.*;
import java.applet.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.event.*;

public class Scroller extends WebBase implements MouseListener
{
	/**
	* The message text.
	*/
	private String message;
	/**
	* Current x coordinate of the text within the applet.
	*/
	private int messageX = 0;
	/**
	* Current y coordinate of the text within the applet.
	*/
	private int messageY = 0;
	/**
	* The width of the message.
	*/
	private int messageWidth = 0;
	/**
	* The font to draw the message with. Defaults to Serif.
	*/
	private Font messageFont;
	/**
	* Flag to indicate whether or not to draw a "shadow" of the message.
	*/
	private boolean shadowOn;
	/**
	* The string of the URL to link to. Optional.
	*/
	private String linkName;
	/**
	* The url of a link. Optional.
	*/
	private URL linkURL = null;

	/**
	* Initialize the applet. Over-rides super class (but calls it).
	* @see java.applet.Applet
	*/
	public void init()
	{
		super.init();

		// get the HTML parameters or set to defaults
		message = readParam("MESSAGE","No message supplied!");
		String shadowParam = readParam("SHADOW");
		shadowOn = (shadowParam== null) ? false : shadowParam.equalsIgnoreCase("true");

		linkName = readParam("URL");
		if (linkName != null)
		{
			try
			{
				if (linkName.indexOf("http://") < 0)
					linkURL = new URL(getDocumentBase(),linkName);
				else
					linkURL = new URL(linkName);
			}
			catch (MalformedURLException e) {};
		}

		// make ourselves listen to the mouse
		addMouseListener(this);
	}

	/**
	* Called when the applet is started. Over-rides super class (but calls it).
	*/
	public void start()
	{
		super.start();

		// set up the font and initial positions
		int fontAttributes = Font.PLAIN;
		String name = readParam("FONT");
		String style = readParam("FONTSTYLE");
		if (style != null)
		{
			style = style.toUpperCase();
			if (style.indexOf("BOLD") >= 0)
				fontAttributes += Font.BOLD;
			if (style.indexOf("ITALIC") >= 0)
				fontAttributes += Font.ITALIC;
		}

		// a font size of 14 seems a decent size to start with, especially with
		// applets
		try
		{
			messageFont = new Font(name,fontAttributes,14);
		}
		catch (Exception e) { }

		// didn't work?
		if (messageFont == null)
		{
			name = "Serif";
			messageFont = new Font(name,fontAttributes,14);
		}

		// set the font on this applet so we can determine it's "true" size
		setFont(messageFont);
		FontMetrics fontStuff = getFontMetrics(messageFont);
		int fontHeight = fontStuff.getHeight();

		// scale this down to the appropriate size (lots of rounding)
		// remake the font with the new point size
		double height = (double)(maxHeight - (2 * Math.abs(borderWidth)));
		fontHeight = (int)Math.floor(14 * height / (double)fontHeight);
		messageFont = new Font(name,fontAttributes,fontHeight);
		fontStuff = getFontMetrics(messageFont);
		messageX = maxWidth;
		messageY = ((maxHeight-fontStuff.getHeight()) >> 1) + fontStuff.getAscent() - 1;
		messageWidth = fontStuff.stringWidth(message);
	}

	/**
	* Over-rides the super class. Paint the text to the offscreen image and
	* place <B>image</B> onto the graphics context.
	*/
	public synchronized void update(Graphics g)
	{
		// are we running?
		if(loaded)
		{
			super.update(g);

		   //...then draw shadow copy of text...
		   if (shadowOn)
			{
			   Color foreColorD1,foreColorD2;
			   foreColorD1 = foreColor.darker();
			   foreColorD2 = foreColorD1.darker();
			   appGC.setColor(foreColorD2);
			   appGC.drawString(message, messageX+2, messageY+2);
			   appGC.setColor(foreColorD1);
			   appGC.drawString(message, messageX+1, messageY+1);
		   }

			//...then draw the text...
			appGC.setColor(foreColor);
			appGC.setFont(messageFont);
			appGC.drawString(message, messageX, messageY);

			//...next comes the border...
			drawBorder();

			//...and drop the whole thing into place
			g.drawImage(appImage, 0, 0, this);
		}
	}

	/**
	* Implementation of the abstract method: increment the X-position of the
	* message by the indicated amount. This "jump" is the animation for the
	* message.
	*/
	protected synchronized void doAppThing()
	{
		messageX -= scrollUnit;
		// oops! too far - start over
		if((messageX + messageWidth) < 0) messageX = maxWidth;
	}

	/**
	* Required method for MouseListener: fired when the mouse button is
	* released. Resets the border to it's initial state. If there is a
	* link URL to jump to, do so.
	*/
	public void mouseReleased(MouseEvent e)
	{
		borderWidth = -borderWidth;
		if (linkURL !=null) {
			getAppletContext().showDocument(linkURL,frameTarget);
		}
	}
	/**
	* Required method for MouseListener: fired when the mouse leaves the
	* applet. Clears the status line.
	*/
	public void mouseExited(MouseEvent e)
	{
		showStatus("");
	}
	/**
	* Required method for MouseListener: fired when the mouse button is clicked
	* (up and down). Note that this method is not used: there are separate
	* events for the down and up of the button(s).
	*/
	public void mouseClicked(MouseEvent e)
	{
	}
	/**
	* Required method for MouseListener: fired when the mouse enters the
	* applet. If there is a URL link for the applet, show the link in the
	* status line.
	*/
	public void mouseEntered(MouseEvent e)
	{
		if (linkURL != null) showStatus("Link to " + linkName);
	}
	/**
	* Required method for MouseListener: fired when the mouse button is pressed
	* down. Invert the border (this gives a "pressed" look to the applet).
	*/
	public void mousePressed(MouseEvent e)
	{
		borderWidth = -borderWidth;
	}
}
