package pacman;

import java.io.*;
import javax.swing.JOptionPane;

public class Store
{
    Store()
    {
    }
    
    protected static void storeScore(String file, int score)
    {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(score), 0, Integer.toString(score).length());
            bufferedWriter.close();
            System.out.println("The highscore is : " + score);
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File is missing. Your high score has been lost.");
        }
    }
    
    protected static void showHScore(String file)
    {
        try {
            FileReader hiscore = new FileReader(file);
            BufferedReader buff = new BufferedReader(hiscore);
            String line = buff.readLine();
            Score.highscore = Integer.parseInt(line);
            buff.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Your highscore doesn't exist.");
        }
    }
        
}
