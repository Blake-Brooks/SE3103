package model;

import java.util.ArrayList;

public class ChoiceQuestion extends Question {
    private ArrayList<String> choices;
    public ChoiceQuestion(String text, String answer){
        super(text, answer);
        choices = new ArrayList<>();
     }

     public void addChoice(String c){
        choices.add(c);
     }

     @Override 
     public void display(){
         super.display();
         int no = 1;
         for(var c: choices){
             System.out.println("\t" + no + "." + c);
             ++no;
         }
     }
}
