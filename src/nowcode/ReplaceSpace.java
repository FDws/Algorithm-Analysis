package nowcode;

/**
 * @author FDws
 * @date 2018/3/22  21:52
 * @title 空格替换
 */

public class ReplaceSpace {
	public String replaceSpace(StringBuffer buffer) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buffer.length(); i++) {
			if (buffer.charAt(i) == ' ') {
				builder.append("%20");
			} else {
				builder.append(buffer.charAt(i));
			}
		}
		return builder.toString();
	}
}
