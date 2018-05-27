import java.awt.*;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int count, max = 0;
        int len = points.length;
        int indentical = 0;
        if (len <= 2) return len;
        for (int i = 0; i < len; i++) {
            if (points[i] == null) continue;
            indentical = 0;
            boolean[][] isUsed = new boolean[len][len];
            for (int j = i + 1; j < len; j++) {
//                if (isUsed[i][j]) continue;
                if (points[j] == null) continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    points[j] = null;
                    indentical++;
                    continue;
                }
                count = 2 + indentical;
                for (int k = j + 1; k < len; k++) {
                    if (points[k] == null) continue;
                    if (isStraight(points[i], points[j], points[k])) {
                        count++;
                        isUsed[j][k] = true;
                        isUsed[i][k] = true;
                    }
                }
                max = Math.max(max, count);
            }
            max = Math.max(max, indentical+1);
        }
        return max;
    }

    private boolean isStraight(Point p1, Point p2, Point p3) {
        if ((p2.y - p1.y)*(long)(p3.x - p1.x) == (p3.y - p1.y)*(long)(p2.x - p1.x))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String input = "[[0,0],[1,1],[2,0],[3,1],[4,0]";
        input = input.replace("[", "");
        input = input.replace("]", "");
        String[] nums = input.split(",");
        Point[] points = new Point[nums.length/2];
        for (int i = 0; i < nums.length/2; i++) {
            points[i] = new Point(Integer.valueOf(nums[2*i]), Integer.valueOf(nums[2*i+1]));
        }
        new MaxPointsOnALine().maxPoints(points);
    }

    public int maxPoints1(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int n = points.length;
        int max = 2;
        Point a, b, c;
        for (int i = 1; i < n; i++) {
            a = points[i - 1];
            b = points[i];
            double k = getSlop(a, b);
            int count = 2;
            for (int j = 0; j < n; j++) {
                if (j == i || j == i - 1) {
                    continue;
                }
                c = points[j];
                if (overlap(a, c) || overlap(b, c) || k == getSlop(b, c)) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean overlap(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }

    private double getSlop(Point a, Point b) {
        if (a.x == b.x) {
            return Double.POSITIVE_INFINITY;
        } else {
            return ((double) a.y - b.y) / ((double) a.x - b.x);
        }
    }

}
