package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PacMan_Graphics extends JFrame implements KeyListener, ActionListener , constants
{
	static int currentDirection = KeyEvent.VK_KP_LEFT;
	public static Container content;
	public static JButton start;
	private static JLabel scorelabel = new JLabel();
	private static JLabel highScoreLabel = new JLabel();
	protected static JLabel[] livesLabel;
	protected static JPanel Down;

	public PacMan_Graphics(String level)
	{
		super("CEID_PacMan");
		content = getContentPane();
		//this.requestFocusInWindow();
		//requestFocusInWindow();
		this.addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		content.setLayout(new BorderLayout(0,30));
		addUpPart();
		addDownPart();
		// start.addActionListener(this);
		addLevel(level);
		//content.requestFocusInWindow(); // nothing has the focus
		//KeyboardFocusManager n = new KeyboardFocusManager();
		//n.focusNextComponent(start);
		content.setBackground(Color.black);
		setSize(posPixel * arrayCreator.colomnsOfLevel + 10, posPixel * arrayCreator.linesOfLevel + 150);
		setLocationRelativeTo(null);
		setVisible(true);
		Store.showHScore("score.txt");
	}


	public static void Initial_Things () {
		Ghost_Movement_1.moved_left = true ;    
		Ghost_Movement_1.exec_once = 0 ;
		Ghost_Movement_2.exec_once = 0 ;
		Ghost_Movement_3.exec_once = 0 ;
		Ghost_Movement_4.exec_once = 0 ;
	}   


	public void addLevel(String level){
		//       JPanel Center = new JPanel();  // kentro
		//       Center.setBackground(Color.black);
		//       KeyboardFocusManager.clearGlobalFocusOwner(); // noone has the focus
		//       requestFocusInWindow();
		arrayCreator pinakas = new arrayCreator(level);
		counter count = new counter();
		Movement.px = counter.syntetagmenes.x ;
		Movement.py = counter.syntetagmenes.y ; 
		MazePane maze = new MazePane();
		MazePane.pacmany = arrayCreator.syntetagmenes.x * 24;
		MazePane.pacmanx = arrayCreator.syntetagmenes.y * 24;
		maze.repaint();
		//requestFocusInWindow();
		content.add("Center",maze);
		//maze.requestFocus(true);
	}

	public static void addUpPart(){
		JPanel Up = new JPanel(new GridLayout(1,2));
		Up.setBackground(Color.gray);
		scorelabel.setText("Score: " + Score.score);
		Up.add(scorelabel);
		highScoreLabel.setText("High Score: " + Score.score);
		Up.add(highScoreLabel);
		content.add("North",Up);
		//Up.repaint();
	}

	public static void displayScores(int score, int highscore){
		scorelabel.setText("Score: " + score);
		highScoreLabel.setText("High Score: " + highscore);
	}

	public static void addDownPart(){
		start = new JButton("Έναρξη!!!");
		livesLabel = new JLabel[Score.lives];
		for(int i = 0; i < Score.lives; i++) { 
			livesLabel[i] = new JLabel(new ImageIcon("images/pacman.gif"));
		}
		Down = new JPanel(new GridLayout(1,2,150,0));
		Down.setBackground(Color.black);
		JPanel Downleft = new JPanel();
		Downleft.setBackground(Color.black);
		for(int i=0; i < Score.lives; i++)
			Downleft.add(livesLabel[i]);
		Down.add(Downleft);
		//Down.add(start);
		//content.add("South",Down);
	}

	public void keyPressed(KeyEvent e)
	{   
		boolean executed = false;
		int buffer = e.getKeyCode();


		switch(buffer){
		case KeyEvent.VK_UP : {executed = Movement.moveup() ; 
		if(executed) currentDirection = buffer; break;}
		case KeyEvent.VK_DOWN : {executed = Movement.movedown() ; 
		if(executed) currentDirection = buffer; break;}
		case KeyEvent.VK_LEFT : {executed = Movement.moveleft(); 
		if(executed) currentDirection = buffer; break;}
		case KeyEvent.VK_RIGHT : {executed = Movement.moveright(); 
		if(executed) currentDirection = buffer;  break;}
		default: 
		}
		if (!executed) switchdir();


		if ( (Movement.py == Ghost_Movement_1.g1x && Movement.px == Ghost_Movement_1.g1y) ) { Movement.moving ( Movement.dirgoing , ghost1 ) ; }
		if ( (Movement.py == Ghost_Movement_2.g2x && Movement.px == Ghost_Movement_2.g2y) ) { Movement.moving ( Movement.dirgoing , ghost2 ) ; }
		if ( (Movement.py == Ghost_Movement_3.g3x && Movement.px == Ghost_Movement_3.g3y) ) { Movement.moving ( Movement.dirgoing , ghost3 ) ; }
		if ( (Movement.py == Ghost_Movement_4.g4x && Movement.px == Ghost_Movement_4.g4y) ) { Movement.moving ( Movement.dirgoing , ghost4 ) ; }

		if ( counter.cookiesRemaining < 8) { counter count = new counter(); }
	}     

	public static void switchdir() {
		switch(currentDirection) {
		case KeyEvent.VK_UP : {Movement.moveup(); break;}
		case KeyEvent.VK_DOWN : {Movement.movedown(); break;}
		case KeyEvent.VK_LEFT : {Movement.moveleft(); break;}
		case KeyEvent.VK_RIGHT : {Movement.moveright(); break;}
		}
	}
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}

	public void actionPerformed(ActionEvent evt)
	{
		System.out.println("actionPerformed");
	}

}