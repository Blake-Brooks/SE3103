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
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(400, 200));
        menuPanel.setLayout(new GridLayout(1,1));
        cp.add(BorderLayout.CENTER, menuPanel);
        var WordGuessButton = new JButton("Word Guessing button");
        menuPanel.add(WordGuessButton);

        WordGuessButton.addActionListener(event -> {
            window.getContentPane().removeAll();
            var panel = new WordGuessPanel(window);
            panel.init();
            window.pack();
            window.setVisible(true);
        });
    }
}
