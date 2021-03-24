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
    public ShapeMovingPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        JPanel southPanel = new JPanel();
        Container cp = window.getContentPane();
        southPanel.add(clearButton);
        southPanel.add(filledBox);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
}
