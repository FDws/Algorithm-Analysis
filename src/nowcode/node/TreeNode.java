package nowcode.node;

/**
 * @author FDws
 * @date 2018/3/28  20:48
 */

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		this.val = x;
	}

	@Override
	public String toString() {
		return "[" + val + "]";
	}
}
