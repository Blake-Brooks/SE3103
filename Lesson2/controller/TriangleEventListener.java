package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.Triangle;
import view.MenuScreen;
import view.TriangleDrawingPanel;
import java.awt.Color;
import java.awt.event.MouseListener;

public class TriangleEventListener implements ActionListener, MouseListener {

    private TriangleDrawingPanel panel;
    private Color color = Color.white;
    private int clicks = 0; 
    private Triangle triangle;

    public TriangleEventListener(TriangleDrawingPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == panel.getExitButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if (source == panel.getClearButton()) {

        } else if (source == panel.getRedButton()) {
            color = Color.red;
        } else if (source == panel.getYellowButton()) {
            color = Color.yellow;
        } else if (source == panel.getBlueButton()) {
            color = Color.blue;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        ++clicks;
        switch(clicks){
            case 1: 
                triangle = new Triangle();
                triangle.setPos(index, x, y);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) { }
    
}
