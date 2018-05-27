public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int product = 1;
        int max = 0;
        int count = 0;
     //   int firstMinus = -1, lastMinus = -1;
        int leftPro = 0, rightPro = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i==nums.length||nums[i] == 0) {
                if (product < 0 && count != 1) {
                    product = Math.max(product/leftPro, product/rightPro);
                }
                if (count == 0) product = 0;
                max = Math.max(product, max);
                product = 1;
                rightPro = 0;
                leftPro = 0;
                count = 0;
                continue;
            }
            product *= nums[i];
            count++;
            if (nums[i] < 0) {
                if (leftPro == 0) {
                    leftPro = product;
                }
                rightPro = 1;
            }
            rightPro *= nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        new MaximumProductSubarray().maxProduct(new int[]{0,-2,0});
    }
}
