package pacman;

public class Main {

	public static void main(String[] args) {
		PacMan_Graphics mainWindow = new PacMan_Graphics("level" + Score.slevel + ".txt");
		PacMan_Graphics.Initial_Things() ;
		Ghost_ContinuousMovement startMovingGhosts = new Ghost_ContinuousMovement();
		Play_Sound.run_Sound(Play_Sound.intro) ;

	}

}
