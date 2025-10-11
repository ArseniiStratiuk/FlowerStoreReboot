package ucu.edu.ua.apps;

/**
 * Interface for filtering flowers based on various criteria.
 * Implementations define specific matching logic.
 */
public interface SearchFilter {
  /**
   * Checks if a flower matches this filter's criteria.
   *
   * @param flower the flower to check
   * @return true if the flower matches, false otherwise
   */
  boolean match(Flower flower);
}
