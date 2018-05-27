import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < (int)Math.pow(2, n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i>>j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
