import java.util.*;

public class Permutations {

    //回溯法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
        } else {
            for (int i : nums) {
                if (tempList.contains(i))
                    continue;
                tempList.add(i);
                backtrack(ans, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }

    }

    public List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }


    //dfs思想
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, 0, nums);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, int pos, int[] nums) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n: nums)
            list.add(n);
            lists.add(list);
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            dfs(lists, pos+1, nums);
            swap(nums, pos, i);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }
    public static void main(String[] args) {
        new Permutations().permute(new int[]{1,2,3});
    }
}
