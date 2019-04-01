import java.util.Scanner;

public class SearchTreeTest {
    public static void main(String[] args) {
        // Add the test PLZ from Blatt8.pdf
        SearchTree baum = new SearchTree(new Leaf(3920, "Zermatt"));
        baum.insert(3215, "Gempenach");
        baum.insert(4000, "Basel");
        baum.insert(4312, "Magden");
        baum.insert(3000, "Bern");
        baum.insert(7436, "Medels");
        baum.insert(3800, "Interlaken");
        baum.insert(4104, "OBERWIL BRONX");

        System.out.println("Please write the PLZ you are searching for!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String Ort = scanner.nextLine();
            if (Ort.toLowerCase().equals("quit")) {
                System.exit(0);
            }
            int PLZ = Integer.parseInt(Ort);
            String value = baum.search(PLZ);

            if (value == null) {
                System.out.println("PLZ not found in tree!");
                //System.out.println("if you want to Search some more PLZs please write them below, to quit type QUIT");
            } else {
                System.out.println(value);
                //System.out.println("if you want to Search some more PLZs please write them below, to quit type QUIT");
            }
            System.out.println("if you want to Search some more PLZs please write them below, to quit type QUIT");
        }

    }
}
