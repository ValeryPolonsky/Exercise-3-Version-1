package algorithms.mazeGenerators;

/**
 * Represents a position in maze by using {x,y,z} values
 * @author Valery Polonsky
 *
 */
public class Position{
	int x,y,z;
	
	/**
	 * Creates a default position {0,0,0}
	 */
	public Position() {
		x=0;
		y=0;
		z=0;
	}
	
	/**
	 * Creates a position with given values
	 * @param x - Value of X axis
	 * @param y - Value of Y axis
	 * @param z - Value of Z axis
	 */
	public Position(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/**
	 * Returns position in format {x,y,z}
	 * @return Position as string
	 */
	public String getPosition()
	{
		String str;
		str=("{"+x+","+y+","+z+"}");
		return str;
	}
	
	/**
	 * Returns x value of the this position
	 * @return x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x value in this position
	 * @param x - Value to be set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns y value of the this position
	 * @return y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y value in this position
	 * @param y - Value to be set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns z value of the this position
	 * @return z value
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z value in this position
	 * @param z - Value to be set
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Overriding the function toString in order to use print function in main
	 */
	public String toString()
	{
		return this.getPosition();
	}
	
	/**
	 * Converts string value to position value
	 * @param position - String position to be converted
	 * @return Position position
	 */
	public Position toPosition(String position)
	{
		int xyz[]=new int[3];
		String str=position.substring(1, position.length()-1);
		String[]retval=str.split(",");
		for(int i=0;i<retval.length;i++)
		{
			xyz[i]=Integer.parseInt(retval[i]);
		}
		Position p=new Position(xyz[0],xyz[1],xyz[2]);
		return p;
	}
	
	
}
