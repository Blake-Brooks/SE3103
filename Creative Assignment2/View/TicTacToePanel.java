package View;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;

public class TicTacToePanel {
    private JFrame window; 
    private TicTacToeCanvas canvas;
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton yellowButton = new JRadioButton("Yellow");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JButton resetButton = new JButton("Reset");

    public TicTacToePanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(blueButton);
        radioPanel.add(resetButton);
        southPanel.add(radioPanel);
        cp.add(BorderLayout.SOUTH, southPanel);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redButton);
        colorGroup.add(yellowButton);
        colorGroup.add(blueButton);
    }

    public JButton getResetButton(){
        return resetButton;
    }

    public JRadioButton getRedButton(){
        return redButton;
    }

    public JRadioButton getYellowButton(){
        return yellowButton;
    }

    public JRadioButton getBlueButton(){
        return blueButton;
    }
}
