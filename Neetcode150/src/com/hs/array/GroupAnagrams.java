package com.hs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0)
			return res;
		
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			int[] hash = new int[26];
			for (char c : s.toCharArray()) {
				hash[c - 'a']++;
			}
			String key = new String(Arrays.toString(hash));
			map.computeIfAbsent(key, k -> new ArrayList<>());
			map.get(key).add(s);
		}
		res.addAll(map.values());
		return res;
	}

	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = obj.groupAnagrams(strs);
		System.out.println(result);
	}
}