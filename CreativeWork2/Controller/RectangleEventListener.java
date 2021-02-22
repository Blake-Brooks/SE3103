package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import Model.Rectangle;
//import view.MenuScreen;
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
        if (source == panel.getClearButton()) {
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
    }

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
