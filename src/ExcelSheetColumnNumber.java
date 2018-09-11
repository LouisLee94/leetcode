/**
 * Created by bobi on 2018/8/26.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int value = 0;
        for (char c : s.toCharArray()) {
            value = value*26 + c - 'A' + 1;
        }
        return value;
    }

    public static void main(String[] args) {
        new ExcelSheetColumnNumber().titleToNumber("AA");
    }
}
