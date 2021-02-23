package View;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MenuScreen {
    private JFrame window; 
    public MenuScreen(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(500,250));
        menu.setLayout(new GridLayout(1,1));
        cp.add(BorderLayout.CENTER, menu);
        var drawRectangle = new JButton("Draw a Rectangle");
        menu.add(drawRectangle);

        drawRectangle.addActionListener(event -> {
            window.getContentPane().removeAll();
            var panel = new RectangleDrawingPanel(window);
            panel.init();
            window.pack();
            window.revalidate();
        });
    }
}
