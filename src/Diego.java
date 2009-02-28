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


/*import javax.microedition.media.*;
import javax.microedition.media.control.*;*/


/*
	Esta clase se llama Diego en honor a Diego Rivera.
	Canvas -> Lienzo.
*/
public class Diego extends Canvas
{
	Image bb = null;
	public Graphics g = null;
	Jesus jesus = null;
	
	int W;
	int H;
	
	public Diego(int w, int h, Jesus j)
	{	
		W = w;
		H = h;
		
		bb = Image.createImage(W,H);
		g = bb.getGraphics();
		jesus = j;
	}
	
	public void paint(Graphics _g)
	{
		jesus.draw(g);
	
		_g.drawImage(bb,0,0,Graphics.TOP| Graphics.LEFT);
	}
	
	protected void keyPressed(int keyCode)
	{
		jesus.whichKey(keyCode);
	}
	
	protected void keyReleased(int keyCode)
	{
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
