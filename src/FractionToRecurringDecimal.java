import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by bobi on 2018/8/25.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        if (num < 0) {
            num = -num;
            flag = -flag;
        }
        if (den < 0) {
            den = -den;
            flag = -flag;
        }
        sb.append(flag < 0 ? '-' : "");
        sb.append(num / den);
        num = num % den;
        if (num == 0) return sb.toString();
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        int point = sb.length() - 1;
        while (!map.containsKey(num)) {
            map.put(num, ++point);
            num *= 10;
            int de = (int)(num / den);
            sb.append(de);
            num = num % den;
            if (num == 0) return sb.toString();
        }
        sb.insert(map.get(num), "(");
        sb.append(')');
        return sb.toString();
    }

    public static void main(String[] args) {
        new FractionToRecurringDecimal().fractionToDecimal(11,53);
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        // negative sign
        boolean negative = (numerator < 0) ^ (denominator < 0);
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long intPart = n / d;
        long rest = n - intPart * d;
        if (rest == 0) return negative ? String.valueOf(intPart * (-1)) : String.valueOf(intPart); // Integer result
        StringBuilder res = new StringBuilder();
        if (negative) res.append("-");
        res.append(intPart);
        res.append(".");
        long slow;
        long fast;
        long[] temp = new long[2];
        slow = Decimal(rest*10, d)[1];
        fast = Decimal(Decimal(rest*10, d)[1], d)[1];
        while (slow != fast) {
            slow = Decimal(slow, d)[1];
            fast = Decimal(Decimal(fast, d)[1], d)[1];
        }
        slow = rest * 10;
        while (slow != fast && slow != 0) {
            temp = Decimal(slow, d);
            slow = temp[1];
            res.append(temp[0]);       // non-cycle part
            fast = Decimal(fast, d)[1];
        }
        if (slow == 0) return res.toString();  // return when result is finite decimal
        temp = Decimal(slow, d);
        fast = temp[1];
        res.append("(");
        res.append(temp[0]);
        while (slow != fast) {
            temp = Decimal(fast, d);
            fast = temp[1];
            res.append(temp[0]);  // cycle part
        }
        res.append(")");
        return res.toString();
    }
    public long[] Decimal(long rest, long denominator) {
        // return the quotient and remainder (multiplied by 10)
        long r1;
        long r2;
        if (rest < denominator) {
            r1 = 0;
            r2 = rest * 10;
        }
        else {
            r1 = rest / denominator;
            r2 = (rest - denominator * r1) * 10;
        }
        return new long[]{r1, r2};
    }
}
