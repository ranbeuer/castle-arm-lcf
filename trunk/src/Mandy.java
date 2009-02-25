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

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;

public class Mandy extends MIDlet
{
	Diego myCanvas=null;
	MIDlet myMydlet;	
	
	public Mandy()
	{
		myMydlet = this;
	}
	
	public void startApp()
	{	
		if(myCanvas == null)
		{
			myCanvas = new Diego(240, 320);			
		}
		myCanvas.setFullScreenMode(true);
		Display.getDisplay(myMydlet).setCurrent(myCanvas);
	}
	
	public void pauseApp()
	{	
		myCanvas.state = myCanvas.STATE_PAUSE;
		
		myCanvas.setFullScreenMode(false);
		Thread.yield();
	}
	
	public void destroyApp(boolean inconditional)
	{	
		myCanvas.setFullScreenMode(false);
		notifyDestroyed();
	}
}
