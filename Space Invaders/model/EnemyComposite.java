package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.lang.model.element.Element;

import view.GameBoard;

public class EnemyComposite extends GameElement {

    public static final int NROWS = 2;
    public static final int NCOLS = 10;
    public static final int ENEMY_SIZE = 20;
    public static final int UNIT_MOVE = 5;

    private ArrayList<ArrayList<GameElement>> rows;
    private ArrayList<GameElement> bombs;
    private boolean movingToRight = true;
    private Random random = new Random();

    public EnemyComposite(){
        rows = new ArrayList<>();
        bombs = new ArrayList<>();
        for(int r = 0; r < NROWS; r++){
            var oneRow = new ArrayList<GameElement>();
            rows.add(oneRow);
            for(int c = 0; c < NCOLS; c++){
                oneRow.add(new Enemy(
                    c * ENEMY_SIZE * 2, r * ENEMY_SIZE * 2, ENEMY_SIZE, Color.yellow, true
                ));
            }
        }
    }
    @Override
    public void render(Graphics2D g2) {
        for(var r: rows){
            for(var c: r){
                c.render(g2);
            }
        }

        for(var b: bombs){
            b.render(g2);
        }
    }

    @Override
    public void animate() {
        GameElement element;
        if(rows.get(1).size() == 0){ 
            if(rows.get(0).size() == 0){
                System.exit(0);
            }
            else{
               element = rows.get(0).get(0);
               if(element.y >= GameBoard.HEIGHT){
                   //game over
                   System.exit(0); 
               }
            } 
        }
        else {
            element = rows.get(1).get(0);
            if(element.y >= GameBoard.HEIGHT){
                //game over
                System.exit(0);
            }
        }

        int dx = UNIT_MOVE;
        int dy = 20;
        if(movingToRight){
            if(rightEnd() >= GameBoard.WIDTH){
                dx = -dx;
                for(var row: rows){
                    for(var e: row){
                        e.y += dy;
                    }
                }
                movingToRight = false;
            }   
        } else{
            dx = -dx;
            if(leftEnd() <= 0){
                dx = -dx;
                for(var row: rows){
                    for(var e: row){
                        e.y += dy;
                    }
                }
                movingToRight = true;
            }
        }
        for(var row: rows){
            for(var e: row){
                e.x += dx;
            }
        }

        for(var b: bombs){
            b.animate();
        }
    }
            
        public ArrayList<GameElement> getBombs(){
            return bombs;
        }

        private int rightEnd(){
            int xEnd = -100;
            for(var row: rows){
                if(row.size() == 0) continue; 
                int x = row.get(row.size() - 1).x + ENEMY_SIZE;
                if(x > xEnd) xEnd = x;
            }
            return xEnd;
   }
        private int leftEnd(){
            int xEnd = 9000;
            for(var row: rows){
                if(row.size() == 0) continue;
                int x = row.get(0).x;
                if(x < xEnd) xEnd = x;
            }
            return xEnd;
        }

        public void dropBomb(){
            for(var row: rows){
                for(var e: row){
                    if(random.nextFloat() < 0.1F){
                        bombs.add(new Bomb(e.x, e.y));
                    }
                }
            }
        }

        public void removeBombsOutOfBounds(){
            var remove = new ArrayList<GameElement>();
            for(var b: bombs){
                if(b.y >= GameBoard.HEIGHT){
                    remove.add(b);
                }
            }
            bombs.removeAll(remove);
        }

        public void removeBomb(GameElement bomb){
            bombs.remove(bomb);
        }

        public void processCollision(Shooter shooter){
            var removeBullets = new ArrayList<GameElement>();
            for(var row: rows){
                var removeEnemies = new ArrayList<GameElement>();
                for(var enemy: row){
                    for(var bullet: shooter.getWeapons()){
                        if(enemy.collideWith(bullet)){
                            removeBullets.add(bullet);
                            removeEnemies.add(enemy);
                            int score = GameBoard.getScore();
                            score += 10;
                            GameBoard.setScore(score);
                        }
                    }
                }
                row.removeAll(removeEnemies);
            }

            for(var row: rows){
                for(var enemy: row){
                    if(shooter.collideWith(enemy)){
                        System.exit(0);
                    } 
                }
            }


            shooter.getWeapons().removeAll(removeBullets);
            var removeBombs = new ArrayList<GameElement>();
            removeBullets.clear();
            for(var b: bombs){
                for(var bullet: shooter.getWeapons()){
                    if(b.collideWith(bullet)){
                        removeBombs.add(b);
                        removeBullets.add(bullet);
                        int score = GameBoard.getScore();
                        score += 5;
                        GameBoard.setScore(score);
                    }
                }
            }

            shooter.getWeapons().removeAll(removeBullets);
            bombs.removeAll(removeBombs);
        }
}
