package pacman;

import java.util.Random;

class Fruit implements Runnable
{
               
    public Fruit()
    {
        Thread fruit_thread = null;
        fruit_thread = new Thread(this);
        fruit_thread.start();        
    } 
   
    public void run() { 
        
       boolean fruit_found = false ;
       int i=0,j=0 ;
       
       
       Random generator = new Random();
       int random_fruit ; 
       
       
      while ( fruit_found == false ) {
        for ( i = 0; i < arrayCreator.linesOfLevel ; i++) {          
           if (fruit_found == true) { i-- ; break ; }
           for ( j = 0; j < arrayCreator.colomnsOfLevel ; j++) { 
                random_fruit = generator.nextInt(15);  
                if ( (counter.aL[i][j]==' ') && (random_fruit ==1 ) ) {     // uparxei 1/16 pi8anothta otan brei ena keno na balei to fruto
                    counter.aL[i][j]='f'; 
                    fruit_found=true;  break ;
                }
                    
           }
        } 
      } 
       
      
        
        
        if ( Movement.fruitActive== true  ) {  
          try {
            
             Thread.sleep(5000);                    // to fruto 8a menei gia 5 deuterolepta sthn pista
         } catch (InterruptedException ie) {} 
        }
         
      
      Movement.fruitActive= false ;
      counter.aL[i][j]=' ';        
    
    }
 


}