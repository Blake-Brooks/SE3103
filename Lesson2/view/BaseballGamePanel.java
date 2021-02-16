package view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.BaseballKeyListener;
import model.BaseballGame;
import java.awt.GridLayout;

public class BaseballGamePanel {

    public enum GameState{
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private BaseballCanvas canvas;
    private JTextField gameKeField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] digitButtons;
    private JButton playButton = new JButton("Play ball--");
    private JButton exiButton = new JButton("Exit");
    private GameState gameState = GameState.READY;

    private BaseballGame baseball;

    public BaseballGamePanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("Secret Game Key: "));
        northPanel.add(gameKeField);
        northPanel.add(new JLabel("Your Guess: "));
        northPanel.add(guessField);
        gameKeField.setEditable(false);
        guessField.setEditable(false);

        cp.add(BorderLayout.NORTH, northPanel); 

        canvas = new BaseballCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,3));

        BaseballKeyListener keyListener = new BaseballKeyListener(this); 

        digitButtons = new JButton[10];
        for(int i = 0; i < 10; i++){
            digitButtons[i] = new JButton("" + i);
            southPanel.add(digitButtons[i]);
            digitButtons[i].addActionListener(keyListener);
        }
        playButton.addActionListener(keyListener);
        exiButton.addActionListener(keyListener);
        southPanel.add(playButton);
        southPanel.add(exiButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for(var b: digitButtons){
            b.setEnabled(false);
        }
    }

    public BaseballGame getBaseballGame(){
        return baseball;
    }

    public JFrame getWindow(){
        return window;
    }

    public BaseballCanvas getCanvas(){
        return canvas;
    }

    public JTextField getGameKeyField(){
        return gameKeField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public JButton[] getDigiButtons(){
        return digitButtons;
    }

    public JButton getPlayButton(){
        return playButton;
    }

    public JButton getExButton(){
        return exiButton;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }

    public BaseballGame getBaseball(){
        return baseball;
    }

    public void setBaseball(BaseballGame baseball){
        this.baseball = baseball; 
    }
}
