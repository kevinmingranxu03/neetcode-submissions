class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> heap = new PriorityQueue<>();
        Map<Double, ArrayList<int[]>> map = new HashMap<>();
        for (int[] point : points) {
            double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            if (!heap.contains(dist)) {
                heap.offer(dist);
            }
            ArrayList<int[]> l = new ArrayList<>();
            if (map.get(dist) == null) {
                map.put(dist, l);
            }
            map.get(dist).add(point);
        }
        int i = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < k - 1) {
            if (i + map.get(heap.peek()).size() >= k) {
                break;
            }
            ArrayList<int[]> ps = map.get(heap.poll());
            res.addAll(ps);
            i+= map.get(heap.peek()).size();
        }

        res.addAll(map.get(heap.poll()));
        int[][] result = new int[res.size()][2];
        for (int j = 0; j < result.length; j++) {
            result[j] = res.get(j);
        }
        return result;
    }
}
