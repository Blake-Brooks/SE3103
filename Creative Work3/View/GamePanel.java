package View;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Controller;

import javax.swing.JButton;

public class GamePanel {

    public enum GameState{
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private Game gameCanvas; 
    private JButton startButton = new JButton("Start");
    private GameState gameState = GameState.READY;
    public GamePanel(JFrame window){
        this.window = window; 
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        southPanel.add(startButton);
        cp.add(BorderLayout.SOUTH, southPanel);
        gameCanvas = new Game(this);
        cp.add(BorderLayout.CENTER, gameCanvas);
        Controller controllerListener = new Controller(this);
        startButton.addActionListener(controllerListener);
    }

    public JButton getStartButton(){
        return startButton;
    }

    public JFrame getWindow(){
        return window;
    }

    public Game getGameCanvas(){
        return gameCanvas;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }
}
