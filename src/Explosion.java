import info.gridworld.actor.Flower;
import java.awt.Color;

public class Explosion extends Flower
{
	private int displayLife = 5;
	
	public Explosion()
	{
		setColor(Color.RED);
	}
	public void act()
	{
		displayLife--;
		decay();
		if (displayLife <= 0)
			removeSelfFromGrid();
	}
	public void decay()
	{
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - .33));
	    int green = (int) (c.getGreen() * (1 - .33));
	    int blue = (int) (c.getBlue() * (1 - .33));

	    setColor(new Color(red, green, blue));
	}
}
