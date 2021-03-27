package model;
import java.awt.Graphics2D; 

public interface ShapeDraw {
    void render(Graphics2D g2);
    void moveIt(int dx, int dy);
}
