package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GameBoard;

public class KeyController implements KeyListener{
    private GameBoard gameBoard;

    public KeyController(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
