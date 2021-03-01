package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.WordGuess;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.WordGuess;
import View.WordGuessPanel;

public class WordGuessingGameEventListener implements ActionListener {
    private WordGuessPanel panel;
    private int clicks = 0;
    public WordGuessingGameEventListener(WordGuessPanel panel){
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        if(button == panel.getNewButton()){
            var wordGuess = new WordGuess();
            panel.setWordGuess(wordGuess);
            panel.setGameState(WordGuessPanel.GameState.PLAYING);
            int index = wordGuess.getIndex();
            String indexString = "" + index;
            panel.getGameKeyField().setText(indexString);
            panel.getGuessField().setText("");
            for(var b: panel.getLetterButtons()){
                b.setEnabled(true);
            }
            panel.getCanvas().repaint();
            wordGuess.getIndex();
        } else {
           button.setEnabled(false); 
           JTextField guessField = panel.getGuessField();
           if(clicks==0) guessField.setText("");
           WordGuess wordGuess = panel.getWordGuess();
           String n = button.getText();
           guessField.setText(guessField.getText() + n);
         //  wordGuess.setGuess(clicks, n.charAt(0) - '0');
        }
    }
}
