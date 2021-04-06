package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import view.GameBoard;

public class Snake extends  GameElement{

    public enum Direction{
        LEFT, RIGHT, UP, DOWN
    }

    public ArrayList<GameElement> composite = new ArrayList<>();
    private final int INIT_XLOC = GameBoard.CELL_SIZE * 7;
    private final int INIT_YLOC = GameBoard.CELL_SIZE * 3;
    private final int INIT_BODY_SIZE = 3;
    public Direction direction = Direction.RIGHT;

    public void init(){
        direction = Direction.RIGHT;
        composite.clear();
        super.x = INIT_XLOC;
        super.y = INIT_YLOC;
        composite.add(new SnakeHead(super.x, super.y));
        for(int i = 0; i < INIT_BODY_SIZE; i++){
            
        }
    }

    @Override
    public void render(Graphics2D g2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }
    
}