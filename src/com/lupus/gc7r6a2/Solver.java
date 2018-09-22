package com.lupus.gc7r6a2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solver {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
		DateCombination dateCombination = new DateCombination(new GregorianCalendar());
		Calendar cal=null;
		
		for (Calendar calendar : dateCombination) {
//			Date date = calendar.getTime();
			cal = calendar;
//			System.out.println(sdf.format(date));
		}
		System.out.println(sdf.format(cal.getTime()));
		
	}

}
