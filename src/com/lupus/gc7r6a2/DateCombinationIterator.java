package com.lupus.gc7r6a2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

public class DateCombinationIterator implements Iterator<Calendar> {

	private Calendar calendar;
	private boolean doInc = false;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
	
	public DateCombinationIterator(Calendar calendar) {
		this.calendar = calendar;
	}
	
	@Override
	public boolean hasNext() {
		String dateStr = sdf.format(calendar.getTime());
		
		return !noDuplicates(dateStr);
	}

	@Override
	public Calendar next() {
		if (doInc) {
			calendar.add(Calendar.MINUTE, 1);
		} else {
			doInc = true;
		}
			
		return calendar;
	}
	
	private boolean noDuplicates(String str) {
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i < charArray.length - 1; i++) {
			char c1 = charArray[i];
			for (int j = i + 1; j < charArray.length; j++) {
				if (c1 == charArray[j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
