import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpecialWindow extends Component {
    private static JFrame jFrame = new JFrame();
    GameOfLife game;
    int pixel = GameOfLife.getCellSize();
    int size = 150;
    private Graphics2D  _imageGraphics;
    private BufferedImage _image;
    int cellSize = GameOfLife.getCellSize();



    public SpecialWindow(GameOfLife game) {
        this.game = game;

        ImageIcon image = new ImageIcon("linard.jpg");
        JLabel label = new JLabel(image);

        label.setIcon(image);
        jFrame.add(this);
        jFrame.setSize(getPreferredSize());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (jFrame.getWidth() / 2);
        int yPos = (dim.height / 2) - (jFrame.getHeight() / 2);
        jFrame.setLocation(xPos, yPos);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Special Game of Linard");
        jFrame.pack();
        jFrame.setVisible(true);
    }


    public void paint(Graphics2D g){

    }


    public Dimension getPreferredSize() {
        int size = this.size * this.pixel;
        return new Dimension(size, size);
    }

    public void redraw() {
        game.evolve();
        jFrame.repaint();
    }

}