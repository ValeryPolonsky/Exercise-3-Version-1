package algorithms.mazeGenerators;
import java.util.Random;

/**
 * Simple 3D maze generator.<br>
 * Uses random() function for each position in the maze, to chose the number from group {0,1}
 * @author Valery Polonsky
 *
 */
public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	/**
	 * Generates a simple maze according to given values
	 * @param x - Length of the maze
	 * @param y - Height of the maze
	 * @param z - Width of the maze
	 */
	@Override
	public Maze3d generate(int x,int y,int z) {
		
		Maze3d maze=new Maze3d(x,y,z);
		int x_start, y_start,z_start;
		int x_current, y_current, z_current;
		int value;
		
		Random r = new Random();
		x_start = r.nextInt(x-2) + 1;//Generates x-axis start point
		y_start = r.nextInt(y-2) + 1;//Generates y-axis start point
		z_start=0;
		
		maze.setStartPosition(x_start, y_start, z_start);
		maze.setGoalPosition(x_start, y_start, z-1);
		//Genarates a random maze
		for(int i=1;i<x-1;i++)
		{
			for(int j=1;j<y-1;j++)
			{
				for(int k=1;k<z-1;k++)
				{
					value=r.nextInt(2)+0;
					maze.setPointValue(i,j,k,value);
				}
			}
		}
		
		
		x_current=x_start;
		y_current=y_start;
		z_current=z_start;
		while(true)//Build a path through the maze
		{
			if(z_current<z-1)
			{
				maze.setPointValue(x_current, y_current, z_current+1, 0);
				z_current++;
			}
			else
			{
				break;
			}
		}
		
		return maze;
	}

}
