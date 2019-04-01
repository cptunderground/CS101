import javax.swing.*;

import java.io.IOException;

public class BasicGOL {
    public static void main(String[] args) throws InterruptedException{


        if (args.length == 0) {
            GameOfLife game = new GameOfLife(6, 150);
            GOLWindow JGOL = new GOLWindow(game);

            while (game.control()) {

                while(GOLWindow.getMouse()){
                    try{
                        Thread.sleep(200);
                    } catch (InterruptedException huso) {
                        huso.printStackTrace();

                    }
                }

                JGOL.redraw();
                System.out.println(game.output());
                System.out.println("---------------------------------------------------");
                Thread.sleep(GOLWindow.getSpeed()*20);

            }
            System.out.println("Created by Jannik Jaberg");
        } else if (args[0].equals("special")) {

            GameOfLife game = new GameOfLife(10, 150);
            SpecialWindow JGOL = new SpecialWindow(game);

            JGOL.redraw();
            System.out.println(game.output());
            System.out.println("---------------------------------------------------");
            while (game.control()) {

                while(GOLWindow.getMouse()){
                    Thread.sleep(200);
                }

                JGOL.redraw();
                System.out.println(game.output());
                System.out.println("---------------------------------------------------");

                Thread.sleep(GOLWindow.getSpeed()*20);


            }
            System.out.println("Created by Jannik Jaberg");


        } else

        {
            int pixel;
            if (args.length != 2) {
                pixel = 25;
            } else {
                pixel = Integer.parseInt(args[1]);
            }
            GameOfLife game = new GameOfLife(Integer.parseInt(args[0]), pixel);
            GOLWindow JGOL = new GOLWindow(game);

            JGOL.repaint();
            //System.out.println(game.output());
            //System.out.println("---------------------------------------------------");
            while (game.control()) {

                while(GOLWindow.getMouse()){
                    Thread.sleep(200);
                }
                JGOL.redraw();
                //System.out.println(game.output());
                //System.out.println("---------------------------------------------------");

                Thread.sleep(GOLWindow.getSpeed()*20);


            }
            System.out.println("Created by Jannik Jaberg");
        }
    }
}

