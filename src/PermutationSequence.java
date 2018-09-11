import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/**
 * Created by bobi on 2018/8/16.
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {



        int[] arr = new int[n];
        arr[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = (n - i) * arr[i+1];
        }
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i < n; i++) {
            int r = k/arr[i];
            sb.append(list.remove(r));
            k = k % arr[i];
        }
        sb.append(list.get(0));

        return sb.toString();
    }
}
