import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlienShip extends Critter
{
	public AlienShip()
	{
		setColor(null);
	}
	public void act()
	{
		 if (getGrid() == null) 
			 return; 
		 ArrayList<Actor> actors = getActors(); 
		 processActors(actors); 
		 ArrayList<Location> moveLocs = getMoveLocations(); 
		 Location loc = selectMoveLocation(moveLocs); 
		 setDirection(getLocation().getDirectionToward(loc)-180); 
		 super.makeMove(loc); 
	}
	public void processActors(ArrayList<Actor> actors)
	{
		 JFrame frame2 = new JFrame("Warning!");
		for (Actor a : actors) 
		 { 
			 if ((!(a instanceof Rock) && !(a instanceof Critter)) && (a instanceof Ship))
			 {
				 GWorldRunner.current.alive--;
			    	JLabel emptyLabel2 = new JLabel("Life left: " + String.valueOf(GWorldRunner.current.alive));
			    	frame2.getContentPane().add(emptyLabel2, BorderLayout.CENTER);
			    	frame2.pack();
			    	frame2.setLocationRelativeTo(null);
		    		frame2.setVisible(true);
		    		frame2.setFocusableWindowState(false);
			 }
		 } 
	}
}
