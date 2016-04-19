package algorithms.demo;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.nio.charset.Charset;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Main {

	public static void main(String[] args) throws Exception {
		//Demo demo=new Demo();
		//demo.run();
		
		/*int[]arr={1,0,0,1,1,0,1,0,1,1};
		byte[]data=new byte[10];
		for(int i=0;i<10;i++)
		{
			data[i]=(byte)arr[i];
		}
		for(int i=0;i<10;i++)
		{
			System.out.print(data[i]);
		}
		System.out.println();
		int a=0;
		for(int i=0;i<10;i++)
		{
			a=data[i];
			System.out.print(a);
		}*/
		
		try{
		Maze3dGenerator mg=new MyMaze3dGenerator();
		Maze3d maze1=mg.generate(10, 10, 10);
		byte[]data=maze1.toByteArray();
		Maze3d maze2=new Maze3d(data);
		System.out.println("FISRST MAZE");
		printMaze(maze1);
		System.out.println(maze2.getStartPosition());
		System.out.println(maze2.getGoalPosition());
		System.out.println();
		System.out.println("SECOND MAZE");
		printMaze(maze2);
		System.out.println(maze2.getStartPosition());
		System.out.println(maze2.getGoalPosition());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*int length=10;
		String str=Integer.toString(length);
		byte[] b = str.getBytes(StandardCharsets.UTF_8);
		String string = new String(b,"UTF_8");
		System.out.println(string);*/
		
		/*int length=3457;
		String s = Integer.toString(length);
		byte[] b = s.getBytes("UTF-8");
		String s1 = new String(b, "US-ASCII");
		int a=Integer.parseInt(s1);
		System.out.println(a);*/
		
	}
	
	private static void printMaze(Maze3d maze3d) throws Exception
	{
		for(int y=0;y<maze3d.getHeight();y++)
		{
			System.out.println();
			System.out.println("Level: "+y);
			printSection(maze3d.getCrossSectionByY(y),"y");
		}
	}
	
	private static void printSection(int[][] CrossSection,String axis)
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
