package pacman;
import java.io.*;
import java.awt.Point;
import javax.swing.JOptionPane;

public class arrayCreator implements constants
{

	public static int linesOfLevel = 0;      // 
	public static int colomnsOfLevel = 0;    // 
	public static int aL[][] ;               //
	protected static Point syntetagmenes;    //

	public arrayCreator(String levelFilename)
	{
		if(lengthOfLevel(levelFilename)){
			file2array(levelFilename);
		}
		syntetagmenes = getCoordinates(aL, PacmanPos);   //
	}

	public arrayCreator()
	{
	}

	/*
	 * 
	 */
	private static boolean lengthOfLevel(String filename) //
	{
		try {
			FileReader level = new FileReader(filename);
			BufferedReader buff = new BufferedReader(level);
			boolean eof = false;
			for(linesOfLevel = 0; !eof; linesOfLevel++)
			{
				String line = buff.readLine();
				if(line == null){
					eof = true;
					linesOfLevel--;     //
				}
				else if(colomnsOfLevel < line.length())
					colomnsOfLevel = line.length();
			}
			buff.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Congratulations, you have beaten the fantoms and ate all the cookies in the world !! What a hunger!!!");
			Score.slevel = 1;

			PacMan_Graphics mainWindow = new PacMan_Graphics("level" + Score.slevel + ".txt"); //
			return false;
		}
		return true;
	}

	/*
	 * 
	 */
	private int[][] file2array(String filename)
	{
		aL = new int[linesOfLevel][colomnsOfLevel + 1];   //
		try {
			FileReader text = new FileReader (filename) ;  // 
			int c;
			int i, j;
			for (i = 0; i < linesOfLevel; i++){
				for (j = 0; j < colomnsOfLevel + 1; j++)  {
					c = text.read();
					if(c == '\n'){
						c = text.read();
					}
					aL[i][j] = c;
					//System.out.print((char)aL[i][j]);
				}
			}
			text.close();
		}
		catch ( IOException e) { // FileNotFound or EOF Exception
		}
		return aL;
	}

	/*
	 * 
	 */
	private static Point getCoordinates(int[][] array, char wanted1)    //
	{   
		Point coordinates = new Point();
		int ver = 0, hor = 0;

		for (int i = 0 ; i < arrayCreator.linesOfLevel; i++)
			for (int j=0 ; j < arrayCreator.colomnsOfLevel ; j++)  {
				if (array[i][j]==wanted1) { coordinates.x = i ; coordinates.y = j ; }
				if (array[i][j]=='F') { Ghost_Movement_1.g1_init_x = j ; Ghost_Movement_1.g1x = j  ; Ghost_Movement_1.g1_init_y = i ; Ghost_Movement_1.g1y=i ;}
				if (array[i][j]=='G') { Ghost_Movement_2.g2_init_x = j ; Ghost_Movement_2.g2x = j ;  Ghost_Movement_2.g2_init_y = i ; Ghost_Movement_2.g2y=i ; }
				if (array[i][j]=='H') { Ghost_Movement_3.g3_init_x = j ; Ghost_Movement_3.g3x = j ;  Ghost_Movement_3.g3_init_y = i ; Ghost_Movement_3.g3y=i ; } 
				if (array[i][j]=='J') { Ghost_Movement_4.g4_init_x = j ; Ghost_Movement_4.g4x = j ;  Ghost_Movement_4.g4_init_y = i ; Ghost_Movement_4.g4y=i ; }  // mhn rwthsete giati einai anapoda - giati mporun
			}

		return coordinates;
	}

	public static void printArray()
	{
		int i, j;
		for (i=0 ; i<22 ; i++){               
			for (j=0 ; j<20 ; j++) {
			}
		}
	}
}
