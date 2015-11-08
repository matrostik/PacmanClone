package pacman;

import java.awt.Point;
import java.awt.* ;
import javax.swing.* ;


class PacMan_Animation implements Runnable
{
    Point previousPosition, currentPosition;
    
    int counter = 0;
    
    final static Image PM0 = (new ImageIcon("images/PM0.gif")).getImage();
    final static Image PMdown1 = (new ImageIcon("images/PMdown1.gif")).getImage();
    final static Image PMdown2 = (new ImageIcon("images/PMdown2.gif")).getImage();
    final static Image PMdown3 = (new ImageIcon("images/PMdown3.gif")).getImage();
    final static Image PMleft1 = (new ImageIcon("images/PMleft1.gif")).getImage();
    final static Image PMleft2 = (new ImageIcon("images/PMleft2.gif")).getImage();
    final static Image PMleft3 = (new ImageIcon("images/PMleft3.gif")).getImage();
    final static Image PMright1 = (new ImageIcon("images/PMright1.gif")).getImage();
    final static Image PMright2 = (new ImageIcon("images/PMright2.gif")).getImage();
    final static Image PMright3 = (new ImageIcon("images/PMright3.gif")).getImage();
    final static Image PMup1 = (new ImageIcon("images/PMup1.gif")).getImage();
    final static Image PMup2 = (new ImageIcon("images/PMup2.gif")).getImage();
    final static Image PMup3 = (new ImageIcon("images/PMup3.gif")).getImage();
    
    PacMan_Animation() {}
    
    PacMan_Animation(Point previousPosition, Point currentPosition, int speed)
    {
        this.previousPosition = previousPosition;
        this.currentPosition = currentPosition;
        MazePane.pacmanImage = PM0;
        Thread thread = null;
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        if(previousPosition.x == currentPosition.x){
            MazePane.pacmanx = 24 * currentPosition.x;
/******************************Down Animation****************************************************/
            if(currentPosition.y > previousPosition.y) {
                if(currentPosition.y == arrayCreator.linesOfLevel - 1 && previousPosition.y == 0) {
                    MazePane.pacmanImage = PMup2;
                    MazePane.pacmany = 24 * currentPosition.y;
                    PacMan_Graphics.content.repaint();
                } else {
                    for(MazePane.pacmany = 24 * previousPosition.y; MazePane.pacmany < 24 * currentPosition.y; MazePane.pacmany++, counter++) {
                        if(counter == 0) MazePane.pacmanImage = PMdown2;
                        if(counter == 5) MazePane.pacmanImage = PMdown3;
                        if(counter == 11) MazePane.pacmanImage = PMdown2;
                        if(counter == 17) MazePane.pacmanImage = PMdown1;
                        PacMan_Graphics.content.repaint();
                        try {
                            Thread.sleep(12);
                        } catch (InterruptedException ie) {}
                    }
                }
            }
/*******************************Up Animation************************************************/
            else {
                if(previousPosition.y == arrayCreator.linesOfLevel - 1 && currentPosition.y == 0) {
                    MazePane.pacmanImage = PMdown2;
                    MazePane.pacmany = 24 * currentPosition.y;
                    PacMan_Graphics.content.repaint();
                } else {
                    for(MazePane.pacmany = 24 * previousPosition.y; MazePane.pacmany > 24 * currentPosition.y; MazePane.pacmany--, counter++) {
                        if(counter == 0) MazePane.pacmanImage = PMup2;
                        if(counter == 5) MazePane.pacmanImage = PMup3;
                        if(counter == 11) MazePane.pacmanImage = PMup2;
                        if(counter == 17) MazePane.pacmanImage = PMup1;
                        PacMan_Graphics.content.repaint();
                        try {
                            Thread.sleep(12);
                        } catch (InterruptedException ie) {}
                    }
                }
            }
        }
        if(previousPosition.y == currentPosition.y) {
            MazePane.pacmany = 24 * currentPosition.y;
/*******************************Right Animation**********************************************/
            if( currentPosition.x > previousPosition.x ){
                if (previousPosition.x == 0 && currentPosition.x == arrayCreator.colomnsOfLevel - 1) {
                    if(counter == 0) MazePane.pacmanImage = PMdown2;
                    MazePane.pacmanImage = PMleft2;
                    MazePane.pacmanx = 24 * currentPosition.x;
                    PacMan_Graphics.content.repaint();
                } else {
                    for(MazePane.pacmanx = 24 * previousPosition.x; MazePane.pacmanx < 24 * currentPosition.x; MazePane.pacmanx++, counter++) {
                        if(counter == 0) MazePane.pacmanImage = PMright2;
                        if(counter == 5) MazePane.pacmanImage = PMright3;
                        if(counter == 11) MazePane.pacmanImage = PMright2;
                        if(counter == 17) MazePane.pacmanImage = PMright1;
                        PacMan_Graphics.content.repaint();
                        try {
                            Thread.sleep(12);
                        } catch(InterruptedException ie) {}
                    }
                }
            }
/********************************Left Animation***********************************************/
            else {
                if(currentPosition.x == 0 && previousPosition.x == arrayCreator.colomnsOfLevel - 1) {
                    MazePane.pacmanImage = PMright2;
                    MazePane.pacmanx = 24 * currentPosition.x;
                    PacMan_Graphics.content.repaint();
                } else {
                    
                    for(MazePane.pacmanx = 24 * previousPosition.x; MazePane.pacmanx > 24 * currentPosition.x; MazePane.pacmanx--, counter++){
                        if(counter == 0) MazePane.pacmanImage = PMleft2;
                        if(counter == 5) MazePane.pacmanImage = PMleft3;
                        if(counter == 11) MazePane.pacmanImage = PMleft2;
                        if(counter == 17) MazePane.pacmanImage = PMleft1;
                        PacMan_Graphics.content.repaint();
                        try {
                            Thread.sleep(12);
                        } catch (InterruptedException ie) {}
                    }
                }
            }
        }
    }
}