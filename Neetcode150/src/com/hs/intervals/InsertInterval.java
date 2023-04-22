package com.hs.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();
		for (int[] interval : intervals) {
			if (newInterval == null || interval[1] < newInterval[0])
				res.add(interval);
			else if (interval[0] > newInterval[1]) {
				res.add(newInterval);
				res.add(interval);
				newInterval = null;
			} else {
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			}
		}
		if (newInterval != null)
			res.add(newInterval);
		return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		InsertInterval obj = new InsertInterval();
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] result = obj.insert(intervals, newInterval);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}