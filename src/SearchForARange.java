public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1, mid;
        int start, end;
        while (lo <= hi) {
            mid = (lo + hi)/2;
            if (nums[mid]>target) {
                hi = mid - 1;
            } else if (nums[mid]<target) {
                lo = mid + 1;
            } else {
                //找到了target值
                int tempHi = hi, tempMid = mid;
                hi = mid;
                while (lo <= hi) {
                    mid = (lo+hi)/2;
                    if (nums[mid] == target) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                start = lo;

                lo = tempMid;
                hi = tempHi;
                while (lo <= hi) {
                    mid = (lo+hi)/2;
                    if (nums[mid] == target) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                end = hi;
                return new int[] {start, end};
            }
        }
        return new int[] {-1, -1};
    }
}
