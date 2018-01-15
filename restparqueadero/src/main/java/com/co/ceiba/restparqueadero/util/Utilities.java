package com.co.ceiba.restparqueadero.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

	public boolean valPlaca(String placa) {
		Pattern pattern = Pattern.compile("^[A-Z]{3}\\d{3}");
		Matcher match = pattern.matcher(placa);
		return match.matches();
	}
	public boolean valRegla(String placa,String regla ) {
		if (String.valueOf(placa.charAt(0)).equalsIgnoreCase(regla)) {
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(now); 
	        int day = calendar.get(Calendar.DAY_OF_WEEK);
	        return day == 1 || day == 2;
		} else {
			return true;
		}
	}
}
