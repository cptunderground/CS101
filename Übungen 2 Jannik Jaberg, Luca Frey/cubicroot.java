public class cubicroot{
	public static void main(String[] args) {
		String arg0 =args[0];
		assert(arg0 != "");
		


		double a = Double.parseDouble(arg0);
		double xn = 1;
		double xn1;

		while(true){
			xn1 = ((2*xn+(a/Math.pow(xn,2)))/3);

			if (Math.abs(xn1-xn)>10E-8) {
				xn=xn1;
				System.out.println(xn1);
				}
			else {
				System.out.println("Die Kubikwurzel von "+ a + " ist " + xn1 + "." );
				break;
			}
		}

	}
}