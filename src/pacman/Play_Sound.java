package pacman;

import javax.sound.midi.* ;
import java.io.File ;


public class Play_Sound {

  public static Sequencer sound_player ;
  public static Sequence currentSound ;
  public static  File eating = new File ( "sounds/eating.mid");
  public static  File intro  = new File ( "sounds/intro.mid");
  public static  File die    = new File ( "sounds/die.mid");   
   
public static void run_Sound(File soundfile) {
try { 
 
   
   sound_player = MidiSystem.getSequencer();
   sound_player.open() ;                     
   currentSound= MidiSystem.getSequence(soundfile) ; 
   sound_player.setSequence(currentSound) ;
   sound_player.start() ;
  } 
catch ( Exception exc ) { System.out.println ( " Error: " + exc.getMessage() ) ;  }


}    
 

  
}