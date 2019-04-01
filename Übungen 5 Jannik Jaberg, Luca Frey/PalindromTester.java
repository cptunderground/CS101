public class PalindromTester{
	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("java PalindromeTester \"text\"");			
		}

		String arg0 = args[0];
		System.out.println(testPalindrom(arg0)? arg0 + " is a palindrom!" : arg0 + " is NOT a palindrom!");
	}
	public static boolean testPalindrom(String text){
		text = text.toLowerCase().replaceAll("[^A-Za-z]","");
		String reverse = new StringBuilder(text).reverse().toString();

		if (text.equals(reverse)) {
			return true;	
		}
		else 
			return false;
	}
}