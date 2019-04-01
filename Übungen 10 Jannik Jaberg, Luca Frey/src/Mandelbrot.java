import ch.unibas.informatik.cs101.ImageWindow;
import java.util.ArrayList;

public class Mandelbrot {
  
  public static int instanceCount;
  public int windowCount;
  public long timer;

  public ColorPalette colPal;
  public double fact;
  public int threads;
  public boolean benchmark;
  public int width;
  public int height;
  private ArrayList<ImageWindow> windowManager;
  private ArrayList<ArrayList<MandelbrotThread>> threadManager;

  public interface  CallbackListener {
    public void threadIsDone();
  }

  // Constructor w/o defaults
  public Mandelbrot(int colPal, double fact, int threads, boolean benchmark) {
    this.colPal = new ColorPalette(colPal);
    this.fact = fact;
    this.threads = threads;
    this.benchmark = benchmark;
    this.width = (int) Math.round(64 * fact);
    this.height = (int) Math.round(48 * fact);
    this.windowManager = new ArrayList<ImageWindow>();
    this.threadManager = new ArrayList<ArrayList<MandelbrotThread>>();
    instanceCount++;
  }

  // Constructor w/ 2 default values
  public Mandelbrot(int colPal, double fact) {
    this(colPal, fact, 1, false);
  }
  
  void show_mandelbrot(Complex c_origin, double c_step, int max_iter, boolean inplace, String windowTitle) {
    windowManager.add(new ImageWindow(width, height));
    windowManager.get(windowCount).openWindow(windowTitle, (width+50)*(instanceCount-1),(height+60)*windowCount);

    threadManager.add(new ArrayList<MandelbrotThread>());

    for (int i = 0; i <= threads; i++) {
      int x_steps = width / threads;
      int x_start = x_steps * i;
      threadManager.get(windowCount).add(new MandelbrotThread(windowManager.get(windowCount), colPal, c_origin, c_step, max_iter, x_start, x_steps, height, width, inplace));
      threadManager.get(windowCount).get(i).start();

    }
    for (int i =0; i<=threads; i++){
      try {
        threadManager.get(windowCount).get(i).join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    windowCount++;
  }

}
