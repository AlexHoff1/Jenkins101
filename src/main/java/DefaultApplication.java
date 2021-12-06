import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DefaultApplication {

    public static void main(String[] args){
        log.info("Application starting");

        // Find min/max/median
        MedianFinder medianFinder = new MedianFinder();
        Stream<Integer> integerStream = Stream.of(1,3,2,4,7,19,-1,5,12);
        log.info(medianFinder.naiveSolution(integerStream).toString());
        log.info(medianFinder.maxHeapMinHeap(Stream.of(1,3,2,4,7,19,-1,5,12)).toString());
    }

}
