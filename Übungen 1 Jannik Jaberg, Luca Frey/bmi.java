public class bmi
 {
 	public static void main(String[] args) 
 	{
 		String arg1 = args[0];
 		assert(arg1 != "");
 		String arg2 = args[1];
 		assert(arg2 != "");

 		double size 	= Double.parseDouble(arg1);
		double weight 	= Double.parseDouble(arg2);
 		size = 0.01 * size;

 		double bmi = (weight / (size*size));

 		System.out.println(bmi);

 		if (bmi < 20) 
 			{
 			System.out.println("Sie haben einen BMI unter 20.");
 			}
 		if ( 20 <= bmi && bmi<= 25 )
 			{
 			System.out.println("Dein BMI ist zwischen 20 und 25.");
 			}
 		if (bmi > 25)
 			{
 			System.out.println("Ihr BMI ist ueber 25.");
 			}

 	}

 	
 }