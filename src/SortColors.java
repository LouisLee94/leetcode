public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (true) {
            while (left < nums.length && nums[left] == 0)
                left++;
            while (right >= 0 && nums[right] != 0)
                right--;
            if (left > right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if(left < nums.length && nums[left] == 0) left++;
        right = nums.length - 1;
        while (true) {
            while (left < nums.length && nums[left] == 1)
                left++;
            while (right >= 0 && nums[right] == 2)
                right--;
            if (left > right) break;;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    public static void main(String [] args) {
        new SortColors().sortColors(new int[]{1});
    }
}
