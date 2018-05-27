public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            temp += num;
            if (temp <= 0) {
                temp = 0;
                max = Math.max(max, num);
            }
            else max = Math.max(max, temp);
        }
        return max;
    }
}
