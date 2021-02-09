package View;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class MenuScreen {
    private JFrame window;
    public MenuScreen(JFrame window){
        this.window = window;
         window.setTitle("Menu Screen");
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        JButton Attack = new JButton("Attack");
        panel.add(Attack);
        cp.add(BorderLayout.CENTER, panel);

        Attack.addActionListener( e -> {
            var battle = new BattleSimulator(window);
            battle.init();
            window.pack();
        });
    }
}   
