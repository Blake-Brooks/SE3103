package model.observerPattern;

import view.GameBoard;

public class shooterOutOfLives implements gameObserver{

    private GameBoard gameBoard; 

    public void shooterOutOfLives(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    @Override
    public void enemyReachesTheEnd() {
          gameBoard.gameHasEnded();
    }

    @Override
    public void shooterOutofLives() {
        gameBoard.gameHasEnded();
    }  
}
