public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] result = new int[len];
        result[0] = 1;
        if (s.charAt(0) == '0') return 0;
        if (len == 1) return 1;
        if (s.charAt(1) == '0' && ('2' < s.charAt(0))) return 0;
        if(Integer.valueOf(s.substring(0,2)) <= 26 && s.charAt(1) != '0')
            result[1] = 2;
        else result[1] = 1;

        for (int i = 2; i < len; i++) {
            if (s.charAt(i) == '0' && s.charAt(i-1) == '0' || s.charAt(i) == '0' && ('2' < s.charAt(i-1))) return 0;
            if (Integer.valueOf(s.substring(i-1, i+1)) <= 26 && s.charAt(i-1) != '0' && s.charAt(i) != '0') {
                result[i] = result[i-1] + result[i-2];
            } else if (s.charAt(i) != '0')
                result[i] = result[i-1];
            else result[i] = result[i-2];
        }
        return result[len-1];
    }
}
