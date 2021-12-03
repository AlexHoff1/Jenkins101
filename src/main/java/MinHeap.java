public class MinHeap implements Heap {
    @Override
    public Node pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Node add(Node node) {
        while(!minHeapPropertyHolds(node)){

        }
        return null;
    }

    private boolean minHeapPropertyHolds(Node node) {
        return (node.right != null && node.right.value <= node.value)
                &&
                (node.left != null && node.left.value <= node.value) ;
    }
}
