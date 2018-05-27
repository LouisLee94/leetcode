public class Sqrt {
    public int mySqrt(int x) {
        long left = 0, right = (x + 1)/2;
        long mid = 0;
        while (left < right) {
            mid = (left + right)/2;
            if(mid*mid > x) right = mid - 1;
            else if(mid*mid < x) left = mid + 1;
            else return (int)mid;
        }
        return (int)(left*left <= x ? left: left - 1);
    }

    public static void main(String[] args) {
        int a = new Sqrt().mySqrt(2147483647);
    }
}
