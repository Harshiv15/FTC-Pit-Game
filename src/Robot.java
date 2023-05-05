package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Robot extends Rectangle2D.Double {
    private BufferedImage robotImage;

    public Robot(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fill(this);
    }
}
