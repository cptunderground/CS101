import ch.unibas.informatik.cs101.ImageWindow;
import java.awt.Color;
import java.time.Duration;
import java.time.Instant;

public class MandelbrotThread extends Thread implements Mandelbrot.CallbackListener {

  private ImageWindow w;
  private ColorPalette colPal;
  private Complex c_origin;
  private double c_step;
  private int max_iter;
  private int x_start;
  private int x_steps;
  private int height;
  private int width;
  private boolean inplace = false;
  private Duration time;


  public MandelbrotThread(ImageWindow w, ColorPalette colPal, Complex c_origin, double c_step, int max_iter, int x_start, int x_steps, int height, int width, boolean inplace) {
    this.w = w;
    this.colPal = colPal;
    this.c_origin = c_origin;
    this.c_step = c_step;
    this.max_iter = max_iter;
    this.x_start = x_start;
    this.x_steps = x_steps;
    this.height = height;
    this.width = width;
    this.inplace = inplace;
  }

  public void run() {
    Instant start = Instant.now();
    
    Complex z;
    Complex c;

    // inplace
    if (inplace) {
      for (int x = x_start; x < x_start + x_steps; x++) {
        for (int y = 0; y < height; y++) {
          int max = max_iter;
          int n = 0;
          c = new Complex((c_origin.real() + c_step * x), (c_origin.imag() + c_step * y));
          z = new Complex(0.0, 0.0);
          while (z.abs_sqr() < 4.0 && 0 < max) {
            z.sqr_inplace().add_inplace(c);
            max--;
            n++;
          }
          //Color col = colPal.getColor(n, z);
          Color col = colPal.getColor(n, c_origin);
          w.setPixel(x, y, col.getRed(), col.getGreen(), col.getBlue());
        }
        w.redraw();
      }
    // regular
    } else {
      for (int x = x_start; x < x_start + x_steps; x++) {
        for (int y = 0; y < height; y++) {
          int max = max_iter;
          int n = 0;
          c = new Complex((c_origin.real() + c_step * x), (c_origin.imag() + c_step * y));
          z = new Complex(0.0, 0.0);
          while (z.abs_sqr() < 4.0 && 0 < max) {
            z = z.sqr().add(c);
            max--;
            n++;
          }
          Color col = colPal.getColor(n, c_origin);
          w.setPixel(x, y, col.getRed(), col.getGreen(), col.getBlue());
        }
        w.redraw();
      }
    }
  Instant end = Instant.now();
  time = Duration.between(start, end);
  }

  public Duration getTime() {
    return this.time;
  }

  public void threadIsDone() {

  }

}