package controller;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShapeMovingListener implements ActionListener, KeyListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        var key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:

            break;
            case KeyEvent.VK_RIGHT:

            break;
            case KeyEvent.VK_UP:

            break;
            case KeyEvent.VK_DOWN:

            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
