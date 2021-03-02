package Model;
import java.util.ArrayList;
import java.util.Random;

public class WordGuess {
  private int index; 
  private ArrayList<String> wordPool = new ArrayList<String>();
  private int healthValue = 5;
  public WordGuess(){
      wordPool.add("communication");
      wordPool.add("science");
      wordPool.add("programming");
      wordPool.add("language");
      wordPool.add("difficulty");
      wordPool.add("artificial");
      wordPool.add("intelligence");
      wordPool.add("attempts");
      wordPool.add("screenshot");
      wordPool.add("baseball");
      wordPool.add("windows");
      wordPool.add("learning");
      wordPool.add("electronics");
      wordPool.add("beautiful");
      wordPool.add("internet");
      wordPool.add("database");
      wordPool.add("organization");
      wordPool.add("application");
      wordPool.add("network");
      wordPool.add("friendly");
      wordPool.add("validation");
      wordPool.add("attempts");
      wordPool.add("statistics");
      wordPool.add("physics");
      wordPool.add("chemistry");
      wordPool.add("engineering");
      wordPool.add("school");
      wordPool.add("industry");
      wordPool.add("revolution");
      wordPool.add("progress");
      wordPool.add("characters");
      wordPool.add("heavily");
      wordPool.add("graphics");
      Random randomIndex = new Random();
      index =  randomIndex.nextInt(33);
      wordPool.get(index);
  }  
  public int getIndex() {
    return wordPool.get(index).length();
  }

  public void healthLevelValue(){
    healthValue = 5; 

  }
}
