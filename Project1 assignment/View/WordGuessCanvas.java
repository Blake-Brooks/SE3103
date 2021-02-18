package View;
import java.awt.Dimension;
import javax.swing.JPanel;

public class WordGuessCanvas extends JPanel{
private WordGuessPanel panel;
public static int width = 500;
public static int height = 500;

public WordGuessCanvas(WordGuessPanel panel) {
    this.panel = panel;
    setPreferredSize(new Dimension(width, height));
    }
}
