import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Win extends JFrame {

    private static JFrame win = new JFrame();


    public Win(String url){

        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        JLabel label = new JLabel(icon);
        JPanel panel = new JPanel();



        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setResizable(false);
        panel.add(label);
        this.add(panel);
        this.pack();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                win.toFront();
                win.repaint();
            }
        });
    }
}
