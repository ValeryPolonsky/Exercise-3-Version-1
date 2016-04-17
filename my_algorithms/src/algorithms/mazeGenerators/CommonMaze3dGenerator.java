package algorithms.mazeGenerators;

public abstract class CommonMaze3dGenerator implements Maze3dGenerator {

	/**
	 * Abstract function that must be implemented in extended class
	 * @param x - Length of the maze
	 * @param y - Height of the maze
	 * @param z - Width of the maze
	 */
	@Override
	public abstract Maze3d generate(int x,int y,int z);
		

	/**
	 * Measures the time that take to algorithm to work
	 * @param x - Length of the maze
	 * @param y - Height of the maze
	 * @param z - Width of the maze
	 */
	@Override
	public String measureAlgorithmTime(int x,int y,int z) {
		long start=0;
		long finish=0;
		start=System.nanoTime();
		this.generate(x,y,z);
		finish=System.nanoTime();
		String str = "The running time is: "+(Long.toString(finish-start))+" nano-seconds";
		return str;
	}

}
