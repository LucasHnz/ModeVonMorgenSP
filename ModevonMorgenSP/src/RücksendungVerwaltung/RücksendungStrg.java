package RücksendungVerwaltung;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RücksendungStrg {
	
	public static String aktuellesDatum() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter df;
		
		df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		
		
		String datum = String.valueOf(date.format(df));
		
		return datum ;
		
	}
	
	public static void main(String[]args) {
		String d = aktuellesDatum();
		System.out.println(d);
	}
	
}
