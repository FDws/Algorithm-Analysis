package leetcode;

import nowcode.node.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * Created on 2018/4/12 16:14
 */

public class SerializeTree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(11);
        t.right = t1;
        t1.right = t2;
        t2.right = t3;
        //t.left = t1;
        //t.right = t2;
        //t1.left = t3;
        //t1.right = t4;
        //t2.left = t5;
        //t2.right = t6;
        SerializeTree st = new SerializeTree();
        String str = st.Serialize(t);
        System.out.println(str);
        System.out.println(st.Serialize(st.Deserialize(str)));
    }

    String Serialize(TreeNode root) {
        if(root == null) return "# ";
        return root.val+" " + Serialize(root.left) + Serialize(root.right);
//        List<TreeNode> list = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        if (root == null) return sb.toString();
//        list.add(root);
//        sb.append(root.val);
//        sb.append(" ");
//        while (!list.isEmpty()) {
//            TreeNode no = list.get(0);
//            list.remove(0);
//            if (no.left != null) {
//                sb.append(no.left.val);
//                sb.append(" ");
//                list.add(no.left);
//                if (no.right == null) {
//                    sb.append("# ");
//                }
//            }
//            if (no.right != null) {
//                if (no.left == null) {
//                    sb.append("# ");
//                }
//                sb.append(no.right.val);
//                sb.append(" ");
//                list.add(no.right);
//            }
//        }
//        return sb.toString().trim();
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        System.out.println("str = [" + index + "]");
        String[] s = str.trim().split(" ");

        if(index >= s.length || s[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s[index]));
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
//        if (str.length() == 0) {
//            return null;
//        }
//        String[] tree = str.split(" ");
//        System.out.println("Len: " + tree.length);
//        for (String t : tree) {
//            System.out.println("str = [" + t + "]");
//        }
//        System.out.println();
//        int i = 0;
//        List<TreeNode> list = new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.parseInt(tree[i]));
//        list.add(root);
//        while (i < tree.length - 1) {
//            i++;
//            TreeNode node = list.get(0);
//            String l = tree[i];
//            if ((i & 1) == 1) {
//                System.out.println("Left " + i);
//                if (l.equals("#")) continue;
//                node.left = new TreeNode(Integer.parseInt(tree[i]));
//                list.add(node.left);
//            } else {
//                System.out.println("Right " + i);
//                list.remove(0);
//                if (l.equals("#")) continue;
//                node.right = new TreeNode(Integer.parseInt(tree[i]));
//                list.add(node.right);
//            }
//        }
//        return root;
    }
}
