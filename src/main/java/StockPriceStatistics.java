public interface StockPriceStatistics {
    /**
     * @return
     */
    Integer findMedian();

    /**
     * @return
     */
    int findLow();

    /**
     * @return
     */
    int findHigh();

    /**
     *
     */
    void insert(Integer next);
}
