package Controller;
import View.PiggyBankSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBStatsListener implements ActionListener {
    private PiggyBankSimulator panel;
    public PBStatsListener(PiggyBankSimulator panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nickles = 0;
        int dimes = 0; 
        int quarters = 0;
        for (var coin : panel.getPiggyBank().getCoinHistory()){
            switch(coin.getValue()){
                case 5: ++nickles; break;
                case 10: ++dimes; break;
                case 25: ++quarters; break;
            }
        }
        String em = panel.getDisplay().getText();
        em += "\nCoin Stats\n";
        panel.getDisplay().setText(em + "Nickels " + nickles + "\nDimes" + dimes + "\nQuarters" + quarters);
    }
}
