package misc;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTime1 {
	
	public static void main(String[] args) {
		
		ZonedDateTime dateTime = ZonedDateTime.parse("2022-12-28T09:15:00+05:30");
		
		System.out.println(dateTime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		System.out.println(dateTime.format(formatter).toString());
		
		
	}

}
