package com.hs.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int i = 0;
		int j = 0;
		int count = map.size();
		int minLen = Integer.MAX_VALUE;
		String result = "";

		while (j < s.length()) {
			char right = s.charAt(j);
			if (map.containsKey(right)) {
				map.put(right, map.get(right) - 1);
				if (map.get(right) == 0) {
					count--;
				}
			}
			j++;

			while (count == 0) {
				char left = s.charAt(i);
				if (map.containsKey(left)) {
					map.put(left, map.get(left) + 1);
					if (map.get(left) > 0) {
						count++;
					}
				}
				if (j - i < minLen) {
					minLen = j - i;
					result = s.substring(i, j);
				}
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring sol = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = sol.minWindow(s, t);
		System.out.println(res);
	}
}