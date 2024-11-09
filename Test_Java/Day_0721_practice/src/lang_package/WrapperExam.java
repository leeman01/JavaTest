package lang_package;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class WrapperExam {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		System.out.println("오늘 날짜 시간: " + d1);
		
		LocalDate d2 =LocalDate.of(1919, 3,1);
		System.out.println("날짜를 지정하는 방법: " + d2 );

		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println("날짜 및 시간: "+ dt1);
		
		LocalDateTime dt2 = LocalDateTime.of(1950, 6,25,0,0,0);
		System.out.println("시간지정하는 법: " + dt2);
		
		LocalDateTime dt3 = LocalDate.now().atTime(LocalTime.MIDNIGHT);
		LocalDateTime dt4 = LocalDate.now().atTime(LocalTime.MAX);
		
		System.out.println(dt3);
		System.out.println(dt4);
		
		LocalDateTime time1 = LocalDateTime.now();
		LocalDateTime time2 = LocalDateTime.now(Clock.systemDefaultZone());
		LocalDateTime time3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		
		System.out.println("LocalDateTime.now(Clock.systemDefaultZone()): " + time3);
		
		LocalDateTime time4 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("time 4 : " + time4 );
		
		LocalDateTime vote = Year.of(2023).atMonth(4).atDay(10).atTime(10,00);
		System.out.println("선거날: "+ vote);
		
		LocalDateTime time7 = LocalDate.now().atTime(10,30);
		System.out.println(time7);
		
		LocalDateTime localdate1 = LocalDateTime.of(2021,03,5,10,0,0);
		
		String format1 = localdate1.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
		System.out.println(format1);
		
		
	}

}
