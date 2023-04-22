package com.hs.intervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
	public int minMeetingRooms(List<Interval> intervals) {
		if (intervals.isEmpty())
			return 0;

		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		Queue<Interval> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

		int count = 0;
		for (Interval interval : intervals) {
			while (!queue.isEmpty() && interval.start >= queue.peek().end)
				queue.poll();

			queue.offer(interval);
			count = Math.max(count, queue.size());
		}
		return count;
	}
}