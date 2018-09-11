/**
 * Created by bobi on 2018/8/28.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        // k = k % nums.length;
        // int[] newNums = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     newNums[i] = nums[(i + nums.length - k) % nums.length];
        // }
        // for (int i = 0; i < nums.length; i++)
        //     nums[i] = newNums[i];

        //O(1) extra space
        int count = 0;
        int start = 0;
        int len = nums.length;
        k %= len;
        if (k == 0) return;
        int i = start + k;
        int temp = nums[start];
        while (count != len) {

            int x = nums[i];
            nums[i] = temp;
            temp = x;
            count++;

            if (i == start) {
                start++;
                i = (start + k) % len;
                temp = nums[start];
                continue;
            }

            i = (i + k) % len;
        }
    }

    public static void main(String[] args) {
      Integer i = Integer.parseInt("");
      System.out.println(i);
    }
}
