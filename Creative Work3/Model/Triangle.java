package Model;
import java.awt.Color;
import java.awt.Graphics2D;

public class Triangle extends Shape {

    public Triangle(float x, float y, Color color) {
        super(x, y, color);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
    }
    
}
