import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NaiveStockPriceStatistics implements StockPriceStatistics {

    private int lowest = Integer.MAX_VALUE;
    private int highest = Integer.MIN_VALUE;
    private final List<Integer> allElements = new ArrayList<>();

    @Override
    public Integer findMedian() {
        if(allElements.size() == 0){
            return null;
        }

        allElements.sort(Comparator.naturalOrder());
        int numElements = allElements.size();

        if(numElements % 2 == 0){
            return (allElements.get(numElements/2) + allElements.get((numElements/2) - 1))/2;
        } else {
            return allElements.get(numElements/2);
        }
    }

    @Override
    public int findLow() {
        return lowest;
    }

    @Override
    public int findHigh() {
        return highest;
    }

    @Override
    public void insert(Integer next) {
        allElements.add(next);
        if(lowest > next){
            lowest = next;
        } else if (highest < next) {
            highest = next;
        }
    }
}
