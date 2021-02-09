package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.ButtonClickListener;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class BattleSimulator {
    private JFrame window;
    private JButton attackButton = new JButton("Attack");
    private JButton exitButton = new JButton("Exit");
    public BattleSimulator(JFrame window){
        this.window = window; 
        window.setTitle("Battle Simulation");
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(2,1));
        JPanel row1 = new JPanel();
        row1.add(attackButton);
        southPanel.add(row1);
        JPanel row2 = new JPanel();
        row2.add(exitButton);
        southPanel.add(row2);

        ButtonClickListener buttonClickListener = new ButtonClickListener(this);
        attackButton.addActionListener(buttonClickListener);
        exitButton.addActionListener(buttonClickListener);
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getAttackButton(){
        return attackButton;
    }

    public JFrame getWindow(){
        return window; 
    }
}
