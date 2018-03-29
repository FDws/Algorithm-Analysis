package nowcode;

import java.util.LinkedList;

/**
 * 判断第一个序列的压栈顺序能否出现第二个序列的弹出顺序
 *
 * @author FDws
 * @date 2018/3/29  17:22
 */

public class StackOrder {
	public boolean isPopOrder(int[] pushA, int[] popA) {
		LinkedList<Integer> stack = new LinkedList<>();
		int index = 0;
		for (int aPushA : pushA) {
			if (stack.isEmpty()) {
				stack.push(aPushA);
			}
			while (stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
			stack.push(aPushA);
		}
		return stack.isEmpty();
	}
}
