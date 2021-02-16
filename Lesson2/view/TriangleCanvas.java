package view;

import javax.swing.JPanel;
import model.Triangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TriangleCanvas extends JPanel{

    private TriangleDrawingPanel panel;
    public TriangleCanvas(TriangleDrawingPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Triangle t1 = new Triangle();
        t1.setPos(0, 10, 10);
        t1.setPos(1, 100, 100);
        t1.setPos(2, 150, 100);
        t1.setColor(Color.yellow);
        t1.render(g2);

        t1.setPos(0, 50, 50);
        t1.setPos(1, 50, 150);
        t1.setPos(2, 200, 100);
        t1.setColor(Color.red);
        t1.render(g2);

        Triangle t2 = new Triangle();
        t2.setPos(0, 200, 200);
        t2.setColor(Color.white);
        t2.render(g2);

        Triangle t3 = new Triangle();
        t3.setPos(0, 200, 200);
        t3.setPos(1, 400, 100);
        t3.setColor(Color.blue);
        t3.render(g2);
    }
}
