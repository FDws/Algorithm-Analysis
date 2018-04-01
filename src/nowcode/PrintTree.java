package nowcode;

import nowcode.node.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 由上至下打印树的节点
 * @author FDws
 * @date 2018/3/29  22:06
 */

public class PrintTree {
	public List<Integer> printFromTopToBottom(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tn = queue.poll();
			if (tn != null) {
				result.add(tn.val);
				queue.add(tn.left);
				queue.add(tn.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode le = new TreeNode(2);
		TreeNode ri = new TreeNode(3);
		TreeNode l = new TreeNode(4);
		root.left = le;
		root.right = ri;
		ri.left = l;

		PrintTree pt = new PrintTree();
		System.out.println(pt.printFromTopToBottom(root));
	}
}
