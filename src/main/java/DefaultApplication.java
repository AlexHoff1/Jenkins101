import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class DefaultApplication {

    public static void main(String[] args){
        log.info("Application starting");

        // Find min/max/median
        StockPriceStatistics medianFinderNaive = new NaiveStockPriceStatistics();
        StockPriceStatistics medianFinderOptimal = new NaiveStockPriceStatistics();

        List<Integer> integerStream = Arrays.asList(1,3,2,4,7,19,-1,5,12);
        logResults(integerStream, medianFinderNaive);
        logResults(integerStream, medianFinderOptimal);
    }

    public static void logResults(List<Integer> integers, StockPriceStatistics stockPriceStatistics) {
        for(Integer element: integers) {
            stockPriceStatistics.insert(element);
            stockPriceStatistics.insert(element);
            log.debug("After adding {} the median is {}",
                    element,
                    stockPriceStatistics.findMedian());
        }
        log.info("Final answer for the problem is low:{}, median:{}, high:{}",
                stockPriceStatistics.findLow(),
                stockPriceStatistics.findMedian(),
                stockPriceStatistics.findHigh());
    }

}
