import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by bobi on 2018/8/26.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

}
