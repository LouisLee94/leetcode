package exam;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bobi on 2018/8/25.
 */
public class solu1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i=0;i<n;i++)
            arr[i] = new ArrayList<>();
        for (int i=0;i<n;i++){
            int next = scanner.nextInt();
            while (next!=0){
                arr[i].add(next-1);
                arr[next-1].add(i);
                next = scanner.nextInt();
            }
        }
        int result = div(n, arr);
        System.out.print(result);
    }
    
    private static int div(int n, ArrayList<Integer>[] arr){
        if (n<=1)
            return n;
        int result=0;
        boolean[] flag = new boolean[n];
        for (int i=0;i<flag.length;i++){
            if (!flag[i]) {
                result++;
                flag[i] = true;
                bfs(flag, arr, i);
            }
        }
        return result;
    }
    private static void bfs(boolean[] flag, ArrayList<Integer>[] arr, int x){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(x);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i=0;i<len;i++){
                int ne = queue.poll();
                ArrayList<Integer> next = arr[ne];
                for (int z:next){
                    if (!flag[z]){
                        queue.add(z);
                        flag[z] = true;
                    }
                }
            }
        }
    }
   
}
