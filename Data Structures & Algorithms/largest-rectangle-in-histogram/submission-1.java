class Solution {
    public int largestRectangleArea(int[] heights) {
        // increasing stack
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;
                int width = rightBoundary - leftBoundary - 1;
                int area = width * height;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
