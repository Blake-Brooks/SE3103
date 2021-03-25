package model;
import java.awt.Color;

public abstract class Shape {
    private float x;
    private float y;
    private Color color; 

    public Shape(float x, float y, Color color){
        this.x = x;
        this.y = y;
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

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
