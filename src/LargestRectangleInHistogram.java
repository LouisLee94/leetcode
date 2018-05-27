import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int height :heights) {
            int count = 0;
            for (int i = 0; i < heights.length; i++) {
                if (height <= heights[i]) {
                    count += height;
                    max = Math.max(count, max);
                } else {
                    count = 0;
                }
            }
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int j = i;
            int count = heights[i];
            while (--j >= 0 && heights[j] >= heights[i]) count += heights[i];
            j = i;
            while (++j < heights.length && heights[j] >= heights[i]) count += heights[i];
            max = Math.max(max, count);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {  //用栈来实现，效率是O(n),还可以用分治法递归来解
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                int pre = stack.empty()? -1: stack.peek();
                max = Math.max(heights[tp]*(i - pre - 1), max);
                i--;
            }
        }
        while (!stack.empty()) {
            int tp = stack.pop();
            int pre = stack.empty()? -1: stack.peek();
            max = Math.max(max, heights[tp] * (heights.length - pre - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
//        for (int i = 0 ; i < 20000; i ++) {
//            heights[i] = i;
//        }
        new LargestRectangleInHistogram().largestRectangleArea2(heights);
    }
}
