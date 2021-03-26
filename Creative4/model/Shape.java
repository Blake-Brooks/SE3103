package model;
import java.awt.Color;

public abstract class Shape {
    private int x;
    private int  y;
    private Color color; 

    public Shape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX (){
        return x;
    }

    public int  getY(){
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
