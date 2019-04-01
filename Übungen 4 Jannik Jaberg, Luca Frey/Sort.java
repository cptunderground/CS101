import ch.unibas.informatik.cs101.ImageWindow;

public class Sort
{
    static ImageWindow w1;
    static ImageWindow w2;


    static final int windowWidth = 790, windowHeight = 790;

    
    public static void swap(int i, int j, char[] characters) {
    char tempi = characters[i];
    char tempj = characters[j];

    characters[i] = tempj;
    characters[j] = tempi;
    displayArray1(characters);
  }

  
  public static void sort1(char[] characters) {

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
    
  }


    public static void sort2(char[] characters)
    {
        int h_size = characters.length;
        assertHeapRules(characters, h_size);
        while (h_size > 1)
        {
            swapFirst(characters, --h_size);
            siftDown(characters, h_size, 0);
        }
    }


    public static void assertHeapRules(char[] characters, int h_size)
    {
        for (int idx = h_size / 2; idx >= 0; --idx)
            siftDown(characters, h_size, idx);
    }

    /**
     * Find a place for a new root.
     * The new root goes down the heap until no rule break is found.
     **/
    public static void siftDown(char[] characters, int h_size, int start)
    {
        int idx = start;
        while (idx != -1)
        {
            idx = assertLocalHeapRules(characters, h_size, idx);
        }
    }

    
    public static void swapFirst(char[] characters, int h_size)
    {
        swapTwo(characters, 0, h_size);
    }

   
    public static void swapTwo(char[] c, int a, int b)
    {
        char t = c[a];
        c[a] = c[b];
        c[b] = t;
        displayArray2(c);
    }

    
    public static int assertLocalHeapRules(char[] characters, int h_size, int idx)
    {
        int first = idx * 2 + 1;
        int second = idx * 2 + 2;
        if (first >= h_size)
        {
            // no child in heap => we are finished
            return -1;
        }
        else
        {
            if (second >= h_size)
            {
                // only one child in heap => test if we have to swap
                if (characters[idx] < characters[first])
                {
                    swapTwo(characters, idx, first);
                    return first;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                // two childs in heap => test if we have to swap
                if (characters[first] < characters[second])
                {
                    if (characters[idx] < characters[second])
                    {
                        swapTwo(characters, idx, second);
                        return second;
                    }
                    else
                    {
                        if (characters[idx] < characters[first])
                        {
                            swapTwo(characters, idx, first);
                            return first;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                }
                else
                {
                    if (characters[idx] < characters[first])
                    {
                        swapTwo(characters, idx, first);
                        return first;
                    }
                    else
                    {
                        if (characters[idx] < characters[second])
                        {
                            swapTwo(characters, idx, second);
                            return second;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                }
            }
        }
    }

    public static void displayArray1(char[] characters)
    {
        assert (w1 != null);
        
        int columnWidth = (windowWidth / characters.length);
       
        w1.fillImage(0,0,0);
     
       

       
        int x = 0;
        for (int i = 0; i < characters.length; i++)
        {
            for (int ii = 0; ii < columnWidth; ii++)
            {
                int color = Character.getNumericValue(characters[i]) * 7;
                int height = Character.getNumericValue(characters[i]) *20;
                for (int y = 0; y < height; y++)
                {
                    w1.setPixel(x, windowHeight - y, 0, 255, Math.abs(255 - color));
                }	
                x++;
            }

        }

        w1.redraw();
    
        w1.pause(12);
        for (int i=0; i<characters.length; i++) {
          System.out.print(characters[i]);  
        }
        System.out.println();
  

        
    }

    public static void displayArray2(char[] characters)
    {
        
        assert (w2 != null); 
        int columnWidth = (windowWidth / characters.length);
        

        w2.fillImage(0,0,0);

       
        int x = 0;
        for (int i = 0; i < characters.length; i++)
        {
            for (int ii = 0; ii < columnWidth; ii++)
            {
                int color = Character.getNumericValue(characters[i]) * 7;
                int height = Character.getNumericValue(characters[i]) *20;
                for (int y = 0; y < height; y++)
                {
                    
                	w2.setPixel(x, windowHeight - y, 255, Math.abs(255 - color), 0);
                }
                x++;
            }

        }

        w2.redraw();
        w2.pause(12);
        for (int i=0; i<characters.length; i++) {
          System.out.print(characters[i]);  
        }
        System.out.println();

        
    }

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf!");
            System.out.println("  java Sort 'dies ist ein text'");
            System.exit(-1);
        }

        w1 = new ImageWindow(windowWidth, windowHeight);
        w2 = new ImageWindow(windowWidth, windowHeight);
        w1.fillImage(0,0,0);
        w2.fillImage(0,0,0);
        w1.openWindow("Visualizing Bubblesort", 1886, 46);
        w2.openWindow("Visualizing Heapsort", 1886, 876);

        w1.redraw();
        w2.redraw();

        char[] characters = args[0].toCharArray();
        for (int i = 0; i < characters.length; i++)
        {
            char c = characters[i];
            characters[i] = Character.toLowerCase(c);
        }
        sort1(characters);
        sort2(characters);

        displayArray1(characters);
        displayArray2(characters);
        System.out.println("Das Array wurde sortiert!");
    }
}