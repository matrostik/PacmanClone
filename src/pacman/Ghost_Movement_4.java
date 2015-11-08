package pacman;

import java.util.Random;
import java.awt.*;
               
class Ghost_Movement_4 extends arrayCreator {// implements Runnable  {  // kanw extend thn arrayCreator gia na glitwsume ligo xwro otan kalume thn arrayLevel 


public static int g4x , g4y ;                            // oi sudetagmenes tou ghost1 
public static int g4_init_x , g4_init_y  ;    // oi sudetagmenes oi arxikes tou ghost stis opoies gurnaei otan fagw8ei
public static int ghostMv2 ,ghostMv3;   // oi tuxaioi ari8moi gia to pou 8a paei to ghost meta apo staurodromi 
public static boolean ghost4_dot , ghost4_boost ; // metablhtes pou deixnun an ena fadasma einai panw apo ena cookie h booster    
public static boolean moved_down , moved_up , moved_left , moved_right ;  // metablhtes pou dhlwnoun pros ta pou kinh8hke to ghost
public static int exec_once = 0 ; // h metablhth enos eidous dirty programming - epekshghseis allh fora (apla gia na ektelestei mono mia fora mia parakatw sun8hkh

public static int tmp_g4x , tmp_g4y ;
 

void MoveGhost ( String s ) {               // BASIKH ME8ODOS METAKINHSHS TOU GHOST 
  if ( s == "left" ) {
      if (aL[g4y][g4x-1] == '.') { ghost4_dot = true ; } else if (aL[g4y][g4x-1] == 'O') { ghost4_boost = true ; }   
      if (aL[g4y][g4x-1] == 'P') {  Movement.moving(east , ghost4); }
      aL[g4y][g4x-1] = 'J' ;
      moved_left = true ;
    }
  else if ( s == "right" ) {
      if (aL[g4y][g4x+1] == '.') { ghost4_dot = true ; } else if (aL[g4y][g4x+1] == 'O') { ghost4_boost = true ; }   
      if (aL[g4y][g4x+1] == 'P') {  Movement.moving(west , ghost4); }
      aL[g4y][g4x+1]= 'J' ;
      moved_right = true ;
    }
  else if ( s == "down" ) {
     if (aL[g4y+1][g4x] == '.') { ghost4_dot = true ; } else if (aL[g4y+1][g4x] == 'O') { ghost4_boost = true ; }   
     if (aL[g4y+1][g4x] == 'P') {  Movement.moving(north , ghost4); }
     aL[g4y+1][g4x] = 'J' ;
     moved_down = true ;   
    }
  else if ( s == "up" ) {
      if (aL[g4y-1][g4x] == '.') { ghost4_dot = true ; }  else if (aL[g4y-1][g4x] == 'O') { ghost4_boost = true ; }  
      if (aL[g4y-1][g4x] == 'P') {  Movement.moving(south , ghost4); }
      aL[g4y-1][g4x] = 'J' ;
      moved_up = true ;
    }
    
} 

      
 
  
      
public Ghost_Movement_4()
    {
        //Thread ghost_thread = null;          // to thread dhmiourgei apisteuto bottleneck opote to ebgala - den xreiazetai outws h allws 
        //ghost_thread = new Thread(this);     // kai twra h taxuthta tou programmatos einai dramatika aukshmenh 
        //ghost_thread.start();        
    //} 
   
    
  //public void run() { 
        
        
      /******************************GHOST 4**********************************************/

      
        exec_once ++ ;

        // H logikh kinhshs tou ghost einai to "scanarisma" ka8e fora twn 3 tetragwnwn gurw tou (to ena einai auto apo to opoio erxotan opote den upologizetai 
        // giati polu apla upo kanonikes sun8hkes den gurnaei pros ta pisw) An apo auta ta 3 tetragwna to ena einai anoixto (dhladh oxi toixos) tote paei pros ta kei
        // an apo ta 3 tetragwna ta 2 einai anoixta tote upologizetai me random ari8mo pou 8a paei . to idio kai me 3 tetragwna anoixta
        

        Random generator_g = new Random(); 
       
        ghostMv2  = generator_g.nextInt(2) ;
        ghostMv3  = generator_g.nextInt(3) ; 
        tmp_g4x = g4x ; tmp_g4y = g4y ;
        
        //System.out.println( "G4X " + g4x + " G4Y "+ g4y ) ;
        
        
        
                                             // epanafora tou cookie otan to fadasma fugei apo th 8esh pou htan
        if ( ghost4_dot == true && aL[g4y][g4x] == 'G' ) { Ghost_Movement_2.ghost2_dot = true ; }  
        if ( ghost4_dot == true && aL[g4y][g4x] == 'H' ) { Ghost_Movement_3.ghost3_dot = true ; }
        if ( ghost4_dot == true && aL[g4y][g4x] == 'F' ) { Ghost_Movement_1.ghost1_dot = true ; }
        
                                           // epanafora tou booster otan to fadasma fugei apo th 8esh pou htan
        if ( ghost4_boost == true && aL[g4y][g4x] == 'G' ) { Ghost_Movement_2.ghost2_boost = true ; }  
        if ( ghost4_boost == true && aL[g4y][g4x] == 'H' ) { Ghost_Movement_3.ghost3_boost = true ; }
        if ( ghost4_boost == true && aL[g4y][g4x] == 'F' ) { Ghost_Movement_1.ghost1_boost = true ; }
        
        if ( !Movement.g4_eat ) arrayCreator.aL[g4y][g4x]=' ' ; 
        if ( ghost4_dot == true ) {  aL[g4y][g4x] = '.' ; }  
        if ( ghost4_boost == true ) {  aL[g4y][g4x] = 'O' ; } 
        
        ghost4_dot   = false ;
        ghost4_boost = false ;
   
    if ( !Movement.g4_eat  && exec_once > 5) {     
           
        
      /******************************* PERIPTWSH POU KINOUTAN PROS TA KATW***********************************************************************************/  
    if ( moved_down == true )  {
          
                // elegxos tou deksia tetragwnou                    // elegxos tou aristera tetragwnou                  // elegxos tou apo katw tetragwnou
      if ( g4y == linesOfLevel -1 ) {
          aL[0][g4x] = 'J' ; 
          moved_down = true ;
          g4y = 0 ;
     }          
                
      else if ( (aL[g4y][g4x+1]==' ' || aL[g4y][g4x+1]=='.' || aL[g4y][g4x+1]=='O' || aL[g4y][g4x+1]=='P' || aL[g4y][g4x+1]=='G' || aL[g4y][g4x+1]=='H' || aL[g4y][g4x+1]=='F' || aL[g4y][g4x+1]=='f') && ( aL[g4y][g4x-1]==' ' || aL[g4y][g4x-1]=='.' || aL[g4y][g4x-1]=='O' || aL[g4y][g4x+1]=='P' || aL[g4y][g4x+1]=='G' || aL[g4y][g4x+1]=='H'|| aL[g4y][g4x+1]=='F' || aL[g4y][g4x+1]=='f' ) && (aL[g4y+1][g4x]=='#') ) {                   
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py && Movement.px == g4y ) {
               if ( !Movement.boosterActive ) {  MoveGhost("left") ; moved_down= false ; } else  { MoveGhost("right") ; moved_down= false ; }  
            } 
            else if ( Movement.py-g4x <= 4 && Movement.py >= g4x && Movement.px == g4y  ){  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; } 
            } 
            else if ( g4y-Movement.px <= 3 && g4y >= Movement.px  && Movement.py == g4x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ;  }   else { MoveGhost("right") ; moved_down= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ;
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("right") ; moved_down= false ;
            } 
      }   
       
      else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1]=='O' || aL[g4y][g4x+1]=='P' || aL[g4y][g4x+1]=='G' || aL[g4y][g4x+1]=='H'|| aL[g4y][g4x+1]=='F' || aL[g4y][g4x+1]=='f') && (aL[g4y][g4x-1] == '#' ) && (aL[g4y+1][g4x] == '#') ) {                   
            if ( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else { MoveGhost("right") ;  moved_down= false ;} 
              }
            else {  
               MoveGhost("right") ; moved_down= false ;
              }  
      } 
         
      else if ( (aL[g4y][g4x+1] == '#' )&&( aL[g4y][g4x-1] ==' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1]=='O' || aL[g4y][g4x-1]=='P' || aL[g4y][g4x-1]=='G'|| aL[g4y][g4x-1]=='H'|| aL[g4y][g4x-1]=='F' || aL[g4y][g4x-1]=='f') && (aL[g4y+1][g4x] == '#') ) {                   
             if ( g4y - Movement.px <= 4 &&  g4y >= Movement.px  && Movement.py == g4x ){
               if ( !Movement.boosterActive ) {  MoveGhost("up") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
             }
             else {
               MoveGhost("left") ; moved_down= false ;
             } 
      } 
         

      else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1]=='O'  || aL[g4y][g4x+1]=='P' || aL[g4y][g4x+1]=='G' || aL[g4y][g4x+1]=='H' || aL[g4y][g4x+1]=='F' || aL[g4y][g4x+1]=='f') && (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1]=='O' || aL[g4y][g4x-1]=='P' || aL[g4y][g4x-1]=='G'|| aL[g4y][g4x-1]=='H'|| aL[g4y][g4x-1]=='F' || aL[g4y][g4x-1]=='f') && (aL[g4y+1][g4x]==' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x]=='O' || aL[g4y+1][g4x]=='P' || aL[g4y+1][g4x]=='G'|| aL[g4y+1][g4x]=='H'|| aL[g4y+1][g4x]=='F' || aL[g4y+1][g4x]=='f') ) {                   
            if ( g4x -Movement.py <= 4 && g4x >= Movement.py && Movement.px == g4y ) {
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("right") ; moved_down= false ; }
            }
            else if ( Movement.py-g4x <= 4 && Movement.py >= g4x && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g4y <= 4 && Movement.px >= g4y && Movement.py == g4x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            }
            else if ( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x ) {
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
        
        
      else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1]=='O' || aL[g4y][g4x+1]=='P' || aL[g4y][g4x+1]=='G'|| aL[g4y][g4x+1]=='H'|| aL[g4y][g4x+1]=='F' || aL[g4y][g4x+1]=='f') && (aL[g4y][g4x-1] == '#' ) && (aL[g4y+1] [g4x]== ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x]=='O' || aL[g4y+1][g4x]=='P' || aL[g4y+1][g4x]=='G'|| aL[g4y+1][g4x]=='H'|| aL[g4y+1][g4x]=='F' || aL[g4y+1][g4x]=='f') ) {                   
            if ( Movement.py-g4x <= 4 && Movement.py >= g4x && Movement.px == g4y ) {
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("right") ; moved_down= false ; }
            }  
            else if ( Movement.px-g4y <= 4 && Movement.px >=g4y  && Movement.py == g4x ){  
               if ( !Movement.boosterActive ) {MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            } 
            else if ( g4y - Movement.px <= 4 && g4y >= Movement.px && Movement.py == g4x ){
               if ( !Movement.boosterActive ) {MoveGhost("up") ; moved_down= false ; } else { MoveGhost("down") ;  moved_down= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("down") ; moved_down= true ;
            } 
      }  
         
      else if ( (aL[g4y][g4x+1] == '#') && (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1]=='O' || aL[g4y][g4x-1]=='P' || aL[g4y][g4x-1]=='G'|| aL[g4y][g4x-1]=='H' || aL[g4y][g4x-1]=='F' || aL[g4y][g4x-1]=='f') && (aL[g4y+1][g4x]== ' ' || aL[g4y+1][g4x]=='.' || aL[g4y+1][g4x]=='O' || aL[g4y+1][g4x]=='P' || aL[g4y+1][g4x]=='G'|| aL[g4y+1][g4x]=='H'|| aL[g4y+1][g4x]=='F' || aL[g4y+1][g4x]=='f') ) {                   
            if ( g4x - Movement.py <= 4  && g4x >= Movement.py   && Movement.px == g4y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ;   moved_down= true ;   }    else {MoveGhost("up") ; moved_down= false ; }
            } 
            else if (  g4y - Movement.px  <= 4  && g4y >= Movement.px  && Movement.py == g4x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else {MoveGhost("down") ; moved_down= true ;}
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost("down") ;  moved_down= true ;
            } 
      }  
         
      else if ( ( aL[g4y][g4x+1] == '#' ) && (aL[g4y][g4x-1] == '#' ) && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x]=='.' || aL[g4y+1][g4x]=='O' || aL[g4y+1][g4x]=='P' || aL[g4y+1][g4x]=='G'|| aL[g4y+1][g4x]=='H'|| aL[g4y+1][g4x]=='F' || aL[g4y+1][g4x]=='f') ){  
            if ( Movement.px - g4y  <= 4 && Movement.px >= g4y  && Movement.py == g4x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_down= true ; }    else {MoveGhost("up") ; moved_down= false ; }
            }    
            else if ( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x ){
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
     if ( g4y == 0 ) {
          aL[linesOfLevel-1][g4x] = 'J' ; 
          moved_up = true ;
          g4y = linesOfLevel-1 ;
     }    
            
     else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G' || aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y][g4x-1]==' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f' ) && (aL[g4y-1] [g4x]== '#') ) {                   
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) { 
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }
            else if (  Movement.py - g4x  <= 4 && Movement.py >= g4x && Movement.px == g4y ) { 
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }
            else if ( Movement.px-g4y <= 4  && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ;  } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }    
            else if ( ghostMv2 == 1 ){  
              MoveGhost("right") ; moved_up= false ; 
            } 
     }   
       
     else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f' ) && (aL[g4y][g4x-1] == '#' ) && (aL[g4y-1][g4x] == '#') ) {                   
          if ( Movement.px-g4y <= 4 && Movement.px >= g4y && Movement.py == g4x ){  
             if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("right") ;  moved_up= false ; } 
          }    
          else {    
             MoveGhost("right") ; moved_up= false ;
         } 
     }
         
     else if ( (aL[g4y][g4x+1] == '#' ) && (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y-1][g4x] == '#') ) {                   
           if ( Movement.px-g4y <= 4 && Movement.px >= g4y && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ;  moved_up= false ; } 
          }    
          else {    
            MoveGhost("left") ; moved_up= false ;
          }  
     } 

         
     else if ( ( aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' | aL[g4y][g4x-1] == 'G'| aL[g4y][g4x-1] == 'H' || aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') ) {                   
            if ( g4x - Movement.py  <= 4 && g4x >= Movement.py  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if ( Movement.py- g4x <= 4 &&  Movement.py >= g4x  && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }  
            else if ( g4x - Movement.px  <= 4 && g4x >= Movement.px   && Movement.py == g4x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_up= true ; } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-4 <= g4y && Movement.px >= g4y && Movement.py == g4x ){  
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
        
    else if ( (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G' || aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y][g4x-1] == '#' ) && (aL[g4y-1] [g4x]== ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') )  {                   
            if (  Movement.py- g4x <= 4 && Movement.py >= g4x && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if (  g4y - Movement.px <= 4 &&  g4y >= Movement.px  && Movement.py == g4x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true;    } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ;  moved_up=true ;   }
            }  
            else if ( ghostMv2 == 0 ) {
              MoveGhost("right") ; moved_up= false ;
            }  
            else if ( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_up= true;
            }  
     } 
         
     else if ( (aL[g4y][g4x+1] == '#' ) && (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G' || aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y-1][g4x]== ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F'  || aL[g4y-1][g4x] == 'f') ) {                   
            if ( g4y - Movement.py <= 4 && g4y >= Movement.py  && Movement.px == g4y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("up") ; moved_up= true ; }
            }   
            else if ( g4y - Movement.px <= 4 && g4y >= Movement.px && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px- g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost ("up") ; moved_up = true ; 
            } 
     }  
         
     else if ( (aL[g4y][g4x+1] == '#' ) && (aL[g4y][g4x-1] == '#') && (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H' || aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') ) {  
         if ( g4y - Movement.px  <= 4 && g4y >= Movement.px  && Movement.py == g4x ){
           if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
         }  
         else if ( Movement.px- g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
            if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
         }   
         else {     
            MoveGhost("up") ; moved_up = true ; 
         }  
     }  
         
         
     
        
 }   
        
        
      
      /******************************* PERIPTWSH POU KINOUTAN PROS TA DEKSIA ********************************************************************************/ 
     else if ( moved_right == true )  {   
        
        if ( g4x == colomnsOfLevel -1 ) { 
             aL[g4y][0] = 'J' ;
             moved_right = true ; 
             g4x = 0 ;
            }  
        
        
            // elegxos tou panw tetragwnou                    // elegxos tou deksia tetragwnou                  // elegxos tou apo katw tetragwnou
       else if ( (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G' || aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f' ) && (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f'   ) && (aL[g4y+1][g4x]== '#') ) {                   
            if ( Movement.py- g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x  ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g4x - Movement.py <= 4 && g4x >= Movement.py && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_right= true ; 
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_right= false ; 
            }  
       }     
       
       else if ( (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') && (aL[g4y][g4x+1] == '#') && (aL[g4y+1][g4x] == '#') ) {                   
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; } 
            }  
            else {  
              MoveGhost("up") ; moved_right= false ; 
            } 
       } 
         
       else if ( (aL[g4y-1][g4x] == '#' ) && (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y+1][g4x] == '#') ) {                   
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py   && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else {  
              MoveGhost("right") ; moved_right= true ; 
            }  
       } 
         
       
       else if ( (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') && (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f') ) {                   
            if ( g4y - Movement.px <= 4 &&  g4y >= Movement.px && Movement.py == g4x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }
            else if ( Movement.py-g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y ) {  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if ( Movement.px- g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }   
            else if ( g4x - Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) {  
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
        
       else if ( ( aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') && (aL[g4y][g4x+1] == '#') && (aL[g4y+1][g4x]== ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f' ) ) {                   
            if ( g4y - Movement.px <= 4  && g4y >= Movement.px  && Movement.py == g4x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }   
            else if( Movement.px-g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }  
            else if ( g4x-Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("up") ; moved_right= false ;
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            }  
       }  
         
       else if ( (aL[g4y-1][g4x] == '#' ) && (aL[g4y][g4x+1] == ' ' || aL[g4y][g4x+1] == '.' || aL[g4y][g4x+1] == 'O' || aL[g4y][g4x+1] == 'P' || aL[g4y][g4x+1] == 'G'|| aL[g4y][g4x+1] == 'H'|| aL[g4y][g4x+1] == 'F' || aL[g4y][g4x+1] == 'f') && (aL[g4y+1][g4x]== ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f') ) {                   
            if ( Movement.py-g4x <= 4  && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( Movement.px-g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g4x - Movement.py <= 4 && g4x >= Movement.py && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost ("right" ) ; moved_right = true ; 
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            } 
       }  
         
       else if ( (aL[g4y-1][g4x] == '#' ) && (aL[g4y][g4x+1] == '#') && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f') ) {  
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else {
              MoveGhost("down") ; moved_right= false ;
            } 
       }
       
       else if ( g4x == g4_init_x && g4y == g4_init_y ) { 
             aL[g4y][g4x+1] = 'J' ;
             moved_right = true ; 
       } 
            
         
   }   

      /******************************* PERIPTWSH POU KINOUTAN PROS TA ARISTERA ********************************************************************************/ 
    else if ( moved_left == true )  {   
        
            // elegxos tou aristera tetragwnou                    // elegxos tou katw tetragwnou                  // elegxos tou apo panw tetragwnou
       if ( g4x == 0) { 
          aL[g4y][colomnsOfLevel-1] = 'J' ; 
          moved_left = true ;
          g4x = colomnsOfLevel-1 ;
       }    
        
        
       else if ( (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f') && (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G' || aL[g4y-1][g4x] == 'H' || aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') ) {                   
            if ( Movement.px-g4y <= 4  && Movement.px >= g4y  && Movement.py == g4x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if ( g4x - Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }  
            else if ( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x ) {
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }  
            else if ( Movement.py - g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
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
        
       else if ( (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y+1][g4x] == '#') && (aL[g4y-1] [g4x]== ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y][g4x-1] == 'f')) {                   
            if ( g4x - Movement.py <=4  && g4x >= Movement.py  && Movement.px == g4y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( g4y - Movement.px <= 4 && g4y >= Movement.px && Movement.py == g4x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( Movement.py - g4x <= 4 && Movement.py >= g4x && Movement.px == g4y  ) {
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }   
            else if( ghostMv2 == 1 ) {  
              MoveGhost("up") ; moved_left= false ; 
            }  
       }  
         
       else if ( (aL[g4y][g4x-1] == '#') && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f' ) && (aL[g4y-1] [g4x]== ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') ) {                   
            if ( Movement.px-g4y <= 4 && Movement.px >= g4y  && Movement.py == g4x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if( g4y - Movement.px <= 4 && g4y >= Movement.px  && Movement.py == g4x ) {  
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else if ( Movement.py-g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }  
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("down") ; moved_left= false ;
            }   
            else if( ghostMv2 == 1 ) {  
               MoveGhost("up") ; moved_left= false ; 
            }   
       }  
         
       else if ( (aL[g4y][g4x-1] == '#') && (aL[g4y+1][g4x] == '#') && (aL[g4y-1][g4x] == ' ' || aL[g4y-1][g4x] == '.' || aL[g4y-1][g4x] == 'O' || aL[g4y-1][g4x] == 'P' || aL[g4y-1][g4x] == 'G'|| aL[g4y-1][g4x] == 'H'|| aL[g4y-1][g4x] == 'F' || aL[g4y-1][g4x] == 'f') ) {  
            if ( Movement.py-g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }  
            }   
            else {   
              MoveGhost("up") ; moved_left= false ; 
            }  
       }    
         
       else if ( (aL[g4y][g4x-1] == '#' ) && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f' ) && (aL[g4y-1][g4x] == '#') ) {  
            if ( Movement.py-g4x <= 4 && Movement.py >= g4x && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else {   
               MoveGhost("down") ; moved_left= false ;
            }  
       }  
         
       else if ( (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y+1][g4x] == '#' ) && (aL[g4y-1][g4x] == '#') ) {  
            if ( Movement.py-g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }   
            else {    
              MoveGhost("left") ; moved_left= true ;
            }  
       }   
        
       else if ( (aL[g4y][g4x-1] == ' ' || aL[g4y][g4x-1] == '.' || aL[g4y][g4x-1] == 'O' || aL[g4y][g4x-1] == 'P' || aL[g4y][g4x-1] == 'G'|| aL[g4y][g4x-1] == 'H'|| aL[g4y][g4x-1] == 'F' || aL[g4y][g4x-1] == 'f') && (aL[g4y+1][g4x] == ' ' || aL[g4y+1][g4x] == '.' || aL[g4y+1][g4x] == 'O' || aL[g4y+1][g4x] == 'P' || aL[g4y+1][g4x] == 'G'|| aL[g4y+1][g4x] == 'H'|| aL[g4y+1][g4x] == 'F' || aL[g4y+1][g4x] == 'f') && (aL[g4y-1][g4x]== '#') ) {                   
            if ( g4x - Movement.py <= 4 && g4x >= Movement.py  && Movement.px == g4y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( Movement.px - g4y  <= 4 && Movement.px >= g4y   && Movement.py == g4x  ){  
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; } 
            }  
            else if ( Movement.py- g4x <= 4 && Movement.py >= g4x  && Movement.px == g4y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_left= false ;
            } 
       }  
       
       else if ( g4x == g4_init_x && g4y == g4_init_y ) { 
             aL[g4y][g4x-1] = 'J' ;
             moved_left = true ;
       } 
       
       
         
         
      }     
     
    } // telos if ( !g4_eat) 
   
    
    
        if (exec_once == 4) { aL[g4y][g4x]=' ' ; g4x = g4x-1 ; aL[g4y][g4x]='J' ;}
        else if ( exec_once == 5 ) { aL[g4y][g4x]=' ' ; g4y = g4y-2 ; aL[g4y][g4x]='J' ; moved_right=true; }
        else if (!Movement.g4_eat && exec_once > 5){
          if      (moved_up==true)     { g4y = g4y -1 ; } 
          else if (moved_down==true)   { g4y = g4y +1 ; }
          else if (moved_right==true && aL[g4y][0] != 'J'  )     { g4x = g4x + 1; }          // xreiazodai kai oi elegxoi gia tis periptwseis pou pernaei sthn adipera meria
          else if (moved_left==true  && aL[g4y][colomnsOfLevel-1] != 'J'  ) { g4x = g4x -1 ; } 
        }
        else if ( Movement.g4_eat == true && exec_once > 5) { 
            g4y = Ghost_Movement_1.g1_init_y ; 
            g4x = Ghost_Movement_1.g1_init_x  ; 
            moved_right = true ; Ghost_Movement_1.NullSetOthers() ;
        }
        
        
         
         Point currentPosition = new Point();
         currentPosition.x = g4x;
         currentPosition.y = g4y;
         
         Ghost_Animation ghost_anim = new Ghost_Animation(currentPosition, countSpeed(), 4, moved_up, moved_down, moved_left , moved_right);
     
       
       PacMan_Graphics.content.repaint();
       
     

    
    }     


    public static int countSpeed(){
        int cookiesEaten = counter.cookies - counter.cookiesRemaining;
        int countedSpeed;
        if(cookiesEaten > 0.6 * counter.cookies) {      // exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = fastSpeed4_BoosterActive;
            else countedSpeed = fastSpeed4;
        }
        else {                                          // den exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = slowSpeed4_BoosterActive;
            else countedSpeed = slowSpeed4;
        }
        return countedSpeed;
    }




}