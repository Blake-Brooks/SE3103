package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Random;
import View.BattleSimulator;
import View.MenuScreen;
public class ButtonClickListener implements ActionListener{
    private BattleSimulator panel;
    public ButtonClickListener(BattleSimulator panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var button = e.getSource();
        if(button==panel.getExitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
         }
         else if(button==panel.getAttackButton()){
            int enemyHp = 10; 
            int turnLimit = 5; 
            for(int i = 0; i < turnLimit; i++){
                Random damageDealt = new Random();
                enemyHp = enemyHp - (damageDealt.nextInt(10) + 1);
            }
                if(enemyHp==0){
                    System.out.println("You win");
                }
                else{
                    System.out.println("Better luck next time");
                }
            }
         }
    }
