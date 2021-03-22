package view;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Shapes.Circle;
import model.Shapes.IShapeDraw;
import model.Shapes.Rectangle;
import model.Shapes.Triangle;

public class DrawingDemoCanvas extends JPanel{
    private DrawingDemoPanel panel;
    ArrayList<IShapeDraw> shapes = new ArrayList<>();
    public DrawingDemoCanvas(DrawingDemoPanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 400));

    }

    @Override
    public void paintComponent(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var s: shapes){
            s.render(g2);
        }
    }

    private void testRendering(){
        shapes.add(new Circle(50, 50, 50, Color.yellow, true));
        shapes.add(new Rectangle(200, 200, 100, 100, Color.white, true));
        shapes.add(new Triangle(100, 100, 50, Color.red, true));
    }
}
