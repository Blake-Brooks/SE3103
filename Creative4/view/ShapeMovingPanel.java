package view;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeMovingPanel {
    private JFrame window;
    private JButton clearButton = new JButton("clear");
    private JCheckBox filledBox = new JCheckBox("Filled");
    private MovingShapeCanvas canvas; 
    public ShapeMovingPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        canvas = new MovingShapeCanvas(this);
        JPanel southPanel = new JPanel();
        southPanel.add(clearButton);
        southPanel.add(filledBox);
        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
}
