package applet;

/**
* A super-class for animated applets. This class contains many standard methods
* and parameters * for providing simple animation using double-buffering (where
* the image is drawn "off-screen" and then drawn all at one time to the
* receiving Graphics object.
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

public abstract class WebBase extends Applet implements Runnable
{
	/**
	* Default sleep time (milliseconds).
	*/
	private final int DEFAULT_SLEEP = 300;
	/**
	* Default scroll increment (pixels).
	*/
	private final int DEFAULT_SCROLL = 10;
	/**
	* The animation thread.
	*/
	protected Thread  myThread = null;
	/**
	* Maximum width of the graphics image.
	*/
	protected int maxWidth;
	/**
	* Maximum height of the graphics image.
	*/
	protected int maxHeight;
	/**
	* Width of the border on the image.
	*/
	protected int borderWidth;
	/**
	* The increment to advance the animation (pixels).
	*/
	protected int scrollUnit;
	/**
	* The amount of time (ms) to wait between updates.
	* Can be considered to be the "frame-rate" of the animation.
	*/
	protected long sleepTime;
	/**
	* The off-screen image to draw to.
	*/
	protected Image appImage;
	/**
	* The graphics object for the off-screen image.
	*/
	protected Graphics appGC;
	/**
	* The foreground color to use while drawing the image.
	*/
	protected Color foreColor;
	/**
	* The background color to use while drawing the image.
	*/
	protected Color backColor;
	/**
	* An internal flag to indicate whether or not the
	* animation thread is running.
	*/
	protected boolean loaded = false;
	/**
	* The image object for the background graphics, if used.
	*/
	protected Image backgroundImage = null;
	/**
	* An HTML frame "target" parameter, if used.
	*/
	protected String  frameTarget = null;

	/**
	* Applet initialization.
	*/
	public void init()
	{
		// get the size of the applet
		Dimension d = getSize();
		maxWidth = d.width;
		maxHeight = d.height;

		// used for children of this class to target URL jumps
		//	  defaults to "_top"
		frameTarget = readParam("TARGET","_top");

		// get some numeric parameters
		sleepTime = readLong("SleepTime",DEFAULT_SLEEP);
		scrollUnit = readInteger("ScrollBy",DEFAULT_SCROLL);
		borderWidth = readInteger("BORDER",0);

		// the color parameters
		foreColor = readColor("FOREGROUND",Color.black);
		backColor = readColor("BACKGROUND",Color.white);
		setBackground(backColor);

		// a background picture (go ahead and wait for full load)
		String tparam = readParam("PICTURE",null);
		if (tparam != null)
		{
			MediaTracker imgTrack;
			URL theURL = null;
			try
			{
				// get the image url
				if (tparam.indexOf("http://") >= 0 )
					theURL = new URL(tparam);
				else
					theURL = new URL(getDocumentBase(),tparam);

				// load the image
				backgroundImage = getImage(theURL);
				if (backgroundImage != null)
				{
					imgTrack = new MediaTracker(this);
					imgTrack.addImage(backgroundImage,0);
					imgTrack.waitForAll();
					if (imgTrack.isErrorAny())
						backgroundImage = null;
				}
			}
			catch (Exception e)
			{
				backgroundImage = null;
			}
		}
		appImage = createImage(maxWidth, maxHeight);
		appGC = appImage.getGraphics();
	}

	/**
	* Read an HTML-supplied parameter.
	* @param param the HTML PARAM tag to find
	* @param defaultValue the default value to return if the parameter is not
	* found.
	* @return the String of the parameter or the defaultValue on error
	*/
	protected String readParam(String param,String defaultValue)
	{
		String rtn = null;
		try
		{
			rtn = getParameter(param);
		}
		catch (Exception e) { }
		if (rtn == null) rtn = defaultValue;
		return rtn;
	}

	/**
	* Read an HTML-supplied parameter.
	* @param param the HTML PARAM tag to find
	* @return the String of the parameter, or null on error
	*/
	protected String readParam(String param)
	{
		return readParam(param,null);
	}

	/**
	* Read an HTML-supplied parameter as an integer.
	* @param param the HTML PARAM tag to find
	* @param defaultValue the default value
	* @return the parameter or the default value if no parameter
	*/
	protected int readInteger(String param, int defaultValue)
	{
		try
		{
			String s = readParam(param);
			int x = Integer.parseInt(s);
			return x;
		}
		catch (Exception e)
		{
			return defaultValue;
		}
	}


	/**
	* Read an HTML-supplied parameter as a long.
	* @param param the HTML PARAM tag to find
	* @param defaultValue the default value
	* @return the parameter or the default value if no parameter
	*/
	protected long readLong(String param, long defaultValue)
	{
		try
		{
			String s = readParam(param);
			long x = Long.parseLong(s);
			return x;
		}
		catch (Exception e)
		{
			return defaultValue;
		}
	}

	/**
	* Reads a color HTML-supplied parameter (either R,G,B or hex RGB value).
	* @param param name of the parameter to read
	* @param defColor default color to use if no parameter present or is
	* an invalid format
	* @return a Color corresponding to the parameter string.
	* @see readParam
	*/
	protected Color readColor(String sParam, Color defColor)
	{
		String tparam = readParam(sParam);
		Color tcolor;
		int rc,gc,bc;

		// set the component colors to invalid values
		rc = gc = bc = -1;

		// a parameter was used...
		if (tparam != null)
		{
			// looks like it might be "HTML" format
			if (tparam.startsWith("#"))
			{
				// if it's the right length, try to separate it properly
				if (tparam.length()==7)
				{
					try
					{
						rc = Integer.parseInt(tparam.substring(1,3),16);
						gc = Integer.parseInt(tparam.substring(3,5),16);
						bc = Integer.parseInt(tparam.substring(5),16);
					}
					catch (Exception e) { }
				}
			}

			// not "HTML" format: try to separate it as CSV
			else
			{
				int x,y;
				x = tparam.indexOf(',');
				y = tparam.lastIndexOf(',');
				if (x>0 && y>0 && x!=y)
				{
					try
					{
						rc = Integer.parseInt(tparam.substring(0,x));
						gc = Integer.parseInt(tparam.substring(x+1,y));
						bc = Integer.parseInt(tparam.substring(y+1));
					}
					catch (Exception e) { }
				}
			}
		}

		// try to make a new color with the three RGB values, or get the
		// default
		tcolor = (rc>=0 && rc<=255 && gc>=0 && gc<=255 && bc>=0 && bc<=255) ? new Color(rc,gc,bc) : defColor;
		return (tcolor);
	}

	/**
	* Start the applet thread. Initialize the animation thread.
	*/
	public void start()
	{
		if (myThread == null)
		{
			myThread = new Thread(this);
			myThread.start();
		}
		loaded = true;
	}

	/**
	* Stop the applet thread. If the animation thread is alive, kill it.
	*/
	public void stop()
	{
		if ((myThread != null) && myThread.isAlive())
			myThread.stop();
		loaded = false;
		myThread = null;
	}

	/**
	* The main thread method.
	* @see java.lang.Runnable
	*/
	public void run()
	{
		// get which is the current thread and set a low priority on it
		Thread me = Thread.currentThread();
		me.setPriority(Thread.MIN_PRIORITY);

		// craete a blank image and it's Graphic object
		appImage = createImage(maxWidth, maxHeight);
		appGC = appImage.getGraphics();

		// force an early paint, even though we haven't actually drawn anything
		// to paint, yet
		repaint();

		// while we have a hold of the animation thread...
		while (myThread == me)
		{
			// just to make sure the applet is running
			if (loaded)
			{
				// do our thing, repaint, and go to sleep
				doAppThing();
				repaint();
				try
				{
					Thread.sleep(sleepTime);
				}
				catch(InterruptedException e){}
			}
		}
	}

	/**
	* Sub-classes must implement this method. This method is where the
	* sub-classes will update the image to be painted.
	* @see update
	*/
	protected abstract void doAppThing();


	/**
	* Over-ride of the superclass method. Because the acutal painting takes
	* place in the update method, we don't want any painting to occur here.
	*/
	public void paint(Graphics g)
	{ }

	/**
	* Over-ride of the superclass method. Draws all of the current elements
	* onto the visible Graphics object of the applet. Sub-classes will also
	* over-ride this method to supply their own implementations.
	* @param g the Graphics object to update
	*/
	public synchronized void update(Graphics g)
	{
		// the animation is running
		if (loaded)
		{
			// if there's a background picture, use it
			if (backgroundImage != null)
				appGC.drawImage(backgroundImage,0, 0, maxWidth, maxHeight,this);

			// otherwise, draw background rectangle...
			else
			{
				appGC.setColor(backColor);
				appGC.fillRect(0, 0, maxWidth, maxHeight);
			}
		}
	}

	/**
	* Draws a 3-D border on the applet image Graphics object.
	* Uses the width, height, and BORDER parameter to determine the wheres and
	* whats of how to draw the border.
	*/
	protected void drawBorder()
	{
		if (borderWidth == 0) return;

		Color bc_light,bc_dark;
		int pWidth = Math.abs(borderWidth);
		Polygon bp_below = new Polygon();
		Polygon bp_above = new Polygon();

		// if the background is white, we can't make the border lighter, so we
		// come up with two darker colors
		if (backColor.equals(Color.white))
		{
			bc_light = backColor.darker();
			bc_dark = bc_light.darker();
		}
		else if (backColor.equals(Color.black))
		{
			bc_light = Color.gray;
			bc_dark = Color.gray.darker();
		}
		else
		{
			bc_light = backColor.brighter();
			bc_dark = backColor.darker();
		}

		// add the vertices to the polygons
		bp_above.addPoint(0,0);
		bp_above.addPoint(maxWidth,0);
		bp_above.addPoint(maxWidth-pWidth,pWidth);
		bp_above.addPoint(pWidth,pWidth);
		bp_above.addPoint(pWidth,maxHeight-pWidth);
		bp_above.addPoint(0,maxHeight);

		bp_below.addPoint(maxWidth,0);
		bp_below.addPoint(maxWidth,maxHeight);
		bp_below.addPoint(0,maxHeight);
		bp_below.addPoint(pWidth,maxHeight-pWidth);
		bp_below.addPoint(maxWidth-pWidth,maxHeight-pWidth);
		bp_below.addPoint(maxWidth-pWidth,pWidth);

		// draw the polygons with appropriate colors
		appGC.setColor(borderWidth < 0 ? bc_dark : bc_light);
		appGC.fillPolygon(bp_above);
		appGC.setColor(borderWidth < 0 ? bc_light : bc_dark);
		appGC.fillPolygon(bp_below);
	}
}


