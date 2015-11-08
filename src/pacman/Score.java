package pacman;

import javax.swing.*;
import java.awt.*;

public class Score extends Movement
{
    public static short lives = init_lives;
    public static short slevel = 1;
    
   private static int scorelive = scoreupLive;
   
    public static void gamewon()
    {
        
        if (cookiesRemaining == 0 && boostersRemaining == 0){
            try{
                JOptionPane.showMessageDialog(null, "YOU WON!!");
            }
            catch (HeadlessException e) {System.out.println(e.toString());}
            
        Movement.boosterActive = false; 
        ++slevel; 
         
        //PacMan_Graphics.mainWindow.hide () ; 
        PacMan_Graphics.Initial_Things() ;
        PacMan_Graphics mainWindow2 = new PacMan_Graphics("level" + slevel + ".txt");
                                                 
        }
    }
    
    public static void gamelost()
    {
        lives--;
        try{
                if (lives > 0){
                    JOptionPane.showMessageDialog(null, "You have lost a life.\nRemaing lives : " + lives);
                    counter count = new counter();
                    px = syntetagmenes.x;
                    py = syntetagmenes.y;
                    removePacman(px, py);
                    drawPacman(px, py);
                    PacMan_Graphics.addDownPart();
                    //PacMan_Graphics.content.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Game Over!!");
                    removePacman(px, py);
                    
                    lives = init_lives; 
                    if (score > highscore) 
                    {
                    highscore = score; 
                    Store.storeScore("score.txt", highscore);
                    }
                    score = 0;
                    
                    slevel = 1;
//                     PacMan_Graphics.visible = false;
//                     PacMan_Graphics.mainWindow.setVisible(PacMan_Graphics.visible);
//                     PacMan_Graphics.visible = true;
                    PacMan_Graphics mainWindow = new PacMan_Graphics("level" + slevel + ".txt");
                    px = syntetagmenes.x;
                    py = syntetagmenes.y;
                    PacMan_Graphics.Initial_Things() ;
                    counter count = new counter();
                    drawPacman(px, py);
                }
            }
            catch (HeadlessException e)
                {
                    System.out.println(e.toString());
                }
    }
    
    protected static void increaseScore(int food)
    {                
        final short FirstGhost = GhostEaten;        
        final short SecondGhost = GhostEaten + 1;
        final short ThirdGhost = GhostEaten + 2;
        final short FourthGhost = GhostEaten + 3;
        
        if (food == cookieEaten)
            score += upcookie;
        else if (food == boosterEaten)
            score += upbooster;
        else if (food == fruitEaten)
            score += upfruit;
        else if (food >= GhostEaten){
            if (food == FirstGhost)
                score += upFirstGhost;
            else if (food == SecondGhost)
                score += upSecondGhost;
            else if (food == ThirdGhost)
                score += upThirdGhost;
            else if (food == FourthGhost)
                score += upForthGhost;
            else if (food - FourthGhost > 0)
                score += upForthGhost * power2(food - FourthGhost);   
            }
        if (score > scorelive && lives < 5){
            lives++;
            scorelive += scoreupLive;
            for(int i = 0; i < lives; i++) { 
            PacMan_Graphics.livesLabel[i] = new JLabel(new ImageIcon("images/pacman.gif"));
            }
            PacMan_Graphics.Down.repaint();
            PacMan_Graphics.addDownPart();
        }
        PacMan_Graphics.displayScores(score, highscore);
    }
    
    
    private final static int power2(int n)
    {
        int coun, result = 1;
    
        for(coun = 0; coun < n; coun++){
            result *= 2;
        }
    
        return result;
    }
}