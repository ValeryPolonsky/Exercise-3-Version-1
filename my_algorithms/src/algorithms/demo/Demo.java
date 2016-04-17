package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class Demo {
	@SuppressWarnings("rawtypes")
	/**
	 * Tests the given searching algorithm on a given "graph"
	 * @param searcher - Searching algorithm
	 * @param searchable - Graph where algorithm will work
	 * @return - Solution of the algorithm
	 */
	private Solution testSearcher(Searcher searcher, Searchable searchable){
		 Solution solution=searcher.Search(searchable);
		 return solution;
	}

	/**
	 * Runs the tests of BFS and DFS algorithms
	 */
	public void run()
	{
		Demo demo=new Demo();
		Maze3dGenerator mg=new MyMaze3dGenerator();
		Solution solution1=new Solution();
		Solution solution2=new Solution();
		Maze3d maze3d=mg.generate(15,15,15);
		try {
			demo.printMaze(maze3d);
			solution1=demo.testSearcher(new BFS(), new Maze3DSearchable(maze3d));
			solution2=demo.testSearcher(new DFS(), new Maze3DSearchable(maze3d));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("*********************************");
		System.out.println("***** TEST OF BFS ALGORITHM *****");
		System.out.println("*********************************");
		System.out.println("Number of paths: "+solution1.size());
		System.out.println(solution1);
		System.out.println();
		System.out.println("*********************************");
		System.out.println("***** TEST OF DFS ALGORITHM *****");
		System.out.println("*********************************");
		System.out.println("Number of paths: "+solution2.size());
		System.out.println(solution2);
	}
	
	/**
	 * Prints the 3D maze
	 * @param maze3d - 3D maze to be printed
	 * @throws Exception IndexOutOfBound
	 */
	private void printMaze(Maze3d maze3d) throws Exception
	{
		Demo demo=new Demo();
		for(int y=0;y<maze3d.getHeight();y++)
		{
			System.out.println();
			System.out.println("Level: "+y);
			demo.printSection(maze3d.getCrossSectionByY(y),"y");
		}
	}
	
	/**
	 * Prints a cross section of the 3D maze
	 * @param CrossSection - Cross section to be printed
	 * @param axis - Axis to print by
	 */
	private void printSection(int[][] CrossSection,String axis)
	{
		if(axis.equals("x"))
			System.out.println("CrossSection by X - axis");
		if(axis.equals("y"))
			System.out.println("CrossSection by Y - axis");
		if(axis.equals("z"))
			System.out.println("CrossSection by Z - axis");
		for(int i=0;i<CrossSection.length;i++)
		{
			for(int j=0;j<CrossSection[0].length;j++)
			{
				System.out.print(CrossSection[i][j]);
			}
			System.out.println();
		}	
	}
}
