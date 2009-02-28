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

/*
	Abi trabaja en un restaurante de Monterrey.
	Menu -> restaurante -> Abi
*/

import javax.microedition.lcdui.*;

class Abi
{	
	Abi()
	{
	
	}
	
	void paint(Graphics g)
	{
		g.setColor(0xFFFFFF);
		g.fillRect(0,0,240,320);
		
		g.setColor(0x000066);
		g.drawString("MAIN MENU", 0, 0, Graphics.LEFT | Graphics.TOP);
	}
	
	void update()
	{
	}
}