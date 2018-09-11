/**
 * Created by bobi on 2018/8/26.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long div = 5;
        long nl = n;
        int result = 0;
//        while (nl >= div) {
//            result += n / div;
//            div *= 10;
//        }
//        div = 25;
        while (nl >= div) {
            result += n / div;
            div *= 5;
        }
        return result;
    }
}
