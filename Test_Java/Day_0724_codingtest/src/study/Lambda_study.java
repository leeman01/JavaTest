package study;

import java.util.ArrayList;
import java.util.function.Function;

public class Lambda_study {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		for (int i=0;i<10;++i) {
			list.add(i);
		}
		list.forEach(i-> System.out.print(i+","));
		
		list.removeIf(i-> i%2==0 || i%3==0);
		System.out.print(list+",");
		
		
		list.replaceAll(i->i*10);
		System.out.print(list+",");
		
		// 문자열을 정수로 반환하는 람다식
		Function<String,Integer> f =(String s) -> Integer.parseInt(s);
		
		// 이걸 더 간편하게 만들면?
		Function<String, Integer> f1 = Integer::parseInt;

        // Test the function
        String numberStr = "123";
        Integer number = f1.apply(numberStr); // 위에서 만들어진 함수를 적용하기 위해서는 apply를 써야한다
        System.out.println("Parsed number: " + number);
        
        // 람다식 메서드 참조
//        
//        Supplier<Myclass> s = () -> new Myclass();
//        Supplier<Myclass> s = Myclass :: new; // 메서드 참조
//        
//        Function<Integer,Myclass>f =(i) -> new Myclass(i);
//        Function<Integer,Myclass>f =Myclass :: new
        
        
        
        
        
        
        
        
        
        
	}

}
