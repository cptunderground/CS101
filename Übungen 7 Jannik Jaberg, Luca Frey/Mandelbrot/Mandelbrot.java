import ch.unibas.informatik.cs101.ImageWindow;
import java.awt.Color;

public class Mandelbrot {

  ColorPalette colPal;
  int width;
  int height;
  ImageWindow sourceWindow;


  public static void main(String[] args) {

    if (args.length == 0)
        {
            throw new IllegalArgumentException("\nNo parameter passed: the correct invocation signature is:\n\"java Mandelbrot 0 int\"\n or\n\"java Mandelbrot 1 int\"");
        }

    int palette = Integer.parseInt(args[0]);
    double fact = Double.parseDouble(args[1]);
    long startTime = 0, endTime;
    int width = (int) Math.round(64 * fact);
    int height = (int) Math.round(48 * fact);

    Mandelbrot m1 = new Mandelbrot( width, height, palette);
    
      long start1 = System.currentTimeMillis();
      m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05/fact, 1000);
      long end1 = System.currentTimeMillis();
      System.out.println("m1.show_mandelbrot()...");
      System.out.println("Time taken: " + (end1 - start1) + "ms");
    
    Mandelbrot m2 = new Mandelbrot( width, height, palette);

      long start2 = System.currentTimeMillis();
      m2.show_mandelbrot_inplace(new Complex(-2.5, -1.3), 0.05/fact, 255);
      long end2 = System.currentTimeMillis();
      System.out.println("m2.show_mandelbrot_inplace()...");
      System.out.println("Time taken: " + (end2 - start2) + "ms");
    

    Mandelbrot m3 = new Mandelbrot( width, height, palette);
        
      long start3 = System.currentTimeMillis();
      m3.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
      long end3 = System.currentTimeMillis();
      System.out.println("m3.show_mandelbrot()...");
      System.out.println("Time taken: " + (end3 - start3) + "ms");

    Mandelbrot m4 = new Mandelbrot( width, height, palette);
    
      long start = System.currentTimeMillis();
      m4.show_mandelbrot_inplace(new Complex(-0.755, -0.1), 0.0002/fact, 255);
      long end = System.currentTimeMillis();
      System.out.println("m4.show_mandelbrot_inplace()...");
      System.out.println("Time taken: " + (end - start) + "ms");
    
    
  }


  public Mandelbrot(int _width, int _height, int pal) {
    width = _width;
    height = _height;
    sourceWindow= new ImageWindow(width,height);
    sourceWindow.openWindow("mandelbrot",0,0);
    colPal = new ColorPalette(pal);
  }

  void show_mandelbrot(Complex c_origin, double c_step, int max_iter) 
  {
    //DONE
    for (int x = 0; x < width; x++) 
    {
      for (int y = 0; y < width; y++) 
      {
        int max = max_iter;
        Complex c = new Complex(c_origin.real() + x * c_step, c_origin.imag() + y * c_step);
        int n = 0;
        Complex z = new Complex(0, 0);

        while (max > 0 && z.abs_sqr() < 4) 
        {

          z = z.sqr().add(c);

          n++;
          max--;
        }

        Color col = colPal.getColor(n, c_origin);

        sourceWindow.setPixel(x, y, col.getRed(), col.getGreen(), col.getBlue());

      }
      redraw();
    }
  }

  void show_mandelbrot_inplace(Complex c_origin, double c_step, int max_iter) 
  {
    //DONE
    for (int x = 0; x < width; x++) 
    {
      for (int y = 0; y < width; y++) 
      {
        int max = max_iter;
        Complex c = new Complex(c_origin.real() + x * c_step, c_origin.imag() + y * c_step);
        int n = 0;
        Complex z = new Complex(0, 0);

        while (max > 0 && z.abs_sqr() < 4) 
        {

          z.sqr_inplace().add_inplace(c);

          n++;
          max--;
        }

        Color col = colPal.getColor(n, c_origin);

        sourceWindow.setPixel(x, y, col.getRed(), col.getGreen(), col.getBlue());

      }
      redraw();
    }
  }

  public void redraw() {
    sourceWindow.redraw();
  }
}
