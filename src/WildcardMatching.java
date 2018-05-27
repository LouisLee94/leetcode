public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] isMatch = new boolean[sLen+1][pLen+1];//默认值是false
        isMatch[sLen][pLen] = true;//表示两个空字符匹配
        for (int i = pLen - 1; i >= 0; i--) {
            if (p.charAt(i)=='*') isMatch[sLen][i] = true;
            else break;
        }
        for (int pp = pLen - 1; pp >= 0; pp--) {
            for (int sp = sLen - 1; sp >= 0; sp--) {
                char c = p.charAt(pp);
                if (c == '*') isMatch[sp][pp] = isMatch[sp+1][pp+1]||isMatch[sp][pp+1]||isMatch[sp+1][pp];
                else if (c == '?') isMatch[sp][pp] = isMatch[sp+1][pp+1];
                else isMatch[sp][pp] = (c == s.charAt(sp))&&isMatch[sp+1][pp+1];

            }
        }
        return isMatch[0][0];
    }
    public static void main(String[] args) {
        new WildcardMatching().isMatch("ab*cdec", "ab*c");
    }
}
