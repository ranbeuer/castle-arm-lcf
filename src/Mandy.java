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

/*
	Esta clase se llama Mandy debido a que en los tutoriales de Sun
	sobre Java ME, el MIDlet de ejemplo es nombrado asi.
*/
public class Mandy extends MIDlet
{	
	Jesus jesus;
	
	public Mandy()
	{
		jesus=null;
	}
	
	public void startApp()
	{	
		if(jesus == null)
		{
			jesus = new Jesus(this);
		}
	}
	
	public void pauseApp()
	{		
		Thread.yield();
	}
	
	public void destroyApp(boolean inconditional)
	{	
		notifyDestroyed();
	}
}
