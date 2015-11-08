package pacman;

import java.util.Random;
import java.awt.*;
               
class Ghost_Movement_1 extends arrayCreator {// implements Runnable  {  // kanw extend thn arrayCreator gia na glitwsume ligo xwro otan kalume thn arrayLevel 


public static int g1x , g1y ;                            // oi sudetagmenes tou ghost1 
public static int g1_init_x , g1_init_y  ;    // oi sudetagmenes oi arxikes tou ghost stis opoies gurnaei otan fagw8ei
public static int ghostMv2 ,ghostMv3;   // oi tuxaioi ari8moi gia to pou 8a paei to ghost meta apo staurodromi 
public static boolean ghost1_dot , ghost1_boost ; // metablhtes pou deixnun an ena fadasma einai panw apo ena cookie h booster    
public static boolean moved_down , moved_up , moved_left , moved_right ;  // metablhtes pou dhlwnoun pros ta pou kinh8hke to ghost
public static int exec_once = 0 ; // h metablhth enos eidous dirty programming - epekshghseis allh fora (apla gia na ektelestei mono mia fora mia parakatw sun8hkh

public static int tmp_g1x , tmp_g1y ;

static void NullSetOthers () {          // sunarthsh pou 8etei false oles tis alles boolean metablhtes ektos apo thn teleutaia isxuousa 
      if      ( moved_up == true   )  { moved_down = false ; moved_left = false ; moved_right = false ; }
      else if ( moved_down == true )  { moved_up = false ; moved_left = false ; moved_right = false ;   }     
      else if ( moved_left == true )  { moved_up = false ; moved_down = false ; moved_right = false ;   }  
      else if ( moved_right == true)  { moved_up = false ; moved_down = false ; moved_left = false ;   }  
}    

void MoveGhost ( String s ) {               // BASIKH ME8ODOS METAKINHSHS TOU GHOST 
  if ( s == "left" ) {
      if (aL[g1y][g1x-1] == '.') { ghost1_dot = true ; } else if (aL[g1y][g1x-1] == 'O') { ghost1_boost = true ; }   
      if (aL[g1y][g1x-1] == 'P' ) {  Movement.moving(east , ghost1); }
      aL[g1y][g1x-1] = 'F' ;
      moved_left = true ;
    }
  else if ( s == "right" ) {
      if (aL[g1y][g1x+1] == '.') { ghost1_dot = true ; } else if (aL[g1y][g1x+1] == 'O') { ghost1_boost = true ; }  
      if (aL[g1y][g1x+1] == 'P') { Movement.moving(west , ghost1); }
      aL[g1y][g1x+1]= 'F' ;
      moved_right = true ;
    }
  else if ( s == "down" ) {
     if (aL[g1y+1][g1x] == '.') { ghost1_dot = true ; } else if (aL[g1y+1][g1x] == 'O') { ghost1_boost = true ; }  
     if (aL[g1y+1][g1x] == 'P') { Movement.moving(north , ghost1); }
     aL[g1y+1][g1x] = 'F' ;
     moved_down = true ;   
    }
  else if ( s == "up" ) {
      if (aL[g1y-1][g1x] == '.') { ghost1_dot = true ; }  else if (aL[g1y-1][g1x] == 'O') { ghost1_boost = true ; }
      if (aL[g1y-1][g1x] == 'P') { Movement.moving(south , ghost1); }
      aL[g1y-1][g1x] = 'F' ;
      moved_up = true ;
    }
    
} 

      
 
  
      
public Ghost_Movement_1()
    {
        //Thread ghost_thread = null;          // to thread dhmiourgei apisteuto bottleneck opote to ebgala - den xreiazetai outws h allws 
        //ghost_thread = new Thread(this);     // kai twra h taxuthta tou programmatos einai dramatika aukshmenh 
        //ghost_thread.start();        
    //} 
   
    
  //public void run() { 
        
        
      /******************************GHOST 1**********************************************/

      
        exec_once ++ ;

        // H logikh kinhshs tou ghost einai to "scanarisma" ka8e fora twn 3 tetragwnwn gurw tou (to ena einai auto apo to opoio erxotan opote den upologizetai 
        // giati polu apla upo kanonikes sun8hkes den gurnaei pros ta pisw) An apo auta ta 3 tetragwna to ena einai anoixto (dhladh oxi toixos) tote paei pros ta kei
        // an apo ta 3 tetragwna ta 2 einai anoixta tote upologizetai me random ari8mo pou 8a paei . to idio kai me 3 tetragwna anoixta
        

        Random generator_g = new Random(); 
       
        ghostMv2  = generator_g.nextInt(2) ;
        ghostMv3  = generator_g.nextInt(3) ; 
        tmp_g1x = g1x ; tmp_g1y = g1y ;
        
        
                                                                         // BASIKO!!! An 2 ghost pane sto idio cookie tote epeidh h metablhth pou krataei oti uphrxe cookie 
                                                                         // epanaferei to cookie prwta kai meta h kinhsh tou 2ou fadasmatos pou htan panw tou to xanei 
                // prepei na kanume tous parakatw eidikus elegxous gia na apotrapei auto  -- to idio kai gia booster
                                                                            
        //System.out.println ( "G1X " + g1x + " G2X" +  g1y ) ;
        
                                                                      // epanafora tou cookie otan to fadasma fugei apo th 8esh pou htan
        
        if ( ghost1_dot == true && aL[g1y][g1x] == 'G' ) { Ghost_Movement_2.ghost2_dot = true ; }  
        if ( ghost1_dot == true && aL[g1y][g1x] == 'H' ) { Ghost_Movement_3.ghost3_dot = true ; }
        if ( ghost1_dot == true && aL[g1y][g1x] == 'J' ) { Ghost_Movement_4.ghost4_dot = true ; }
        
                                                                   // epanafora tou booster otan to fadasma fugei apo th 8esh pou htan
        if ( ghost1_boost == true && aL[g1y][g1x] == 'G' ) { Ghost_Movement_2.ghost2_boost = true ; }  
        if ( ghost1_boost == true && aL[g1y][g1x] == 'H' ) { Ghost_Movement_3.ghost3_boost = true ; }
        if ( ghost1_boost == true && aL[g1y][g1x] == 'J' ) { Ghost_Movement_4.ghost4_boost = true ; }
        
        if ( !Movement.g1_eat ) arrayCreator.aL[g1y][g1x]=' ' ;  
        if ( ghost1_dot == true ) {  aL[g1y][g1x] = '.' ; }  
        if ( ghost1_boost == true ) {  aL[g1y][g1x] = 'O' ; } 
        
        ghost1_dot   = false ;
        ghost1_boost = false ;
   
   if ( !Movement.g1_eat ) {     
        
      /******************************* PERIPTWSH POU KINOUTAN PROS TA KATW***********************************************************************************/  
    if ( moved_down == true )  {
          
                // elegxos tou deksia tetragwnou                    // elegxos tou aristera tetragwnou                  // elegxos tou apo katw tetragwnou
      if ( g1y == linesOfLevel -1 ) {
          aL[0][g1x] = 'F' ; 
          moved_down = true ;
          g1y = 0 ;
     }          
                
      else if ( (aL[g1y][g1x+1]==' ' || aL[g1y][g1x+1]=='.' || aL[g1y][g1x+1]=='O' || aL[g1y][g1x+1]=='P' || aL[g1y][g1x+1]=='G' || aL[g1y][g1x+1]=='H' || aL[g1y][g1x+1]=='J' || aL[g1y][g1x+1]=='f') && ( aL[g1y][g1x-1]==' ' || aL[g1y][g1x-1]=='.' || aL[g1y][g1x-1]=='O' || aL[g1y][g1x+1]=='P' || aL[g1y][g1x+1]=='G' || aL[g1y][g1x+1]=='H'|| aL[g1y][g1x+1]=='J' || aL[g1y][g1x+1]=='f' ) && (aL[g1y+1][g1x]=='#') ) {                   
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py && Movement.px == g1y ) {
               if ( !Movement.boosterActive ) {  MoveGhost("left") ; moved_down= false ; } else  { MoveGhost("right") ; moved_down= false ; }  
            } 
            else if ( Movement.py-g1x <= 4 && Movement.py >= g1x && Movement.px == g1y  ){  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; } 
            } 
            else if ( g1y-Movement.px <= 3 && g1y >= Movement.px  && Movement.py == g1x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ;  }   else { MoveGhost("right") ; moved_down= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ;
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("right") ; moved_down= false ;
            } 
      }   
       
      else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1]=='O' || aL[g1y][g1x+1]=='P' || aL[g1y][g1x+1]=='G' || aL[g1y][g1x+1]=='H'|| aL[g1y][g1x+1]=='J' || aL[g1y][g1x+1]=='f') && (aL[g1y][g1x-1] == '#' ) && (aL[g1y+1][g1x] == '#') ) {                   
            if ( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else { MoveGhost("right") ;  moved_down= false ;} 
              }
            else {  
               MoveGhost("right") ; moved_down= false ;
              }  
      } 
         
      else if ( (aL[g1y][g1x+1] == '#' )&&( aL[g1y][g1x-1] ==' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1]=='O' || aL[g1y][g1x-1]=='P' || aL[g1y][g1x-1]=='G'|| aL[g1y][g1x-1]=='H'|| aL[g1y][g1x-1]=='J' || aL[g1y][g1x-1]=='f') && (aL[g1y+1][g1x] == '#') ) {                   
             if ( g1y - Movement.px <= 4 &&  g1y >= Movement.px  && Movement.py == g1x ){
               if ( !Movement.boosterActive ) {  MoveGhost("up") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
             }
             else {
               MoveGhost("left") ; moved_down= false ;
             } 
      } 
         

      else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1]=='O'  || aL[g1y][g1x+1]=='P' || aL[g1y][g1x+1]=='G' || aL[g1y][g1x+1]=='H' || aL[g1y][g1x+1]=='J' || aL[g1y][g1x+1]=='f') && (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1]=='O' || aL[g1y][g1x-1]=='P' || aL[g1y][g1x-1]=='G'|| aL[g1y][g1x-1]=='H'|| aL[g1y][g1x-1]=='J' || aL[g1y][g1x-1]=='f') && (aL[g1y+1][g1x]==' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x]=='O' || aL[g1y+1][g1x]=='P' || aL[g1y+1][g1x]=='G'|| aL[g1y+1][g1x]=='H'|| aL[g1y+1][g1x]=='J' || aL[g1y+1][g1x]=='f') ) {                   
            if ( g1x -Movement.py <= 4 && g1x >= Movement.py && Movement.px == g1y ) {
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("right") ; moved_down= false ; }
            }
            else if ( Movement.py-g1x <= 4 && Movement.py >= g1x && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g1y <= 4 && Movement.px >= g1y && Movement.py == g1x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            }
            else if ( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x ) {
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
        
        
      else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1]=='O' || aL[g1y][g1x+1]=='P' || aL[g1y][g1x+1]=='G'|| aL[g1y][g1x+1]=='H'|| aL[g1y][g1x+1]=='J' || aL[g1y][g1x+1]=='f') && (aL[g1y][g1x-1] == '#' ) && (aL[g1y+1] [g1x]== ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x]=='O' || aL[g1y+1][g1x]=='P' || aL[g1y+1][g1x]=='G'|| aL[g1y+1][g1x]=='H'|| aL[g1y+1][g1x]=='J' || aL[g1y+1][g1x]=='f') ) {                   
            if ( Movement.py-g1x <= 4 && Movement.py >= g1x && Movement.px == g1y ) {
              if ( !Movement.boosterActive ) {MoveGhost("right") ; moved_down= false ; } else { MoveGhost("right") ; moved_down= false ; }
            }  
            else if ( Movement.px-g1y <= 4 && Movement.px >=g1y  && Movement.py == g1x ){  
               if ( !Movement.boosterActive ) {MoveGhost("down") ;  moved_down= true ;  } else { MoveGhost("up") ; moved_down= false ; }
            } 
            else if ( g1y - Movement.px <= 4 && g1y >= Movement.px && Movement.py == g1x ){
               if ( !Movement.boosterActive ) {MoveGhost("up") ; moved_down= false ; } else { MoveGhost("down") ;  moved_down= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
               MoveGhost("down") ; moved_down= true ;
            } 
      }  
         
      else if ( (aL[g1y][g1x+1] == '#') && (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1]=='O' || aL[g1y][g1x-1]=='P' || aL[g1y][g1x-1]=='G'|| aL[g1y][g1x-1]=='H' || aL[g1y][g1x-1]=='J' || aL[g1y][g1x-1]=='f') && (aL[g1y+1][g1x]== ' ' || aL[g1y+1][g1x]=='.' || aL[g1y+1][g1x]=='O' || aL[g1y+1][g1x]=='P' || aL[g1y+1][g1x]=='G'|| aL[g1y+1][g1x]=='H'|| aL[g1y+1][g1x]=='J' || aL[g1y+1][g1x]=='f') ) {                   
            if ( g1x - Movement.py <= 4  && g1x >= Movement.py   && Movement.px == g1y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_down= false ; } else {MoveGhost("left") ; moved_down= false ; }
            }
            else if ( Movement.px - g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ;   moved_down= true ;   }    else {MoveGhost("up") ; moved_down= false ; }
            } 
            else if (  g1y - Movement.px  <= 4  && g1y >= Movement.px  && Movement.py == g1x ){
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_down= false ; } else {MoveGhost("down") ; moved_down= true ;}
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_down= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost("down") ;  moved_down= true ;
            } 
      }  
         
      else if ( ( aL[g1y][g1x+1] == '#' ) && (aL[g1y][g1x-1] == '#' ) && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x]=='.' || aL[g1y+1][g1x]=='O' || aL[g1y+1][g1x]=='P' || aL[g1y+1][g1x]=='G'|| aL[g1y+1][g1x]=='H'|| aL[g1y+1][g1x]=='J' || aL[g1y+1][g1x]=='f') ){  
            if ( Movement.px - g1y  <= 4 && Movement.px >= g1y  && Movement.py == g1x ) {
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_down= true ; }    else {MoveGhost("up") ; moved_down= false ; }
            }    
            else if ( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x ){
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
     if ( g1y == 0 ) {
          aL[linesOfLevel-1][g1x] = 'F' ; 
          moved_up = true ;
          g1y = linesOfLevel-1 ;
     }    
            
     else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G' || aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y][g1x-1]==' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f' ) && (aL[g1y-1] [g1x]== '#') ) {                   
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) { 
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }
            else if (  Movement.py - g1x  <= 4 && Movement.py >= g1x && Movement.px == g1y ) { 
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }
            else if ( Movement.px-g1y <= 4  && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ;  } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }    
            else if ( ghostMv2 == 1 ){  
              MoveGhost("right") ; moved_up= false ; 
            } 
     }   
       
     else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f' ) && (aL[g1y][g1x-1] == '#' ) && (aL[g1y-1][g1x] == '#') ) {                   
          if ( Movement.px-g1y <= 4 && Movement.px >= g1y && Movement.py == g1x ){  
             if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("right") ;  moved_up= false ; } 
          }    
          else {    
             MoveGhost("right") ; moved_up= false ;
         } 
     }
         
     else if ( (aL[g1y][g1x+1] == '#' ) && (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y-1][g1x] == '#') ) {                   
           if ( Movement.px-g1y <= 4 && Movement.px >= g1y && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("left") ;  moved_up= false ; } 
          }    
          else {    
            MoveGhost("left") ; moved_up= false ;
          }  
     } 

         
     else if ( ( aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' | aL[g1y][g1x-1] == 'G'| aL[g1y][g1x-1] == 'H' || aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') ) {                   
            if ( g1x - Movement.py  <= 4 && g1x >= Movement.py  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if ( Movement.py- g1x <= 4 &&  Movement.py >= g1x  && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("left") ; moved_up= false ; }
            }  
            else if ( g1x - Movement.px  <= 4 && g1x >= Movement.px   && Movement.py == g1x ){
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_up= true ; } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-4 <= g1y && Movement.px >= g1y && Movement.py == g1x ){  
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
        
    else if ( (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G' || aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y][g1x-1] == '#' ) && (aL[g1y-1] [g1x]== ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') )  {                   
            if (  Movement.py- g1x <= 4 && Movement.py >= g1x && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_up= false ; } else {MoveGhost("right") ; moved_up= false ; }
            }   
            else if (  g1y - Movement.px <= 4 &&  g1y >= Movement.px  && Movement.py == g1x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true;    } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px-g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ;  moved_up=true ;   }
            }  
            else if ( ghostMv2 == 0 ) {
              MoveGhost("right") ; moved_up= false ;
            }  
            else if ( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_up= true;
            }  
     } 
         
     else if ( (aL[g1y][g1x+1] == '#' ) && (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G' || aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y-1][g1x]== ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J'  || aL[g1y-1][g1x] == 'f') ) {                   
            if ( g1y - Movement.py <= 4 && g1y >= Movement.py  && Movement.px == g1y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_up= false ; } else {MoveGhost("up") ; moved_up= true ; }
            }   
            else if ( g1y - Movement.px <= 4 && g1y >= Movement.px && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
            }  
            else if ( Movement.px- g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_up= false ; 
            }
            else if ( ghostMv2 == 1 ){  
              MoveGhost ("up") ; moved_up = true ; 
            } 
     }  
         
     else if ( (aL[g1y][g1x+1] == '#' ) && (aL[g1y][g1x-1] == '#') && (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H' || aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') ) {  
         if ( g1y - Movement.px  <= 4 && g1y >= Movement.px  && Movement.py == g1x ){
           if ( !Movement.boosterActive ) { MoveGhost("up") ;   moved_up= true ;   } else {MoveGhost("down") ; moved_up= false ; }
         }  
         else if ( Movement.px- g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
            if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_up= false ; } else {MoveGhost("up") ; moved_up = true ;  }
         }   
         else {     
            MoveGhost("up") ; moved_up = true ; 
         }  
     }  
         
         
     
        
 }   
        
        
      
      /******************************* PERIPTWSH POU KINOUTAN PROS TA DEKSIA ********************************************************************************/ 
     else if ( moved_right == true )  {   
        
        if ( g1x == colomnsOfLevel -1 ) { 
             aL[g1y][0] = 'F' ;
             moved_right = true ; 
             g1x = 0 ;
            }  
        
        
            // elegxos tou panw tetragwnou                    // elegxos tou deksia tetragwnou                  // elegxos tou apo katw tetragwnou
       else if ( (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G' || aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f' ) && (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f'   ) && (aL[g1y+1][g1x]== '#') ) {                   
            if ( Movement.py- g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x  ){  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g1x - Movement.py <= 4 && g1x >= Movement.py && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("right") ; moved_right= true ; 
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("up") ; moved_right= false ; 
            }  
       }     
       
       else if ( (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') && (aL[g1y][g1x+1] == '#') && (aL[g1y+1][g1x] == '#') ) {                   
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; } 
            }  
            else {  
              MoveGhost("up") ; moved_right= false ; 
            } 
       } 
         
       else if ( (aL[g1y-1][g1x] == '#' ) && (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y+1][g1x] == '#') ) {                   
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py   && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else {  
              MoveGhost("right") ; moved_right= true ; 
            }  
       } 
         
       
       else if ( (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') && (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f') ) {                   
            if ( g1y - Movement.px <= 4 &&  g1y >= Movement.px && Movement.py == g1x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }
            else if ( Movement.py-g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y ) {  
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if ( Movement.px- g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }   
            else if ( g1x - Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) {  
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
        
       else if ( ( aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') && (aL[g1y][g1x+1] == '#') && (aL[g1y+1][g1x]== ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f' ) ) {                   
            if ( g1y - Movement.px <= 4  && g1y >= Movement.px  && Movement.py == g1x ) {
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; }
            }   
            else if( Movement.px-g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("up") ; moved_right= false ; }
            }  
            else if ( g1x-Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("up") ; moved_right= false ;
            }   
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            }  
       }  
         
       else if ( (aL[g1y-1][g1x] == '#' ) && (aL[g1y][g1x+1] == ' ' || aL[g1y][g1x+1] == '.' || aL[g1y][g1x+1] == 'O' || aL[g1y][g1x+1] == 'P' || aL[g1y][g1x+1] == 'G'|| aL[g1y][g1x+1] == 'H'|| aL[g1y][g1x+1] == 'J' || aL[g1y][g1x+1] == 'f') && (aL[g1y+1][g1x]== ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f') ) {                   
            if ( Movement.py-g1x <= 4  && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_right= true ; } else {MoveGhost("left") ; moved_right= false ; }
            }   
            else if( Movement.px-g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ){  
              if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; }
            }  
            else if ( g1x - Movement.py <= 4 && g1x >= Movement.py && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("right") ; moved_right= true ; } 
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost ("right" ) ; moved_right = true ; 
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_right= false ;
            } 
       }  
         
       else if ( (aL[g1y-1][g1x] == '#' ) && (aL[g1y][g1x+1] == '#') && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f') ) {  
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_right= false ; } else {MoveGhost("down") ; moved_right= false ; } 
            }  
            else {
              MoveGhost("down") ; moved_right= false ;
            } 
       }
       
       else if ( g1x == g1_init_x && g1y == g1_init_y ) { 
             aL[g1y][g1x+1] = 'F' ;
             moved_right = true ; 
       } 
            
         
   }   

      /******************************* PERIPTWSH POU KINOUTAN PROS TA ARISTERA ********************************************************************************/ 
    else if ( moved_left == true )  {   
        
            // elegxos tou aristera tetragwnou                    // elegxos tou katw tetragwnou                  // elegxos tou apo panw tetragwnou
       if ( g1x == 0) { 
          aL[g1y][colomnsOfLevel-1] = 'F' ; 
          moved_left = true ;
          g1x = colomnsOfLevel-1 ;
       }    
        
        
       else if ( (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f') && (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G' || aL[g1y-1][g1x] == 'H' || aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') ) {                   
            if ( Movement.px-g1y <= 4  && Movement.px >= g1y  && Movement.py == g1x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if ( g1x - Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) {  
              if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }  
            else if ( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x ) {
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }  
            else if ( Movement.py - g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
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
        
       else if ( (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y+1][g1x] == '#') && (aL[g1y-1] [g1x]== ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y][g1x-1] == 'f')) {                   
            if ( g1x - Movement.py <=4  && g1x >= Movement.py  && Movement.px == g1y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( g1y - Movement.px <= 4 && g1y >= Movement.px && Movement.py == g1x ) {  
              if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( Movement.py - g1x <= 4 && Movement.py >= g1x && Movement.px == g1y  ) {
              if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }  
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }   
            else if( ghostMv2 == 1 ) {  
              MoveGhost("up") ; moved_left= false ; 
            }  
       }  
         
       else if ( (aL[g1y][g1x-1] == '#') && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f' ) && (aL[g1y-1] [g1x]== ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') ) {                   
            if ( Movement.px-g1y <= 4 && Movement.px >= g1y  && Movement.py == g1x ) {
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }
            }   
            else if( g1y - Movement.px <= 4 && g1y >= Movement.px  && Movement.py == g1x ) {  
               if ( !Movement.boosterActive ) { MoveGhost("up") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else if ( Movement.py-g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }  
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("down") ; moved_left= false ;
            }   
            else if( ghostMv2 == 1 ) {  
               MoveGhost("up") ; moved_left= false ; 
            }   
       }  
         
       else if ( (aL[g1y][g1x-1] == '#') && (aL[g1y+1][g1x] == '#') && (aL[g1y-1][g1x] == ' ' || aL[g1y-1][g1x] == '.' || aL[g1y-1][g1x] == 'O' || aL[g1y-1][g1x] == 'P' || aL[g1y-1][g1x] == 'G'|| aL[g1y-1][g1x] == 'H'|| aL[g1y-1][g1x] == 'J' || aL[g1y-1][g1x] == 'f') ) {  
            if ( Movement.py-g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("up") ; moved_left= false ; }  
            }   
            else {   
              MoveGhost("up") ; moved_left= false ; 
            }  
       }    
         
       else if ( (aL[g1y][g1x-1] == '#' ) && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f' ) && (aL[g1y-1][g1x] == '#') ) {  
            if ( Movement.py-g1x <= 4 && Movement.py >= g1x && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; }
            }   
            else {   
               MoveGhost("down") ; moved_left= false ;
            }  
       }  
         
       else if ( (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y+1][g1x] == '#' ) && (aL[g1y-1][g1x] == '#') ) {  
            if ( Movement.py-g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }  
            }   
            else {    
              MoveGhost("left") ; moved_left= true ;
            }  
       }   
        
       else if ( (aL[g1y][g1x-1] == ' ' || aL[g1y][g1x-1] == '.' || aL[g1y][g1x-1] == 'O' || aL[g1y][g1x-1] == 'P' || aL[g1y][g1x-1] == 'G'|| aL[g1y][g1x-1] == 'H'|| aL[g1y][g1x-1] == 'J' || aL[g1y][g1x-1] == 'f') && (aL[g1y+1][g1x] == ' ' || aL[g1y+1][g1x] == '.' || aL[g1y+1][g1x] == 'O' || aL[g1y+1][g1x] == 'P' || aL[g1y+1][g1x] == 'G'|| aL[g1y+1][g1x] == 'H'|| aL[g1y+1][g1x] == 'J' || aL[g1y+1][g1x] == 'f') && (aL[g1y-1][g1x]== '#') ) {                   
            if ( g1x - Movement.py <= 4 && g1x >= Movement.py  && Movement.px == g1y ) {
               if ( !Movement.boosterActive ) { MoveGhost("left") ; moved_left= true ; } else {MoveGhost("right") ; moved_left= false ; } 
            }   
            else if( Movement.px - g1y  <= 4 && Movement.px >= g1y   && Movement.py == g1x  ){  
               if ( !Movement.boosterActive ) { MoveGhost("down") ; moved_left= false ; } else {MoveGhost("down") ; moved_left= false ; } 
            }  
            else if ( Movement.py- g1x <= 4 && Movement.py >= g1x  && Movement.px == g1y  ) {
               if ( !Movement.boosterActive ) { MoveGhost("right") ; moved_left= false ; } else {MoveGhost("left") ; moved_left= true ; }
            }   
            else if ( ghostMv2 == 0 ) {
               MoveGhost("left") ; moved_left= true ;
            }
            else if( ghostMv2 == 1 ){  
              MoveGhost("down") ; moved_left= false ;
            } 
       }  
       
       else if ( g1x == g1_init_x && g1y == g1_init_y ) { 
             aL[g1y][g1x-1] = 'F' ;
             moved_left = true ;
       } 
       
       
         
         
      }     
     
    }  // telos if ( !g1_eat) 
    
    
        if (exec_once == 1) { aL[g1y][g1x]=' ' ; }
        else if (!Movement.g1_eat){
          if      (moved_up==true)     { g1y = g1y -1 ; } 
          else if (moved_down==true)   { g1y = g1y +1 ; }
          else if (moved_right==true && aL[g1y][0] != 'F'  )     { g1x = g1x + 1; }          // xreiazodai kai oi elegxoi gia tis periptwseis pou pernaei sthn adipera meria
          else if (moved_left==true  && aL[g1y][colomnsOfLevel-1] != 'F'  ) { g1x = g1x -1 ; } 
        }
        else { 
            g1y = g1_init_y ; 
            g1x = g1_init_x  ;    
            moved_right = true ; NullSetOthers() ;
        }
        
        
         Point currentPosition = new Point();
         currentPosition.x = g1x;
         currentPosition.y = g1y;
         
         Ghost_Animation ghost_anim = new Ghost_Animation(currentPosition, countSpeed(), 1, moved_up, moved_down, moved_left , moved_right);
     
       
       PacMan_Graphics.content.repaint();
           
    
    }     

    public static int countSpeed(){
        int cookiesEaten = counter.cookies - counter.cookiesRemaining;
        int countedSpeed;
        if(cookiesEaten > 0.6 * counter.cookies) {      // exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = fastSpeed1_BoosterActive;
            else countedSpeed = fastSpeed1;
        }
        else {                                          // den exoun fagothei to 60%
            if(Movement.boosterActive) countedSpeed = slowSpeed1_BoosterActive;
            else countedSpeed = slowSpeed1;
        }
        return countedSpeed;
    }


}