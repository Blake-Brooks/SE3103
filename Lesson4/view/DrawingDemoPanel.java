package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ShapeDemoListener;

public class DrawingDemoPanel {
    private JFrame window;
    private DrawingDemoCanvas canvas;
    private JRadioButton circleButton = new JRadioButton("Circle");
    private JRadioButton recButton = new JRadioButton("Rectangle");
    private JRadioButton triButton = new JRadioButton("Triangle");
    private JRadioButton whiteColor = new JRadioButton("white");
    private JRadioButton yellowButton = new JRadioButton("yellow");
    private JRadioButton redButton = new JRadioButton("red");
    private JCheckBox filledBox = new JCheckBox("filled");
    private JRadioButton smallSize = new JRadioButton("small");
    private JRadioButton midSize = new JRadioButton("medium");
    private JRadioButton largeSize = new JRadioButton("large");
    private JButton sortXButton = new JButton("Sort by X");
    private JButton sortYButton = new JButton("Sort by y");
    private JButton showAllButton = new JButton("Show All");
    private JButton showOrderButton = new JButton("ShowOrder");
    private JButton clearButton = new JButton("Clean");
    private JButton exitButton = new JButton("Exit");

    public DrawingDemoPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        canvas = new DrawingDemoCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,1));
        JPanel shapePanel = new JPanel();
        JPanel colorPanel = new JPanel();
        JPanel sizePanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        southPanel.add(shapePanel);
        southPanel.add(colorPanel);
        southPanel.add(sizePanel);
        southPanel.add(buttonPanel);
        cp.add(BorderLayout.SOUTH, southPanel);

        shapePanel.setBorder(BorderFactory.createTitledBorder("Shape"));
        shapePanel.add(circleButton);
        shapePanel.add(recButton);
        shapePanel.add(triButton);
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(circleButton);
        shapeGroup.add(recButton);
        shapeGroup.add(triButton);
        circleButton.setSelected(true);

        colorPanel.setBorder(BorderFactory.createTitledBorder("Color"));
        colorPanel.add(whiteColor);
        colorPanel.add(yellowButton);
        colorPanel.add(redButton);
        colorPanel.add(filledBox);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(whiteColor);
        colorGroup.add(yellowButton);
        colorGroup.add(redButton);
        whiteColor.setSelected(true);

        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
        sizePanel.add(smallSize);
        sizePanel.add(midSize);
        sizePanel.add(largeSize);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallSize);
        sizeGroup.add(midSize);
        sizeGroup.add(largeSize);
        smallSize.setSelected(true);

        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(sortXButton);
        buttonPanel.add(sortYButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(showOrderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        ButtonGroup actionsGroup = new ButtonGroup();
        actionsGroup.add(sortXButton);
        actionsGroup.add(sortYButton);
        actionsGroup.add(showAllButton);
        actionsGroup.add(showOrderButton);
        actionsGroup.add(clearButton);
        actionsGroup.add(exitButton);

        ShapeDemoListener listener = new ShapeDemoListener(this);
        canvas.addMouseListener(listener);
        clearButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        showOrderButton.addActionListener(listener);
        showAllButton.addActionListener(listener);
        sortXButton.addActionListener(listener);
        sortYButton.addActionListener(listener);

    }

    public JFrame getWindow(){
        return window;
    }

    public JRadioButton getCircleRadioButton(){
        return circleButton;
    }

    public JRadioButton getRecButton(){
        return recButton;
    }

    public JRadioButton getTriButton(){
        return triButton;
    }

    public JRadioButton getWhiteButton(){
        return whiteColor;
    }

    public JRadioButton getYellowButton(){
        return yellowButton;
    }

    public JRadioButton getRedButton(){
        return redButton;
    }

    public JCheckBox getFilled(){
        return filledBox;
    }

    public JRadioButton getSmallButton(){
        return smallSize;
    }

    public JRadioButton getMediumButton(){
        return midSize;
    }

    public JRadioButton getLargeButton(){
        return largeSize;
    }

    public JButton getSortByXButton(){
        return sortXButton;
    }

    public JButton getSortByYButton(){
        return sortYButton;
    }

    public JButton getShowAllButton(){
        return showAllButton;
    }

    public JButton getShowOrderButton(){
        return showOrderButton;
    }

    public JButton getClearButton(){
        return clearButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public DrawingDemoCanvas getCanvas(){
        return canvas;
    }
}
