package nowcode;

import java.util.Arrays;

/**
 * 根据给定的前序遍历和中序遍历, 构建二叉树输出
 *
 * @author FDws
 * @date 2018/3/22  22:02
 * @title 重建二叉树
 */

public class ReBuildTree {
	public TreeNode reConstructBinaryTree(int[] pri, int[] in) {
		if (pri.length == 0) {
			return null;
		}
		if (pri.length == 1) {
			return new TreeNode(pri[0]);
		}

		int root = pri[0];
		int mid = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == root) {
				mid = i;
				break;
			}
		}

		TreeNode tree = new TreeNode(root);
		tree.left = reConstructBinaryTree(Arrays.copyOfRange(pri, 1, mid + 1), Arrays.copyOfRange(in, 0, mid));
		tree.right = reConstructBinaryTree(Arrays.copyOfRange(pri, mid + 1, pri.length), Arrays.copyOfRange(in, mid + 1, in.length));
		return tree;
	}

	public static void main(String[] args) {

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
	}
}
