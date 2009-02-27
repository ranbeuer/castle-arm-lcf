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


/*
	Esta clase se llama Diego en honor a Diego Rivera.
	Diego rivera era un pintor.
	Canvas == Lienzo.
*/
public class Diego extends Canvas
{
	Image bb = null;
	Graphics g = null;
	
	int W;
	int H;
	
	public Diego(int w, int h)
	{	
		W = w;
		H = h;
		
		bb = Image.createImage(W,H);
		g = bb.getGraphics();
	}
	
	public void paint(Graphics _g)
	{
		g.setColor(0x000000);
		g.drawRect(0,0,W,H);
		g.setColor(0xFF0000);
	
		switch(Andrew.current_state)
		{
		case Andrew.PAUSE:
			return;
	
		case Andrew.INVALID:
			Andrew.setState(Andrew.LOAD);
			return;
	
		case Andrew.LOAD:
			g.drawString("STATE: LOAD", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.SPLASH);
			break;
		
		case Andrew.SPLASH:
			g.drawString("STATE: SPLASH", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.PRESS5);
			break;
		
		case Andrew.PRESS5:
			g.drawString("STATE: PRESS 5", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.MAIN_MENU);
			break;
		
		case Andrew.MAIN_MENU:
			g.drawString("STATE: MAIN MENU", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.MAIN_LOOP);
			break;
		
		case Andrew.MAIN_LOOP:
			g.drawString("STATE: MAIN LOOP", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.DONE);
			break;
			
		case Andrew.DONE:
			g.drawString("STATE: DONE", 0, 0, Graphics.HCENTER | Graphics.TOP);
			Andrew.setState(Andrew.INVALID);
			Jesus.done = true;
			break;
		}
	
		_g.drawImage(bb,0,0,Graphics.TOP| Graphics.LEFT);
	}
	
	public void showNotify()
	{
		setFullScreenMode(true);
	}
	
	protected void hideNotify()
	{
		setFullScreenMode(false);
	}

}
