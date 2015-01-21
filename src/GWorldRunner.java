import info.gridworld.grid.Location;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class GWorldRunner
{
	public static Ship current;
	
    public static void main(String[] args)
    {    	
    	JFrame frame = new JFrame("Hello");
    	JLabel emptyLabel = new JLabel("Move your ship to a safe place, and begin the survival...");
    	frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	
    	//suppress the bounding square from displaying on the grid
    	System.setProperty("info.gridworld.gui.selection", "hide");
    	
    	//suppress the toString method from displaying
    	System.setProperty("info.gridworld.gui.tooltips", "hide");
    	
    	//Set the title bar of the window
    	System.setProperty("info.gridworld.gui.frametitle", "Bomber Ship");
    	
    	current = new Ship();
    	AlienShip a = new AlienShip();
    	AlienShip b = new AlienShip();
    	AlienShip c = new AlienShip();
    	a.setDirection(135);

    	b.setDirection(135);

    	c.setDirection(135);
    	
        GWorld world = new GWorld();

    	current.putSelfInGrid(world.getGrid(), new Location(0,0));
    	
        a.putSelfInGrid(world.getGrid(), new Location (9, 9));

        b.putSelfInGrid(world.getGrid(), new Location (8, 9));

        c.putSelfInGrid(world.getGrid(), new Location (9, 8));
        
        world.show();

    	frame.setVisible(true);

    	
    	
    }
}



