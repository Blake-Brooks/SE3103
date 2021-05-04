package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.Timer;

import controller.TimerListener;
import controller.keyController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.EnemyComposite;
import model.Shooter;
import model.ShooterElement;
import model.observerPattern.EndOfGameObserver;

public class GameBoard implements EndOfGameObserver{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    public static final int FPS = 20;
    public static final int DELAY = 1000 / FPS;

    private JFrame window;
    private MyCanvas canvas;
    private Shooter shooter;
    private EnemyComposite enemyComposite;
    private Timer timer;
    private static  JLabel displayScore = new JLabel();
    private static int score = 0;
    private TimerListener timerListener;
    public GameBoard(JFrame window){
        this.window = window;
    }    

    public void init(){
        Container cp = window.getContentPane();
        canvas = new MyCanvas(this, WIDTH, HEIGHT);
        cp.add(BorderLayout.CENTER, canvas);
        canvas.addKeyListener(new keyController(this));   
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);     
        JButton startButton = new JButton("Start");
        JButton quitButton = new JButton("Quit");
        startButton.setFocusable(false);
        quitButton.setFocusable(false);
        JPanel southPanel = new JPanel();
        southPanel.add(startButton);
        southPanel.add(quitButton);
        cp.add(BorderLayout.SOUTH, southPanel);
        JPanel northPanel = new JPanel();
        JLabel label = new JLabel("Score: ");
        northPanel.add(label);
        displayScore.setText("" + score);
        northPanel.add(displayScore);
        cp.add(BorderLayout.NORTH, northPanel);
        canvas.getGameElements().add(new TextDraw("Click <Start> to play", 100, 100, Color.yellow, 30));
        timerListener = new TimerListener(this);
        timer = new Timer(DELAY, timerListener);

        startButton.addActionListener(event -> {
            shooter = new Shooter(GameBoard.WIDTH / 2, GameBoard.HEIGHT - ShooterElement.SIZE);
            enemyComposite = new EnemyComposite();
            canvas.getGameElements().clear();
            canvas.getGameElements().add(shooter);
            canvas.getGameElements().add(enemyComposite);
            shooter.addEndOfGameObserver(this);
            timer.start();
        });

        quitButton.addActionListener(event -> System.exit(0));
    }

    public static int getScore(){
        return score;
    }

    public static void setScore(int newScore){
       score = newScore;
       displayScore.setText("" + score);
    }

    public MyCanvas getCanvas(){
        return canvas;
    }

    public Timer getTimer(){
        return timer;
    }

    public TimerListener getTimerListener(){
        return timerListener;
    }

    public Shooter getShooter(){
        return shooter;
    }

    public EnemyComposite getEnemyComposite(){
        return enemyComposite;
    }

    @Override
    public void gameHasEnded(){
        System.out.println("In here");
        JOptionPane.showConfirmDialog(null, "Do you want to start a new game", "Restart Game Dialogue", JOptionPane.QUESTION_MESSAGE);
    }

}
