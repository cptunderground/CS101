

import java.util.Random;


public class GameOfLife {
    private boolean[][] cellPop;
    private int size;

    public GameOfLife() {
        size = 6;
        cellPop = new boolean[size][size];
        cellPop[1][1] = true;
        cellPop[1][3] = true;
        cellPop[2][2] = true;
        cellPop[2][3] = true;
        cellPop[3][2] = true;
    }

    public GameOfLife(int size) {
        this.size = size;
        cellPop = new boolean[size][size];
        generatePop();
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
        for(int line = 0; line < cellPop.length; line++) {
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

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {

                int n = 0;

                if(cellPop[(i-1+size)%size][(j-1+size)%size]) n++;
                if(cellPop[(i-1+size)%size][j]) n++;
                if(cellPop[(i-1+size)%size][(j+1)%size]) n++;
                if(cellPop[i][(j-1+size)%size]) n++;
                if(cellPop[i][(j+1)%size]) n++;
                if(cellPop[(i+1)%size][(j-1+size)%size]) n++;
                if(cellPop[(i+1)%size][j]) n++;
                if(cellPop[(i+1)%size][(j+1)%size]) n++;

                neighbours[i][j] = n;
            }
        }

        return neighbours;
    }

    public void evolve() {

        int[][] neighbours = count();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {

                if(neighbours[i][j] == 3) cellPop[i][j] = true;
                else if(neighbours[i][j] < 2 || neighbours[i][j] > 3) cellPop[i][j] = false;
            }
        }
    }

    boolean control(){
        for (int i=0; i<cellPop.length; i++) {
            for (int j=0; j<cellPop.length; j++) {
                if (cellPop[i][j]){
                    return true;
                }
                               
            }
            
        }
        return false;
    }
}