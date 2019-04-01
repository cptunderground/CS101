import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GOLWindow extends Component {
    private static JFrame jFrame = new JFrame();
    GameOfLife game;
    int cellSize = GameOfLife.getCellSize();
    int size = GameOfLife.getSize();
    private static boolean mouse = false;
    private static int speed = 5;


    public GOLWindow(GameOfLife game) {
        this.game = game;

        jFrame.add(this);
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                if (k.getKeyCode() == 49) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateBlinker(x, y);
                        }
                    });
                } else if (k.getKeyCode() == 50) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateClock(x, y);
                        }
                    });
                }else if (k.getKeyCode() == 51) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateFrog(x, y);
                        }
                    });
                }else if (k.getKeyCode() == 52) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateBipol(x, y);
                        }
                    });
                }else if (k.getKeyCode() == 53) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateTripol(x, y);
                        }
                    });
                }else if (k.getKeyCode() == 54) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updatePulsator(x, y);
                        }
                    });
                 //ADD TÜMMLER
                 //ADD OCTAGON

                }else if (k.getKeyCode() == 57) {
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            int x = e.getX();
                            int y = e.getY();
                            updateLWSS(x, y);
                        }
                    });

                 //ADD MLSS
                 //ADD HWSS
                 //ADD

                }else if (k.getKeyCode() == 27) {
                    GameOfLife.setNull();
                }
            }

            public void keyReleased(KeyEvent e) {

                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 39) {
                    if (speed > 1) speed--;
                    System.out.println("speed--");
                    System.out.println("speed=" + speed);
                } else if (e.getKeyCode() == 37) {
                    if (speed < 10) speed++;
                    System.out.println("speed++");
                    System.out.println("speed=" + speed);

                }
            }

        });
        jFrame.setSize(getPreferredSize());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (jFrame.getWidth() / 2);
        int yPos = (dim.height / 2) - (jFrame.getHeight() / 2);
        jFrame.setLocation(xPos, yPos);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Game of Life");
        jFrame.pack();
        jFrame.setVisible(true);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                updateCell(x, y);
                jFrame.repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mouse = !mouse;
                System.out.println(mouse);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mouse = !mouse;
                System.out.println(mouse);
            }


        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int x = e.getX();
                int y = e.getY();
                updateCellDrag(x, y);
                jFrame.repaint();
            }
        });

    }

    public static boolean getMouse() {
        return mouse;
    }

    public static int getSpeed() {
        return speed;
    }

    public void updateCell(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setCellPop(newx, newy);
        System.out.println("UpdateCell");
    }

    public void updateCellDrag(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setCellPopDrag(newx, newy);
        System.out.println("UpdateCellDrag");
    }

    public void updateBlinker(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setBlinker(newx, newy);
        System.out.println("UpdateBlinker");
    }

    public void updateClock(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setClock(newx, newy);
        System.out.println("UpdateClock" +
                "");
    }

    public void updateFrog(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setFrog(newx, newy);
        System.out.println("UpdateFrog");
    }

    public void updateBipol(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setBipol(newx, newy);
        System.out.println(newx + " " + newy);
    }

    public void updateTripol(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setTripol(newx, newy);
        System.out.println(newx + " " + newy);
    }

    public void updatePulsator(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setPulsator(newx, newy);
        System.out.println(newx + " " + newy);
    }

    public void updateLWSS(int x, int y) {
        int newx = x / GameOfLife.getCellSize();
        int newy = y / GameOfLife.getCellSize();
        GameOfLife.setLightweightSpaceship(newx, newy);
        System.out.println(newx + " " + newy);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (GameOfLife.getCellPop(i, j)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * this.cellSize, j * this.cellSize, this.cellSize, this.cellSize);


                } else {
                    Color Intellij = new Color(84, 84, 84);
                    g.setColor(Color.WHITE);
                    g.fillRect(i * this.cellSize, j * this.cellSize, this.cellSize, this.cellSize);


                }
            }
        }
    }

    public Dimension getPreferredSize() {
        int size = this.size * this.cellSize;
        return new Dimension(size, size);
    }

    public void redraw() {
        game.evolve();
        jFrame.repaint();
    }

}
