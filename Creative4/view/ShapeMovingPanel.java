package view;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ShapeMovingListener;

public class ShapeMovingPanel {
    private JFrame window;
    private JCheckBox filledBox = new JCheckBox("Filled");
    private MovingShapeCanvas canvas; 
    public ShapeMovingPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        canvas = new MovingShapeCanvas(this);
        JPanel southPanel = new JPanel();
        southPanel.add(filledBox);
        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);
        ShapeMovingListener listener = new ShapeMovingListener(this);
        canvas.addKeyListener(listener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);
        filledBox.setFocusable(false);
    }

    public JCheckBox getFIlled(){
        return filledBox;
    }

    public MovingShapeCanvas getCanvas(){
        return canvas;
    }
}
