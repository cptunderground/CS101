import java.util.Random;


public class GenPool {
    
    //DONE
    Random r = new Random();
    Genom[] gpool;
    
    //DONE
    GenPool( int n, int len ) 
    {  
        gpool= new Genom[n];

        randomize(len);
    }


    //DONE
    public Genom[] getGenPool() {
        return this.gpool;
    }
    
    //DONE
    private void randomize(int len) {
        int i=0;
        while(i<gpool.length){
            int l = r.nextInt(len)+1;
            gpool[i]=new Genom(l);
            i++;
        }
    }
    
    //DONE
    public boolean contains(Genom other) {
        
        for (Genom genom1 : gpool) 
        {
            if (genom1.isEqual(other)) {
                   return true; 
                }    
        }
        return false;
    }
    
    //TODO
    public void mutate() {
        for (Genom genepool1 : gpool) {
            switch (r.nextInt(4)) 
            {
                case 0:
                    genepool1.deletion();
                    break;
                case 1:
                    genepool1.pointMutation();
                    break;
                case 2:
                    genepool1.insertion();
                    break;
                default:
                    //System.out.println("not mutated");
                    break;
            }
        }
    }
    
    //DONE
    
    public String toString() {
        String s = "";
        for (Genom c : this.gpool) 
        {
            s=s+ c.toString();      
        }
        return s;
    }

}
