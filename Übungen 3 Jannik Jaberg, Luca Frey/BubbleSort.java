import ch.unibas.informatik.cs101.ImageWindow;

class BubbleSort {

  static ImageWindow window;
  static final int windowWidth = 500, windowHeight = 500;
  /**
   * Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
   **/
  public static void swap(int i, int j, char[] characters) {
    char tempi = characters[i];
    char tempj = characters[j];

    characters[i] = tempj;
    characters[j] = tempi;
    displayArray(characters);
  }

  /**
   * Sortiert das Eingabearray und aendert das Array in place
   **/
  public static void sort(char[] characters) {

    int arrayLength = characters.length;
    
    for (int i = 0; i < arrayLength; i++)
        {
            for (int j = 1; j < (arrayLength - i); j++)
            {
                
                if (characters[j - 1] > characters[j])
                {
                  swap(j, j - 1, characters);
                }
            }
        }
    /* Diese Methode muss implementiert werden */
  }

  /**
   * Schreibt das Array auf die Ausgabekonsole
   **/
  public static void displayArray(char[] characters) 
  {
    assert (window != null);
    int columnWidth = (windowWidth / characters.length);

    window.clearImage();

      
        int x = 0;
        for (int i = 0; i < characters.length; i++)
        {
            for (int ii = 0; ii < columnWidth; ii++)
            {
                int height = Character.getNumericValue(characters[i]) * 7;
                for (int y = 0; y < height; y++)
                {
                    window.setPixel(x, windowHeight - y, Math.abs(0 + height), 0, Math.abs(255 - height));
                }
                x++;
            }

        }

        window.redraw();
        window.pause(10);

        
    }

  /**
   * Die Hauptfunktion liest das Character Array und ruft die Sortierfunktion
   * und die Ausgabefunktion auf
   **/
  public static void main(String[] args) {
    window = new ImageWindow(windowWidth, windowHeight);
        window.openWindow("Visualizing Bubblesort", 50, 100);
        window.redraw();

        char[] characters = args[0].toCharArray();
        for (int i = 0; i < characters.length; i++)
        {
            char c = characters[i];
            characters[i] = Character.toLowerCase(c);
        }
    sort(characters);

    displayArray(characters);
  }
}