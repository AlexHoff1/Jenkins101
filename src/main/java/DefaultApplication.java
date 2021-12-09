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
        for(Integer element: integerStream) {
            medianFinderNaive.insert(element);
            medianFinderOptimal.insert(element);
            log.info("After adding {} the median is {} and {}",
                    element,
                    medianFinderNaive.findMedian(),
                    medianFinderOptimal.findMedian());
        }

    }

}
