package pacman;

import java.awt.* ;
import javax.swing.* ;
import java.awt.geom.* ;

public class MazePane extends JPanel implements constants {                                 

    public static Image pacmanImage;
    
    
    public static ImageIcon pacmanlives = new ImageIcon("images/pacman.gif");
    public static Image lives_icon = pacmanlives.getImage();
    
    public static ImageIcon fruitIcon = new ImageIcon("images/cherry.gif") ;
    public static Image fruit_img = fruitIcon.getImage();
    
    public static Image Ghost1_Image;  
    public static Image Ghost2_Image;
    public static Image Ghost3_Image;
    public static Image Ghost4_Image;
    
    public static int pacmanx, pacmany;               
    
    public static int ga1x, ga1y;               /*oi suntetagmenes autes allazoun apo thn Ghost_Animation*/
    public static int ga2x, ga2y;               /*                                                       */
    public static int ga3x, ga3y;               /*                                                       */
    public static int ga4x, ga4y;               /*        wste na ginetai to animation twn Ghosts        */

    public void paintComponent (Graphics comp) {                     // uperskelish ths paintComponent 
         Graphics2D comp2D = (Graphics2D)comp ;                       // allagh tupou tou adikeimenu se 2D
         float RectCenter = (float)(12 - 4*1.4/2) ;   // Euresh tou kentru tou tetragwnu gia tis teleies: Einai to kentro (+12) - to miso ths upoteinusas ths teleias
                                                    // h opoia brisketai efarmozodas to Pu8agoreio 8ewrhma sto tetragwno (dot) pou thn apeikonizei
         
         BasicStroke pen = new BasicStroke( 1F, BasicStroke.CAP_BUTT , BasicStroke.JOIN_ROUND );               // orismos penas zwgrafikhs
         comp2D.setStroke(pen);
         
         int i,j ;
         int[][] array = arrayCreator.aL;
         
         for (i = 0 ; i < arrayCreator.linesOfLevel; i++)
           for ( j=0 ; j < arrayCreator.colomnsOfLevel ; j++)  {
                comp2D.setColor(Color.white) ;          
          //      Rectangle2D.Float test = new Rectangle2D.Float( (float)j*24 , (float)i*24 , 24F, 24F ) ;   // to plegma . kanonika den fainetai sto paixnidi
          //      comp2D.draw(test) ;
                
                      if ( array[i][j] == wall) {                 // sxediash twn adiaperastwn toixwmatwn ths pistas
                         if (!Movement.boosterActive) comp2D.setColor(Color.blue) ;   // allagh xrwmatos 
                          else comp2D.setColor(Color.red) ;
                          Rectangle2D.Float wall = new Rectangle2D.Float( (float)(j*24) , (float)(i*24) , 24F, 24F ) ;
                          comp2D.fill(wall) ;  }  
                      if ( array[i][j] == food) {                    // sxediash twn cookies
                          comp2D.setColor(Color.white) ;
                          Rectangle2D.Float dot = new Rectangle2D.Float( (float)((j*24)+RectCenter) , (float)((i*24)+RectCenter) , 4F, 4F ) ;
                          comp2D.fill(dot) ;  
                        }
                      if ( array[i][j] == booster) {                // oi sudetagmenes ths eleipshs (kuklu edw) orizun ena panw aristera akro - giauto gia na ton 
                          comp2D.setColor(Color.white) ;        //  balume sto kentro pros8etume 12 (kentro tetragwnu) kai afairume thn aktina tou 
                          Ellipse2D.Float dot = new Ellipse2D.Float( (float)((j*24)+12-4) , (float)((i*24)+12-4) , 8F, 8F ) ;   
                          comp2D.fill(dot) ;  
                        } 
                      if ( array[i][j] == fantomExit) {               // h eksodos twn fadasmatwn 
                          comp2D.setColor(Color.green) ;        
                          Line2D.Float exit = new Line2D.Float( (float)((j*24)) , (float)((i*24)+12) , (float)((j*24)+24) , (float)((i*24)+12) ) ;   
                          comp2D.draw(exit) ;  
                        } 
                      if ( array[i][j] == PacmanPos) {               // o pacman
                            ((Graphics)comp2D).drawImage ( pacmanImage, pacmanx , pacmany, this ) ;  // me auto to statement sxediazetai "statika" o Pacman
                           /* ousiastika methodos h opoia dinei ths syntetagmenes ths PacmanPos wste autos na sxediastei me to katallhlo animation */
//                           getPacmanPos();
                              
                        }
                      if ( array[i][j] == ghost1)                                           // ta fantasmatakia
                         ((Graphics)comp2D).drawImage ( Ghost1_Image, ga1x , ga1y, this ) ; 
                      if ( array[i][j] == ghost2)                                           // ta fantasmatakia
                         ((Graphics)comp2D).drawImage ( Ghost2_Image, ga2x , ga2y, this ) ;
                      if ( array[i][j] == ghost3)                                           // ta fantasmatakia
                         ((Graphics)comp2D).drawImage ( Ghost3_Image, ga3x , ga3y, this ) ;
                      if ( array[i][j] == ghost4)                                           // ta fantasmatakia
                         ((Graphics)comp2D).drawImage ( Ghost4_Image, ga4x , ga4y, this ) ;
                         
                      if ( array[i][j] == fruit) {    
                         ((Graphics)comp2D).drawImage ( fruit_img, j*24 , i*24, this ) ;
                       }
                      
  
                    }
                 for (int c = 0; c < Score.lives; c++) {
                    ((Graphics)comp2D).drawImage ( lives_icon,  posPixel * (c + 2),posPixel * (arrayCreator.linesOfLevel + 1) , this ) ;
                }
                
}
}