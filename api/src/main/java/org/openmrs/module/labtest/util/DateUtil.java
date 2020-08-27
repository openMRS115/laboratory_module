package org.openmrs.module.labtest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getCurrentTime() {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(currentTime);
		String strdate = formatter.format(date);
		return strdate;
	}
}
