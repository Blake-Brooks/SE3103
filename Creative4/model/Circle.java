package model;
import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape implements ShapeDraw{
    private float radius; 
    public Circle(float x, float y, Color color, float radius){
        super(x, y, color);
        this.radius = radius;
    }

    public float getRadius(){
        return radius;
    }

    @Override
    public void render(Graphics2D g2) {
        // TODO Auto-generated method stub
        
    }
}
