package com.hs.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		int[] arr = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) {
			arr[--k] = pq.poll().getKey();
		}
		return arr;
	}

	public static void main(String[] args) {
		TopKFrequentElements sol = new TopKFrequentElements();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] topKFrequent = sol.topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}
}