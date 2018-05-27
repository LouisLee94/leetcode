public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        int start = 0, end = nums.length-1, mid;
        while (start <= end) {
            mid = (start + end + 1)/2;
            if (nums[start] == target) return start;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target && nums[mid] < nums[start] || nums[mid] > target && target > nums[start] ||
                    nums[mid] < nums[start] && nums[start] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
//            else if (nums[start] > target) {
//                if (nums[mid] > target && nums[mid] < nums[start]) {
//                    end = mid - 1;
//                } else if (nums[mid] > nums[start] || nums[mid] < target) {
//                    start = mid + 1;
//                } else {
//                    return mid;
//                }
//            } else if (nums[start] < target) {
//                if (nums[mid] > target || nums[mid] < nums[start]) {
//                    end = mid - 1;
//                } else if (nums[mid] > nums[start] && nums[mid] < target) {
//                    start = mid + 1;
//                } else {
//                    return mid;
//                }
//            }
        }
        return -1;

    }
}
