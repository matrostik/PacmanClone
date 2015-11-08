package pacman;

import java.awt.* ;
import javax.swing.* ;

public class Ghost_Animation implements Runnable
{
    Point currentPosition;
    
    int prepos;
    int counter = 0;
    int speed;
    int Ghost_number;
    boolean moved_up;
    boolean moved_down;
    boolean moved_left;
    boolean moved_right;
    
    public static ImageIcon fantomIcon1_a = new ImageIcon("images/ghost1_a.gif") ;
    public static Image ghost1_img_a = fantomIcon1_a.getImage();
    
    public static ImageIcon fantomIcon1_b = new ImageIcon("images/ghost1_b.gif") ;
    public static Image ghost1_img_b = fantomIcon1_b.getImage();
    
    public static ImageIcon fantomIcon2_a = new ImageIcon("images/ghost2_a.gif") ;
    public static Image ghost2_img_a = fantomIcon2_a.getImage();
    
    public static ImageIcon fantomIcon2_b = new ImageIcon("images/ghost2_b.gif") ;
    public static Image ghost2_img_b = fantomIcon2_b.getImage();
    
    public static ImageIcon fantomIcon3_a = new ImageIcon("images/ghost3_a.gif") ;
    public static Image ghost3_img_a = fantomIcon3_a.getImage();
    
    public static ImageIcon fantomIcon3_b = new ImageIcon("images/ghost3_b.gif") ;
    public static Image ghost3_img_b = fantomIcon3_b.getImage();
    
    public static ImageIcon fantomIcon4_a = new ImageIcon("images/ghost4_a.gif") ;
    public static Image ghost4_img_a = fantomIcon4_a.getImage();
    
    public static ImageIcon fantomIcon4_b = new ImageIcon("images/ghost4_b.gif") ;
    public static Image ghost4_img_b = fantomIcon4_b.getImage();
    
    public static ImageIcon scared_fantomIcon_1 = new ImageIcon("images/GhostScared1.gif") ;
    public static Image scared_ghost_img_1 = scared_fantomIcon_1.getImage();
    
    public static ImageIcon scared_fantomIcon_2 = new ImageIcon("images/GhostScared2.gif") ;
    public static Image scared_ghost_img_2 = scared_fantomIcon_2.getImage();
    
    Ghost_Animation() {}
    
    Ghost_Animation(Point currPosition, int speed, int Ghost_number, boolean moved_up, boolean moved_down, boolean moved_left, boolean moved_right)
    {
        currentPosition = currPosition;
        this.moved_up = moved_up;
        this.moved_down = moved_down;
        this.moved_left = moved_left;
        this.moved_right = moved_right;
        this.speed = speed;
        this.Ghost_number = Ghost_number;
        Thread thread = null;
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        if(Ghost_number == 1){
 /*************************************************Animation gia to Ghost1*********************************************************************/
            if(moved_up) {
                MazePane.ga1x = currentPosition.x * 24;
                prepos = currentPosition.y + 1;
                for(MazePane.ga1y = prepos * 24; MazePane.ga1y > 24 * currentPosition.y; MazePane.ga1y--, counter++)
                {
                    ghost1animation();
                }
            }
            else if(moved_down) {
                MazePane.ga1x = currentPosition.x * 24;
                prepos = currentPosition.y - 1;
                for(MazePane.ga1y = prepos * 24; MazePane.ga1y < 24 * currentPosition.y; MazePane.ga1y++, counter++)
                {
                    ghost1animation();
                }
            }
            else if(moved_left) {
                MazePane.ga1y = currentPosition.y * 24;
                prepos = currentPosition.x + 1;
                for(MazePane.ga1x = prepos * 24; MazePane.ga1x > currentPosition.x * 24; MazePane.ga1x--, counter++)
                {
                    ghost1animation();
                }
            }
            else {
                MazePane.ga1y = currentPosition.y * 24;
                prepos = currentPosition.x - 1;
                for(MazePane.ga1x = prepos * 24; MazePane.ga1x < currentPosition.x * 24; MazePane.ga1x++, counter++)
                {
                    ghost1animation();
                }
            }
        }
        else if(Ghost_number == 2){
 /*************************************************Animation gia to Ghost2*********************************************************************/
            if(moved_up) {
                MazePane.ga2x = currentPosition.x * 24;
                prepos = currentPosition.y + 1;
                for(MazePane.ga2y = prepos * 24; MazePane.ga2y > 24 * currentPosition.y; MazePane.ga2y--, counter++)
                {
                    ghost2animation();
                }
            }
            else if(moved_down) {
                MazePane.ga2x = currentPosition.x * 24;
                prepos = currentPosition.y - 1;
                for(MazePane.ga2y = prepos * 24; MazePane.ga2y < 24 * currentPosition.y; MazePane.ga2y++, counter++)
                {
                    ghost2animation();
                }
            }
            else if(moved_left) {
                MazePane.ga2y = currentPosition.y * 24;
                prepos = currentPosition.x + 1;
                for(MazePane.ga2x = prepos * 24; MazePane.ga2x > currentPosition.x * 24; MazePane.ga2x--, counter++)
                {
                    ghost2animation();
                }
            }
            else {
                MazePane.ga2y = currentPosition.y * 24;
                prepos = currentPosition.x - 1;
                for(MazePane.ga2x = prepos * 24; MazePane.ga2x < currentPosition.x * 24; MazePane.ga2x++, counter++)
                {
                    ghost2animation();
                }
            }
        }
        else if(Ghost_number == 3){
 /*************************************************Animation gia to Ghost3*********************************************************************/
            if(moved_up) {
                MazePane.ga3x = currentPosition.x * 24;
                prepos = currentPosition.y + 1;
                for(MazePane.ga3y = prepos * 24; MazePane.ga3y > 24 * currentPosition.y; MazePane.ga3y--, counter++)
                {
                    ghost3animation();
                }
            }
            else if(moved_down) {
                MazePane.ga3x = currentPosition.x * 24;
                prepos = currentPosition.y - 1;
                for(MazePane.ga3y = prepos * 24; MazePane.ga3y < 24 * currentPosition.y; MazePane.ga3y++, counter++)
                {
                    ghost3animation();
                }
            }
            else if(moved_left) {
                MazePane.ga3y = currentPosition.y * 24;
                prepos = currentPosition.x + 1;
                for(MazePane.ga3x = prepos * 24; MazePane.ga3x > currentPosition.x * 24; MazePane.ga3x--, counter++)
                {
                    ghost3animation();
                }
            }
            else {
                MazePane.ga3y = currentPosition.y * 24;
                prepos = currentPosition.x - 1;
                for(MazePane.ga3x = prepos * 24; MazePane.ga3x < currentPosition.x * 24; MazePane.ga3x++, counter++)
                {
                    ghost3animation();
                }
            }
        }
        else{
 /*************************************************Animation gia to Ghost4*********************************************************************/
            if(moved_up) {
                MazePane.ga4x = currentPosition.x * 24;
                prepos = currentPosition.y + 1;
                for(MazePane.ga4y = prepos * 24; MazePane.ga4y > 24 * currentPosition.y; MazePane.ga4y--, counter++)
                {
                    ghost4animation();
                }
            }
            else if(moved_down) {
                MazePane.ga4x = currentPosition.x * 24;
                prepos = currentPosition.y - 1;
                for(MazePane.ga4y = prepos * 24; MazePane.ga4y < 24 * currentPosition.y; MazePane.ga4y++, counter++)
                {
                    ghost4animation();
                }
            }
            else if(moved_left) {
                MazePane.ga4y = currentPosition.y * 24;
                prepos = currentPosition.x + 1;
                for(MazePane.ga4x = prepos * 24; MazePane.ga4x > currentPosition.x * 24; MazePane.ga4x--, counter++)
                {
                    ghost4animation();
                }
            }
            else {
                MazePane.ga4y = currentPosition.y * 24;
                prepos = currentPosition.x - 1;
                for(MazePane.ga4x = prepos * 24; MazePane.ga4x < currentPosition.x * 24; MazePane.ga4x++, counter++)
                {
                    ghost4animation();
                }
            }
        }
    }
    
    private final void ghost1animation()
    {
        if(counter == 0) if(!Movement.boosterActive) MazePane.Ghost1_Image = ghost1_img_a; else MazePane.Ghost1_Image = scared_ghost_img_1;
        if(counter == 5) if(!Movement.boosterActive) MazePane.Ghost1_Image = ghost1_img_b; else MazePane.Ghost1_Image = scared_ghost_img_2;
        if(counter == 11) if(!Movement.boosterActive) MazePane.Ghost1_Image = ghost1_img_a; else MazePane.Ghost1_Image = scared_ghost_img_1;
        if(counter == 17) if(!Movement.boosterActive) MazePane.Ghost1_Image = ghost1_img_b; else MazePane.Ghost1_Image = scared_ghost_img_2;
        PacMan_Graphics.content.repaint();
        try { Thread.sleep(12); } catch (InterruptedException ie) {System.out.println("Debbuging : Sleep Interrupted Exception");}
    }
    
    private final void ghost2animation()
    {
        if(counter == 0) if(!Movement.boosterActive) MazePane.Ghost2_Image = ghost2_img_a; else MazePane.Ghost2_Image = scared_ghost_img_1;
        if(counter == 5) if(!Movement.boosterActive) MazePane.Ghost2_Image = ghost2_img_b; else MazePane.Ghost2_Image = scared_ghost_img_2;
        if(counter == 11) if(!Movement.boosterActive) MazePane.Ghost2_Image = ghost2_img_a; else MazePane.Ghost2_Image = scared_ghost_img_1;
        if(counter == 17) if(!Movement.boosterActive) MazePane.Ghost2_Image = ghost2_img_b; else MazePane.Ghost2_Image = scared_ghost_img_2;
        PacMan_Graphics.content.repaint();
        try { Thread.sleep(12); } catch (InterruptedException ie) {System.out.println("Debbuging : Sleep Interrupted Exception");}
    }
    
    private final void ghost3animation()
    {
        if(counter == 0) if(!Movement.boosterActive) MazePane.Ghost3_Image = ghost3_img_a; else MazePane.Ghost3_Image = scared_ghost_img_1;
        if(counter == 5) if(!Movement.boosterActive) MazePane.Ghost3_Image = ghost3_img_b; else MazePane.Ghost3_Image = scared_ghost_img_2;
        if(counter == 11) if(!Movement.boosterActive) MazePane.Ghost3_Image = ghost3_img_a; else MazePane.Ghost3_Image = scared_ghost_img_1;
        if(counter == 17) if(!Movement.boosterActive) MazePane.Ghost3_Image = ghost3_img_b; else MazePane.Ghost3_Image = scared_ghost_img_2;
        PacMan_Graphics.content.repaint();
        try { Thread.sleep(12); } catch (InterruptedException ie) {System.out.println("Debbuging : Sleep Interrupted Exception");}
    }
    
    private final void ghost4animation()
    {
        if(counter == 0) if(!Movement.boosterActive) MazePane.Ghost4_Image = ghost4_img_a; else MazePane.Ghost4_Image = scared_ghost_img_1;
        if(counter == 5) if(!Movement.boosterActive) MazePane.Ghost4_Image = ghost4_img_b; else MazePane.Ghost4_Image = scared_ghost_img_2;
        if(counter == 11) if(!Movement.boosterActive) MazePane.Ghost4_Image = ghost4_img_a; else MazePane.Ghost4_Image = scared_ghost_img_1;
        if(counter == 17) if(!Movement.boosterActive) MazePane.Ghost4_Image = ghost4_img_b; else MazePane.Ghost4_Image = scared_ghost_img_2;
        PacMan_Graphics.content.repaint();
        try { Thread.sleep(12); } catch (InterruptedException ie) {System.out.println("Debbuging : Sleep Interrupted Exception");}
    }
}