package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

public class MenuScreen {
        private JFrame window;

        public MenuScreen(JFrame window){
            this.window = window;
            window.setTitle("Menu Screen");
        }
        
        public void init(){
            Container cp = window.getContentPane();
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(400,200));
            panel.setLayout(new GridLayout(2,1));
            JButton calcButton = new JButton("Calculator Simulator");
            JButton piggyBankButton = new JButton("PiggyBank Simulator");
            panel.add(calcButton);
            panel.add(piggyBankButton);
            cp.add(BorderLayout.CENTER, panel);

            calcButton.addActionListener( e -> {
                window.getContentPane().removeAll();
                var calc = new CalculatorSimulator(window);
                calc.init(); 
                window.pack();
                window.revalidate();
            });

            
            piggyBankButton.addActionListener( e -> {
                window.getContentPane().removeAll();
                var piggybank = new PiggyBankSimulator(window);
                piggybank.init();
                window.pack();
                window.revalidate();
            });
        }
    }
