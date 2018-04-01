package leetcode;

/**
 * @author FDws
 * @date 2017年12月8日 下午4:13:34
 * @title Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n==0) {
			return head;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode move = head;
		ListNode del = pre;

		int x = -n;
		while (x < 0) {
			move = move.next;
			x++;
		}
		while (move != null) {
			move = move.next;
			del = del.next;
		}

		del.next = del.next.next;

		return pre.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode m = head;

		int[] l = { 1, 2, 3, 4, 5 };
		int tar = 0;

		for (int x : l) {
			ListNode i = new ListNode(x);
			m.next = i;
			m = i;
		}

		out(head.next);

		RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();

		out(r.removeNthFromEnd(head.next, tar));

	}

	public static void out(ListNode h) {
		ListNode m = h;
		while (m != null) {
			System.out.print(m.val + "->");
			m = m.next;
		}
		System.out.println();
	}
}
