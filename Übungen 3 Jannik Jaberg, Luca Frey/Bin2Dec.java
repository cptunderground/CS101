// Jannik Jaberg, 16. October 2017

public class Bin2Dec
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            throw new IllegalArgumentException("No parameter passed: the correct invocation signature is \"java Bin2Dec 1 0 0 1 0 [...]\".");
        }

        int dec = 0;

        int argsLength = args.length;

        // Read the binary number R->L
        for (int i = argsLength - 1; i >= 0; i--)
        {
            // Calculate how much we'd add if the digit was 1.
            int a = (int) Math.pow(2, argsLength - 1 - i);

            // If the digit actually is 1,
            // add the corresponding power of 2 to the "dec" variable.
            if (Math.abs(Integer.parseInt(args[i])) == 1)
            {
                dec += a;
            }
        }

        System.out.println(dec);
    }
}
