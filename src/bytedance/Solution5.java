package bytedance;

/**
 * Created by bobi on 2018/9/9.
 */


import java.util.*;

public class Solution5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<m;i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (map.containsKey(right)){
                ArrayList<Integer> list = map.get(right);
                list.add(left);
                map.put(right, list);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left);
                map.put(right, list);
            }
        }
        int red = 0;
        for (int i=1;i<=n;i++){
            if (map.containsKey(i)){
                ArrayList<Integer> gz = map.get(i);
                Queue<Integer> queue = new LinkedList<>(gz);
                boolean[] flag = new boolean[n+1];
                flag[i] = true;
                int count=0;
                while (queue.size()!=0){
                    int len = queue.size();
                    for (int j=0;j<len;j++){
                        int num = queue.poll();
                        if (!flag[num]){
                            flag[num] = true;
                            count++;
                            if (map.containsKey(num))
                                queue.addAll(map.get(num));
                        }
                    }
                }
                if (count==n-1)
                    red++;
            }
        }

        System.out.println(red);
    }
}
