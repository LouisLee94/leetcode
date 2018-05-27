public class Pow {
    public double myPow(double x, int n) {
        double result = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }
        return n >= 0 ? result : 1/result;
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double result = myPow1(x, n/2);
        x = n >= 0? x : 1/x;
        return n%2 == 0 ? result*result : result*result*x;
    }
}
