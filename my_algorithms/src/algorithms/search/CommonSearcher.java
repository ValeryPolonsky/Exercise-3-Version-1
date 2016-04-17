package algorithms.search;
import java.util.PriorityQueue;

import algorithms.search.Searchable;

/**
 * Represents a common functions of searching algorithms
 * @author Valery Polonsky
 *
 */
public abstract class CommonSearcher implements Searcher {
	private int evaluatedNodes;
	@SuppressWarnings("rawtypes")
	protected PriorityQueue<State> openList;

	@SuppressWarnings("rawtypes")
	public abstract Solution Search(Searchable S);
	
	/**
	 * Creates a new priority queue
	 */
	@SuppressWarnings("rawtypes")
	public CommonSearcher(){
		openList=new PriorityQueue<State>();
		this.evaluatedNodes=0;
	}
	
	/**
	 * Returns state from the priority queue
	 * @return state
	 */
	@SuppressWarnings("rawtypes")
	protected State popOpenList(){
		evaluatedNodes++;
		return openList.poll();
	}
	
	/**
	 * Adds the given state to the priority queue
	 * @param state - State to be added
	 */
	@SuppressWarnings("rawtypes")
    protected void addToOpenList(State state) {
    	openList.add(state);
	}
	
	/**
	 * Returns a number of states in priority queue
	 * @return Number of states
	 */
	public int getNumberOfEvaluatedNodes(){
		return evaluatedNodes;
	}
}
