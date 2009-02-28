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

import javax.microedition.lcdui.*;

/*
	Siguiendo la tradiccion de nombrar nuestras clases como personas,
	hemos nombrado a esta clase Jesus.
	
	Jesus es el nombre del administrador de sistemas de la empresa 
	en la que trabajo y esta clase administra el sistema.
*/

public class Jesus implements Runnable
{
	/*
		Objetos
	*/
	Diego diego=null;
	Mandy mandy=null;
	public Abi abi=null;
	/*
		variables
	*/
	boolean done=false;
	boolean keyPressed = false;
	/*
		metodos
	*/
	public Jesus(Mandy midlet)
	{		
		diego = new Diego(240, 320, this);
		Display.getDisplay(midlet).setCurrent(diego);
		mandy = midlet;
		abi = new Abi("");
		
		new Thread(this).start();
	}
	public void whichKey(int keyCode)
	{
		keyPressed = true;
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
			
			diego.repaint();
			this.update();
		}
		while(!done);
		
		mandy.destroyApp(true);
		System.gc();
	}
	
	void update()
	{
		if(keyPressed == true)
		{
			switch(Andrew.current_state)
			{
				case Andrew.PRESS5:
					Andrew.setState(Andrew.MAIN_MENU);
					break;
				
				case Andrew.MAIN_MENU:
					Andrew.setState(Andrew.MAIN_LOOP);
					break;
					
				case Andrew.MAIN_LOOP:
					Andrew.setState(Andrew.DONE);
					done = true;
					break;
			}
			keyPressed = false;
		}
	}
	
	void draw(Graphics g)
	{
		switch(Andrew.current_state)
		{
		case Andrew.PAUSE:
			return;
	
		case Andrew.INVALID:
			Andrew.setState(Andrew.LOAD);
			return;
	
		case Andrew.LOAD:
			g.drawString("STATE: LOAD", 0, 0, Graphics.LEFT | Graphics.TOP);
			Andrew.setState(Andrew.SPLASH);
			break;
		
		case Andrew.SPLASH:
			g.drawString("STATE: SPLASH", 0, 0, Graphics.LEFT | Graphics.TOP);
			Andrew.setState(Andrew.PRESS5);
			break;
		
		case Andrew.PRESS5:
			g.drawString("STATE: PRESS 5", 0, 0, Graphics.LEFT | Graphics.TOP);
			break;
		
		case Andrew.MAIN_MENU:
			abi.paint(g);
			break;
		
		case Andrew.MAIN_LOOP:
			g.drawString("STATE: MAIN LOOP", 0, 0, Graphics.LEFT | Graphics.TOP);
			break;
			
		case Andrew.DONE:
			g.drawString("STATE: DONE", 0, 0, Graphics.LEFT | Graphics.TOP);
			break;
		}
	}
}
