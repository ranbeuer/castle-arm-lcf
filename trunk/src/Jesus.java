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
	/*
		variables
	*/
	public static boolean done=false;
	/*
		metodos
	*/
	public Jesus(Mandy midlet)
	{
		new Thread(this).start();
		diego = new Diego(240, 320);
		Display.getDisplay(midlet).setCurrent(diego);
		mandy = midlet;
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
		}
		while(!done);
		
		mandy.destroyApp(true);
		System.gc();
	}

}
