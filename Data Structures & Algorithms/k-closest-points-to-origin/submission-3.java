class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {return distance(b) - distance(a);});
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
            
        }
        int[][] result = new int[k][2];
        for (int j = 0; j < k; j++) {
            result[j] = heap.poll();
        }
        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
