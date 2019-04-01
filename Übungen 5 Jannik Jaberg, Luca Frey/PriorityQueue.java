
public class PriorityQueue {
    static final int SIZE = 32;
    Element[] q = new Element[SIZE];
    int len = 0;


    boolean put(Element x) {
        if (len >= SIZE) {
            System.out.println("Overflow");
            return false;
        } else {
            int a = len - 1;
            while (a >= 0 && x.getPriority() > q[a].getPriority()) {
                q[a + 1] = q[a];
                a--;
            }
            q[a + 1] = x;
            len++;
            System.out.println("Correctly inserted into Queue!");
            return true;
        }
    }


    Element get() {
        if (len > 0) {
            Element x = q[0];
            for (int i = 0; i < len - 1; i++) {
                q[i] = q[i + 1];

            }
            len--;
            return x;
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }


    int length() {
        return len;
    }


    public String toString() {
        String result = "";
        for (int i = 0; i < len; i++) {
            result = result + "Data: " + q[i].getData() +" , Priority: " + q[i].getPriority() + "\n";
        }
        return result;
    }

}