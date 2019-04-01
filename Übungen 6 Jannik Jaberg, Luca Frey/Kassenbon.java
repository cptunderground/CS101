import java.util.ArrayList;

public class Kassenbon{
	private Adresse adresse;
	private ArrayList<Artikel> artikelArrayList = new ArrayList();

	public Kassenbon(Adresse adresse){
		this.adresse = adresse;
	}

	public void add(Artikel artikel){
		if (artikel != null){
			artikelArrayList.add(artikel);
		}
	}

	public void print(){
		System.out.println("\n\n|----------------------------|");
        adresse.print();
        System.out.println("|----------------------------|");

        double sum = 0;
        for (Artikel a : artikelArrayList)
        {
            a.print();
            sum += a.getPrice();
        }
        System.out.println("------------------------------");
        System.out.println("\nTotal:\t\t\t" + String.format("%.2f",sum));
        System.out.println("==============================");
        System.out.println();
        System.out.println(center("MANS NOT DUMB"));
        System.out.println(center("YU DUN NO"));
        System.out.println(center("\u00A9 BIG SHAQ"));
	}
	int len=30;
	public String center(String text) {
        int l = text.length();
        int dif1 = (len - l) / 2;
        int dif2 = len - dif1 - l;
        String out = String.format("%-" + dif1 + "s%s%" + dif2 + "s", "|", text, "|");
        return out;
    }

   
}