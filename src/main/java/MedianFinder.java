import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class MedianFinder {

    // Naive solution, sorted list
    public List<Integer> naiveSolution(Stream<Integer> integerStream){
        List<Integer> sortedStream = integerStream.sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> results = new ArrayList<>();
        results.add(sortedStream.get(0));
        results.add(sortedStream.get(sortedStream.size()-1));
        int median;
        if(sortedStream.size()%2==0){
            median = sortedStream.get(sortedStream.size()/2); // round down
        } else {
            int location = sortedStream.size()==1 ? 0 : sortedStream.size()/2 - 1;
            median = sortedStream.get(location);
        }
        results.add(median);
        log.info(results.toString());
        return results;
    }

    public List<Integer> maxHeapMinHeap(Stream<Integer> integerStream) {
        // condition one: keep heaps balanced in size. Implement "rebalance"
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> listForSimplicity = integerStream.collect(Collectors.toList());
        for (Integer next : listForSimplicity) {
            Integer minHeapValue = minHeap.peek();
            boolean minHeapDestination = ((minHeapValue == null) || (minHeapValue >= next));
            if (minHeapDestination) {
                minHeap.add(next);
            } else {
                maxHeap.add(next);
            }

            // rebalance if necessary
            if (minHeap.size() >= (maxHeap.size() + 1)) {
                maxHeap.add(minHeap.poll());
            } else if (minHeap.size() <= (maxHeap.size() - 1)) {
                minHeap.add(maxHeap.poll());
            }
            log.info(String.format("min heap: %d, max heap: %d", minHeap.size(), maxHeap.size()));
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
        sortedMaxHeap.sort(Comparator.naturalOrder());
        results.add(sortedMaxHeap.get(0));
        List<Integer> sortedMinHeap = new ArrayList<>(minHeap);
        sortedMinHeap.sort(Comparator.naturalOrder());

        results.add(sortedMinHeap.get(sortedMinHeap.size()-1));
        results.add(median);

        return results;
    }
}
