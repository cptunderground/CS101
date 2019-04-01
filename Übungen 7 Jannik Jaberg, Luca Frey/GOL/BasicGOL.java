public class BasicGOL {
    public static void main(String[] args) throws InterruptedException
    {
        if (args.length == 0) {
            GameOfLife game = new GameOfLife();
            while (game.control()) {
                System.out.println(game.output());
                System.out.println("---------------------------------------------------");
                Thread.sleep(200);
                game.evolve();
            }
            System.out.println("Created by Jannikis Jaberg");
        } else

        {
            //int arg = Integer.parseInt(args[0]);

            GameOfLife game = new GameOfLife(Integer.parseInt(args[0]));
            System.out.println(game.output());
            System.out.println("---------------------------------------------------");
            
            while (game.control()) {
                game.evolve();
                System.out.println(game.output());
                System.out.println("---------------------------------------------------");
                Thread.sleep(100);
                
            }
            System.out.println("Created by Jannik Jaberg");
        }
    }
}
