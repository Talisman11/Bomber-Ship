import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class Bomb extends Rock
{
	private int life;
	
	public Bomb(int time)
	{
		life = time;
		
		setColor(null);
	}
	public void act()
	{
		life--;
		if (life <= 0)
		{
			explode();
		}	
	}	
	public void explode()
	{
		ArrayList<Location> around = new ArrayList<Location>(getGrid().getValidAdjacentLocations(getLocation()));
		around.add(getLocation());
		for (Location e: around)
		{
			if (getGrid().get(e) instanceof AlienShip)
			{
				GWorldRunner.current.points += 100;
			}
			
			Explosion boom = new Explosion();
			boom.putSelfInGrid(getGrid(), e);
		}
	}
}

