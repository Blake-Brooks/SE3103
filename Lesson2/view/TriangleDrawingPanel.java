package view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import controller.TriangleEventListener;

import java.awt.GridLayout;

public class TriangleDrawingPanel {
    private JFrame window;
    private TriangleCanvas canvas;
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton yellowButton = new JRadioButton("Yellow");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JButton clearButton = new JButton("Clear");
    private JButton exitButton = new JButton("Exit");

    public TriangleDrawingPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);

        southPanel.setLayout(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(blueButton);
        southPanel.add(radioPanel);

        // radio group
        ButtonGroup coloGroup = new ButtonGroup();
        coloGroup.add(redButton);
        coloGroup.add(yellowButton);
        coloGroup.add(blueButton);

        // tilted border for radio
        TitledBorder title = BorderFactory.createTitledBorder("Color");
        radioPanel.setBorder(title);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        southPanel.add(buttonPanel);

        canvas = new TriangleCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
      
        // attach event listener
        TriangleEventListener listener = new TriangleEventListener(this);
        exitButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        redButton.addActionListener(listener);
        yellowButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        canvas.addMouseListener(listener);
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getClearButton() {
        return clearButton;
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

    public JFrame getWindow() {
        return window;
    }
}
