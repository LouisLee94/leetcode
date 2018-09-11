import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobi on 2018/9/7.
 */
public class CountPrimes {
    private List<Integer> list = new ArrayList<>();
    public int countPrimes(int n) {
        list.add(2);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                list.add(i);
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        int bound = (int)Math.sqrt(n);

//        for (int i = 2; i <= bound; i++) {
//            if (n % i == 0) return false;
//        }
        for (int i : list) {
            if (i > bound) break;
            if (n % i == 0) return false;
        }
        return true;
    }
}
