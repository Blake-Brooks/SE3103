package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.observerPattern.EndOfGameObserver;
import model.observerPattern.gameObserver;
import view.GameBoard;



public class Shooter extends GameElement{
    
    public static final int UNIT_MOVE = 10;
    public static final int MAX_BULLETS = 3;
    private ArrayList<GameElement> components = new ArrayList<>();
    private ArrayList<GameElement> weapons = new ArrayList<>();
    private ArrayList<GameElement> enemyInFormation = new ArrayList<>();
    private ArrayList<EndOfGameObserver> endOfGameObservers = new ArrayList<>();

    public void gameHasEnded(){
        for(EndOfGameObserver endOfGameObserver: endOfGameObservers){
            endOfGameObserver.gameHasEnded();
        }
    }

    public void addEndOfGameObserver(EndOfGameObserver observer){
        endOfGameObservers.add(observer);
    }

    public void removeEndOfGameObserver(EndOfGameObserver observer){
        endOfGameObservers.remove(observer);
    }

    public Shooter(int x, int y){
      super(x, y, 0, 0);

      var size = ShooterElement.SIZE; 
      var s1 = new ShooterElement(x- size, y - size, Color.white, false);
      var s2 = new ShooterElement(x, y - size, Color.white, false);
      var s3 = new ShooterElement(x- size, y, Color.white, false);
      var s4 = new ShooterElement(x, y, Color.white, false);
      components.add(s1);
      components.add(s2);
      components.add(s3);
      components.add(s4);
    }

    public void moveRight(){
        super.x += UNIT_MOVE;
        for(var c: components){
            c.x += UNIT_MOVE;
        }
    }

    public void moveLeft() {
        super.x -= UNIT_MOVE;
        for(var c: components){
            c.x -= UNIT_MOVE;
        }
    }

    public boolean canFireMoreBullets(){
        return weapons.size() < MAX_BULLETS;
    }

    public void removeBulletsOutOfBounds(){
        var remove = new ArrayList<GameElement>();
        for(var w: weapons){
            if(w.y < 0) remove.add(w);
        }
        weapons.removeAll(remove);
    }

    public ArrayList<GameElement> getWeapons(){
        return weapons;
    }

    @Override
    public void render(Graphics2D g2) {
        for(var c: components){
            c.render(g2);
        }

        for(var w: weapons){
            w.render(g2);
        }
    }

    @Override
    public void animate() {
        for(var w: weapons){
            w.animate();
        }
    }

    public void processCollision(EnemyComposite enemies){
        var componentsToBeRemoved = new ArrayList<GameElement>();
        var bombsToBeRemoved = new ArrayList<GameElement>();
        for(var bomb: enemies.getBombs()){
            for(var component: components){
                if(component.collideWith(bomb)){
                    componentsToBeRemoved.add(component);
                    bombsToBeRemoved.add(bomb);
                }
            }
        }
        components.removeAll(componentsToBeRemoved);  
        for(int i = 0; i < bombsToBeRemoved.size(); i++){
            enemies.removeBomb(bombsToBeRemoved.get(i));
            int score = GameBoard.getScore();
            score += 10;
            GameBoard.setScore(score);
        }
        if(components.size() == 0){
            gameHasEnded();
        }
    }
}
