package algorithms.search;
import algorithms.search.Searchable;

/**
 * Represents a common interface functionality of Searching algorithms
 * @author Valery Polonsky
 *
 */
public interface Searcher {
	@SuppressWarnings("rawtypes")
	public Solution Search(Searchable S);
	public int getNumberOfEvaluatedNodes();
}
