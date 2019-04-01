public class cubicroot1{
	public static void main(String[] args) {
		
		assert(args[0] != "");
		double a = Double.parseDouble(args[0]);
		double xn= 0;
		double xn1 =1;

		while(Math.abs(xn1-xn)>10E-8){
			xn=xn1;
			xn1 = ((2*xn+(a/Math.pow(xn,2)))/3);
			System.out.println(xn1);
			}
			System.out.println("Die Kubikwurzel von "+ a + " ist " + xn1 + "." );
				
		
		}

	
}