package leetcode;

/**
 * @author FDws
 * @date 2017年12月17日 上午10:50:58
 * @title Reverse Nodes in k-Group
 */
public class ReverseNodesink_Group {
	int k = 0;
	ListNode[] arry = null;

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}
		this.k = k;
		arry = new ListNode[k];

		return reverse(head, 0);
	}

	public ListNode reverse(ListNode now, int loc) {
		if (now == null) {
			arry[loc] = now;
			return arry[0];
		}
		if (loc == k - 1) {
			ListNode next = now.next;
			arry[loc] = now;
			for (int i = loc; i > 0; i--) {
				arry[i].next = arry[i - 1];
			}
			arry[0].next = reverse(next, 0);
			return now;
		} else {
			arry[loc] = now;
			return reverse(now.next, loc + 1);
		}
	}

	public static void main(String[] args) {
		ReverseNodesink_Group r = new ReverseNodesink_Group();
		System.out.println("Begin...");
		ListNode.out(r.reverseKGroup(ListNode.generatorListNode(new int[] { 1, 2 }), 2));
		System.out.println("Done...");
	}
}
