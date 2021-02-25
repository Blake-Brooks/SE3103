package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

public class WordGuessPanel {
    private JFrame window;
    private WordGuessCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] letterButtons;
    private JButton newButton = new JButton("New");
    public WordGuessPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        gameKeyField.setEditable(false);
        guessField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);
        canvas = new WordGuessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,7));
        letterButtons = new JButton[26];
        for(int i = 0; i < 26; i++){
            letterButtons[i] = new JButton("" + i);
            southPanel.add(letterButtons[i]);
        }
        southPanel.add(newButton);

    }

    public JButton getNewButton(){
        return newButton;
    }

    public JButton[] getLetterButtons(){
        return letterButtons;
    }
}
