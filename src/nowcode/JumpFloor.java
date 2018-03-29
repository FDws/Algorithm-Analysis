package nowcode;

/**
 * @author FDws
 * @date 2018/3/28  20:51
 */

public class JumpFloor {
	int times;

	public void resolver(int target) {
		if (target == 1) {
			times++;
		} else if (target == 2) {
			times += 2;
		} else {
			resolver(target - 1);
			resolver(target - 2);
		}
	}

	public int re(int target) {
		resolver(target);
		return times;
	}


}
