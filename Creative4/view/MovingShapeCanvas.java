package view;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;

public class MovingShapeCanvas extends JPanel {
    private ShapeMovingPanel panel;

    public MovingShapeCanvas(ShapeMovingPanel panel){
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
