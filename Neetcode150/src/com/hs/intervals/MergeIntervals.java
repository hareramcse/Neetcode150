package com.hs.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();

		if (intervals.length == 0 || intervals == null)
			return res.toArray(new int[0][]);

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] i : intervals) {
			if (i[0] <= end) {
				end = Math.max(end, i[1]);
			} else {
				res.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		MergeIntervals obj = new MergeIntervals();
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 2, 6 }, { 8, 9 }, { 8, 10 }, { 9, 11 }, { 15, 18 }, { 16, 17 } };

		int[][] result = obj.merge(intervals);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}