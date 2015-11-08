package pacman;

import java.util.Random;
import java.awt.*;
               
class Ghost_Movement_2 extends arrayCreator {

public static int g2x , g2y ;                            // oi sudetagmenes tou ghost2 
public static int g2_init_x , g2_init_y  ;    // oi sudetagmenes oi arxikes tou ghost stis opoies gurnaei otan fagw8ei
public static int ghostMv2 ,ghostMv3;   // oi tuxaioi ari8moi gia to pou 8a paei to ghost meta apo staurodromi 
public static boolean ghost2_dot , ghost2_boost ; // metablhtes pou deixnun an ena fadasma einai panw apo ena cookie h booster    
public static boolean moved_down , moved_up , moved_left , moved_right ;  // metablhtes pou dhlwnoun pros ta pou kinh8hke to ghost
public static int exec_once = 0 ; // h metablhth enos eidous dirty programming - epekshghseis allh fora (apla gia na ektelestei mono mia fora mia parakatw sun8hkh

public static int tmp_g2x , tmp_g2y ;
 

void MoveGhost ( String s ) {               // BASIKH ME8ODOS METAKINHSHS TOU GHOST 
  if ( s == "left" ) {
      if (aL[g2y][g2x-1] == '.') { ghost2_dot = true ; } else if (aL[g2y][g2x-1] == 'O') { ghost2_boost = true ; }
      if (aL[g2y][g2x-1] == 'P' ) {  Movement.moving(east , ghost2); }
      aL[g2y][g2x-1] = 'G' ;
      moved_left = true ;
    }
  else if ( s == "right" ) {
      if (aL[g2y][g2x+1] == '.') { ghost2_dot = true ; } else if (aL[g2y][g2x+1] == 'O') { ghost2_boost = true ; }   
      if (aL[g2y][g2x+1] == 'P')  {  Movement.moving(west , ghost2); }
      aL[g2y][g2x+1]= 'G' ;
      moved_right = true ;
    }
  else if ( s == "down" ) {
     if (aL[g2y+1][g2x] == '.') { ghost2_dot = true ; } else if (aL[g2y+1][g2x] == 'O') { ghost2_boost = true ; }  
     if (aL[g2y+1][g2x] == 'P')  {  Movement.moving(north , ghost2); }
     aL[g2y+1][g2x] = 'G' ;
     moved_down = true ;   
    }
  else if ( s == "up" ) {
      if (aL[g2y-1][g2x] == '.') { ghost2_dot = true ; }  else if (aL[g2y-1][g2x] == 'O') { ghost2_boost = true ; }  
      if (aL[g2y-1][g2x] == 'P')  {  Movement.moving(south , ghost2); }
      aL[g2y-1][g2x] = 'G' ;
      moved_up = true ;
    }
    
} 

      
 
  
      
public Ghost_Movement_2()
    {
        
        
      /******************************GHOST 2**********************************************/

      
        exec_once ++ ;
        

        Random generator_g = new Random(); 
       
        ghostMv2  = generator_g.nextInt(2) ;
        ghostMv3  = generator_g.nextInt(3) ; 
        tmp_g2x = g2x ; tmp_g2y = g2y ;
        
        
       // System.out.println( "G2X " + g2x + " G2Y " +g2y ) ;
        
        
        
                                   // epanafora tou cookie otan to fadasma fugei apo th 8esh pou htan
        if ( ghost2_dot == true && aL[g2y][g2x] == 'F' ) { Ghost_Movement_1.ghost1_dot = true ; }  
        if ( ghost2_dot == true && aL[g2y][g2x] == 'H' ) { Ghost_Movement_3.ghost3_dot = true ; }
        if ( ghost2_dot == true && aL[g2y][g2x] == 'J' ) { Ghost_Movement_4.ghost4_dot = true ; }
        
        
                                  // epanafora tou booster otan to fadasma fugei apo th 8esh pou htan
        if ( ghost2_boost == true && aL[g2y][g2x] == 'F' ) { Ghost_Movement_1.ghost1_boost = true ; }  
        if ( ghost2_boost == true && aL[g2y][g2x] == 'H' ) { Ghost_Movement_3.ghost3_boost = true ; }
        if ( ghost2_boost == true && aL[g2y][g2x] == 'J' ) { Ghost_Movement_4.ghost4_boost = true ; }
        
        if ( !Movement.g2_eat ) arrayCreator.aL[g2y][g2x]=' ' ; 
        if ( ghost2_dot == true ) {  aL[g2y][g2x] = '.' ; }  
        if ( ghost2_boost == true ) {  aL[g2y][g2x] = 'O' ; } 
        
        ghost2_boost  = false ;
        ghost2_dot = false ;
   
   
        
   
   if ( !Movement.g2_eat && exec_once >2 ) {     
        
      /******************************* PERIPTWSH POU KINOUTAN PROS TA KATW***********************************************************************************/  
    if ( moved_down == true )  {
          
                // elegxos tou deksia tetragwnou                    // elegxos tou aristera tetragwnou                  // elegxos tou apo katw tetragwnou
      if ( g2y == linesOfLevel -1 ) {
          aL[0][g2x] = 'G' ; 
          g2y = 0 ;
          moved_down = true ;
     }          
                
      else if ( (aL[g2y][g2x+1]==' ' || aL[g2y][g2x+1]=='.' || aL[g2y][g2x+1]=='O' || aL[g2y][g2x+1]=='P' || aL[g2y][g2x+1]=='F' || aL[g2y][g2x+1]=='H' || aL[g2y][g2x+1]=='J' || aL[g2y][g2x+1]=='f') && ( aL[g2y][g2x-1]==' ' || aL[g2y][g2x-1]=='.' || aL[g2y][g2x-1]=='O' || aL[g2y][g2x+1]=='P' || aL[g2y][g2x+1]=='F' || aL[g2y][g2x+1]=='H'|| aL[g2y][g2x+1]=='J' || aL[g2y][g2x+1]=='f' ) && (aL[g2y+1][g2x]=='#') ) {                   
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py && Movement.px == g2y ) {
               if ( !Movement.boosterActive ) {  MoveGhost("left") ; moved_down= false ; } else  { MoveGhost("right") ; moved_down= false ; }  
            } 
            else if ( Movement.py-g2x <= 4 && Movement.py >= g2x && Movement.px == g2y  ){  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; } 
            } 
            else if ( g2y-Movement.px <= 3 && g2y >= Movement.px  && Movement.py == g2x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ;  }   else { MoveGhost("right") ; moved_down= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ;
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("right") ; moved_down= false ;
            } 
      }   
       
      else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1]=='O' || aL[g2y][g2x+1]=='P' || aL[g2y][g2x+1]=='F' || aL[g2y][g2x+1]=='H'|| aL[g2y][g2x+1]=='J' || aL[g2y][g2x+1]=='f') && (aL[g2y][g2x-1] == '#' ) && (aL[g2y+1][g2x] == '#') ) {                   
            if ( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else { MoveGhost("right") ;  moved_down= false ;} 
              }
            else {  
               MoveGhost("right") ; moved_down= false ;
              }  
      } 
         
      else if ( (aL[g2y][g2x+1] == '#' )&&( aL[g2y][g2x-1] ==' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1]=='O' || aL[g2y][g2x-1]=='P' || aL[g2y][g2x-1]=='F'|| aL[g2y][g2x-1]=='H'|| aL[g2y][g2x-1]=='J' || aL[g2y][g2x-1]=='f') && (aL[g2y+1][g2x] == '#') ) {                   
             if ( g2y - Movement.px <= 4 &&  g2y >= Movement.px  && Movement.py == g2x ){
               if ( !Movement.boosterActive ) {  MoveGhost("up") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
             }
             else {
               MoveGhost("left") ; moved_down= false ;
             } 
      } 
         

      else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1]=='O'  || aL[g2y][g2x+1]=='P' || aL[g2y][g2x+1]=='F' || aL[g2y][g2x+1]=='H' || aL[g2y][g2x+1]=='J' || aL[g2y][g2x+1]=='f') && (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1]=='O' || aL[g2y][g2x-1]=='P' || aL[g2y][g2x-1]=='F'|| aL[g2y][g2x-1]=='H'|| aL[g2y][g2x-1]=='J' || aL[g2y][g2x-1]=='f') && (aL[g2y+1][g2x]==' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x]=='O' || aL[g2y+1][g2x]=='P' || aL[g2y+1][g2x]=='F'|| aL[g2y+1][g2x]=='H'|| aL[g2y+1][g2x]=='J' || aL[g2y+1][g2x]=='f') ) {                   
            if ( g2x -Movement.py <= 4 && g2x >= Movement.py && Movement.px == g2y ) {
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("right") ; moved_down= false ; }
            }
            else if ( Movement.py-g2x <= 4 && Movement.py >= g2x && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g2y <= 4 && Movement.px >= g2y && Movement.py == g2x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            }
            else if ( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) {MoveGhost("up") ; moved_down= false ; }  else { MoveGhost("down") ; moved_down= true ; } 
            }   
            else if ( ghostMv3 == 0 ) {
               MoveGhost("left") ; moved_down=false  ; 
            }
            else if ( ghostMv3 == 1) {  
               MoveGhost("right") ; moved_down= false ;
            } 
            else if ( ghostMv3 == 2) {
              MoveGhost("down") ;  moved_down= true ;
            } 
      } 
        
        
      else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1]=='O' || aL[g2y][g2x+1]=='P' || aL[g2y][g2x+1]=='F'|| aL[g2y][g2x+1]=='H'|| aL[g2y][g2x+1]=='J' || aL[g2y][g2x+1]=='f') && (aL[g2y][g2x-1] == '#' ) && (aL[g2y+1] [g2x]== ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x]=='O' || aL[g2y+1][g2x]=='P' || aL[g2y+1][g2x]=='F'|| aL[g2y+1][g2x]=='H'|| aL[g2y+1][g2x]=='J' || aL[g2y+1][g2x]=='f') ) {                   
            if ( Movement.py-g2x <= 4 && Movement.py >= g2x && Movement.px == g2y ) {
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("right") ; moved_down= false ; }
            }  
            else if ( Movement.px-g2y <= 4 && Movement.px >=g2y  && Movement.py == g2x ){  
               if ( !Movement.boosterActive ) {MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            } 
            else if ( g2y - Movement.px <= 4 && g2y >= Movement.px && Movement.py == g2x ){
               if ( !Movement.boosterActive ) {MoveGhost("up") ; moved_down= false ; } else { MoveGhost("down") ;  moved_down= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("down") ; moved_down= true ;
            } 
      }  
         
      else if ( (aL[g2y][g2x+1] == '#') && (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1]=='O' || aL[g2y][g2x-1]=='P' || aL[g2y][g2x-1]=='F'|| aL[g2y][g2x-1]=='H' || aL[g2y][g2x-1]=='J' || aL[g2y][g2x-1]=='f') && (aL[g2y+1][g2x]== ' ' || aL[g2y+1][g2x]=='.' || aL[g2y+1][g2x]=='O' || aL[g2y+1][g2x]=='P' || aL[g2y+1][g2x]=='F'|| aL[g2y+1][g2x]=='H'|| aL[g2y+1][g2x]=='J' || aL[g2y+1][g2x]=='f') ) {                   
            if ( g2x - Movement.py <= 4  && g2x >= Movement.py   && Movement.px == g2y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ;   moved_down= true ;   }    else {MoveGhost("up") ; moved_down= false ; }
            } 
            else if (  g2y - Movement.px  <= 4  && g2y >= Movement.px  && Movement.py == g2x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else {MoveGhost("down") ; moved_down= true ;}
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost("down") ;  moved_down= true ;
            } 
      }  
         
      else if ( ( aL[g2y][g2x+1] == '#' ) && (aL[g2y][g2x-1] == '#' ) && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x]=='.' || aL[g2y+1][g2x]=='O' || aL[g2y+1][g2x]=='P' || aL[g2y+1][g2x]=='F'|| aL[g2y+1][g2x]=='H'|| aL[g2y+1][g2x]=='J' || aL[g2y+1][g2x]=='f') ){  
            if ( Movement.px - g2y  <= 4 && Movement.px >= g2y  && Movement.py == g2x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_down= true ; }    else {MoveGhost("up") ; moved_down= false ; }
            }    
            else if ( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ;  moved_down= false ; }  else {MoveGhost("down") ; moved_down= true ; }
            }
            else  {
              MoveGhost("down") ; moved_down= true ;  
            }   
      }    
         
  }   

      
   /******************************* PERIPTWSH POU KINOUTAN PROS TA PANW ********************************************************************************/ 
     else if ( moved_up == true )  {   
        
            // elegxos tou deksia tetragwnou                    // elegxos tou aristera tetragwnou                  // elegxos tou apo panw tetragwnou
     if ( g2y == 0 ) {
          aL[linesOfLevel-1][g2x] = 'G' ; 
          g2y = linesOfLevel-1 ;
          moved_up = true ;
          
     }    
            
     else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F' || aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y][g2x-1]==' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f' ) && (aL[g2y-1] [g2x]== '#') ) {                   
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) { 
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }
            else if (  Movement.py - g2x  <= 4 && Movement.py >= g2x && Movement.px == g2y ) { 
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }
            else if ( Movement.px-g2y <= 4  && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ;  } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }    
            else if ( ghostMv2 == 1 ){  
              MoveGhost("right") ; moved_up= false ; 
            } 
     }   
       
     else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f' ) && (aL[g2y][g2x-1] == '#' ) && (aL[g2y-1][g2x] == '#') ) {                   
          if ( Movement.px-g2y <= 4 && Movement.px >= g2y && Movement.py == g2x ){  
             if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("right") ;  moved_up= false ; } 
          }    
          else {    
             MoveGhost("right") ; moved_up= false ;
         } 
     }
         
     else if ( (aL[g2y][g2x+1] == '#' ) && (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y-1][g2x] == '#') ) {                   
           if ( Movement.px-g2y <= 4 && Movement.px >= g2y && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ;  moved_up= false ; } 
          }    
          else {    
            MoveGhost("left") ; moved_up= false ;
          }  
     } 

         
     else if ( ( aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' | aL[g2y][g2x-1] == 'F'| aL[g2y][g2x-1] == 'H' || aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') ) {                   
            if ( g2x - Movement.py  <= 4 && g2x >= Movement.py  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if ( Movement.py- g2x <= 4 &&  Movement.py >= g2x  && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }  
            else if ( g2x - Movement.px  <= 4 && g2x >= Movement.px   && Movement.py == g2x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_up= true ; } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-4 <= g2y && Movement.px >= g2y && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ;   moved_up= true ;  }
            }  
            else if ( ghostMv3 == 0 ) {
               MoveGhost("left") ; moved_up= false ;
            }   
            else if ( ghostMv3 == 1) {  
              MoveGhost("right") ; moved_up= false ;
            }  
            else if ( ghostMv3 == 2){
              MoveGhost("up") ; moved_up= true ;
            } 
     }
        
    else if ( (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F' || aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y][g2x-1] == '#' ) && (aL[g2y-1] [g2x]== ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') )  {                   
            if (  Movement.py- g2x <= 4 && Movement.py >= g2x && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if (  g2y - Movement.px <= 4 &&  g2y >= Movement.px  && Movement.py == g2x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true;    } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ;  moved_up=true ;   }
            }  
            else if ( ghostMv2 == 0 ) {
              MoveGhost("right") ; moved_up= false ;
            }  
            else if ( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_up= true;
            }  
     } 
         
     else if ( (aL[g2y][g2x+1] == '#' ) && (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F' || aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y-1][g2x]== ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J'  || aL[g2y-1][g2x] == 'f') ) {                   
            if ( g2y - Movement.py <= 4 && g2y >= Movement.py  && Movement.px == g2y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("up") ; moved_up= true ; }
            }   
            else if ( g2y - Movement.px <= 4 && g2y >= Movement.px && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px- g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost ("up") ; moved_up = true ; 
            } 
     }  
         
     else if ( (aL[g2y][g2x+1] == '#' ) && (aL[g2y][g2x-1] == '#') && (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H' || aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') ) {  
         if ( g2y - Movement.px  <= 4 && g2y >= Movement.px  && Movement.py == g2x ){
           if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
         }  
         else if ( Movement.px- g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
            if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
         }   
         else {     
            MoveGhost("up") ; moved_up = true ; 
         }  
     }  
         
         
     
        
 }   
        
        
      
      /******************************* PERIPTWSH POU KINOUTAN PROS TA DEKSIA ********************************************************************************/ 
     else if ( moved_right == true )  {   
        
        if ( g2x == colomnsOfLevel -1 ) { 
             aL[g2y][0] = 'G' ;
             moved_right = true ; 
             g2x = 0 ;
            }  
        
        
            // elegxos tou panw tetragwnou                    // elegxos tou deksia tetragwnou                  // elegxos tou apo katw tetragwnou
       else if ( (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F' || aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f' ) && (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f'   ) && (aL[g2y+1][g2x]== '#') ) {                   
            if ( Movement.py- g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x  ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g2x - Movement.py <= 4 && g2x >= Movement.py && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_right= true ; 
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_right= false ; 
            }  
       }     
       
       else if ( (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') && (aL[g2y][g2x+1] == '#') && (aL[g2y+1][g2x] == '#') ) {                   
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; } 
            }  
            else {  
              MoveGhost("up") ; moved_right= false ; 
            } 
       } 
         
       else if ( (aL[g2y-1][g2x] == '#' ) && (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y+1][g2x] == '#') ) {                   
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py   && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else {  
              MoveGhost("right") ; moved_right= true ; 
            }  
       } 
         
       
       else if ( (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') && (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f') ) {                   
            if ( g2y - Movement.px <= 4 &&  g2y >= Movement.px && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }
            else if ( Movement.py-g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y ) {  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if ( Movement.px- g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }   
            else if ( g2x - Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) {  
               MoveGhost("left") ; moved_right= false ; 
            }   
            else if ( ghostMv3 == 0 ) {
               MoveGhost("up") ; moved_right= false ;
            }   
            else if ( ghostMv3 == 1) {  
               MoveGhost("right") ; moved_right= true ;
            }  
            else if ( ghostMv3 == 2) {
               MoveGhost("down") ; moved_right= false ;
            } 
       }
        
       else if ( ( aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') && (aL[g2y][g2x+1] == '#') && (aL[g2y+1][g2x]== ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f' ) ) {                   
            if ( g2y - Movement.px <= 4  && g2y >= Movement.px  && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }   
            else if( Movement.px-g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }  
            else if ( g2x-Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("up") ; moved_right= false ;
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            }  
       }  
         
       else if ( (aL[g2y-1][g2x] == '#' ) && (aL[g2y][g2x+1] == ' ' || aL[g2y][g2x+1] == '.' || aL[g2y][g2x+1] == 'O' || aL[g2y][g2x+1] == 'P' || aL[g2y][g2x+1] == 'F'|| aL[g2y][g2x+1] == 'H'|| aL[g2y][g2x+1] == 'J' || aL[g2y][g2x+1] == 'f') && (aL[g2y+1][g2x]== ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f') ) {                   
            if ( Movement.py-g2x <= 4  && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( Movement.px-g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g2x - Movement.py <= 4 && g2x >= Movement.py && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost ("right" ) ; moved_right = true ; 
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            } 
       }  
         
       else if ( (aL[g2y-1][g2x] == '#' ) && (aL[g2y][g2x+1] == '#') && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f') ) {  
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else {
              MoveGhost("down") ; moved_right= false ;
            } 
       }
       
       else if ( g2x == g2_init_x && g2y == g2_init_y ) { 
             aL[g2y][g2x+1] = 'G' ;
             moved_right = true ; 
       } 
            
         
   }   

      /******************************* PERIPTWSH POU KINOUTAN PROS TA ARISTERA ********************************************************************************/ 
    else if ( moved_left == true )  {   
        
            // elegxos tou aristera tetragwnou                    // elegxos tou katw tetragwnou                  // elegxos tou apo panw tetragwnou
       if ( g2x == 0) { 
          aL[g2y][colomnsOfLevel-1] = 'G' ; 
          moved_left = true ;
          g2x = colomnsOfLevel-1 ;
       }    
        
        
       else if ( (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f') && (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F' || aL[g2y-1][g2x] == 'H' || aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') ) {                   
            if ( Movement.px-g2y <= 4  && Movement.px >= g2y  && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if ( g2x - Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }  
            else if ( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x ) {
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }  
            else if ( Movement.py - g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( ghostMv3 == 0 ) {
               MoveGhost("down") ; moved_left= false ;
            }   
            else if ( ghostMv3 == 1) {  
               MoveGhost("left") ; moved_left= true ; 
            }   
            else if ( ghostMv3 == 2) {
              MoveGhost("up") ; moved_left= false ; 
            }  
       }
        
       else if ( (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y+1][g2x] == '#') && (aL[g2y-1] [g2x]== ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y][g2x-1] == 'f')) {                   
            if ( g2x - Movement.py <=4  && g2x >= Movement.py  && Movement.px == g2y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( g2y - Movement.px <= 4 && g2y >= Movement.px && Movement.py == g2x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( Movement.py - g2x <= 4 && Movement.py >= g2x && Movement.px == g2y  ) {
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }   
            else if( ghostMv2 == 1 ) {  
              MoveGhost("up") ; moved_left= false ; 
            }  
       }  
         
       else if ( (aL[g2y][g2x-1] == '#') && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f' ) && (aL[g2y-1] [g2x]== ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') ) {                   
            if ( Movement.px-g2y <= 4 && Movement.px >= g2y  && Movement.py == g2x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if( g2y - Movement.px <= 4 && g2y >= Movement.px  && Movement.py == g2x ) {  
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else if ( Movement.py-g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }  
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("down") ; moved_left= false ;
            }   
            else if( ghostMv2 == 1 ) {  
               MoveGhost("up") ; moved_left= false ; 
            }   
       }  
         
       else if ( (aL[g2y][g2x-1] == '#') && (aL[g2y+1][g2x] == '#') && (aL[g2y-1][g2x] == ' ' || aL[g2y-1][g2x] == '.' || aL[g2y-1][g2x] == 'O' || aL[g2y-1][g2x] == 'P' || aL[g2y-1][g2x] == 'F'|| aL[g2y-1][g2x] == 'H'|| aL[g2y-1][g2x] == 'J' || aL[g2y-1][g2x] == 'f') ) {  
            if ( Movement.py-g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }  
            }   
            else {   
              MoveGhost("up") ; moved_left= false ; 
            }  
       }    
         
       else if ( (aL[g2y][g2x-1] == '#' ) && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f' ) && (aL[g2y-1][g2x] == '#') ) {  
            if ( Movement.py-g2x <= 4 && Movement.py >= g2x && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else {   
               MoveGhost("down") ; moved_left= false ;
            }  
       }  
         
       else if ( (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y+1][g2x] == '#' ) && (aL[g2y-1][g2x] == '#') ) {  
            if ( Movement.py-g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }   
            else {    
              MoveGhost("left") ; moved_left= true ;
            }  
       }   
        
       else if ( (aL[g2y][g2x-1] == ' ' || aL[g2y][g2x-1] == '.' || aL[g2y][g2x-1] == 'O' || aL[g2y][g2x-1] == 'P' || aL[g2y][g2x-1] == 'F'|| aL[g2y][g2x-1] == 'H'|| aL[g2y][g2x-1] == 'J' || aL[g2y][g2x-1] == 'f') && (aL[g2y+1][g2x] == ' ' || aL[g2y+1][g2x] == '.' || aL[g2y+1][g2x] == 'O' || aL[g2y+1][g2x] == 'P' || aL[g2y+1][g2x] == 'F'|| aL[g2y+1][g2x] == 'H'|| aL[g2y+1][g2x] == 'J' || aL[g2y+1][g2x] == 'f') && (aL[g2y-1][g2x]== '#') ) {                   
            if ( g2x - Movement.py <= 4 && g2x >= Movement.py  && Movement.px == g2y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( Movement.px - g2y  <= 4 && Movement.px >= g2y   && Movement.py == g2x  ){  
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; } 
            }  
            else if ( Movement.py- g2x <= 4 && Movement.py >= g2x  && Movement.px == g2y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_left= false ;
            } 
       }  
       
       else if ( g2x == g2_init_x && g2y == g2_init_y ) { 
             aL[g2y][g2x-1] = 'G' ;
             moved_left = true ;
       } 
       
       
         
         
      }     
     
    }  // telos if ( !g2_eat) 
    
        if (exec_once == 2) { aL[g2y][g2x]=' ' ; g2y = g2y -2 ; aL[g2y][g2x]='G' ; moved_left = true ;}
        else if (!Movement.g2_eat && exec_once >2 ){
          if      (moved_up==true)     { g2y = g2y -1 ; } 
          else if (moved_down==true)   { g2y = g2y +1 ; }
          else if (moved_right==true && aL[g2y][0] != 'G'  )     { g2x = g2x + 1; }          // xreiazodai kai oi elegxoi gia tis periptwseis pou pernaei sthn adipera meria
          else if (moved_left==true  && aL[g2y][colomnsOfLevel-1] != 'G'  ) { g2x = g2x -1 ; } 
        }
        else if (Movement.g2_eat == true && exec_once > 2) { 
            g2y = Ghost_Movement_1.g1_init_y; 
            g2x = Ghost_Movement_1.g1_init_x  ;   
            moved_left = true ; Ghost_Movement_1.NullSetOthers() ;
        }
        
        
         Point currentPosition = new Point();
         currentPosition.x = g2x;
         currentPosition.y = g2y;
         
         Ghost_Animation ghost_anim = new Ghost_Animation(currentPosition, countSpeed(), 2, moved_up, moved_down, moved_left , moved_right);
     
       
       

    
    
    
    }     


    public static int countSpeed(){
        int cookiesEaten = counter.cookies - counter.cookiesRemaining;
        int countedSpeed;
        if(cookiesEaten > 0.6 * counter.cookies) {      // exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = fastSpeed2_BoosterActive;
            else countedSpeed = fastSpeed2;
        }
        else {                                          // den exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = slowSpeed2_BoosterActive;
            else countedSpeed = slowSpeed2;
        }
        return countedSpeed;
    }




}