import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class DefaultApplication {

    public static void main(String[] args){
        log.info("Application starting");

        // Find min/max/median
        MedianFinder medianFinder = new MedianFinder();
        List<Integer> integerStream = Arrays.asList(1,3,2,4,7,19,-1,5,12);

        log.info(medianFinder.naiveSolution(integerStream.stream()).toString());
        log.info(medianFinder.maxHeapMinHeap(integerStream.stream()).toString());
    }

}
