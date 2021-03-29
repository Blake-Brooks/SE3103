package model;
import java.awt.Color;

public abstract class Shape {
    protected int x;
    protected int  y;
    protected Color color; 

    public Shape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX (){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
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
