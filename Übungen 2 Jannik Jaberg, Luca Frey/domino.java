public class domino {
     public static void main(String[] args) {
        start();
        System.out.println();
        start1();
     }
    //OHNE DUPLIKATE
    
    public static void start() {
       int upper, lower;
       int c = 6;
       upper = 0;
       while(upper <= c) {
          lower = upper; // keine Duplikate
          while(lower <= c ) {
               System.out.print("("+ upper + "|" + lower+ ")");
               lower = lower + 1;
           }
           upper = upper + 1;
           System.out.println();
       }
    }
    

    //MIT DUPLIKATEN
    private static void start1() 
    {
       int upper = 0, lower = 0;
       int c = 6;
       while(upper <= c) 
       {
          while(lower <= c)
          {
                 System.out.print("("+ upper + "|" + lower+ ")");
                 lower = lower + 1;
          }
          upper = upper + 1;
          lower = 0;
          System.out.println();
       }
    }
}                        