package pacman;

import java.util.Random;
import java.awt.*;
               
class Ghost_Movement_3 extends arrayCreator {// implements Runnable  {  // kanw extend thn arrayCreator gia na glitwsume ligo xwro otan kalume thn arrayLevel 


public static int g3x , g3y ;                            // oi sudetagmenes tou ghost1 
public static int g3_init_x , g3_init_y  ;    // oi sudetagmenes oi arxikes tou ghost stis opoies gurnaei otan fagw8ei
public static int ghostMv2 ,ghostMv3;   // oi tuxaioi ari8moi gia to pou 8a paei to ghost meta apo staurodromi 
public static boolean ghost3_dot , ghost3_boost ; // metablhtes pou deixnun an ena fadasma einai panw apo ena cookie h booster    
public static boolean moved_down , moved_up , moved_left , moved_right ;  // metablhtes pou dhlwnoun pros ta pou kinh8hke to ghost
public static int exec_once = 0 ; // h metablhth enos eidous dirty programming - epekshghseis allh fora (apla gia na ektelestei mono mia fora mia parakatw sun8hkh

public static int tmp_g3x , tmp_g3y ;
 

void MoveGhost ( String s ) {               // BASIKH ME8ODOS METAKINHSHS TOU GHOST 
  if ( s == "left" ) {
      if (aL[g3y][g3x-1] == '.') { ghost3_dot = true ; } else if (aL[g3y][g3x-1] == 'O') { ghost3_boost = true ; }   
      if (aL[g3y][g3x-1] == 'P') {  Movement.moving(east , ghost3); }
      aL[g3y][g3x-1] = 'H' ;
      moved_left = true ;
    }
  else if ( s == "right" ) {
      if (aL[g3y][g3x+1] == '.') { ghost3_dot = true ; } else if (aL[g3y][g3x+1] == 'O') { ghost3_boost = true ; }   
      if (aL[g3y][g3x+1] == 'P') {  Movement.moving(west , ghost3); }
      aL[g3y][g3x+1]= 'H' ;
      moved_right = true ;
    }
  else if ( s == "down" ) {
     if (aL[g3y+1][g3x] == '.') { ghost3_dot = true ; } else if (aL[g3y+1][g3x] == 'O') { ghost3_boost = true ; }   
     if (aL[g3y+1][g3x] == 'P') {  Movement.moving(north , ghost3); }
     aL[g3y+1][g3x] = 'H' ;
     moved_down = true ;   
    }
  else if ( s == "up" ) {
      if (aL[g3y-1][g3x] == '.') { ghost3_dot = true ; }  else if (aL[g3y-1][g3x] == 'O') { ghost3_boost = true ; }  
      if (aL[g3y-1][g3x] == 'P') {  Movement.moving(south , ghost3); }
      aL[g3y-1][g3x] = 'H' ;
      moved_up = true ;
    }
    
} 

      
 
  
      
public Ghost_Movement_3()
    {
        //Thread ghost_thread = null;          // to thread dhmiourgei apisteuto bottleneck opote to ebgala - den xreiazetai outws h allws 
        //ghost_thread = new Thread(this);     // kai twra h taxuthta tou programmatos einai dramatika aukshmenh 
        //ghost_thread.start();        
    //} 
   
    
  //public void run() { 
        
        
      /******************************GHOST 3**********************************************/

      
        exec_once ++ ;

        // H logikh kinhshs tou ghost einai to "scanarisma" ka8e fora twn 3 tetragwnwn gurw tou (to ena einai auto apo to opoio erxotan opote den upologizetai 
        // giati polu apla upo kanonikes sun8hkes den gurnaei pros ta pisw) An apo auta ta 3 tetragwna to ena einai anoixto (dhladh oxi toixos) tote paei pros ta kei
        // an apo ta 3 tetragwna ta 2 einai anoixta tote upologizetai me random ari8mo pou 8a paei . to idio kai me 3 tetragwna anoixta
        

        Random generator_g = new Random(); 
       
        ghostMv2  = generator_g.nextInt(2) ;
        ghostMv3  = generator_g.nextInt(3) ; 
        tmp_g3x = g3x ; tmp_g3y = g3y ;
        
        
        //System.out.println( "G3X " + g3x + " G3Y " +g3y ) ;
        
        
        
           // epanafora tou cookie otan to fadasma fugei apo th 8esh pou htan
        if ( ghost3_dot == true && aL[g3y][g3x] == 'F' ) { Ghost_Movement_1.ghost1_dot = true ; }  
        if ( ghost3_dot == true && aL[g3y][g3x] == 'G' ) { Ghost_Movement_2.ghost2_dot = true ; }
        if ( ghost3_dot == true && aL[g3y][g3x] == 'J' ) { Ghost_Movement_4.ghost4_dot = true ; }
        
        
           // epanafora tou booster otan to fadasma fugei apo th 8esh pou htan
        if ( ghost3_boost == true && aL[g3y][g3x] == 'F' ) { Ghost_Movement_1.ghost1_boost = true ; }  
        if ( ghost3_boost == true && aL[g3y][g3x] == 'G' ) { Ghost_Movement_2.ghost2_boost = true ; }
        if ( ghost3_boost == true && aL[g3y][g3x] == 'J' ) { Ghost_Movement_4.ghost4_boost = true ; }
        
        if ( !Movement.g3_eat ) arrayCreator.aL[g3y][g3x]=' ' ; 
        if ( ghost3_dot == true ) {  aL[g3y][g3x] = '.' ; } 
        if ( ghost3_boost == true ) {  aL[g3y][g3x] = 'O' ; } 
        
        ghost3_dot   = false ;
        ghost3_boost = false ;
   
    if ( !Movement.g3_eat && exec_once >4 ) {     
       
        
      /******************************* PERIPTWSH POU KINOUTAN PROS TA KATW***********************************************************************************/  
    if ( moved_down == true )  {
          
                // elegxos tou deksia tetragwnou                    // elegxos tou aristera tetragwnou                  // elegxos tou apo katw tetragwnou
      if ( g3y == linesOfLevel -1 ) {
          aL[0][g3x] = 'H' ; 
          moved_down = true ;
          g3y = 0 ;
     }          
                
      else if ( (aL[g3y][g3x+1]==' ' || aL[g3y][g3x+1]=='.' || aL[g3y][g3x+1]=='O' || aL[g3y][g3x+1]=='P' || aL[g3y][g3x+1]=='G' || aL[g3y][g3x+1]=='F' || aL[g3y][g3x+1]=='J' || aL[g3y][g3x+1]=='f') && ( aL[g3y][g3x-1]==' ' || aL[g3y][g3x-1]=='.' || aL[g3y][g3x-1]=='O' || aL[g3y][g3x+1]=='P' || aL[g3y][g3x+1]=='G' || aL[g3y][g3x+1]=='F'|| aL[g3y][g3x+1]=='J' || aL[g3y][g3x+1]=='f' ) && (aL[g3y+1][g3x]=='#') ) {                   
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py && Movement.px == g3y ) {
               if ( !Movement.boosterActive ) {  MoveGhost("left") ; moved_down= false ; } else  { MoveGhost("right") ; moved_down= false ; }  
            } 
            else if ( Movement.py-g3x <= 4 && Movement.py >= g3x && Movement.px == g3y  ){  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; } 
            } 
            else if ( g3y-Movement.px <= 3 && g3y >= Movement.px  && Movement.py == g3x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ;  }   else { MoveGhost("right") ; moved_down= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ;
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("right") ; moved_down= false ;
            } 
      }   
       
      else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1]=='O' || aL[g3y][g3x+1]=='P' || aL[g3y][g3x+1]=='G' || aL[g3y][g3x+1]=='F'|| aL[g3y][g3x+1]=='J' || aL[g3y][g3x+1]=='f') && (aL[g3y][g3x-1] == '#' ) && (aL[g3y+1][g3x] == '#') ) {                   
            if ( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else { MoveGhost("right") ;  moved_down= false ;} 
              }
            else {  
               MoveGhost("right") ; moved_down= false ;
              }  
      } 
         
      else if ( (aL[g3y][g3x+1] == '#' )&&( aL[g3y][g3x-1] ==' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1]=='O' || aL[g3y][g3x-1]=='P' || aL[g3y][g3x-1]=='G'|| aL[g3y][g3x-1]=='F'|| aL[g3y][g3x-1]=='J' || aL[g3y][g3x-1]=='f') && (aL[g3y+1][g3x] == '#') ) {                   
             if ( g3y - Movement.px <= 4 &&  g3y >= Movement.px  && Movement.py == g3x ){
               if ( !Movement.boosterActive ) {  MoveGhost("up") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
             }
             else {
               MoveGhost("left") ; moved_down= false ;
             } 
      } 
         

      else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1]=='O'  || aL[g3y][g3x+1]=='P' || aL[g3y][g3x+1]=='G' || aL[g3y][g3x+1]=='F' || aL[g3y][g3x+1]=='J' || aL[g3y][g3x+1]=='f') && (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1]=='O' || aL[g3y][g3x-1]=='P' || aL[g3y][g3x-1]=='G'|| aL[g3y][g3x-1]=='F'|| aL[g3y][g3x-1]=='J' || aL[g3y][g3x-1]=='f') && (aL[g3y+1][g3x]==' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x]=='O' || aL[g3y+1][g3x]=='P' || aL[g3y+1][g3x]=='G'|| aL[g3y+1][g3x]=='F'|| aL[g3y+1][g3x]=='J' || aL[g3y+1][g3x]=='f') ) {                   
            if ( g3x -Movement.py <= 4 && g3x >= Movement.py && Movement.px == g3y ) {
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("right") ; moved_down= false ; }
            }
            else if ( Movement.py-g3x <= 4 && Movement.py >= g3x && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g3y <= 4 && Movement.px >= g3y && Movement.py == g3x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            }
            else if ( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x ) {
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
        
        
      else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1]=='O' || aL[g3y][g3x+1]=='P' || aL[g3y][g3x+1]=='G'|| aL[g3y][g3x+1]=='F'|| aL[g3y][g3x+1]=='J' || aL[g3y][g3x+1]=='f') && (aL[g3y][g3x-1] == '#' ) && (aL[g3y+1] [g3x]== ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x]=='O' || aL[g3y+1][g3x]=='P' || aL[g3y+1][g3x]=='G'|| aL[g3y+1][g3x]=='F'|| aL[g3y+1][g3x]=='J' || aL[g3y+1][g3x]=='f') ) {                   
            if ( Movement.py-g3x <= 4 && Movement.py >= g3x && Movement.px == g3y ) {
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("right") ; moved_down= false ; }
            }  
            else if ( Movement.px-g3y <= 4 && Movement.px >=g3y  && Movement.py == g3x ){  
               if ( !Movement.boosterActive ) {MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            } 
            else if ( g3y - Movement.px <= 4 && g3y >= Movement.px && Movement.py == g3x ){
               if ( !Movement.boosterActive ) {MoveGhost("up") ; moved_down= false ; } else { MoveGhost("down") ;  moved_down= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("down") ; moved_down= true ;
            } 
      }  
         
      else if ( (aL[g3y][g3x+1] == '#') && (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1]=='O' || aL[g3y][g3x-1]=='P' || aL[g3y][g3x-1]=='G'|| aL[g3y][g3x-1]=='F' || aL[g3y][g3x-1]=='J' || aL[g3y][g3x-1]=='f') && (aL[g3y+1][g3x]== ' ' || aL[g3y+1][g3x]=='.' || aL[g3y+1][g3x]=='O' || aL[g3y+1][g3x]=='P' || aL[g3y+1][g3x]=='G'|| aL[g3y+1][g3x]=='F'|| aL[g3y+1][g3x]=='J' || aL[g3y+1][g3x]=='f') ) {                   
            if ( g3x - Movement.py <= 4  && g3x >= Movement.py   && Movement.px == g3y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ;   moved_down= true ;   }    else {MoveGhost("up") ; moved_down= false ; }
            } 
            else if (  g3y - Movement.px  <= 4  && g3y >= Movement.px  && Movement.py == g3x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else {MoveGhost("down") ; moved_down= true ;}
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost("down") ;  moved_down= true ;
            } 
      }  
         
      else if ( ( aL[g3y][g3x+1] == '#' ) && (aL[g3y][g3x-1] == '#' ) && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x]=='.' || aL[g3y+1][g3x]=='O' || aL[g3y+1][g3x]=='P' || aL[g3y+1][g3x]=='G'|| aL[g3y+1][g3x]=='F'|| aL[g3y+1][g3x]=='J' || aL[g3y+1][g3x]=='f') ){  
            if ( Movement.px - g3y  <= 4 && Movement.px >= g3y  && Movement.py == g3x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_down= true ; }    else {MoveGhost("up") ; moved_down= false ; }
            }    
            else if ( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x ){
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
     if ( g3y == 0 ) {
          aL[linesOfLevel-1][g3x] = 'H' ; 
          moved_up = true ;
          g3y = linesOfLevel-1 ;
     }    
            
     else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G' || aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y][g3x-1]==' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f' ) && (aL[g3y-1] [g3x]== '#') ) {                   
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) { 
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }
            else if (  Movement.py - g3x  <= 4 && Movement.py >= g3x && Movement.px == g3y ) { 
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }
            else if ( Movement.px-g3y <= 4  && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ;  } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }    
            else if ( ghostMv2 == 1 ){  
              MoveGhost("right") ; moved_up= false ; 
            } 
     }   
       
     else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f' ) && (aL[g3y][g3x-1] == '#' ) && (aL[g3y-1][g3x] == '#') ) {                   
          if ( Movement.px-g3y <= 4 && Movement.px >= g3y && Movement.py == g3x ){  
             if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("right") ;  moved_up= false ; } 
          }    
          else {    
             MoveGhost("right") ; moved_up= false ;
         } 
     }
         
     else if ( (aL[g3y][g3x+1] == '#' ) && (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y-1][g3x] == '#') ) {                   
           if ( Movement.px-g3y <= 4 && Movement.px >= g3y && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ;  moved_up= false ; } 
          }    
          else {    
            MoveGhost("left") ; moved_up= false ;
          }  
     } 

         
     else if ( ( aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' | aL[g3y][g3x-1] == 'G'| aL[g3y][g3x-1] == 'F' || aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') ) {                   
            if ( g3x - Movement.py  <= 4 && g3x >= Movement.py  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if ( Movement.py- g3x <= 4 &&  Movement.py >= g3x  && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }  
            else if ( g3x - Movement.px  <= 4 && g3x >= Movement.px   && Movement.py == g3x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_up= true ; } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-4 <= g3y && Movement.px >= g3y && Movement.py == g3x ){  
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
        
    else if ( (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G' || aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y][g3x-1] == '#' ) && (aL[g3y-1] [g3x]== ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') )  {                   
            if (  Movement.py- g3x <= 4 && Movement.py >= g3x && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if (  g3y - Movement.px <= 4 &&  g3y >= Movement.px  && Movement.py == g3x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true;    } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ;  moved_up=true ;   }
            }  
            else if ( ghostMv2 == 0 ) {
              MoveGhost("right") ; moved_up= false ;
            }  
            else if ( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_up= true;
            }  
     } 
         
     else if ( (aL[g3y][g3x+1] == '#' ) && (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G' || aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y-1][g3x]== ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J'  || aL[g3y-1][g3x] == 'f') ) {                   
            if ( g3y - Movement.py <= 4 && g3y >= Movement.py  && Movement.px == g3y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("up") ; moved_up= true ; }
            }   
            else if ( g3y - Movement.px <= 4 && g3y >= Movement.px && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px- g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost ("up") ; moved_up = true ; 
            } 
     }  
         
     else if ( (aL[g3y][g3x+1] == '#' ) && (aL[g3y][g3x-1] == '#') && (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F' || aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') ) {  
         if ( g3y - Movement.px  <= 4 && g3y >= Movement.px  && Movement.py == g3x ){
           if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
         }  
         else if ( Movement.px- g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
            if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
         }   
         else {     
            MoveGhost("up") ; moved_up = true ; 
         }  
     }  
         
         
     
        
 }   
        
        
      
      /******************************* PERIPTWSH POU KINOUTAN PROS TA DEKSIA ********************************************************************************/ 
     else if ( moved_right == true )  {   
        
        if ( g3x == colomnsOfLevel -1 ) { 
             aL[g3y][0] = 'H' ;
             moved_right = true ; 
             g3x = 0 ;
            }  
        
        
            // elegxos tou panw tetragwnou                    // elegxos tou deksia tetragwnou                  // elegxos tou apo katw tetragwnou
       else if ( (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G' || aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f' ) && (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f'   ) && (aL[g3y+1][g3x]== '#') ) {                   
            if ( Movement.py- g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x  ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g3x - Movement.py <= 4 && g3x >= Movement.py && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_right= true ; 
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_right= false ; 
            }  
       }     
       
       else if ( (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') && (aL[g3y][g3x+1] == '#') && (aL[g3y+1][g3x] == '#') ) {                   
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; } 
            }  
            else {  
              MoveGhost("up") ; moved_right= false ; 
            } 
       } 
         
       else if ( (aL[g3y-1][g3x] == '#' ) && (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y+1][g3x] == '#') ) {                   
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py   && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else {  
              MoveGhost("right") ; moved_right= true ; 
            }  
       } 
         
       
       else if ( (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') && (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f') ) {                   
            if ( g3y - Movement.px <= 4 &&  g3y >= Movement.px && Movement.py == g3x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }
            else if ( Movement.py-g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y ) {  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if ( Movement.px- g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }   
            else if ( g3x - Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) {  
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
        
       else if ( ( aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') && (aL[g3y][g3x+1] == '#') && (aL[g3y+1][g3x]== ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f' ) ) {                   
            if ( g3y - Movement.px <= 4  && g3y >= Movement.px  && Movement.py == g3x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }   
            else if( Movement.px-g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }  
            else if ( g3x-Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("up") ; moved_right= false ;
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            }  
       }  
         
       else if ( (aL[g3y-1][g3x] == '#' ) && (aL[g3y][g3x+1] == ' ' || aL[g3y][g3x+1] == '.' || aL[g3y][g3x+1] == 'O' || aL[g3y][g3x+1] == 'P' || aL[g3y][g3x+1] == 'G'|| aL[g3y][g3x+1] == 'F'|| aL[g3y][g3x+1] == 'J' || aL[g3y][g3x+1] == 'f') && (aL[g3y+1][g3x]== ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f') ) {                   
            if ( Movement.py-g3x <= 4  && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( Movement.px-g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g3x - Movement.py <= 4 && g3x >= Movement.py && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost ("right" ) ; moved_right = true ; 
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            } 
       }  
         
       else if ( (aL[g3y-1][g3x] == '#' ) && (aL[g3y][g3x+1] == '#') && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f') ) {  
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else {
              MoveGhost("down") ; moved_right= false ;
            } 
       }
       
       else if ( g3x == g3_init_x && g3y == g3_init_y ) { 
             aL[g3y][g3x+1] = 'H' ;
             moved_right = true ; 
       } 
            
         
   }   

      /******************************* PERIPTWSH POU KINOUTAN PROS TA ARISTERA ********************************************************************************/ 
    else if ( moved_left == true )  {   
        
            // elegxos tou aristera tetragwnou                    // elegxos tou katw tetragwnou                  // elegxos tou apo panw tetragwnou
       if ( g3x == 0) { 
          aL[g3y][colomnsOfLevel-1] = 'H' ; 
          moved_left = true ;
          g3x = colomnsOfLevel-1 ;
       }    
        
        
       else if ( (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f') && (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G' || aL[g3y-1][g3x] == 'F' || aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') ) {                   
            if ( Movement.px-g3y <= 4  && Movement.px >= g3y  && Movement.py == g3x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if ( g3x - Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }  
            else if ( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x ) {
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }  
            else if ( Movement.py - g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
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
        
       else if ( (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y+1][g3x] == '#') && (aL[g3y-1] [g3x]== ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y][g3x-1] == 'f')) {                   
            if ( g3x - Movement.py <=4  && g3x >= Movement.py  && Movement.px == g3y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( g3y - Movement.px <= 4 && g3y >= Movement.px && Movement.py == g3x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( Movement.py - g3x <= 4 && Movement.py >= g3x && Movement.px == g3y  ) {
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }   
            else if( ghostMv2 == 1 ) {  
              MoveGhost("up") ; moved_left= false ; 
            }  
       }  
         
       else if ( (aL[g3y][g3x-1] == '#') && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f' ) && (aL[g3y-1] [g3x]== ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') ) {                   
            if ( Movement.px-g3y <= 4 && Movement.px >= g3y  && Movement.py == g3x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if( g3y - Movement.px <= 4 && g3y >= Movement.px  && Movement.py == g3x ) {  
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else if ( Movement.py-g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }  
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("down") ; moved_left= false ;
            }   
            else if( ghostMv2 == 1 ) {  
               MoveGhost("up") ; moved_left= false ; 
            }   
       }  
         
       else if ( (aL[g3y][g3x-1] == '#') && (aL[g3y+1][g3x] == '#') && (aL[g3y-1][g3x] == ' ' || aL[g3y-1][g3x] == '.' || aL[g3y-1][g3x] == 'O' || aL[g3y-1][g3x] == 'P' || aL[g3y-1][g3x] == 'G'|| aL[g3y-1][g3x] == 'F'|| aL[g3y-1][g3x] == 'J' || aL[g3y-1][g3x] == 'f') ) {  
            if ( Movement.py-g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }  
            }   
            else {   
              MoveGhost("up") ; moved_left= false ; 
            }  
       }    
         
       else if ( (aL[g3y][g3x-1] == '#' ) && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f' ) && (aL[g3y-1][g3x] == '#') ) {  
            if ( Movement.py-g3x <= 4 && Movement.py >= g3x && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else {   
               MoveGhost("down") ; moved_left= false ;
            }  
       }  
         
       else if ( (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y+1][g3x] == '#' ) && (aL[g3y-1][g3x] == '#') ) {  
            if ( Movement.py-g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }   
            else {    
              MoveGhost("left") ; moved_left= true ;
            }  
       }   
        
       else if ( (aL[g3y][g3x-1] == ' ' || aL[g3y][g3x-1] == '.' || aL[g3y][g3x-1] == 'O' || aL[g3y][g3x-1] == 'P' || aL[g3y][g3x-1] == 'G'|| aL[g3y][g3x-1] == 'F'|| aL[g3y][g3x-1] == 'J' || aL[g3y][g3x-1] == 'f') && (aL[g3y+1][g3x] == ' ' || aL[g3y+1][g3x] == '.' || aL[g3y+1][g3x] == 'O' || aL[g3y+1][g3x] == 'P' || aL[g3y+1][g3x] == 'G'|| aL[g3y+1][g3x] == 'F'|| aL[g3y+1][g3x] == 'J' || aL[g3y+1][g3x] == 'f') && (aL[g3y-1][g3x]== '#') ) {                   
            if ( g3x - Movement.py <= 4 && g3x >= Movement.py  && Movement.px == g3y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( Movement.px - g3y  <= 4 && Movement.px >= g3y   && Movement.py == g3x  ){  
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; } 
            }  
            else if ( Movement.py- g3x <= 4 && Movement.py >= g3x  && Movement.px == g3y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_left= false ;
            } 
       }  
       
       else if ( g3x == g3_init_x && g3y == g3_init_y ) { 
             aL[g3y][g3x-1] = 'H' ;
             moved_left = true ;
       } 
       
       
         
         
      }     
     
    }
  
    
    
        if (exec_once == 3)      { aL[g3y][g3x]=' ' ;  g3x=g3x+1 ; aL[g3y][g3x]='H' ;}
        else if ( exec_once == 4)  { aL[g3y][g3x]=' ' ;  g3y=g3y-2 ; aL[g3y][g3x]='F' ;moved_right= true ; }
        else if (!Movement.g3_eat && exec_once >4 ){
          if      (moved_up==true)     { g3y = g3y -1 ; } 
          else if (moved_down==true)   { g3y = g3y +1 ; }
          else if (moved_right==true && aL[g3y][0] != 'H'  )     { g3x = g3x + 1; }          // xreiazodai kai oi elegxoi gia tis periptwseis pou pernaei sthn adipera meria
          else if (moved_left==true  && aL[g3y][colomnsOfLevel-1] != 'H'  ) { g3x = g3x -1 ; } 
        }
        else if ( Movement.g3_eat == true && exec_once >4) { 
            g3y = Ghost_Movement_1.g1_init_y ;
            g3x = Ghost_Movement_1.g1_init_x  ;   
            moved_left = true ; Ghost_Movement_1.NullSetOthers() ;
        }
        
        
        
         
         Point currentPosition = new Point();
         currentPosition.x = g3x;
         currentPosition.y = g3y;
         
         Ghost_Animation ghost_anim = new Ghost_Animation(currentPosition, countSpeed(), 3, moved_up, moved_down, moved_left , moved_right);
     
       
       PacMan_Graphics.content.repaint();
       
     

    
    }     
    public static int countSpeed(){
        int cookiesEaten = counter.cookies - counter.cookiesRemaining;
        int countedSpeed;
        if(cookiesEaten > 0.6 * counter.cookies) {      // exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = fastSpeed3_BoosterActive;
            else countedSpeed = fastSpeed3;
        }
        else {                                          // den exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = slowSpeed3_BoosterActive;
            else countedSpeed = slowSpeed3;
        }
        return countedSpeed;
    }



}