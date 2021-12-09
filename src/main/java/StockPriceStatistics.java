public interface StockPriceStatistics {
    /**
     * @return the median value observed, if even in size return average of 2 middle elements.
     */
    Integer findMedian();

    /**
     * @return lowest number observed in stream.
     */
    int findLow();

    /**
     * @return highest number observed in stream.
     */
    int findHigh();

    /**
     *
     */
    void insert(Integer next);
}
