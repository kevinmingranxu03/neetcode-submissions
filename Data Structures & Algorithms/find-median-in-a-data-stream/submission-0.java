class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }
}
