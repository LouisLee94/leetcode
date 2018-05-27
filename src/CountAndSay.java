public class CountAndSay {
    public String countAndSay(int n) {
        String resultSeq = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char pre = resultSeq.charAt(0);
            int prePos = 0;
            for (int j = 0; j < resultSeq.length(); j++) {
                char c = resultSeq.charAt(j);
                if (c != pre) {
                    int dif = j - prePos;
                    sb.append(dif);
                    sb.append(pre);
                    pre = c;
                    prePos = j;
                }
            }
            sb.append(resultSeq.length()-prePos);
            sb.append(pre);
            resultSeq = sb.toString();
        }
        return resultSeq;
    }
    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
}
