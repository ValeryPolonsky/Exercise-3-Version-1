package algorithms.search;

import java.util.Stack;

/**
 * Represents a path from start state to goal state
 * @author Valery Polonsky
 *
 */
public class Solution {
	
	@SuppressWarnings("rawtypes")
	private Stack<State> states;
	
	/**
	 * Creates a new stack to save states
	 */
	@SuppressWarnings("rawtypes")
	public Solution()
	{
		states=new Stack<State>();
	}
	
	/**
	 * Saves the given stack at this stack
	 * @param states - Stack of states to be saved
	 */
	@SuppressWarnings("rawtypes")
	public Solution(Stack<State> states)
	{
		this.states=states;
	}
	
	/**
	 * Adds a given state to stack
	 * @param state - State to be added
	 */
	@SuppressWarnings("rawtypes")
	public void addStateToSolution(State state)
	{
		states.push(state);
	}
	
	/**
	 * Removes the given state from stack
	 * @param state
	 */
	@SuppressWarnings("rawtypes")
	public void removeStateFromSolution(State state)
	{
		states.remove(state);
	}
	
	/**
	 * Returns the size of the stack
	 * @return Size
	 */
	public int size()
	{
		return states.size();
	}
	
	/**
	 * Overrides the toString() function, in order to print solution
	 * 
	 */
	public String toString()
	{
		String str="Solution is: ";
		while(!states.isEmpty())
		{
			str=str+states.pop().getStateName().toString()+" ";
		}
		return str;
	}
}
