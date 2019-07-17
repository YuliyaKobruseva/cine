package yuli.app.tools;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ToolsApp {

	/**
	 * Method for generate List with date beetwen now and counter
	 * 
	 * @param count
	 * @return list with date
	 */
	public static List<String> getNextDay(int count) {
		// devolvera count+1 fechas porque epieza a contar desde 0
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = calendar.getTime();

		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gCalendar.getTime().after(endDate)) {
			Date date = gCalendar.getTime();
			gCalendar.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(date));
		}

		return nextDays;
	}
}
