package algorithms.mazeGenerators;

/**
 * Represents a common interface functionality of maze generators
 * @author Valery Polonsky
 *
 */
public interface Maze3dGenerator {
	public Maze3d generate(int x,int y,int z);
	public String measureAlgorithmTime(int x,int y,int z);
}
