package leetcode;

/**
 * @author FDws
 * @date 2017年11月19日 下午3:27:01
 * @title AddTwoNumbers
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = new ListNode(0);
		ListNode sm = sum;
		ListNode lm1 = l1;
		ListNode lm2 = l2;

		int more = 0;
		while (true) {
			int s = 0;
			if (lm1 != null) {
				s = s + lm1.val;
				lm1 = lm1.next;
			}
			if (lm2 != null) {
				s = s + lm2.val;
				lm2 = lm2.next;
			}

			s = s + more;
			if (s == 0 && lm1 == null && lm2 == null)
				break;

			sm.next = new ListNode(s % 10);

			more = s / 10;
			sm = sm.next;
		}
		return sum.next == null ? new ListNode(0) : sum.next;
	}

	void out(ListNode r) {
		while (r != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
		System.out.println("Done");
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);

		int[] n1 = { 1, 6, 0, 3, 3, 6, 7, 2, 0, 1 };
		int[] n2 = { 6, 3, 0, 8, 9, 6, 6, 9, 6, 1 };

		ListNode tem = l1;
		ListNode temp = l2;

		for (int x : n1) {
			tem.next = new ListNode(x);
			tem = tem.next;
		}
		for (int x : n2) {
			temp.next = new ListNode(x);
			temp = temp.next;
		}

		AddTwoNumbers b = new AddTwoNumbers();
		b.out(b.addTwoNumbers(l1.next, l2.next));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void out(ListNode l) {
		ListNode m = l;
		while (m != null) {
			System.out.print(m.val + " -> ");
			m = m.next;
		}
		System.out.println();
	}

	public static ListNode generatorListNode(int[] a) {
		ListNode head = new ListNode(0);
		ListNode move = head;
		for (int x : a) {
			move.next = new ListNode(x);
			move = move.next;
		}
		return head.next;
	}
}
