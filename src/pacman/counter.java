package pacman;

public class counter extends arrayCreator
{
    protected static int spaces;        // counter twn kenwn
    protected static int cookies;       // counter twn cookies
    protected static int boosters;      // counter twn boosters
    protected static int ghosts;        // counter twn fantasmatwn
    protected static int walls;
    
     protected static int cookiesRemaining ;           // counter twn fagomenwn cookies
     protected static int boostersRemaining ;           // counter twn gafomenwn boosters
     protected static int LevelCookies ;
    
    public static int px;                   // H tetmhmenh tou PacMan
    public static int py;                   // H tetagmenh tou PacMan
    
    public static int score = 0;
    public static int highscore = 0;
    
    public counter() { 
    
                                  
        spaces = 0;        // counter twn kenwn
        cookies = 0;       // counter twn cookies
        boosters = 0;      // counter twn boosters
        ghosts = 0;       // counter twn fantasmatwn
        walls = 0;
        for (int i = 0; i < linesOfLevel ; i++){
            for (int j = 0; j < colomnsOfLevel ; j++)  {
                switch(aL[i][j]){
                case space:  spaces++; break; 
                case food: cookies++; break;
                case booster: boosters++; break;
                case ghost1: ghosts++; break;
                case wall: walls++; break;
                }
            }
       }
       
       cookiesRemaining = cookies;  
       boostersRemaining = boosters;  
       LevelCookies = cookies ;
       
       System.out.println("cookies : " + cookies);
       
    }     
    
    counter(int x){}
    
}
