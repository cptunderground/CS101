import ch.unibas.informatik.cs101.ImageWindow;

public class BasicTurtle {
  public static ImageWindow w;
  public static void main(String args[]) {
    
    ImageWindow hur = new ImageWindow(500,500);

    
    hur.openWindow("Linard the Turtle", 100, 100);

    Turtle Linard = new Turtle(hur);

    Linard.rotateTurtle(1, true);
    Linard.moveTurtle(100);
    Linard.togglePen();
    Linard.moveTurtle(50,255);
    Linard.rotateTurtle(1, true);
    Linard.moveTurtle(50, 0, 255);
    Linard.rotateTurtle(1, false);
    Linard.moveTurtle(50, 0, 0, 255);
    Linard.rotateTurtle(1, true);
    Linard.moveTurtle(50, 123, 123, 123);
    Linard.rotateTurtle(3, false);
    Linard.moveTurtle(50);
    Linard.rotateTurtle(1, false);
    Linard.moveTurtle(50, 23, 65);
    Linard.rotateTurtle(1, true);
    Linard.moveTurtle(50);

    Turtle Linardbetrunken = new Turtle(hur);

    Linardbetrunken.rotateTurtle(1, false);
    Linardbetrunken.moveTurtle(100);
    Linardbetrunken.rotateTurtle(1, true);
    Linardbetrunken.togglePen();

    int[] red = new int[]{255, 130, 0, 0};
    int[] green = new int[]{0, 0, 255, 0};
    int[] blue = new int[]{0, 150, 255, 255};
    int[] counter = new int[]{0,1,2,3};

    for (int i: counter) {
        Linardbetrunken.rotateTurtle(1, false);

        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, true);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, false);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, true);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, true);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, false);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);
        Linardbetrunken.rotateTurtle(1, true);
        Linardbetrunken.moveTurtle(30, red[i], green[i], blue[i]);    
    }



    
    hur.redraw();
  }
}
