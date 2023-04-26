package com.hs.intervals;

import java.util.ArrayList;
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

			queue.add(interval);
			count = Math.max(count, queue.size());
		}
		return count;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(0, 30));
		list.add(new Interval(5, 10));
		list.add(new Interval(15, 20));
		list.add(new Interval(7, 12));
		list.add(new Interval(25, 30));

		MeetingRooms2 obj = new MeetingRooms2();
		int result = obj.minMeetingRooms(list);
		System.out.println(result);
	}
}