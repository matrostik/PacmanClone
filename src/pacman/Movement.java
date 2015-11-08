package pacman;

import java.awt.*;

public class Movement extends counter implements constants
{
    protected static int wtm;                 

    protected static boolean movOK = false;    
    
    counter asdf = new counter() ;
    
    static int chanceoffruit = spaces;        
    
    static Point previousPosition = new Point();
    static Point currentPosition = new Point();
    
    protected static short eatenGhosts = 0;           
    public static boolean boosterActive = false;       
    public static int speed = slowSpeed;            
    public static boolean fruitActive = false ; 
    
    // public static boolean ghostExistence = false;
    public static boolean g1_eat =false , g2_eat = false , g3_eat = false , g4_eat = false ;
    
    
    
    public static short dirgoing;
    
    static final short cookieEaten = 1;        
    static final short boosterEaten = 2;       
    static final short GhostEaten = 3;         
    static final short fruitEaten = 4;         
    
    protected static char goingto = wall;         
    
    public static boolean moveleft(){
        initial();
        if (py == 0)  wtm = colomnsOfLevel - 1; 
        else wtm = py - 1;
        //  if (wtm < 0) {wtm += 19;}  
        if (aL[px][wtm] == space)
            goingto = space;
        else if (aL[px][wtm] == food)
            goingto = food;
        else if (aL[px][wtm] == booster)
            goingto = booster;
        else if (aL[px][wtm] == ghost1)
            goingto = ghost1;
        else if (aL[px][wtm] == ghost2)
            goingto = ghost2;
        else if (aL[px][wtm] == ghost3)
            goingto = ghost3;
        else if (aL[px][wtm] == ghost4)
            goingto = ghost4;     
        else if (aL[px][wtm] == fruit)
            goingto = fruit;
        dirgoing = west;
        moving(dirgoing, goingto);
        //Continuous cont = new Continuous(west);
        return movOK;
    }


    
    public static boolean moveright(){
        initial();
        if (py == colomnsOfLevel - 1) wtm = 0;  
        else wtm = py + 1;
        if (aL[px][wtm] == space)
            goingto = space;
        else if (aL[px][wtm] == food)
            goingto = food;
        else if (aL[px][wtm] == booster)
            goingto = booster;
        else if (aL[px][wtm] == ghost1)
            goingto = ghost1;
        else if (aL[px][wtm] == ghost2)
            goingto = ghost2;
        else if (aL[px][wtm] == ghost3)
            goingto = ghost3;
        else if (aL[px][wtm] == ghost4)
            goingto = ghost4;    
        else if (aL[px][wtm] == fruit)
            goingto = fruit;
        dirgoing = east;
        moving(dirgoing, goingto);
        //Continuous cont = new Continuous(east);
        return movOK;
    }
    
    
    public static boolean moveup(){
        initial();
        if (px == 0) wtm = linesOfLevel - 1;
        else wtm = px - 1;   
        if (aL[wtm][py] == space)
            goingto = space;
        else if (aL[wtm][py] == food)
            goingto = food;
        else if (aL[wtm][py] == booster)
            goingto = booster;
        else if (aL[wtm][py] == ghost1)
            goingto = ghost1;
        else if (aL[wtm][py] == ghost2)
            goingto = ghost2;
        else if (aL[wtm][py] == ghost3)
            goingto = ghost3; 
        else if (aL[wtm][py] == ghost4)
            goingto = ghost4;      
        else if (aL[wtm][py] == fruit)
            goingto = fruit;
        dirgoing = north;
        moving(dirgoing, goingto);
        //Continuous cont = new Continuous(north);
        return movOK;
    } 

                                                                                          
    public static boolean movedown(){
        initial();
        if (px == linesOfLevel - 1) wtm = 0;
        else wtm = px + 1;   
        if (aL[wtm][py] == space)
            goingto = space;
        else if (aL[wtm][py] == food)
            goingto = food;
        else if (aL[wtm][py] == booster)
            goingto = booster;
        else if (aL[wtm][py] == ghost1)
            goingto = ghost1;
        else if (aL[wtm][py] == ghost2)
            goingto = ghost2;
        else if (aL[wtm][py] == ghost3)
            goingto = ghost3; 
        else if (aL[wtm][py] == ghost4)
            goingto = ghost4;    
        else if (aL[wtm][py] == fruit)
            goingto = fruit;
        dirgoing = south;
        moving(dirgoing, goingto);
        //Continuous cont = new Continuous(south);
        return movOK;
    }


    public static void moving(short direction, char point)
    {   
        
        if ( Ghost_Movement_1.ghost1_dot == true && g1_eat == true ) {  aL[Ghost_Movement_1.tmp_g1y][Ghost_Movement_1.tmp_g1x] = '.' ; }
        if ( Ghost_Movement_2.ghost2_dot == true && g2_eat == true ) {  aL[Ghost_Movement_2.tmp_g2y][Ghost_Movement_2.tmp_g2x] = '.' ; }
        if ( Ghost_Movement_3.ghost3_dot == true && g3_eat == true ) {  aL[Ghost_Movement_3.tmp_g3y][Ghost_Movement_3.tmp_g3x] = '.' ; }
        if ( Ghost_Movement_4.ghost4_dot == true && g4_eat == true ) {  aL[Ghost_Movement_4.tmp_g4y][Ghost_Movement_4.tmp_g4x] = '.' ; }

        if (point == space){
            removePacman(px, py);
            if(direction == north || direction == south)
                px = wtm;
            else
                py = wtm;
            
            drawPacman(px, py);
            movOK = true;
        }

        else if (point == food){                           
            cookiesRemaining--;
            chanceoffruit++;
            removePacman(px, py);
            if(direction == north || direction == south)
                px = wtm;
            else
                py = wtm;
            drawPacman(px, py);
            Score.increaseScore(cookieEaten);    
            
            if ( cookiesRemaining == (int) (0.25 * LevelCookies) || cookiesRemaining == (int)( 0.5 * LevelCookies) || cookiesRemaining == (int) (0.75 * LevelCookies) || cookiesRemaining == (int)(0.6 * LevelCookies) ) // edw ginetai elegxos gia thn emfanish fruit 
                 { fruitActive=true ; Fruit ch = new Fruit() ;  }  
           // System.out.println("cookiesRemaining: " + cookiesRemaining + "LevelCookies:" + LevelCookies);
            movOK = true;
        }

        else if (point == fruit) {
            removePacman(px, py);
            if(direction == north || direction == south)
                px = wtm;
            else
                py = wtm;
            drawPacman(px, py);
            Score.increaseScore(fruitEaten);  
            fruitActive = false; 
            movOK = true;            
        }
/**********************************PERIPTWSH BOOSTER**************************************************************/          
        else if (point == booster){
            Play_Sound.run_Sound(Play_Sound.eating) ;
            if(!boosterActive){
                eatenGhosts = 0;    
            }
            removePacman(px, py);
            if(direction == north || direction == south)
                px = wtm;
            else
                py = wtm;
            drawPacman(px, py);
            movOK = true;
            boostersRemaining--;
            //System.out.println("boostersRemaining: " + boostersRemaining);
            boosterActive = true;
            countBoostime boostime = new countBoostime();  
            Score.increaseScore(boosterEaten);
            
        }
/**********************************PERIPTWSH GHOST**************************************************************/          
        else if ( (point == ghost1) || (point == ghost2) || (point == ghost3) || (point == ghost4)){
            removePacman(px, py);
            
            if(direction == north || direction == south)
                px = wtm;
            else
                py = wtm;
            movOK = true; 
            if(boosterActive){
                Score.increaseScore(GhostEaten);
                eatenGhosts++;
                drawPacman(px, py);
                
                if (point == ghost1) { g1_eat = true ; Ghost_Movement_1 ghost1_mv = new Ghost_Movement_1() ; }
                if (point == ghost2) { g2_eat = true ; Ghost_Movement_2 ghost2_mv = new Ghost_Movement_2() ; }
                if (point == ghost3) { g3_eat = true ; Ghost_Movement_3 ghost3_mv = new Ghost_Movement_3() ; }
                if (point == ghost4) { g4_eat = true ; Ghost_Movement_4 ghost4_mv = new Ghost_Movement_4() ; }
                

            }
            else{
                Play_Sound.run_Sound(Play_Sound.die) ;
                Score.gamelost();
                
            }
        }
        
        
        
        Score.gamewon();   
    }
    
    private static void initial()   
    {
        movOK = false;  
        goingto = wall;  
        countSpeed();
    }
    
    public static void drawPacman(int ver, int hor)
    {
        aL[ver][hor] = PacmanPos;
        currentPosition.x = hor;
        currentPosition.y = ver;
        PacMan_Animation pmanim = new PacMan_Animation(previousPosition, currentPosition, speed);
    }
    
    public static void removePacman(int ver, int hor)
    {
        aL[ver][hor] = ' ';
        previousPosition.x = hor;
        previousPosition.y = ver;
    }
    
    public static void countSpeed() {    
        int cookiesEaten = cookies - cookiesRemaining;
        if(cookiesEaten > 0.6*cookies) {
            if(boosterActive) speed = fastSpeed_BoosterActive;
            else speed = fastSpeed;
        }
        else {
            if(boosterActive) speed = slowSpeed_BoosterActive;
            else speed = slowSpeed;
        }
    }
}