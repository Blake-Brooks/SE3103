package model;
import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape implements ShapeDraw{
    private int radius; 
    private boolean filled;
    public Circle(int x, int y, Color color, int radius, boolean filled){
        super(x, y, color);
        this.radius = radius;
        this.filled = filled;
    }

    public float getRadius(){
        return radius;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        if(filled){
            g2.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        } else{
            g2.drawOval(getX(), getY(), radius * 2, radius * 2);
        }
    }

    @Override
    public void moveIt(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
