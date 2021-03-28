package controller;
import java.awt.event.MouseListener;

import model.Shape;
import model.ShapeDraw;
import view.ShapeMovingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShapeMovingListener implements ActionListener, KeyListener{
    public static final int movingIt = 5;
    private ShapeMovingPanel panel;
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int index = panel.getCanvas().getIndex();
        var key = e.getKeyCode();
        ShapeDraw ShapeMoving = panel.getCanvas().getShapeToBeMoved().get(index);
        switch(key){
            case KeyEvent.VK_LEFT:
            ShapeMoving.moveIt(-movingIt, 0);
            break;
            case KeyEvent.VK_RIGHT:
            ShapeMoving.moveIt(movingIt, 0);
            break;
            case KeyEvent.VK_UP:
            ShapeMoving.moveIt(0, -movingIt);
            break;
            case KeyEvent.VK_DOWN:
            ShapeMoving.moveIt(0, movingIt);
            break;
        }
        panel.getCanvas().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
