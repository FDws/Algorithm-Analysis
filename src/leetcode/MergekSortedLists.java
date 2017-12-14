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
		return mergeKLists(lists, 0, lists.length - 1);
	}

	public ListNode mergeKLists(ListNode[] lists, int begin, int right) {
		if (right == begin) {
			return lists[begin];
		} else if (right == begin + 1) {
			return mergeTwoLists(lists[begin], lists[right]);
		}

		int mid = (right - begin) >> 1;

		return mergeTwoLists(mergeKLists(lists, begin, begin + mid), mergeKLists(lists, begin + mid + 1, right));
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

	public ListNode generatorListNode(int[] a) {
		ListNode head = new ListNode(0);
		ListNode move = head;
		for (int x : a) {
			move.next = new ListNode(x);
			move = move.next;
		}
		return head.next;
	}

	public void out(ListNode l) {
		ListNode m = l;
		while (m != null) {
			System.out.print(m.val + " -> ");
			m = m.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergekSortedLists m = new MergekSortedLists();
		ListNode[] l = new ListNode[3];
		// l[0] = m.generatorListNode(new int[] { 1, 3, 8, 8, 9 });
		// l[1] = m.generatorListNode(new int[] { 0, 0, 4, 9, 18 });
		// l[2] = m.generatorListNode(new int[] { 0, 1, 10, 19, 28 });
		System.out.println("Begin...");
		m.out(m.mergeKLists(l));
		System.out.println("Done...");
	}
}
