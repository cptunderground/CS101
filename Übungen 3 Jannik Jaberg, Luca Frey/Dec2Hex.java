//Jannik Jaberg, 16. October 2017

public class Dec2Hex
{
    /*
            0   1   2   3   4   5   6   7   8   9   A   B   C   D   E   F
            |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
            0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
     */
    final static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args)
    {
        
        if (args.length != 1)
        {
            throw new IllegalArgumentException("Illegal arguments (or none at all) passed: the correct invocation signature is \"java Dec2Hex <insert_integer_here>\".");
        }


        int dec = Math.abs(Integer.parseInt(args[0]));

        String rawHex = "";

        while (dec > 0)
        {
            
            int remainder = dec % 16;

            rawHex = hexDigits[remainder] + rawHex;

            dec /= 16;
        }

        String hex = "0x0" + rawHex;

        System.out.println(hex);
    }
}

