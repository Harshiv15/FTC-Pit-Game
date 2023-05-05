package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    public static final int PANEL_WIDTH = 1024;
    public static final int PANEL_HEIGHT = 744;
    private Image fieldImage, robotImage;
    private boolean movingUp, movingLeft, movingDown, movingRight;

    private Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(movingUp)
                robot.y -= 3;

            if(movingLeft)
                robot.x -= 3;

            if(movingDown)
                robot.y += 3;

            if(movingRight)
                robot.x += 3;

            repaint();
        }
    });

    private Robot robot = new Robot(360, 360, 50, 50);

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        timer.start();

        try {
            fieldImage = ImageIO.read(new File("./assets/FTC_GAME_FIELD.png"));
            robotImage = ImageIO.read(new File("./assets/ROBOT_EMPTY_1.png"));
        } catch (IOException e) {
            System.out.println("One or more images did not load");
        }

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();

                if(key == KeyEvent.VK_LEFT) {
                    movingLeft = true;
                }

                if(key == KeyEvent.VK_UP) {
                    movingUp = true;
                }

                if(key == KeyEvent.VK_RIGHT) {
                    movingRight = true;
                }

                if(key == KeyEvent.VK_DOWN) {
                    movingDown = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();

                if(key == KeyEvent.VK_LEFT) {
                    movingLeft = false;
                }

                if(key == KeyEvent.VK_UP) {
                    movingUp = false;
                }

                if(key == KeyEvent.VK_RIGHT) {
                    movingRight = false;
                }

                if(key == KeyEvent.VK_DOWN) {
                    movingDown = false;
                }
            }
        });

        this.setFocusable(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fieldImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
        g2d.drawImage(robotImage, (int) robot.x, (int) robot.y, (int) robot.width, (int) robot.height, null);
    }
}
