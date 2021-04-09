package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import model.StrategyPattern.SnakeMoveAliveStrategy;
import model.StrategyPattern.SnakeMoveDeadStrategy;
import model.StrategyPattern.SnakeMoveStrategy;
import model.StrategyPattern.SnakeRenderAliveStrategy;
import model.StrategyPattern.SnakeRenderStrategy;
import model.observerPattern.Observer;
import model.observerPattern.Subject;
import view.GameBoard;

public class Snake extends GameElement implements Subject{

    public enum Direction{
        LEFT, RIGHT, UP, DOWN
    }

    public enum Event {
        AteFood, AtePoison, LeftScene, SelfCollision
    }

    public ArrayList<GameElement> composite = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>(); 
    private final int INIT_XLOC = GameBoard.CELL_SIZE * 7;
    private final int INIT_YLOC = GameBoard.CELL_SIZE * 3;
    private final int INIT_BODY_SIZE = 3;
    public Direction direction = Direction.RIGHT;
    private SnakeMoveStrategy moveStrategy;
    private SnakeRenderStrategy renderStrategy;

    public void init(){
        direction = Direction.RIGHT;
        composite.clear();
        super.x = INIT_XLOC;
        super.y = INIT_YLOC;
        var head = new SnakeHead(super.x, super.y);
        head.color = Color.yellow;
        composite.add(head);
        composite.add(new SnakeHead(super.x, super.y));
        for(int i = 0; i <= INIT_BODY_SIZE; i++){
            int x = INIT_XLOC - i * GameBoard.CELL_SIZE;
            int y = INIT_YLOC;
            var body = new SnakeBody(x, y);
            body.color = Color.white;
            composite.add(body);
        }
    }

    public void setMoveStrategy(SnakeMoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    public ArrayList<GameElement> getComposite(){
        return composite;
    }

    @Override
    public void render(Graphics2D g2) {
        this.renderStrategy.renderAlgorithm(g2);
    }

    @Override
    public void move() {
        this.moveStrategy.moveAlgorithm();        
    }

    @Override
    public void addSnakeListener(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeSnakeListener(Observer o) {
        observers.remove(o);
    }

    
    @Override
    public void notifyObservers(Event event) {
        switch(event){
            case AteFood:
            for(var o: observers){
                o.snakeAteFood();
            }
            break;
            case AtePoison: 
            break;
            case LeftScene: 
            for(var o: observers){
                o.snakeLeftScene();
            }
            break;
            case SelfCollision: 
            break;
        }
    }

}
