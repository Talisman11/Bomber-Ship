import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class Ship extends Bug
{
	int alive;
	int points = 0;
	
	public Ship()
	{
		alive = 3;
		setColor(null);
	}
	public void act()
	{
		points += 1;
		
		if (alive <= 0 )
    	{
			JFrame frame2 = new JFrame("Mayday!");
	    	JLabel emptyLabel2 = new JLabel("Game Over! Restart by aborting program." + 
			" Score: " + String.valueOf(points) + ". 1 point per step; 100 points per AlienShip");
	    	frame2.getContentPane().add(emptyLabel2, BorderLayout.CENTER);
	    	frame2.pack();
	    	frame2.setLocationRelativeTo(null);
    		frame2.setVisible(true);
    		removeSelfFromGrid();
    	}
	}
	public void bomb()
	{
		Grid<Actor> gr = getGrid(); 
		 if (gr == null) 
		 return; 
		Bomb t = new Bomb(3); 
		 t.putSelfInGrid(gr, getLocation().getAdjacentLocation(getDirection()-180)); 
	}
	public boolean canMove(int direction)
	{
		Grid<Actor> gr = getGrid(); 
		 if (gr == null) 
		 return false; 
		Location loc = getLocation(); 
		Location next = loc.getAdjacentLocation(direction); 
		if (!gr.isValid(next)) 
		return false; 
		Actor neighbor = gr.get(next); 
		return (neighbor == null) || (neighbor instanceof Flower); 

	}
}
