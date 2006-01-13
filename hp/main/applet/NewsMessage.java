package applet;

/**
* This class represents an individual message item in the NewsScroller applet.
* This way, each message can take care of it's own position vs. the applet and
* draw itself.
* <P>
* Each message may contain a URL (and optional target, as found in &lt;A HREF&gt;
* HTML tags) to jump to when it is clicked upon.
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
* @see NewsScroller
*/

import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

class NewsMessage {
	/**
	* The current top position of this message (in pixels).
	*/
	private int top;
	/**
	* The height of this message (in pixels).
	*/
	private int height;
	/**
	* The maximum width of a line (in pixels). Used for calculating the
	* wrapping of lines.
	*/
	private int maxWidth = 0;
	/**
	* A URL associated with this message, if any.
	*/
	private URL link = null;
	/**
	* A URL target, if any.
	*/
	private String target = null;
	/**
	* The font for headlines.
	*/
	private Font headFont;
	/**
	* The fontmetric for headlines. Pre-calculated to save those previous
	* milliseconds.
	*/
	private FontMetrics headFM;
	/**
	* The lines that compose this message's headline.
	*/
	Vector vHeadline = new Vector();
	/**
	* The font for the body text.
	*/
	private Font bodyFont;
	/**
	* The fontmetric for bodylines. Pre-calculated to save those previous
	* milliseconds.
	*/
	private FontMetrics bodyFM;
	/**
	* The lines that compose this message's body.
	*/
	Vector vBody = new Vector();

	/**
	* The constructor for a new message.
	* @param startat the initial position relative to the top of the applet
	* @param width the width of the viewable area within the applet
	* @param g the graphics context for the applet (to calculate fonts and
	* metrics)
	* @param fontHead the font to use for headlines
	* @param fontBody the font to use for body lines
	*/
	NewsMessage (int startat,int width,Graphics g,Font fontHead,Font fontBody)
	{
		// no height initially (duh!) and set the top to the starting position
		height = 0;
		top = startat;

		// hang on to all the other things we need later on
		headFont = fontHead;
		headFM = g.getFontMetrics(fontHead);
		bodyFont = fontBody;
		bodyFM = g.getFontMetrics(fontBody);
		maxWidth = width - 10;		// give it a touch of slack
	}

	/**
	* Change the position of this message. Since the applet is always scrolling
	* "up", the position is actually decremented towards 0.
	* @param amount the amount to change position
	*/
	protected void movePosition(int amount)
	{
		top -= amount;
	}
	/**
	* Reset the current top of this message to another value.
	* @param newtop the new position for the top of the message
	*/
	protected void resetTop(int newtop)
	{
		top = newtop;
	}
	/**
	* Get the current position of the bottom of this message.
	* @return the position of the bottom of the last line in the message in
	* pixels
	*/
	protected int getBottom()
	{
		return top + height;
	}
	/**
	* Get the current position of the top of this message.
	* @return the position of the top of the first headline in pixels
	*/
	protected int getTop()
	{
		return top;
	}
	/**
	* Set the link URL for this message. Takes either an absolute URL or a
	* relative one to the HTML page the applet is on. If it's invalid, it
	* remains unset.
	* @param docbase the URL of the HTML page of the applet
	* @param s the name of the URL to create
	*/
	protected void setLink(URL docbase,String s)
	{
		try
		{
			if (s.indexOf("http://") >= 0 )
				link = new URL(s);
			else
				link = new URL(docbase,s);
		}
		catch (MalformedURLException e)
		{
			link = null;
		}

	}
	/**
	* Get this message's URL if the given position is somewhere inside of it.
	* @param y the position to check against
	* @return the message's URL or null if the position is outside of it
	*/
	protected URL click(int y)
	{
		if (y >= top && y <= (top + height))
			return(link);
		return(null);
	}
	/**
	* Set the URL target for this message.
	* @param target the URL target
	*/
	protected void setTarget(String t)
	{
		target = new String(t);
	}
	/**
	* Get the URL target for this message.
	* @return the URL target
	*/
	protected String getTarget()
	{
		return target;
	}
	/**
	* Append a new headline to this message.
	* @param s the line to add
	*/
	protected void addHeadLine(String s)
	{
		addLine(vHeadline,s,headFM);
	}
	/**
	* Append a new body line to this message.
	* @param s the line to add
	*/
	protected void addMessageLine(String s)
	{
		addLine(vBody,s,bodyFM);
	}

	/**
	* Add a line to the message. Calculates line-wrapping so text fits within
	* the viewable area and updates the height (in pixels) of the message.
	* <P>
	* Words that are too long for a line by themselves are chopped. Blank lines
	* are also allowed.
	* @param v the portion of the message this line is to be appended to
	* (headlines or body lines)
	* @param line the line of text to add
	* @param fm the FontMetrics to use for this line
	*/
	private void addLine(Vector v,String line,FontMetrics fm)
	{
		// line heights
		int h = fm.getHeight();

		// add a blank line - fake it by putting a newline in
		if (line.length() == 0)
		{
			v.addElement("\n");
			height += h;
			return;
		}

		// If there's already text in there, grab the last line so we can wrap
		// it. Remove it so it can be re-appended, depening on the wrapping.
		String s;
		if (v.size() > 0)
		{
			s = (String)v.lastElement();
			if (s.equals("\n"))
				s = line;
			else
			{
				v.removeElement(s);
				height -= h;
				s += " " + line;
			}
		}
		// otherwise, it's the first line in this portion
		else
			s = line;

		// break our working copy apart on spaces
		String t = null;
		StringTokenizer toke = new StringTokenizer(s," ");
		while (toke.hasMoreTokens())
		{
			String last = t;
			String lastToken = toke.nextToken();

			if (t==null)
				t = lastToken;
			else
				t += " " + lastToken;

			// now it's too long
			if (fm.stringWidth(t) > maxWidth)
			{
				// eep! the last word itself was too long!
				// whittle it down to something that will fit
				if (last == null || t.indexOf(' ') < 0)
				{
					int x;
					for (x = 1; x < t.length(); x++)
					{
						String t2 = t.substring(0,x);
						if (fm.stringWidth(t2+"-") > maxWidth) break;
					}
					v.addElement(t.substring(0,x-1) + "-");
					t = t.substring(x);
				}
				// otherwise, just append the last known line
				else
				{
					v.addElement(last);
					t = lastToken;
				}
				height += h;
			}
		}

		// examine the last remnant
		// once again, too long for the line - we can assume it's one word
		// because of the nature of the loop above
		while (fm.stringWidth(t) > maxWidth)
		{
			int x;
			for (x = 1; x < t.length(); x++)
			{
				String t2 = t.substring(0,x);
				if (fm.stringWidth(t2+"-") > maxWidth) break;
			}
			v.addElement(t.substring(0,x-1) + "-");
			height += h;
			t = t.substring(x);
		}

		// add the last remains
		v.addElement(t);
		height += h;
	}

	/**
	* Draw the text of this message on the specified Graphics object with the
	* specified colors.
	* @param g the Graphics object to draw on -- usually an off-screen image
	* @param border the width of the border
	* @param headColor the color for headlines
	* @param msgColor the color for normal text
	* @param urlColor the color for linked text
	*/
	protected void draw (Graphics g,int border,
					Color headColor,Color msgColor,Color urlColor)
	{
		// is this thing even in the picture?
		if (top+height <= 0) return;

		// do the headlines
		g.setColor(headColor);
		g.setFont(headFont);
		int startat = drawline(g,vHeadline,border,headFM,top);
		// then do the message
		g.setColor(link==null ? msgColor : urlColor);
		g.setFont(bodyFont);
		drawline(g,vBody,border,bodyFM,startat);
	}
	/**
	* Draws the specified vector of lines onto a Graphics object using the
	* params.
	* @param g the Graphics object to draw on -- usually an off-screen image
	* @param v the Vector of text lines to draw
	* @param border the width of the border
	* @param fm the font metrics for the font
	* @param start the position to start drawing at
	* @return the ending position of this group of lines
	*/
	private int drawline(Graphics g,Vector v,int border,FontMetrics fm,int start)
	{
		int h = fm.getHeight();
		int y = fm.getAscent();

		for (Enumeration e = v.elements(); e.hasMoreElements(); ) {
			String s = (String)e.nextElement();
			if (s.equals("\n"))  s = " ";
			g.drawString(s,border+5,start+y);
			start += h;
		}
		return start;
	}
}


