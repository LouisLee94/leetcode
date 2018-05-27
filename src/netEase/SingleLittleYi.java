package netEase;

//小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,
// 小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独
// 立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。

import java.util.Scanner;

public class SingleLittleYi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int f = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();

        int ans;

        if (d/x < f) ans = d/x;
        else {
            ans = (d - f*x)/(p+x) + f;
        }

        System.out.print(ans);
    }
}
