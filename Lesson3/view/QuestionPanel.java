package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Container;

public class QuestionPanel {
    private JFrame window;
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Prev");
    private JButton quitButton = new JButton("Quit");
    private JButton enterButton = new JButton("Enter");
    private JTextField answerField = new JTextField(20);
    public QuestionPanel(JFrame window){
        this.window = window;
    } 

    public void init(){
        Container cp = window.getContentPane(); 
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
    }
}
