public class AnagrammTester
{
	public static void main(String[] args)
  {
        if (args.length != 2)
        {
            throw new IllegalArgumentException("Wrong amount of arguments passed, please invoke with java AnagrammTester \"string1\" \"string2\".");
        }

        String arg0 = args[0];
        String arg1 = args[1];

        System.out.println("Okay, so here we go...\n\n" + arg0 + "\n\nand\n\n" + arg1 + "\n\n are " + (testAnagramm(arg0, arg1) ? "" : "NOT ") + "anagrams!\n");
  }

    public static boolean testAnagramm(String text1, String text2){
    	char[] text1Ar = text1.toLowerCase().replaceAll("[^A-Za-z]","").toCharArray();
    	char[] text2Ar = text2.toLowerCase().replaceAll("[^A-Za-z]","").toCharArray();

    	if (text1Ar.length != text2Ar.length) 
      {
    		return false;
       	}
	
       	else{
       		sort(text1Ar);
       		sort(text2Ar);

       		for (int i = 0; i< text1Ar.length; i++) 
          {
       			if (text1Ar[i] != text2Ar[i]) 
            {
       				return false;
       			}
       			
       		}
       	return true;
        }
	    }

	public static void swap(int i, int j, char[] characters) {
    char tempi = characters[i];
    char tempj = characters[j];

    characters[i] = tempj;
    characters[j] = tempi;
  }
  	
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
  }
}