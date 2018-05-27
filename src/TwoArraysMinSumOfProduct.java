
//
//        已知有两个长度相等的正整数数组A、B，
//        其元素分别记为{a(1)，a(2)，a(3)，a(4) ...... a(n) ......}和{b(1)，b(2)，b(3)，b(4) ...... b(n) ......}，
//        两个数组中任一元素大小不超过10000，数组长度在1000以内，
//        现在按照以下规则将A数组中的元素插入到B数组中进行合并：
//        对于A数组中任一元素可以插入到B数组中任意位置。
//        对于A数组中任一元素a(i)，在合并之后的数组中a(i)对应的下标小于a(i+1)对应的下标。（如果a(i+1)存在的话）
//        问题：
//        对合并之后的数组中相邻元素两两相乘，然后求其累加值，请给出所有合并可能形成的数组对应累加值的最小值。
//        以长度为4的两个数组为例：
//        A：{a1，a2，a3，a4}
//        B：{b1，b2，b3，b4}
//        插入完成后的数组可能为：
//        {a1，a2，b1，b2，b3，b4，a3，a4}、
//        {b1，a1，b2，b3，a2，a3，b4，a4}等。
//        其对应的累加值分别对应为
//        a1*a2 + b1*b2 + b3*b4 + a3*a4、
//        b1*a1 + b2*b3 + a2*a3 + b4*a4等。

public class TwoArraysMinSumOfProduct {
    static long min(int[] from, int[] to) {
        int n = from.length;
        long[][] ans = new long[n+1][n+1];
        ans[0][0] = 0;
        ans[1][1] = from[0]*to[0];
        for (int i = 2; i <= n; i+=2) {
            ans[0][i] = ans[0][i - 2] + to[i - 1] * to[i - 2];
            ans[i][0] = ans[i-2][0] + from[i - 1] * from[i - 2];
        }
        for (int i = 3; i <= n; i+=2) {
            ans[1][i] = Math.min(ans[1][i-2] + to[i-1]*to[i-2], ans[0][i-1] + from[0]*to[i-1]);
            ans[i][1] = Math.min(ans[i-2][1] + from[i-1]*from[i-2], ans[i-1][0] + from[i-1]*to[0]);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if ((i + j)%2 == 0) {
                    long smaller = Math.min(ans[i-2][j]+from[i-1]*from[i-2], ans[i][j-2]+to[i-1]*to[i-2]);
                    ans[i][j] = Math.min(smaller, ans[i-1][i-1]+from[i-1]*to[j-1]);
                }
            }
        }


        return ans[n][n];
    }

    public static void main(String[] args) {
        int[] from = {1,7,50};
        int[] to = {2,9,3};
        long r = TwoArraysMinSumOfProduct.min(from, to);
    }
}
