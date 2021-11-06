package arrays_aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		//배열을 리스트로
		List<String> names = Arrays.asList("Eric", "Elena", "Java");
		
		names.stream()
			.filter(name -> name.contains("a"))
			.map(String::toUpperCase) //대문자
			.forEach(System.out::println); //출력
		
		List<Integer> numbers = Arrays.asList(9,4,6,3,2,1);
		
		numbers.stream()
			.filter(n -> n > 3) // 9,4,6만 남는
			.sorted()			// 4,6,9
			.map(n -> n*10)		// 40, 60, 90
			.forEach(System.out::println);
		
		
		
		
	}

}
