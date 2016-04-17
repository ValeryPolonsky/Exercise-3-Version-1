package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Searches the shortest path from start state to goal state by using BFS algorithm
 * @author Valery Polonsky
 *
 */

/*DFS advantages:
	- Connectivity problem
	- Strongly Connected Components finding
	- Topological Sorting
  
  BFS advantages:
    - Shortest path searching
    - Testing whether the graph is bipartite.
	*/

public class BFS extends CommonSearcher {
	
	/**
	 * Searches the shortest path from start state to goal state
	 * @param s - "Graph" where algorithm will work
	 * @return Paths from start state to goal state
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Solution Search(Searchable s)
	{
		addToOpenList(s.getInitialState());
		HashSet<State>closedSet=new HashSet<State>();
		
		
		while(!openList.isEmpty())
		{
			
			 State n=popOpenList();
			 closedSet.add(n);
			
			 if(n.equals(s.getGoalState()))
				return backTrace(n,s.getInitialState(),closedSet); 
			 ArrayList<State> successors=s.getAllPossibleStates(n);
			 for(State state : successors)
			 {
				  if(!closedSet.contains(state) && ! openList.contains(state))
				  {
				      state.setCameFrom(n);
				      addToOpenList(state);
				  } 
				  else
				  {
				     if(isBetterPath(n,state))
				     {
				    	 addToOpenList(state);
				         state.setCameFrom(n);
			
				    	 if(! openList.contains(state))
				    		addToOpenList(state);
				         else
				    	 {
				    		state.setCameFrom(n);
				    		state.setPathCost(state.getEdgeCost()+n.getPathCost());
				    	 }	 
				      }  
				   }
			  }
		}
		return null; 

	}

	/**
	 * Checks if a new path is better than the old one
	 * @param n - State with given path cost
	 * @param state - State to be checked if it's better to get to through n state
	 * @return true or false
	 */
	@SuppressWarnings("rawtypes")
	private boolean isBetterPath(State n, State state) {
		if(state.getPathCost()>n.getPathCost()+state.getEdgeCost())
			return true;
		else
			return false;
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
