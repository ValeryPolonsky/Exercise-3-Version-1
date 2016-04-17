package algorithms.mazeGenerators;

/**
 * Creates a new empty maze.<br>
 * Maze represented as three dimensional array of integer values.<br>
 * Each value is from the group {0,1}.<br>
 * 0 - Represents an empty place.<br>
 * 1 - Represents a wall.
 * @author Valery Polonsky.
 */
public class Maze3d implements Maze{
	private int[][][] maze3d;//x-axis,y-axis,z-axis
	private int length;
	private int width;
	private int height;
	Position start_p;//Start position
	Position goal_p;//Goal position
	
	/**
	 * Constructor that creates an empty maze with given parameters
	 * @param x - Length of the maze
	 * @param y - Height of the maze
	 * @param z - Width of the maze
	 */
	public Maze3d(int x,int y,int z) {
		length=x;//length of the maze
		width=z;//width of the maze
		height=y;//height of the maze
		
		maze3d=new int[x][y][z];//Generates a 3 dimensional array, that
		//will express a 3D maze
		
		//Setting all values of the array to zero
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				for(int k=0;k<z;k++)
				{
					maze3d[i][j][k]=0;
				}
			}
		}
		
		//Setting first and last x/y planes to 1, 
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				maze3d[i][j][0]=1;
				maze3d[i][j][z-1]=1;
			}
		}
		
		//Setting first and last x/z planes to 1, 
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<z;j++)
			{
				maze3d[i][0][j]=1;
				maze3d[i][y-1][j]=1;
			}
		}
		
		//Setting first and last y/z planes to 1, 
		for(int i=0;i<y;i++)
		{
			for(int j=0;j<z;j++)
			{
				maze3d[0][i][j]=1;
				maze3d[x-1][i][j]=1;
			}
		}
			
	}
	
	/**
	 * Sets the given value to the specified position in the maze
	 * @param x - Position according to x axis
	 * @param y - Position according to y axis
	 * @param z - Position according to z axis
	 * @param value - Value that has to be set at the position
	 */
	public void setPointValue(int x,int y,int z,int value)
	{
		maze3d[x][y][z]=value;
	}
	
	/**
	* Returns the value from the given position in the maze
	* @param x - Position according to x axis
	* @param y - Position according to y axis
	* @param z - Position according to z axis
	* @return Value at the given position
	*/
    public int getPointValue(int x,int y,int z)
    {
    	return maze3d[x][y][z];
    }
    
    /**
     * Returns the length of the maze
     * @return Length of the maze
     */
    public int getLength()
    {
    	return length;
    }
    
    /**
     * Returns the width of the maze
     * @return Width of the maze
     */
    public int getWidth()
    {
    	return width;
    }
    
    /**
     * Returns the height of the maze
     * @return Width of the maze
     */
    public int getHeight()
    {
    	return height;
    }
    
    /**
     * Returns the start position in the maze
     * @return Start position in the maze
     */
    public Position getStartPosition()
    {
    	return start_p;
    }
    
    /**
     * Sets start position in the maze
     * @param x - Position according to x axis
	 * @param y - Position according to y axis
	 * @param z - Position according to z axis
     */
    public void setStartPosition(int x,int y,int z)
    {
    	setPointValue(x,y,z,0);
    	start_p=new Position(x,y,z);
    }
    
    
    /**
     * Returns all possible moves from the given position
     * @param p - Position to get all possible moves from
     * @return Array of positions of String type
     */
    public String[] getPossibleMoves(Position p)
    {
    	String[]moves=new String[6];
    	Position temp;
    	int index=0;
    	//Checks if there is path to right
    	if((p.getX()<length-1)&&maze3d[(p.getX()+1)][p.getY()][p.getZ()]==0)
    	{
    		temp=new Position(p.getX()+1,p.getY(),p.getZ());
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Checks if there is path to left
    	if((p.getX()>0)&&maze3d[(p.getX()-1)][p.getY()][p.getZ()]==0)
    	{
    		temp=new Position(p.getX()-1,p.getY(),p.getZ());
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Checks if there is path to up
    	if((p.getY()<height-1)&&maze3d[p.getX()][p.getY()+1][p.getZ()]==0)
    	{
    		temp=new Position(p.getX(),p.getY()+1,p.getZ());
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Checks if there is path to down
    	if((p.getY()>0)&&maze3d[p.getX()][p.getY()-1][p.getZ()]==0)
    	{
    		temp=new Position(p.getX(),p.getY()-1,p.getZ());
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Checks if there is path forward
    	if((p.getZ()<width-1)&&maze3d[p.getX()][p.getY()][p.getZ()+1]==0)
    	{
    		temp=new Position(p.getX(),p.getY(),p.getZ()+1);
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Checks if there is path backward
    	if((p.getZ()>0)&&maze3d[p.getX()][p.getY()][p.getZ()-1]==0)
    	{
    		temp=new Position(p.getX(),p.getY(),p.getZ()-1);
    		moves[index]=temp.getPosition();
    		index++;
    	}
    	//Removes null value from the array
    	int length=0;
    	for(int i=0;i<6;i++)
    	{
    		if(moves[i]!=null)
    			length++;
    	}
    	String[]moves1=new String[length];
    	for(int i=0;i<length;i++)
    	{
    		moves1[i]=moves[i];
    	}
    	return moves1;
    }
    
    
    
    /**
     * Returns goal position in the maze
     * @return Goal position in the maze
     */
    public Position getGoalPosition()
    {
    	return goal_p;
    }
    
    /**
     * Sets the goal position in the maze
     * @param x - Position according to x axis
	 * @param y - Position according to y axis
	 * @param z - Position according to z axis
     */
    public void setGoalPosition(int x,int y,int z)
    {
    	setPointValue(x,y,z,0);
    	goal_p=new Position(x,y,z);
    }
    
    /**
     * Returns cross section by given X axis
     * @param x - Position according to X axis
     * @return Two dimensional array of integers
     * @throws Exception IndexOutOfBoundsException <br>If input value is negative<br>
     * If input value is greater than length of the maze
     */
    public int[][] getCrossSectionByX(int x) throws Exception
    {
    	//Throws exceptions if the given index is out of range
    	if(x<0)
    		throw new IndexOutOfBoundsException("The input x-axis value must be a non-negative number");
    	if(x>length-1)
    		throw new IndexOutOfBoundsException("The input x-axis value must be smaller than "+length);
    	int [][]crossSection=new int[height][width];//Array where cross section is placed
    	
    	//Sets the cross section to the array
    	for(int y=0;y<height;y++)
    	{
    		for(int z=0;z<width;z++)
    		{
    			crossSection[y][z]=maze3d[x][y][z];
    		}
    	}
    	return crossSection;
    }
    

	
    /**
     * Returns cross section by given Y axis
     * @param y - Position according to Y axis
     * @return Two dimensional array of integers
     * @throws Exception IndexOutOfBoundsException <br> If input value is negative<br>
     * If input value is greater than height of the maze
     */
    public int[][] getCrossSectionByY(int y)throws Exception
    {
    	//Throws exceptions if the given index is out of range
    	if(y<0)
    		throw new IndexOutOfBoundsException("The input y-axis value must be a non-negative number");
    	if(y>height-1)
    		throw new IndexOutOfBoundsException("The input y-axis value must be smaller than "+height);
    	int [][]crossSection=new int[length][width];//Array where cross section is placed
    	
    	//Sets the cross section to the array
    	for(int x=0;x<length;x++)
    	{
    		for(int z=0;z<width;z++)
    		{
    			crossSection[x][z]=maze3d[x][y][z];
    		}
    	}
    	return crossSection;
    }
    
    /**
     * Returns cross section by given Z axis
     * @param z - Position according to Z axis
     * @return Two dimensional array of integers
     * @throws Exception IndexOutOfBoundsException <br> If input value is negative<br>
     * If input value is greater than width of the maze
     */
    public int[][] getCrossSectionByZ(int z)throws Exception
    {
    	//Throws exceptions if the given index is out of range
    	if(z<0)
    		throw new IndexOutOfBoundsException("The input x-axis value must be a non-negative number");
    	if(z>width-1)
    		throw new IndexOutOfBoundsException("The input x-axis value must be smaller than "+width);
    	int [][]crossSection=new int[length][height];//Array where cross section is placed
    	
    	//Sets the cross section to the array
    	for(int x=0;x<length;x++)
    	{
    		for(int y=0;y<height;y++)
    		{
    			crossSection[x][y]=maze3d[x][y][z];
    		}
    	}
    	return crossSection;
    }
}
