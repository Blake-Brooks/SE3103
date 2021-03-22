package controller;
import java.awt.event.MouseListener;
import java.util.Collections;
import javax.swing.JFrame;
import model.Shapes.Circle;
import model.Shapes.IShapeDraw;
import model.Shapes.Rectangle;
import model.Shapes.Shape;
import model.Shapes.Triangle;
import java.awt.Color;
import view.DrawingDemoPanel;
import view.MenuScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ShapeDemoListener implements MouseListener, ActionListener{
    public static final int SIZE_SMALL = 40;
    public static final int SIZE_MID = 60;
    public static final int SIZE_LARGE = 80;

    private DrawingDemoPanel panel;

    public ShapeDemoListener(DrawingDemoPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == panel.getClearButton()){
        panel.getCanvas().getShapes().clear();
        panel.getCanvas().setSingleStepIndex(-1);
        panel.getCanvas().repaint();
       } else if(e.getSource() == panel.getExitButton()){
        JFrame window = panel.getWindow();
        window.getContentPane().removeAll();
        var menu = new MenuScreen(window);
        menu.init();
        window.pack();
        window.revalidate();
       } else if(e.getSource() == panel.getShowOrderButton()){
           panel.getCanvas().incrementSingleStepIndex();
           panel.getCanvas().repaint();
       } else if(e.getSource() == panel.getShowAllButton()){
           panel.getCanvas().setSingleStepIndex(-1);
           panel.getCanvas().repaint();
       } else if(e.getSource() == panel.getSortByXButton()){
           Collections.sort(panel.getCanvas().getShapes(), (o1, o2) ->{
                Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.getX() < s2.getX()) return -1;
                else if(s1.getX() > s2.getX()) return 1;
                else return 0;
           });
           panel.getCanvas().setSingleStepIndex(-1);
           panel.getCanvas().repaint();
       } else if (e.getSource() == panel.getSortByYButton()){
           Collections.sort(panel.getCanvas().getShapes(), (o1, o2) ->{
            Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.getY() < s2.getY()) return -1;
                else if(s1.getY() > s2.getY()) return 1;
                else return 0;
           });
           panel.getCanvas().setSingleStepIndex(-1);
           panel.getCanvas().repaint();
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Color color = getColor();
        int size = getSize();
        boolean filled = getFilled();
        IShapeDraw shape = getShape(e.getX(), e.getY(), color, size, filled);
        panel.getCanvas().getShapes().add(shape);
        panel.getCanvas().repaint();
        panel.getCanvas().setSingleStepIndex(-1);
    }

    private IShapeDraw getShape(int x, int y, Color color, int size, boolean filled){
        if(panel.getCircleRadioButton().isSelected()){
            return new Circle(x, y, size, color, filled);
        } else if(panel.getRecButton().isSelected()){
            return new Rectangle(x, y, size, size, color, filled);
        } else if(panel.getTriButton().isSelected()){
            return new Triangle(x, y, size, color, filled);
        }
        return new Circle(x, y, size, color, filled);
    }

    private Boolean getFilled(){
     return panel.getFilled().isSelected();
    }

    private int getSize(){
        if(panel.getSmallButton().isSelected()){
            return SIZE_SMALL;
        } else if(panel.getMediumButton().isSelected()){
            return SIZE_MID;
        } else if(panel.getLargeButton().isSelected()){
            return SIZE_LARGE;
        }
        return SIZE_SMALL;
    }

    private Color getColor(){
        if(panel.getWhiteButton().isSelected()){
            return Color.white;
        } else if (panel.getYellowButton().isSelected()){
            return Color.yellow;
        } else if(panel.getRedButton().isSelected()){
            return Color.red;
        }
        return Color.white;
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
