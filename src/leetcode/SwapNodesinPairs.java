package leetcode;

/**
 * @author FDws
 * @date 2017年12月15日 下午9:48:57
 * @title Swap Nodes in Pairs
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}

	public static void main(String[] args) {
		ListNode l = ListNode.generatorListNode(new int[] { 1, 2, 3, 4 });
		SwapNodesinPairs s = new SwapNodesinPairs();
		ListNode.out(s.swapPairs(l));
	}
}
