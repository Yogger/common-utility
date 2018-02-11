package com.windforce.common.utility;

import java.util.Calendar;

import org.junit.Test;

public class DateUtilsTest {

	/**
	 * @param args
	 */
	@Test
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.add(Calendar.DAY_OF_YEAR, -1);
//		System.out.println(DateUtils.isBetweenHourOfDay(10, cal.getTime()));
	}

}
