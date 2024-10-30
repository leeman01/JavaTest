package dateapi;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;

public class LocalDateTimeTest_01 {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.of(1919,3,1);
		
		LocalTime t1 = LocalTime.now();
		LocalTime t2 = LocalTime.of(12,40,45);
		
		LocalDateTime dt1 = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.of(1950,6,25,0,0,0);
		
		LocalDateTime dt3 = LocalDate.now().atTime(LocalTime.MIDNIGHT);
		LocalDateTime dt4 = LocalDate.now().atTime(LocalTime.MAX);
		
		System.out.println("LocalDateNow() : " + d1);
		System.out.println("LocalDateNow() : " + d2);
		System.out.println("LocalDateNow() : " + t1);
		System.out.println("LocalDateNow() : " + t2);
		System.out.println("LocalDateNow() : " + dt1);
		System.out.println("LocalDateNow() : " + dt2);
		System.out.println("LocalDateNow() : " + dt3);
		System.out.println("LocalDateNow() : " + dt4);
		
		LocalDateTime time1 = LocalDateTime.now();
		LocalDateTime time2 = LocalDateTime.now(Clock.systemDefaultZone());
		LocalDateTime time3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		// of()
		LocalDateTime time4 = LocalDateTime.of(2024, 1, 15, 0, 0, 0);
		LocalDateTime time5 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		// parse()
		LocalDateTime independent = LocalDateTime.parse("1945-08-15T15:36:00.000");
		System.out.println("광복절 일왕 방송: " + independent);
		LocalDateTime xmas = LocalDateTime.of(2024, 12, 25, 0, 0, 0);
		System.out.println("2024년 Christmas: " + xmas);
		// at()
		LocalDateTime vote = Year.of(2024).atMonth(4).atDay(10).atTime(10, 00);
		System.out.println("22대 국회의원선거일: " + vote);
		LocalDateTime time7 = LocalDate.now().atTime(10, 30);
		LocalDateTime time6 = Year.of(2024).atMonth(1).atDay(15).atTime(10, 30);
		
		
		
		
		
		
		
		
		
		
		
	}
}
