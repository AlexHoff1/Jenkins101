import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MedianFinderTest {

    private MedianFinder medianFinder;

    @Before
    public void setup(){
        medianFinder = new MedianFinder();
    }

    @Test
    public void singleArgumentIsMedian(){
        List<Integer> results = medianFinder.naiveSolution(Stream.of(1));
        assertEquals(results.get(0), results.get(1));
        assertEquals(results.get(1), results.get(2));
    }

}