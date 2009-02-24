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
	final int W = 240;
	final int H = 320;
	boolean done;
	Mandy myMIDlet;
	Image bb = null;
	Graphics g = null;
	int i=0;
	
	int fps = 0;
	int cur_fps = 0;
	long  first = 0;
	long  current = 0;
	
	Image pov;
	
	public Diego(Mandy midlet)
	{	
		myMIDlet = midlet;
		done = false;
		new Thread(this).start();
		if(bb==null)
		{
			bb = Image.createImage(W,H);
			g = bb.getGraphics();
			first = System.currentTimeMillis();
			
			try
			{
				pov = Image.createImage("/s.JPG");
			}
			catch(Exception ioe)
			{
				System.out.println(ioe);
			}
			
		}
	}
	
	public void paint(Graphics _g)
	{
	//back buffer
	
	if(myMIDlet.paused) 
	{
		return;
	}
	
	/*g.setColor(0x000000);
	g.fillRect(0,0,W,H);*/
	
	g.drawImage(pov,0,0,Graphics.TOP| Graphics.LEFT);
	
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
