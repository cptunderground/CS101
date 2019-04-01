import ch.unibas.informatik.cs101.ImageWindow;

public class Turtle{
	
	int x, y, direction = 0;
	boolean pen;
	ImageWindow hur;

	public Turtle(ImageWindow hur){
		this.hur = hur;
		x = hur.getWidth() / 2;
		y = hur.getHeight() / 2;
		pen = false;
	}

	public void togglePen(){
		pen = !pen;
	}

	public void rotateTurtle(int turns, boolean clockwise)
    {
        for (int i = 0; i < turns; i++)
        {
            if (clockwise)
            {
                direction++;
            }
            else
            {
                direction--;
            }

      
            if (direction < 0)
            {
                direction = 3;
            }
            if (direction > 3)
            {
                direction = 0;
            }
        }
    }
    public void moveTurtle(int steps){
    	moveTurtle(steps, 0, 0, 0);
    }
    public void moveTurtle(int steps, int red){
    	moveTurtle(steps, red, 0, 0);
    }
    public void moveTurtle(int steps, int red, int green){
    	moveTurtle(steps, red, green, 0);
    }
    public void moveTurtle(int steps, int red, int green, int blue)
    {
        for (int i = 0; i < steps; i++)
        {
            if (pen)
            {
                hur.setPixel(x, y, red, green, blue); // default color is black.
            }
            switch (direction)
            {
                case 0:
                    y--;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x--;
                    break;

            }
        }
        hur.redraw();
    }    



}