public class Kasse{
	public static void main(String[] args)
    {
        Kassenbon b = new Kassenbon(new Adresse("Herbstmesse Basel", "Uni Basel", "Petersplatz 1", "CH-4001 Basel"));
        b.add(new Artikel("Marroni", 2, 5.40));
        b.add(new Artikel("Magebrot", 5, 9.90));
        b.add(new Artikel("Gl\u00fchwein", 2, 6));
        b.add(new Artikel("M\u00E4ssmogge", 7, 2.5));
        b.add(new Artikel("Ch\u00E4sb\u00E4ngel", 6, 9));
        b.print();
    }
}