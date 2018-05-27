public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, current = 0;
        int[] temp = new int[m+n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) temp[current++] = nums1[i++];
            else {
                    temp[current++] = nums2[j++];
            }
        }
        while (i < m) temp[current++] = nums1[i++];
        while (j < n) temp[current++] = nums2[j++];

        i = 0;
        for (int num: temp) {
            nums1[i++] = num;
        }

    }


}
