package com.hs.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		int intervalsRemoved = 0;

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int[] firstInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			if (firstIntervalwithinSecond(firstInterval, intervals[i])) {
				// mark first interval to be removed
				intervalsRemoved++;
				// determines which interval to remove, remove the interval that ends last
				if (firstInterval[1] > intervals[i][1]) {
					firstInterval = intervals[i];
				}
			} else {
				firstInterval = intervals[i];
			}
		}
		return intervalsRemoved;
	}

	public boolean firstIntervalwithinSecond(int[] firstInterval, int[] secondInterval) {
		return firstInterval[1] > secondInterval[0];
	}

	public static void main(String[] args) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int result = obj.eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
}