package algorithms.search;

import java.util.ArrayList;

/**
 * Represents a common functionality of graph
 * @author Valery Polonsky
 * @param <T>
 */
public interface Searchable<T> {
	State<T> getInitialState();
	State<T> getGoalState();
	ArrayList<State<T>>getAllPossibleStates(State<T> s);
}
