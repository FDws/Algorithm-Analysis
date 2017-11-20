package leetcode;

/**
 * @author FDws
 * @date 2017年11月20日 下午8:14:17
 * @title Median of Two Sorted Arrays
 */
public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int mid = (nums1.length + nums2.length) >> 1;
		if (nums1.length == 0) {
			if (((nums1.length + nums2.length) & 1) == 0) {
				return (double) (nums2[mid] + nums2[mid - 1]) / 2;
			} else {
				return nums2[mid];
			}
		} else if (nums2.length == 0) {
			if (((nums1.length + nums2.length) & 1) == 0) {
				return (double) (nums1[mid] + nums1[mid - 1]) / 2;
			} else {
				return nums1[mid];
			}
		}

		int al = mid + 1;
		int[] all = new int[al];

		int i1 = 0;
		int i2 = 0;
		int index = 0;
		while (index < al) {
			if (i1 < nums1.length && (i2 == nums2.length || nums1[i1] < nums2[i2])) {
				all[index] = nums1[i1];
				i1++;
			} else {
				all[index] = nums2[i2];
				i2++;
			}
			index++;
		}

		if (((nums1.length + nums2.length) & 1) == 0) {
			return (double) (all[al - 1] + all[al - 2]) / 2;
		} else {
			return all[al - 1];
		}
	}

	public static void main(String[] args) {
		int[] i = { 2, 3, 5 };
		int[] j = { 1 };
		MedianofTwoSortedArrays me = new MedianofTwoSortedArrays();
		System.out.println(me.findMedianSortedArrays(i, j));
	}
}
