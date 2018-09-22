package com.lupus.gc7r6a2;

import java.util.Calendar;
import java.util.Iterator;

public class DateCombination implements Iterable<Calendar> {

	private final Calendar startDate;
	
	public DateCombination(Calendar startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public Iterator<Calendar> iterator() {
		return new DateCombinationIterator(startDate);
	}
	
	public Calendar getStartDate() {
		return startDate;
	}

}
