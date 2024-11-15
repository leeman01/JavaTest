package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_study {

	public static void main(String[] args) {
		// 스트림이란 배열과 리스트에서 사용되는 메소드가 각기 다르니 이를 통합해서 보다 쉽게 코딩을 하게 도와 준다
		// 배열 : 크기가 고정됨 int [] array
		// list : 크기가 고정되지 않은 arraylist나 list
		
		String[] strArr = {"abc","ddd","ccc"};
		
		List<String> strlist = Arrays.asList(strArr);
		
		Stream<String> strStream1 = strlist.stream();
		Stream<String> strstream2 = Arrays.stream(strArr);
		
		strStream1.sorted().forEach((i)->System.out.println(i));
		strstream2.sorted().forEach((i)->System.out.println(i)); // 보기에는 정렬된 처럼 보이지만 실제로는 아니라는 걸 명심
		
		// 스트림은 데이터 소스로부터 데이터를 읽기만 할뿐 실제로는 변경하지 않는다는 차이가 있다
		// 필요하면 정렬된 결과를 컬렉션이나 배열에 담아 반환할 수 있다
		
//		List<String> sortedList= strStream1.sorted().collect(Collectors.toList()); // 이런식으로 반환
		// 스트림 만들기
		List <Integer> list = Arrays.asList(1,2,3,4,5);
		Stream <Integer> intstream = list.stream();
		intstream.forEach(System.out::println);
//		intstream.forEach(System.out::println); 스트림의 경우 Iterator와 마찬가지로 일회용이라 한번사용하면 닫혀버린다
		// 이문제는 다시 Stream을 만들 수 밖에없다
		
		Stream<String> strStream =Stream.of("a","b","c");
		// 특정 범위의 정수 만들기
		
		 IntStream intstream1 =IntStream.range(1, 5);
		 IntStream intstream2 =IntStream.rangeClosed(1,5);
		
		 intstream1.forEach(System.out::print);
		 System.out.println();
		 intstream2.forEach(System.out::print);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
