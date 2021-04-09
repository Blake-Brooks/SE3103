package model.observerPattern;
import view.GameBoard;
import view.Text;

public class SnakeObserver implements Observer{
    private GameBoard gameBoard; 

    public SnakeObserver(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }
    
    @Override
    public void snakeAteFood() {
        int score = gameBoard.getScore();
        ++score;
        gameBoard.setScore(score);
        gameBoard.getScoreDisplay().setText("" + score);
    }

    @Override
    public void snakeAtePoison() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void snakeLeftScene() {
        gameBoard.getCanvas().getFigures().add(new Text("Game Over - Out of Bounds", 100, 200));
    }

    @Override
    public void snakeSelfCOllision() {
        // TODO Auto-generated method stub
        
    }
    
}
