package algorithms.search;

/**
 * Represents a node in the graph
 * @author Valery Polonsky
 *
 * @param <T> - Generic type of the state
 */
public class State<T> implements Comparable<State<T>>{
	private T stateName;
	private double edgeCost;
	private double pathCost;
	private State<T> cameFrom;
	
	/**
	 * Creates a new state with a given name
	 * @param stateName - Name to be set
	 */
	public State(T stateName)
	{
		this.stateName=stateName;
		this.edgeCost=1;
		this.pathCost=0;
		this.cameFrom=null;
	}
	
	/**
	 * Creates a default state
	 */
	public State()
	{
		this.stateName=null;
		this.edgeCost=1;
		this.pathCost=0;
		this.cameFrom=null;
	}
	
	/**
	 * Returns a name of the this state
	 * @return name
	 */
	public T getStateName() {
		return stateName;
	}
	
	/**
	 * Sets the given name to this state
	 * @param stateName Name to be set
	 */
	public void setStateName(T stateName) {
		this.stateName = stateName;
	}
	
	/**
	 * Sets the state from where we came to this state
	 * @param cameFrom State to be set
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom=cameFrom;
	}
	
	/**
	 * Returns a state from where we came to this state
	 * @return State
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * Returns the edge cost from "came from" state to "this" state
	 * @return Edge cost
	 */
	public double getEdgeCost() {
		return edgeCost;
	}

	/**
	 * Sets the edge cost between two states
	 * @param edgeCost - Edge cost to be set
	 */
	public void setEdgeCost(double edgeCost) {
		this.edgeCost = edgeCost;
	}

	/**
	 * Returns the cost of whole path to this state
	 * @return Path cost
	 */
	public double getPathCost() {
		return pathCost;
	}

	/**
	 * Sets the given path cost to this state 
	 * @param pathCost - Cost to be set
	 */
	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

	/**
	 * Function needed for priority queue to compare between two states
	 */
	@Override
	public int compareTo(State<T> state) {
		return (int)(state.getEdgeCost()-this.getEdgeCost());
	}
	
	/**
	 * Function needed to save the states in the HashSet
	 */
	@Override
	public int hashCode(){
	    return stateName.hashCode();
	}
	
	/**
	 * Function needed for HashSet structure to compare between two states
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object object){
	    if(object == null || object.getClass() != this.getClass()){
	        return false;
	    }
	    State other = (State)object;
	    return this.stateName.equals(other.stateName);
	}

}
