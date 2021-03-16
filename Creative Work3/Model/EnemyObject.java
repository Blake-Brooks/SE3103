package Model;

import java.awt.Color;
import java.awt.Graphics2D;

public class EnemyObject extends Shape {
    private float radius;
    public EnemyObject(float x, float y, Color color, float radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public float getRadius(){
        return radius;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
        g2.drawOval((int)super.getX(), (int)super.getY(), (int)(radius*2), (int)(radius*2));
    }  
}
