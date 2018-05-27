public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length+1 && nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }

        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0};
        new FirstMissingPositive().firstMissingPositive(nums);
    }
}
