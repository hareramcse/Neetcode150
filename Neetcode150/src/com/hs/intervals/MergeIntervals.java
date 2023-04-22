package com.hs.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> ans = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		ans.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			// comparing the values of prevEnd and curEnd
			int curStart = intervals[i][0];
			if (curStart <= ans.get(ans.size() - 1)[1]) {
				// do the merging
				ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
			} else {
				ans.add(intervals[i]);
			}
		}
		int[][] res = new int[ans.size()][2];
		ans.toArray(res);
		return res;
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
