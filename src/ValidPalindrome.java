public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int len = charArray.length;
        int left = 0, right = len-1;
        while (left < right) {
            char lCh = charArray[left];
            char rCh = charArray[right];
            if (!(Character.isAlphabetic(lCh)||Character.isDigit(lCh))) {
                left++;
                continue;
            }
            if (!(Character.isAlphabetic(rCh)||Character.isDigit(rCh))) {
                right--;
                continue;
            }
            if (lCh != rCh) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
    }
}
