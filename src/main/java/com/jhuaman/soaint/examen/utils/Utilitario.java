package com.jhuaman.soaint.examen.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilitario {

	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof StringBuilder) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof List<?> || object instanceof ArrayList<?>) {
			return ((List<?>) object).isEmpty();
		}
		if (object instanceof Map<?, ?> || object instanceof HashMap<?, ?>) {
			return ((Map<?, ?>) object).isEmpty();
		}
		return false;
	}

	public static String dateToString(Date fechaDate, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.format(fechaDate);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date stringToDate(String fechaString, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.parse(fechaString);
		} catch (Exception e) {
			return null;
		}
	}

	public static String dateToStringDDMMYYYY(Date fechaDate) {
		return dateToString(fechaDate, "dd/MM/yyyy");
	}

	public static Date stringToDateDDMMYYYY(String fechaString) {
		return stringToDate(fechaString,"dd/MM/yyyy");
	}
	
}
