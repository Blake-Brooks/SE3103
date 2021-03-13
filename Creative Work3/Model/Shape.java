package Model;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
    private float x;
    private float y;
    private Color color;

    public Shape(float x, float y, Color color){
        this.x = x;
        this.x = y;
        this.color = color;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }

    public abstract void render(Graphics2D g2);
}
