package class33;

import java.util.HashMap;
import java.util.Map.Entry;

public class Code01_FindHalfMajority {

	public static int halfMajor(int[] arr) {
		int cand = 0;
		int HP = 0;
		// 遍历一遍数组arr，一次删掉两个不同的数，谁会剩下来，谁就是cand
		for (int i = 0; i != arr.length; i++) {
			if (HP == 0) { // 无候选
				cand = arr[i];
				HP = 1;
			} else if (arr[i] == cand) {
				HP++;
			} else {
				HP--;
			}
		}
		if (HP == 0) {
			System.out.println("你他妈在逗我，没水王");
			return -1;
		}
		HP = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] == cand) {
				HP++;
			}
		}
		return HP > arr.length / 2 ? cand : -1;
	}

	// for test
	public static int right(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int cur : arr) {
			if (!map.containsKey(cur)) {
				map.put(cur, 0);
			}
			map.put(cur, map.get(cur) + 1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > arr.length / 2) {
				return entry.getKey();
			}
		}
		return -1;
	}

	// for test
	public static int[] genareteRandomArray(int len, int max) {
		int[] ans = new int[(int) (Math.random() * len) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (int) (Math.random() * max) + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int len = 100;
		int max = 10;
		int testTime = 100000;
		System.out.println("test begin");
		for (int i = 0; i < testTime; i++) {
			int[] arr = genareteRandomArray(len, max);
			int ans1 = halfMajor(arr);
			int ans2 = right(arr);
			if (ans1 != ans2) {
				System.out.println("Oops!");
				break;
			}
		}
		System.out.println("test end");
	}

}
