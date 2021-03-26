package view;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import model.Circle;
import model.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MovingShapeCanvas extends JPanel {
    private ShapeMovingPanel panel;
    private ArrayList<Shape> shapeToBeMoved = new ArrayList<>();

    public MovingShapeCanvas(ShapeMovingPanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 500));
        shapeToBeMoved.add(new Circle(100, 100, Color.red, 50, false));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
