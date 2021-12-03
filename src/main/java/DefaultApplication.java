import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DefaultApplication {

    public static void main(String[] args){
        log.info("Application starting");
        log.error("This is an error message");

        // Find min/max/median

        // Naive solution, sorted list
        Stream<Integer> integerStream = Stream.of(1,3,2,4,7);
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
    }
}
