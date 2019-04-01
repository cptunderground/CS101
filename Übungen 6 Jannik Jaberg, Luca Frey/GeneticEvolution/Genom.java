import java.util.Random;

public class Genom 
{
    
    char[] bases;
    Random r = new Random();
    
    //DONE
    Genom(int len) 
    {   
        //int l = r.nextInt(len)+1;
        int l = len;
        bases = new char[l];
        randomize();
    }

   //DONE 
    public char[] getGenom() {
        return bases;
    }
    
    
    public String toString() {
        String s = "";
        for (char c : this.bases ) 
        {
        	if (c !=0) 
        	{
        		s=s+ Character.toString(c);	
        	}	
        }
        return s;
    }
    
    //DONE
    public boolean isEqual(Genom other) {
        boolean a = this.toString().length() == other.toString().length();
        boolean b = this.toString().equals(other.toString());
        return (a && b);
    }
    
    //DONE
    private void randomize() 
    {
    	for (int i=0; i<this.bases.length; i++) 
    	{
    	int j = r.nextInt(4);
    	this.bases[i] = getChar(j);	
    	}
    }
    
    //DONE
    private char getChar(int a) {
        char c;
        switch (a) 
        {
        	case 0:
        		c='A';
        		break;
        	case 1:
        		c='C';
        		break;
        	case 2:	
        		c='G';
        		break;
        	case 3:
        		c='T';
        		break;
        	default:
        		c=0;
        		System.out.println(c + "is invalid.");
        }

        return c;
    }
    
    //DONE
    public void pointMutation() {
        if(bases.length!=0){
        bases[r.nextInt(bases.length)] = getChar(r.nextInt(4));
        }
    }
    
    //DONE
    public void insertion() {
        
        char b =getChar(r.nextInt(4));
        char[] tempAr = new char[bases.length + 1];
        int pos = r.nextInt(tempAr.length);
        
        //if(this.toString().length()==bases.length){
            
            
            for (int i = 0; i<tempAr.length; i++) {
                if (i<pos) {
                    tempAr[i]=bases[i];
                }

                else if (i==pos){
                    tempAr[i] = b;
                }

                else if(i>pos){
                    tempAr[i]=bases[i-1];
                }

                
            }
            bases = tempAr;
        //}


        /*
        if (this.toString().length() < bases.length) 
        {
        	while (a>= 0 && a!= pos)
        	{
        		bases[a+1]=bases[a];
        		a--;
        	}
        	bases[a+1]= b;	
        }*/
    }
    
    //DONE
    public void deletion() {
        if(bases.length!=0){
            int pos = r.nextInt(bases.length);
            char[] tempAr = new char[bases.length-1];
            
            for (int i = 0; i<tempAr.length; i++) {
                    if (i<pos) {
                        tempAr[i]=bases[i];
                    }

                    else if(i>=pos){
                        tempAr[i]=bases[i+1];
                    }
            }
            bases=tempAr;

            /*int index = r.nextInt(bases.length);
            if (index == (bases.length-1)) 
            {
            	bases[index] = 0;
            	return;	
            }
            for(int a = index; a< bases.length-1;a++)
            {
            	bases[a]=bases[a+1];
            	bases[a+1]=0;
            }*/
        }    
    }
    
}
