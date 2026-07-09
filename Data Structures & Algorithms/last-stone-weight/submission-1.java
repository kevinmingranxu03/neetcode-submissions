class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.sort(stones);
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if (stone1 - stone2 > 0) {
                heap.offer(stone1 - stone2);
            }
        }
        return heap.size() == 0 ? 0 : heap.peek();
    }
}
