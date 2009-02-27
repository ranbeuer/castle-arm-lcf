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
	Andrew es una maquina de estados, un robot.
	Un robot como Andrew, el hombre Bicentenario.
*/

public class Andrew
{
	public static final int INVALID		= -1;
	public static final int LOAD 		= 0;
	public static final int SPLASH 		= 1;
	public static final int PRESS5 		= 2;
	public static final int MAIN_MENU 	= 3;
	public static final int MAIN_LOOP 	= 4;
	public static final int PAUSE 		= 5;
	public static final int DONE		= 6;
	
	public static int current_state = INVALID;
	public static int last_state 	= INVALID;
	
	public static void setState(int state)
	{
		last_state = current_state;
		current_state = state;
	}
}