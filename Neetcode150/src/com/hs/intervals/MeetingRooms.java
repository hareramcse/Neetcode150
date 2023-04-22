package com.hs.intervals;

import java.util.Collections;
import java.util.List;

public class MeetingRooms {
	public boolean canAttendMeetings(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> a.start - b.start);

		for (int i = 0; i + 1 < intervals.size(); i++) {
			if (intervals.get(i).end > intervals.get(i + 1).start) {
				return false;
			}
		}
		return true;
	}
}