/*
    This file is part of Leo's and Angel's project (LAP).

    LAP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    LAP is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with LAP.  If not, see <http://www.gnu.org/licenses/>.
*/
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;

public class Diego extends Canvas implements Runnable
{
	int W;
	int H;
	boolean done;
	Image bb = null;
	Graphics g = null;
	int i=0;
	
	int fps = 0;
	int cur_fps = 0;
	long  first = 0;
	long  current = 0;
	
	public static final int STATE_LOAD = 		0;
	public static final int STATE_SPLASH = 	1;
	public static final int STATE_PRESS5 = 	2;
	public static final int STATE_MAIN_MENU = 	3;
	public static final int STATE_MAIN_LOOP = 	4;
	public static final int STATE_PAUSE = 		5;
	
	public int state;	
	
	public Diego(int w, int h)
	{	
		done = false;
		
		W = width;
		H = height;
		
		new Thread(this).start();
		if(bb==null)
		{
			bb = Image.createImage(W,H);
			g = bb.getGraphics();
			first = System.currentTimeMillis();
		}
	}
	
	public void paint(Graphics _g)
	{
	
	if( state == STATE_PAUSE)
	{
		return;
	}
	current = System.currentTimeMillis();
	fps++;
	if((current - first) > 1000)
	{
		cur_fps=fps;
		fps = 0;
		first = current;
	}
	
	g.setColor(0xff0000);
	g.drawString("fps: " + cur_fps,0,0,Graphics.TOP|Graphics.LEFT);

	
	_g.drawImage(bb,0,0,Graphics.TOP| Graphics.LEFT);
	
	}
	
	public void run()
	{
		
		
		do
		{
			try
			{
				Thread.sleep(10);
			} 
			catch(Exception e)
			{
			
			}
			repaint();
		}
		while(!done);
		
	}

}
