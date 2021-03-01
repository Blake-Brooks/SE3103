package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.WordGuessingGameEventListener;
import Model.WordGuess;

import java.awt.Container;
import java.awt.GridLayout;

public class WordGuessPanel {
    public enum GameState{
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private WordGuessCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] letterButtons;
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;
    private WordGuess wordGuessing;
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
        southPanel.add(newButton);
         WordGuessingGameEventListener keyListener = new WordGuessingGameEventListener(this);
        letterButtons = new JButton[26];
        for(char i = 'a'; i <= 'z'; i++){
            letterButtons[i] = new JButton("" + i);
            southPanel.add(letterButtons[i]);
            letterButtons[i].addActionListener(keyListener);
        }
        cp.add(BorderLayout.SOUTH, southPanel);
    }

    public JButton getNewButton(){
        return newButton;
    }

    public JButton[] getLetterButtons(){
        return letterButtons;
    }

    public JTextField getGameKeyField(){
        return gameKeyField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public WordGuessCanvas getCanvas(){
        return canvas;
    }

    public GameState getGameState(){
        return gameState;
    }
    public void setGameState (GameState state) {
        this.gameState = state;
    }

    public WordGuess getWordGuess(){
        return wordGuessing;
    }

    public void setWordGuess(WordGuess wordGuessing){
        this.wordGuessing = wordGuessing;
    }
}
