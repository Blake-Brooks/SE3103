package View;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import Controller.RectangleEventListener;
import java.awt.GridLayout;

public class RectangleDrawingPanel {
    private JFrame window;
    private RectangleDrawingCanvas canvas;
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton yellowButton = new JRadioButton("Yellow");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JButton clearButton = new JButton("Clear");
    private JButton exitButton = new JButton("Exit");
    
    public RectangleDrawingPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(blueButton);
        southPanel.add(radioPanel);
        ButtonGroup coloringGroup = new ButtonGroup();
        coloringGroup.add(redButton);
        coloringGroup.add(yellowButton);
        coloringGroup.add(blueButton);
        TitledBorder name = BorderFactory.createTitledBorder("Color Options");
        radioPanel.setBorder(name);
        JPanel buttonPart = new JPanel();
        buttonPart.add(clearButton);
        buttonPart.add(exitButton);
        southPanel.add(buttonPart);
        canvas = new RectangleDrawingCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        RectangleEventListener listener = new RectangleEventListener(this);
        clearButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        redButton.addActionListener(listener);
        yellowButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        canvas.addMouseListener(listener);
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JRadioButton getRedButton() {
        return redButton;
    }

    public JRadioButton getYellowButton() {
        return yellowButton;
    }

    public JRadioButton getBlueButton() {

        return blueButton;
    }

    public JFrame getWindow(){
        return window;
    }

    public RectangleDrawingCanvas getCanvas(){
        return canvas;
    }
}
