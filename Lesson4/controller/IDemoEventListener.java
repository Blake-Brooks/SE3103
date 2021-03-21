package controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.idemo.IRender;
import view.IDemoPanel;
import java.awt.Rectangle;

public class IDemoEventListener implements MouseListener{

    private IDemoPanel panel;

    public IDemoEventListener(IDemoPanel panel){
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e) {
        ArrayList<IRender> pictures = panel.getCanvas().getPictures();
        for(int i = 0; i < pictures.size(); i++){
            Rectangle r = pictures.get(i).getBoundingBox();
            if(r.contains(e.getX(), e.getY())){
                panel.getCanvas().setSelectedIndex(i);
                panel.getCanvas().repaint();
                return;
            }
        } 
        panel.getCanvas().setSelectedIndex(-1);
        panel.getCanvas().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
