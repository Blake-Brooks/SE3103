
import java.awt.* ;
import java.awt.event.*;

import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Main implements ActionListener{
    public JFrame jframe= new JFrame("Hangman 5000");
    public ArrayList<String> guesses = new ArrayList<>();
    public String wordToBeGuessed = getRandomWord();
    public static void main(String[] args){
        Main m = new Main();
        System.out.println(" our word is "+m.wordToBeGuessed);

        JPanel pane = new JPanel();
        JLabel label = new JLabel("Guess the word");
        m.jframe.add(label);
        JPanel southpanel = new JPanel();
        m.jframe.add(pane);
        m.jframe.add(southpanel);
        JButton button = new JButton("hi mom");
        ArrayList<JButton> buttons = new ArrayList<>();
        
        m.jframe.setVisible(true);
        label.setFont(new Font("Serif", Font.PLAIN, 28));
        label.setVerticalAlignment(JLabel.TOP);
        pane.add( label );
        for (char c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            Button b = new Button(String.valueOf(c));
            b.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                  m.selectionButtonPressed(c);
                } 
              } );
            southpanel.add(b);
        }    
        
        
        int x = 400;
        int y = 50;
        int width = 400;
        int height = 600;
        m.jframe.setBounds(x,y,x+width,y+height);
        // m.jpane = new JPanel();
    }

    public boolean guessedAllLetters(){
        for (char c: wordToBeGuessed.toCharArray()){
            if (!guesses.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }


    public void gameLogic(){


        if ( guesses.size() > 2*wordToBeGuessed.length())
        {
            System.out.println("you've guessed too many times bucko");
        }
        else if (guessedAllLetters()){
            System.out.println("yea you correctly guessed the word!");
        }
        else{
           System.out.println("you can still guess..."); 
        }

        

    }


    public String getRandomWord(){
        Scanner sc = new Scanner(System.in);;
        try{
            String filename = "hangmanwords.txt";
            File file = new File(filename);
            sc = new Scanner(file);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<String> words = new ArrayList<>();
        
        while( sc.hasNextLine()){
            words.add(sc.next());
        }
        return words.get(new Random().nextInt(words.size()));         

    }

    public void selectionButtonPressed(char c){
        this.guesses.add(String.valueOf(c));
        System.out.println(guesses.toString());
        gameLogic();
    }
}