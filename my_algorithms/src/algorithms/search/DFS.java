package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Searches a path from start state to goal state by using DFS algorithm
 * @author Valery Polonsky
 *
 */
public class DFS extends CommonSearcher {

	/**
	 * Searches a path from start state to goal state
	 * @param s - "Graph" where algorithm will work
	 * @return Paths from start state to goal state
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Solution Search(Searchable s) {
		addToOpenList(s.getInitialState());
		HashSet<State>discovered=new HashSet<State>();
		
		
		while(!openList.isEmpty())
		{
			State n=popOpenList();
			
			if(n.equals(s.getGoalState()))
				return backTrace(n,s.getInitialState(),discovered); 
			
			if(!discovered.contains(n))
			{
				 discovered.add(n);
				 ArrayList<State> successors=s.getAllPossibleStates(n);
				 
				 for(State state : successors)
				 {
					 state.setCameFrom(n);
					 addToOpenList(state);
				 }
			}
		}
		return null; 
	}
	
	/**
	 * Builds an paths section from goal state to start state
	 * @param goalState - Goal state
	 * @param initialState - Start state
	 * @param closedSet - Saved states after BFS work
	 * @return Paths from goal to start
	 */
	@SuppressWarnings("rawtypes")
	private Solution backTrace(State goalState, State initialState,HashSet<State> closedSet) {
		Solution solution=new Solution();
		solution.addStateToSolution(goalState);
		State tempState=goalState.getCameFrom();
		
		while(!tempState.equals(initialState))
		{
			solution.addStateToSolution(tempState);
			tempState=tempState.getCameFrom();
		}
		solution.addStateToSolution(initialState);
		return solution;
	}

}
