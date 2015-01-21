import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class GWorld extends ActorWorld
{
	public GWorld()
	{
		setMessage("Arrow keys to move, space for bombs...");
	}
    public boolean keyPressed(String description, Location loc)
    {
    	
    	if (GWorldRunner.current != null)
    	{
	    	if(description.equalsIgnoreCase("left"))
	    	{
	    		
	    		GWorldRunner.current.setDirection(Location.LEFT);
	    		if(GWorldRunner.current.canMove(Location.LEFT))
	    			GWorldRunner.current.moveTo(GWorldRunner.current.getLocation().getAdjacentLocation(Location.LEFT));
	    	}
	    	else if(description.equalsIgnoreCase("right"))
	    	{
	    		
	    		GWorldRunner.current.setDirection(Location.RIGHT);
	    		if(GWorldRunner.current.canMove(Location.RIGHT))
	    			GWorldRunner.current.moveTo(GWorldRunner.current.getLocation().getAdjacentLocation(Location.RIGHT));
	    	}
			else if(description.equalsIgnoreCase("up"))
			{
	    		
				GWorldRunner.current.setDirection(Location.NORTH);
				if(GWorldRunner.current.canMove(Location.NORTH))
					GWorldRunner.current.moveTo(GWorldRunner.current.getLocation().getAdjacentLocation(GWorldRunner.current.getDirection()));
			}
			else if(description.equalsIgnoreCase("down"))
			{
	    		
				GWorldRunner.current.setDirection(Location.SOUTH);
				if(GWorldRunner.current.canMove(Location.SOUTH))
					GWorldRunner.current.moveTo(GWorldRunner.current.getLocation().getAdjacentLocation(GWorldRunner.current.getDirection()));
			}
			else if (description.equalsIgnoreCase("Space"))
			{
				GWorldRunner.current.bomb();
			}
    	}
    	System.out.println(description);
        return true;
    }
    public boolean locationClicked(Location loc)
    {
    	if(getGrid().get(loc)==GWorldRunner.current)
    		return false;
    	
    	System.out.println(loc);
        return true;
    }  
}
