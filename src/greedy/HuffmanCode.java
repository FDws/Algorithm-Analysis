package greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author FDws
 * @date 2017年11月14日 下午10:07:24
 * @title Huffman 编码
 */
public class HuffmanCode {

	List<HuffmanNode> list = new LinkedList<>();
	Map<Object, String> result = new HashMap<>();

	public HuffmanCode(Map<Object, Double> map) {
		for (Object o : map.keySet()) {
			list.add(new HuffmanNode(o, map.get(o)));
		}
	}

	public Map<Object, String> search() {
		if (list.size() == 1) {
			HuffmanNode node = list.get(0);
			result.put(node.getContent(), "0");
		} else if (list.size() >= 2) {
			while (list.size() != 1) {
				Collections.sort(list);
				HuffmanNode node1 = list.get(0);
				list.remove(0);
				HuffmanNode node2 = list.get(0);
				list.remove(0);
				HuffmanNode newNode = new HuffmanNode(node1.getWeight() + node2.getWeight());
				newNode.setLeft(node1);
				newNode.setRight(node2);
				list.add(newNode);
			}

			getCode();
		}

		return result;
	}

	private void getCode() {
		HuffmanNode node = list.iterator().next();
		node.code("");
	}

	class HuffmanNode implements Comparable<HuffmanNode> {
		double weight;
		Object content;
		HuffmanNode left = null;
		HuffmanNode right = null;

		public HuffmanNode() {

		}

		public HuffmanNode(Object content, double weight) {
			setContent(content);
			setWeight(weight);
		}

		public HuffmanNode(double weight) {
			setWeight(weight);
		}

		public void code(String code) {
			if (left == null) {
				result.put(content, code);
			} else {
				left.code(code + "0");
				right.code(code + "1");
			}
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public Object getContent() {
			return content;
		}

		public void setContent(Object content) {
			this.content = content;
		}

		public HuffmanNode getLeft() {
			return left;
		}

		public void setLeft(HuffmanNode left) {
			this.left = left;
		}

		public HuffmanNode getRight() {
			return right;
		}

		public void setRight(HuffmanNode right) {
			this.right = right;
		}

		@Override
		public int compareTo(HuffmanNode o) {
			return Double.compare(weight, o.getWeight());
		}

		@Override
		public String toString() {
			return content + ":" + weight;
		}

	}

	public static void main(String[] args) {
		char[] content = { 'a', 'b', 'c', 'd', 'e', 'f' };
		double[] weight = { 3, 4, 1, 9, 2, 8 };

		Map<Object, Double> map = new HashMap<>();
		for (int i = 0; i < content.length; i++) {
			map.put(content[i], weight[i]);
		}

		HuffmanCode hc = new HuffmanCode(map);
		Map<Object, String> result = hc.search();
		for (Object o : result.keySet()) {
			System.out.println(o + " : " + result.get(o));
		}

	}
}
