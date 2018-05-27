public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxLeft = 0, maxRight = 0;
        int ans = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                if (maxLeft < height[left])
                    maxLeft = height[left++];
                else ans += maxLeft - height[left++];
            } else {
                if (maxRight < height[right])
                    maxRight = height[right--];
                else ans += maxRight - height[right--];
            }
        }
        return ans;
    }

}
