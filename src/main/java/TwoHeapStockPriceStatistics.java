import java.util.PriorityQueue;

public class TwoHeapStockPriceStatistics implements StockPriceStatistics {
    private int lowest;
    private int highest;
    private final PriorityQueue<Integer> halfOfListLowerThanMedian = new PriorityQueue<>();
    private final PriorityQueue<Integer> halfOfListHigherThanMedian = new PriorityQueue<>();

    @Override
    public Integer findMedian() {
        int leftHalfSize = halfOfListLowerThanMedian.size();
        int rightHalfSize = halfOfListHigherThanMedian.size();
        if(leftHalfSize == 0 && rightHalfSize == 0){
            return null;
        }

        if(leftHalfSize > rightHalfSize) {
            return halfOfListLowerThanMedian.peek();
        } else if (rightHalfSize > leftHalfSize) {
            return halfOfListHigherThanMedian.peek();
        } else {
            return (halfOfListHigherThanMedian.peek() + halfOfListLowerThanMedian.peek())/2;
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
        if(lowest > next){
            lowest = next;
        } else if (highest < next) {
            highest = next;
        }

        // decide which heap to add to, if it's a new median element it doesn't matter which. Default right.
        Integer leftTop = halfOfListLowerThanMedian.peek();
        if(leftTop == null || next < leftTop){
            halfOfListLowerThanMedian.add(next);
        } else {
            halfOfListHigherThanMedian.add(next);
        }

        // rebalance if necessary
        int leftHalfSize = halfOfListLowerThanMedian.size();
        int rightHalfSize = halfOfListHigherThanMedian.size();
        if(leftHalfSize > (rightHalfSize + 1)) {
            halfOfListHigherThanMedian.add(halfOfListLowerThanMedian.poll());
        } else if (rightHalfSize > (leftHalfSize + 1)) {
            halfOfListLowerThanMedian.add(halfOfListHigherThanMedian.poll());
        }
    }
}
