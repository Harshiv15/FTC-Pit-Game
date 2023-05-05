package src;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        super("FTC Pit Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new GamePanel());
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
