package View;

import javax.swing.JPanel;

import Model.Rectangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class RectangleDrawingCanvas extends JPanel {
    private RectangleDrawingPanel panel;
    private ArrayList<Rectangle> Shape = new ArrayList<>();
    public RectangleDrawingCanvas(RectangleDrawingPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.cyan);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var s: Shape){
            s.render(g2);
        }
    }
    public ArrayList<Rectangle > getShapes(){
        return Shape;
    }
}
