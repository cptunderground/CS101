import ch.unibas.informatik.cs101.ImageWindow;

public class BasicDrawing {
  public static ImageWindow w1;
  public static ImageWindow w2;
  public static ImageWindow w3;
  public static ImageWindow w4;

  public static void main(String args[]) {
    
    w1 = new ImageWindow(500,500);
    w2 = new ImageWindow(500,500);
    w3 = new ImageWindow(500,500);
    w4 = new ImageWindow(500,500);
    

    w1.openWindow("Kreuz",200,200);
    w2.openWindow("Rechteck",800,200);
    w3.openWindow("Schachbrett",1400,200);
    w4.openWindow("Kreis",2000,200);

    //Kreuz
    for (int x=0; x<500; x++)
        w1.setPixel(x, 250, 0, 100, 100);
    for (int y=0; y<500; y++)
        w1.setPixel(250, y, 0, 100, 100);
  
    //Rechteck
    for (int x=100; x<400; x++){
        for (int y=100; y<400; y++)
        w2.setPixel(x, y, 0, 100, 100);
    }

    //Schachbrett
    for (int x=0; x<500/20; x++){
        for (int y=0; y<500/20; y++){
            if ((x%2==0 && y%2==0) || (x%2!=0 && y%2!=0)) {
                for (int i=0; i<20; i++) {
                    for (int j=0; j<20; j++) {
                    w3.setPixel(x*20+i, y*20+j, 0, 0, 0);
                    } 
                }  
            }      
        }
    }    
     
    
    double r = 20000;
    for (int x = -500; x < 500; x++) {
        for (int y = -500; y < 500; y++) {
            if(r >= (Math.pow(x,2) + Math.pow(y, 2))){
                w4.setPixel(x+249, y+249, 254, 0, 0);
            }
        }
    }        
                 

    w1.redraw();
    w2.redraw();
    w3.redraw();
    w4.redraw();

  }
}
