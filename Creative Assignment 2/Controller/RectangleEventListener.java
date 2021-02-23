package Controller;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import Model.Rectangle;
import View.MenuScreen;
import View.RectangleDrawingPanel;
import java.awt.Color;
import java.awt.event.MouseListener;

public class RectangleEventListener implements ActionListener, MouseListener{
    private RectangleDrawingPanel panel;
    private Color color = Color.white;
    private int clicks = 0;
    private Rectangle rectangle;

    public RectangleEventListener(RectangleDrawingPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        }
        else if (source == panel.getClearButton()) {
            panel.getCanvas().getShapes().clear();
            panel.getCanvas().repaint();
        } else if(source == panel.getRedButton()){
            color = Color.red;
        }
        else if(source == panel.getYellowButton()){
            color = Color.yellow;
        }
        else if(source == panel.getBlueButton()){
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
            rectangle = new Rectangle();
            rectangle.setPos(0, e.getX(), e.getY());
            rectangle.setColor(color);
            panel.getCanvas().getShapes().add(rectangle);
            break;
            case 2: 
            rectangle.setPos(1, e.getX(), e.getY());
            break;
            case 3: 
            rectangle.setPos(2, e.getX(), e.getY());
            break;
            case 4:
            rectangle.setPos(3, e.getX(), e.getY());
            clicks = 0;
            break;
    }
    panel.getCanvas().repaint();
}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
