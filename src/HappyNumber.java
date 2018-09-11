import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bobi on 2018/9/7.
 */
public class HappyNumber {

    private Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(!set.add(n)) return false;
        int sum = 0;
        while (n > 0) {
            sum += (n%10)*(n%10);
            n /= 10;
        }

        return isHappy(sum);
    }
}
