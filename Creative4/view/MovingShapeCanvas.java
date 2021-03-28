package view;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import model.Circle;
import model.Shape;
import model.ShapeDraw;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MovingShapeCanvas extends JPanel {
    private int index = -1;
    private ShapeMovingPanel panel;
    private ArrayList<ShapeDraw> shapeToBeMoved = new ArrayList<>();

    public MovingShapeCanvas(ShapeMovingPanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 500));
        shapeToBeMoved.add(new Circle(100, 100, Color.red, 50, false));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var s: shapeToBeMoved){
            s.render(g2);
        }
    }

    public ArrayList<ShapeDraw> getShapeToBeMoved(){
        return shapeToBeMoved;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }
}
