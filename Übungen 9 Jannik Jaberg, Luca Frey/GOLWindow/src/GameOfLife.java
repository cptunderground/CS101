import java.util.Random;


public class GameOfLife {


    static private boolean[][] cellPop;
    static private int size;
    static private int cellSize;


    public GameOfLife() {
        size = 6;
        cellPop = new boolean[size][size];
        cellPop[1][1] = true;
        cellPop[1][3] = true;
        cellPop[2][2] = true;
        cellPop[2][3] = true;
        cellPop[3][2] = true;
    }

    public GameOfLife(int size, int cellSize) {
        this.size = size;
        cellPop = new boolean[size][size];
        generatePop();
        this.cellSize = cellSize;
    }

    public static int getSize() {
        return size;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public static boolean getCellPop(int x, int y) {
        return cellPop[y][x];
    }

    public static void setCellPop(int x, int y) {
        System.out.println(cellPop[y][x]);
        cellPop[y][x] = !cellPop[y][x];
        System.out.println(cellPop[y][x]);
    }

    public static void setCellPopDrag(int x, int y) {
        System.out.println(cellPop[y][x]);
        cellPop[y][x] = true;
        System.out.println(cellPop[y][x]);
    }

    public static void setBlinker(int x, int y) {
        cellPop[y][x] = true;
        cellPop[y][x - 1] = true;
        cellPop[y][x + 1] = true;
    }

    public static void setClock(int x, int y) {
        cellPop[y][x] = true;
        cellPop[y - 1][x - 1] = true;
        cellPop[y][x + 1] = true;
        cellPop[y - 1][x - 2] = true;
        cellPop[y + 1][x - 1] = true;
        cellPop[y - 2][x] = true;

    }

    public static void setFrog(int x, int y) {
        cellPop[y][x] = true;
        cellPop[y][x - 1] = true;
        cellPop[y - 1][x - 1] = true;
        cellPop[y + 1][x - 1] = true;
        cellPop[y + 2][x] = true;
        cellPop[y + 1][x] = true;
    }

    public static void setBipol(int x, int y) {
        cellPop[y][x] = false;
        cellPop[y - 2][x - 2] = true;
        cellPop[y - 2][x - 1] = true;
        cellPop[y - 1][x - 2] = true;
        cellPop[y][x + 1] = true;
        cellPop[y + 1][x] = true;
        cellPop[y + 1][x + 1] = true;
    }

    public static void setTripol(int x, int y) {
        cellPop[y][x] = false;
        cellPop[y][x - 1] = true;
        cellPop[y][x + 1] = true;
        cellPop[y - 2][x - 2] = true;
        cellPop[y - 2][x - 1] = true;
        cellPop[y - 1][x - 2] = true;
        cellPop[y + 1][x + 2] = true;
        cellPop[y + 2][x + 1] = true;
        cellPop[y + 2][x + 2] = true;

    }

    public static void setPulsator(int x, int y) {
        cellPop[y][x] = true;
        cellPop[y][x - 1] = true;
        cellPop[y][x + 1] = true;
        cellPop[y - 1][x - 2] = true;
        cellPop[y][x - 3] = true;
        cellPop[y][x - 4] = true;
        cellPop[y + 1][x - 2] = true;
        cellPop[y - 1][x + 3] = true;
        cellPop[y][x + 4] = true;
        cellPop[y][x + 5] = true;
        cellPop[y + 1][x + 3] = true;
        cellPop[y][x + 2] = true;
    }

    public static void setLightweightSpaceship(int x, int y){

    }

    public static void setNull(){
        for (int line = 0; line < cellPop.length; line++) {
            for (int column = 0; column < cellPop[line].length; column++) {
                cellPop[line][column] = false;
            }
        }
    }

    public void generatePop() {
        for (int line = 0; line < cellPop.length; line++) {
            for (int column = 0; column < cellPop[line].length; column++) {
                cellPop[line][column] = giveLife();
            }
        }
    }

    public boolean giveLife() {
        Random rand = new Random();
        int lifeChance = rand.nextInt(10);

        if (lifeChance < 3) {
            return true;
        } else {
            return false;
        }
    }

    public String output() {
        String outputString = "";
        for (int line = 0; line < cellPop.length; line++) {
            for (int column = 0; column < cellPop[line].length; column++) {
                if (cellPop[line][column]) {
                    outputString = outputString + "@";
                } else {
                    outputString = outputString + ".";
                }
            }
            outputString = outputString + "\n";
        }
        return outputString;
    }


    private int[][] count() {

        int[][] neighbours = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                int n = 0;

                if (cellPop[(i - 1 + size) % size][(j - 1 + size) % size]) n++;
                if (cellPop[(i - 1 + size) % size][j]) n++;
                if (cellPop[(i - 1 + size) % size][(j + 1) % size]) n++;
                if (cellPop[i][(j - 1 + size) % size]) n++;
                if (cellPop[i][(j + 1) % size]) n++;
                if (cellPop[(i + 1) % size][(j - 1 + size) % size]) n++;
                if (cellPop[(i + 1) % size][j]) n++;
                if (cellPop[(i + 1) % size][(j + 1) % size]) n++;

                neighbours[i][j] = n;
            }
        }

        return neighbours;
    }

    public void evolve() {

        int[][] neighbours = count();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (neighbours[i][j] == 3) cellPop[i][j] = true;
                else if (neighbours[i][j] < 2 || neighbours[i][j] > 3) cellPop[i][j] = false;
            }
        }
    }

    boolean control() {
        for (int i = 0; i < cellPop.length; i++) {
            for (int j = 0; j < cellPop.length; j++) {
                if (cellPop[i][j]) {
                    return true;
                }

            }

        }
        return false;
    }
}