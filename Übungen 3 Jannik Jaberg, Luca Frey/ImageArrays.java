import ch.unibas.informatik.cs101.ImageWindow;
import java.util.Random;

public class ImageArrays {

	public static void main(String[] args) {
		//create & open the first window (to display the source image)
		ImageWindow sourceWindow= new ImageWindow(500,500);
		sourceWindow.openWindow("source",0,0);

		//load the image 
		sourceWindow.loadImage("horn.jpg");	

		//redraw to see the image
		sourceWindow.redraw();


		/*  TODO: create an array that is large enough to hold
         *       the complete image information
         */
		int res = 500 * 500;
		int[] pixels = new int [3*res];

		/*  TODO: store the complete image information in the
         *        array you have created.
         *  HINT: int red=sourceWindow.getPixelRed(xPosition, yPosition);
		 *        int green=sourceWindow.getPixelGreen(xPosition, yPosition);
		 *        int blue=sourceWindow.getPixelBlue(xPosition, yPosition);
	 	 */
		int red = 0;
		int green = res;
		int blue = res * 2;
		for (int x=0; x<500; x++) 
		{
			for (int y=0; y<500; y++) 
			{
				pixels[red]=sourceWindow.getPixelRed(x,y);
				red++;
				pixels[green]=sourceWindow.getPixelGreen(x,y);
				green++;
				pixels[blue]=sourceWindow.getPixelBlue(x,y);
				blue++;
			}
			
		}

		//create & open the second windo (to draw your copy into)
		ImageWindow destinationWindow= new ImageWindow(500,500);
		destinationWindow.openWindow("Image rotated by 90 degree",550,0);



		/*  TODO: write back your array data into the destinationWindow so that
         *        it appears to be rotated 90 degrees.
         *  HINT: destinationWindow.setPixel(xPos,yPos,red,green,blue);
		 */
		red = 0;
		green = res;
		blue = 2*res;

		for (int y=0; y<500; y++) 
		{
			for (int x=499; x>=0; x--) 
			{
				destinationWindow.setPixel(x,y,pixels[red],pixels[green],pixels[blue]);

				red++;
				green++;
				blue++;
					
			}
				
		}


                // redraw to see the changed image
        destinationWindow.redraw();

                // Create another output window
		ImageWindow destinationWindow2= new ImageWindow(500,500);
		destinationWindow2.openWindow("Image with permuted color channels",0,550);



                /*  TODO: call here your function which permutes the color channels
                 */
		int[] newpixels = linardwiesoheschduunsepunktabzoge(pixels);

		red = 0;
		green = res;
		blue = 2*res;

		for (int y=0; y<500; y++) 
		{
			for (int x=0; x<500; x++) 
			{
				destinationWindow.setPixel(x,y,newpixels[red],0,0);
				red++;
				green++;
				blue++;			
			}
				
		}


        

                // redraw to see the changed image
		destinationWindow2.redraw();
	}


        /*  TODO: implement here the function to rotate the color channels.
         *  HINT: think about the arguments you need for the function.
         */
     public static int[] linardwiesoheschduunsepunktabzoge(int[]pixels)
     {
     	int i=0;
     	int newres = 500 * 500;
        int[] newpixels = new int [3*newres];
        for (int x = 0; x <500; x++)
        {
        	for (int y = 499; y >=0; y--)
        	{
        		newpixels[i] = pixels[x*500+y];
        	}
        	
        }
        	return newpixels;
	}	

}
