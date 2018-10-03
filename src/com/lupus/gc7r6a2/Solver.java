package com.lupus.gc7r6a2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solver {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
		GregorianCalendar startDate = new GregorianCalendar();
		DateCombination dateCombination = new DateCombination(startDate);
		Calendar cal=null;
		int i=0;
		
		
		for (Calendar calendar : dateCombination) {
//			Date date = calendar.getTime();
			cal = calendar;
			i++;
//			System.out.println(sdf.format(cal.getTime()));
		}
		System.out.println(String.format("%d Versuche waren nötig.\n", i));
		System.out.println(sdf.format(cal.getTime()));
		
	}

}
