package yuli.app.tools;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * Metodo para guardar archivo
	 * @param multiPart
	 * @param request
	 * @return
	 */
	public static String saveImg(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String originalName = multiPart.getOriginalFilename();
		//REemplazar espacios vacion en el nombre de img
		originalName = originalName.replace(" ", "_");
		String finalName = (new StringBuilder()).append(getActuallyDate()).append("_").append(originalName).toString();
		// Obtenemos la ruta ABSOLUTA del directorio images /apache-tomcat/webapps/cineapp/resources/images/
		String finalPath = request.getServletContext().getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(finalPath + finalName);
			// Aqui se guarda fisicamente el archivo en el disco duro
			System.out.println(imageFile.getAbsolutePath());
			multiPart.transferTo(imageFile);
			return finalName;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private static String getActuallyDate() {

		// Instanciamos el objeto Calendar en fecha obtenemos la fecha y hora del
		// sistema
		Calendar date = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema
		// usando el método get y el parámetro correspondiente
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int min = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);
		String dateNow = (new StringBuilder()).append(day).append("_").append(month).append("_").append(year)
				.append("_").append(hour).append("_").append(min).append("_").append(second).toString();
		//System.out.println(dateNow);

		return dateNow;

	}
}
