package leetcode;

/**
 * @author FDws
 * @date 2017年12月12日 下午10:22:26
 * @title Merge k Sorted Lists
 */
public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		ListNode result = lists[0];
		for (int i = 1; i < lists.length; i++) {
			result = mergeTwoLists(result, lists[i]);
		}
		return result;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}

	public static void main(String[] args) {
		MergekSortedLists m = new MergekSortedLists();
		ListNode[] l = new ListNode[2];
		System.out.println("Begin...");
		System.out.println(m.mergeKLists(l));
		System.out.println("Done...");
	}
}
