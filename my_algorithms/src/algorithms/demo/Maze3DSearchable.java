package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

public class Maze3DSearchable implements Searchable<String> {

	
	private Maze3d maze3d;
	private State<String> startState;
	private State<String> goalState;
	
	/**
	 * Object adapter between "Maze" and "Searchable"
	 * @param maze3d - 3D maze where algorithm will work
	 */
			
	public Maze3DSearchable(Maze3d maze3d)
	{
		this.maze3d=maze3d;
		this.startState=new State<String>();
		this.startState.setStateName(maze3d.getStartPosition().toString());
		this.goalState=new State<String>();
		this.goalState.setStateName(maze3d.getGoalPosition().toString());
	}
	
	/**
	 * Returns 3D maze
	 * @return 3D Maze
	 */
	public Maze3d returnMaze()
	{
		return maze3d;
	}
	
	/**
	 * Returns start state as State<String>
	 */
	@Override
	public State<String> getInitialState() {
		return startState;
	}

	/**
	 * Returns goal state as State<String>
	 */
	@Override
	public State<String> getGoalState() {
		return goalState;
	}

	/**
	 * Returns all possible states from the given one
	 * @param s - Given state
	 */
	@Override
	public ArrayList<State<String>> getAllPossibleStates(State<String> s) {
		Position p = new Position();//Position needed for getting possible moves
		ArrayList<State<String>> positions=new ArrayList<State<String>>();//Save all possible states from the given one
		p=p.toPosition(s.getStateName());//Converts String to Position
		String[]possibleMoves=maze3d.getPossibleMoves(p);//Saves possible moves as strings
		for(int i=0;i<possibleMoves.length;i++)
		{
			State<String> tempSt=new State<String>();//Temperate State needed for adding to the array list
			tempSt.setStateName(possibleMoves[i]);//Sets the state
			positions.add(tempSt);//Adds the state to array list
		}
		return positions;//Returns array list of possible states
	}
}
