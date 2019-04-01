
public class Testprogramm {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();



        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));

        System.out.println("\nTest 1: Konsolenausgabe der gesammten Queue" + "\n" + "---------------------------------------");
        System.out.println(q.toString());

        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());


        System.out.println("\nTest 2: Konsolenausgabe der restlichen Queue nach q.get()" + "\n" + "---------------------------------------");
        System.out.println(q.toString());

        System.out.println("\nTest 3: Underflow" + "\n" + "---------------------------------------");

        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());

        System.out.println("\nTest 4: Overflow" + "\n" + "---------------------------------------");

        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));
        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));
        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));
        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));
        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));
        q.put(new Element(100, "Erstes"));
        q.put(new Element(90, "2"));
        q.put(new Element(80, "3"));
        q.put(new Element(100, "Mittleres"));
        q.put(new Element(70, "4"));
        q.put(new Element(60, "5"));
        q.put(new Element(100, "Letztes"));

        System.out.println("\nKonsolenausgabe der gesammten Queue mit Overflow" + "\n" + "---------------------------------------");
        System.out.println(q.toString());

    }
}
