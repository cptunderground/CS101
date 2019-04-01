
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Post
{
    public static void main(String[] args) throws Exception
    {
        final String filePath = "src/Adressdaten2016.csv";

        // A HashMap is a fast, easy and predictable data structure to hold KVPs
        // (in our case the location names that correspond to a PLZ).
        HashMap<Integer, List<String>> csv = new HashMap<>(50);

        File file = new File(filePath);
        if (!file.exists())
        {
            System.out.println("\nThe file \"" + filePath + "\" doesn't exist.\nTerminating application...");
            System.exit(0);
        }

        // At this point we're sure the CSV file exists.
        // The buffered reader is gonna read through our csv file.
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Create a container variable for each read line.
        String line;

        //Read to skip the header
        br.readLine();

        while ((line = br.readLine()) != null)
        {
            String[] lineContent = line.split(";");

            if (lineContent.length > 0)
            {
                int plz = Integer.valueOf(lineContent[4]);
                String location = lineContent[7];

                if (csv.containsKey(plz))
                {
                    csv.get(plz).add(location);
                }
                else
                {
                    List<String> l = new ArrayList<>(5);
                    l.add(location);
                    csv.put(plz, l);
                }
            }
        }

        System.out.println("\n------------------------\n\nWelcome to the Swiss Post!\n\n");

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\t-Type a valid Swiss zip-code to display its corresponding location name (according to the provided Adressdaten2016.csv)\n\n\t-Type \"Q\" to quit.\n");

            String nextCommand = scanner.nextLine();

            if (nextCommand.equalsIgnoreCase("q"))
            {
                System.out.println("QUIT");
                System.exit(0);
            }

            try
            {
                int plz = Math.abs(Integer.valueOf(nextCommand));

                System.out.println("\nThe PLZ \"" + plz + "\" holds the following location names:\n");

                // Get the associated location names from the CSV HashMap.
                List<String> locationNames = csv.get(plz);

                // Print out the results.
                for (String s : locationNames)
                {
                    System.out.println(s + "\n");
                }
            }
            catch (Exception e)
            {
                // Handle invalid zip-codes...
                System.out.println("ERROR: \"" + nextCommand + "\" is not a valid command or zip-code from the provided CSV file. Try again...\nException message: " + e.getMessage() + "\n");
            }
        }
    }
}
