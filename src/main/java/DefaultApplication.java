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
        log.error("This is an error message");

        // Find min/max/median
        Stream<Integer> integerStream = Stream.of(1,3,2,4,7);
        log.info(naiveSolution(integerStream).toString());
        integerStream = Stream.of(1,3,2,4,7);
        log.info(maxHeapMinHeap(integerStream).toString());
    }

    public static List<Integer> naiveSolution(Stream<Integer> integerStream){
        // Naive solution, sorted list
        List<Integer> sortedStream = integerStream.collect(Collectors.toList());

        List<Integer> results = new ArrayList<>();
        results.add(sortedStream.get(0));
        results.add(sortedStream.get(sortedStream.size()-1));
        int median;
        if(sortedStream.size()%2==0){
            median = sortedStream.get(sortedStream.size()/2); // round down
        } else {
            median = sortedStream.get(sortedStream.size()/2-1);
        }
        results.add(median);
        log.info(results.toString());
        return results;
    }

    public static List<Integer> maxHeapMinHeap(Stream<Integer> integerStream) {
        // condition one: keep heaps balanced in size. Implement "rebalance"
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> listForSimplicity = integerStream.collect(Collectors.toList());
        for (Integer next : listForSimplicity) {
            Integer minHeapValue = minHeap.peek();
            boolean minHeapDestination = ((minHeapValue == null) || (minHeapValue <= next));
            if (minHeapDestination) {
                minHeap.add(next);
            } else {
                maxHeap.add(next);
            }

            // rebalance
            if (minHeap.size() > (maxHeap.size() + 2)) {
                maxHeap.add(minHeap.poll());
            } else if (minHeap.size() < (maxHeap.size() - 2)) {
                minHeap.add(maxHeap.poll());
            }
        }

        List<Integer> results = new ArrayList<>();
        Integer median;
        if(maxHeap.size() > minHeap.size()) {
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek())/2;
        }
        List<Integer> sortedMaxHeap = new ArrayList<>(maxHeap);
        results.add(sortedMaxHeap.get(sortedMaxHeap.size()-1));
        List<Integer> sortedMinHeap = new ArrayList<>(minHeap);
        results.add(sortedMinHeap.get(0));
        results.add(median);
        return results;
    }
}
