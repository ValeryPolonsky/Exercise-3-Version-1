package algorithms.mazeGenerators;

import java.util.Random;

/**
 * Generates a 3D maze by using "recursion division algorithm".<br>
 * Each level is generated separately.<br>
 * Each level represented as 2D maze.<br>
 * Level - cross section by Y axis.
 * @author Valery Polonsky
 */
public class MyMaze3dGenerator extends CommonMaze3dGenerator {

	/* THE ALGORITHM THAT HAS BEEN USED IS - RECURSIVE DIVISION MAZE GENERATION ALGORITHM */
	@Override
	public Maze3d generate(int x, int y, int z) {
		
		Maze3d maze3d=new Maze3d(x,y,z);//Generates a new empty maze
		for(int i=1;i<y-1;i++)
		{
			Maze3d maze2d=new Maze3d(x,1,z);//Generates a new empty 2D maze
			
			//Sets the inside value to - 0 to make it empty
			for(int m=1;m<x-1;m++)
			{
				for(int l=1;l<z-1;l++)
				{
					maze2d.setPointValue(m, 0, l, 0);
				}
			}
			
			//Generates a 2D maze
			generate2dMaze(maze2d,x-2,z-2,1,1);
			
			//Copy the generated 2D maze to the suitable level in 3D maze 
			for(int j=0;j<x;j++)
			{
				for(int k=0;k<z;k++)
				{
					maze3d.setPointValue(j, i, k, maze2d.getPointValue(j, 0, k));
				}
			}
		}
		//Sets exit and entrance to the 3D maze
		setExitEntrance(maze3d,x,y,z);
		
		return maze3d;
	}
	
	/**
	 * Sets start position and goal position in the maze
	 * @param maze - 3D Maze where positions have to be set
	 * @param x - Position according to X axis
	 * @param y - Position according to Y axis
	 * @param z - Position according to Z axis
	 */
	private void setExitEntrance(Maze3d maze, int x,int y, int z)
	{
		maze.setStartPosition(0, 1, 1);//Sets the entrance position
		maze.setGoalPosition(x-1, y-2, z-2);//Sets the exit position
	}
	
	/**
	 * Generates a 2D maze according to given parameters
	 * @param maze - Empty 2D maze where a new maze has to be generated
	 * @param x - Length of the maze
	 * @param z - Width of the maze
	 * @param start_x - Start position according to X axis
	 * @param start_z - Start position according to Z axis
	 */
	private void generate2dMaze(Maze3d maze,int x,int z, int start_x,int start_z)
	{
		int rnd_wall=0;
		if((x<2||z<2)||(x==2&&z==2))
		{
			return;
		}
		else
		{
			if(x>z)//Builds a horizontal wall when width is smaller then length
			{	
				 //Generates a random wall
				 rnd_wall= buildWall(maze,x,z,start_x,start_z);
				 //Continues the generations of the maze with recursion
				 generate2dMaze(maze,rnd_wall-start_x,z,start_x,start_z);
				 generate2dMaze(maze,start_x+x-rnd_wall-1,z,rnd_wall+1,start_z);
			}
			else//Builds a vertical wall when width is greater then length
			{
				//Generates a random wall
				rnd_wall= buildWall(maze,x,z,start_x,start_z);
				//Continues the generations of the maze with recursion
				generate2dMaze(maze,x,rnd_wall-start_z,start_x,start_z);
				generate2dMaze(maze,x,start_z+z-rnd_wall-1,start_x,rnd_wall+1);
			}
			
		}
	}
	
	/**
	 * Builds a random wall in the given range of positions<br>
	 * Horizontal and Vertical walls can be built.
	 * @param maze - 2D maze where wall has to be built
	 * @param x - Length of the maze
	 * @param z - Width of the maze
	 * @param start_x - Start position according to X axis
	 * @param start_z - Start position according to Z axis
	 * @return Position of the built wall according to X axis or Z axis
	 */
	private int buildWall(Maze3d maze,int x,int z,int start_x,int start_z)
	{
		int min,max,range;
		int rnd_wall=0;
		if(x>z)//Generates and build random horizontal wall when width is smaller then length
		{
			Random r = new Random();
			min=start_x+1;
			max=start_x+x-1;
			range=max-min;//The range where wall can be placed
			//Generation of the index where wall will be placed
			rnd_wall= r.nextInt(range) + (min);
			//Building the wall in the given range with generated index
			for(int i=0;i<z;i++)
			{
				maze.setPointValue(rnd_wall, 0, start_z+i, 1);
			}
			setValidExit(maze,rnd_wall,x,z,start_x,start_z);
		}
		else//Generates and build random vertical wall when width is greater then length
		{
			Random r = new Random();
			min=start_z+1;
			max=start_z+z-1;
			range=max-min;//The range where wall can be placed
			//Generation of the index where wall will be placed
			rnd_wall= r.nextInt(range) + (min);
			//Building the wall in the given range with generated index
			for(int i=0;i<x;i++)
			{
				maze.setPointValue(start_x+i, 0, rnd_wall, 1);
			}
			setValidExit(maze,rnd_wall,x,z,start_x,start_z);
		}
		return rnd_wall;
	}
	
	/**
	 * Sets valid exit on the generated wall
	 * @param maze - 2D maze where wall is built
	 * @param wall - Position of the wall in maze
	 * @param x - Length of the maze
	 * @param z - Width of the maze
	 * @param start_x - Start position according to X axis
	 * @param start_z - Start position according to Z axis
	 */
	private void setValidExit(Maze3d maze, int wall, int x, int z, int start_x,int start_z)
	{
		int min;
		int max;
		int range;
		boolean set_used=false;
		int rnd_exit=0;
		//Checks if the generated wall doesn't block any other exit in the maze
		if(x>z)//Checks horizontal wall
		{
			//Checks the ends of the wall
			if(maze.getPointValue(wall, 0, start_z-1)==0)
			{
			    maze.setPointValue(wall, 0, start_z,0);
			    set_used=true;
			}
			if(maze.getPointValue(wall, 0, start_z+z)==0)
			{
			    maze.setPointValue(wall, 0, start_z+z-1,0);
			    set_used=true;
			}
			//If ends of the wall don't block any exit,
			//exit is generated randomly on the wall
			if(set_used==false)
			{
				min=start_z;
				max=start_z+z;
				range=max-min;
				Random r = new Random();
				rnd_exit= r.nextInt(range) + (min);
				maze.setPointValue(wall, 0, rnd_exit, 0);
			}
		}
		else//Checks vertical wall
		{
			//Checks the ends of the wall
			if(maze.getPointValue(start_x-1, 0, wall)==0)
			{
			    maze.setPointValue(start_x, 0, wall,0);
			}
			if(maze.getPointValue(start_x+x, 0, wall)==0)
			{
			    maze.setPointValue(start_x+x-1, 0, wall,0);
			}
			//If ends of the wall don't block any exit,
			//exit is generated randomly on the wall
			if(set_used==false)
			{
				min=start_x;
				max=start_x+x;
				range=max-min;
				Random r = new Random();
				rnd_exit= r.nextInt(range) + (min);
				maze.setPointValue(rnd_exit, 0, wall, 0);
			}
		}
	}
	
}
