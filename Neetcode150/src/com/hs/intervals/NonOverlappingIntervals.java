package com.hs.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		int count = 0;

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int prevEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			int curStart = intervals[i][0];
			int curEnd = intervals[i][1];
			if (prevEnd > curStart) {
				// mark first interval to be removed
				count++;
				// determines which interval to remove, remove the interval that ends last
				prevEnd = Math.min(prevEnd, curEnd);
			} else {
				prevEnd = curEnd;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int result = obj.eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
}