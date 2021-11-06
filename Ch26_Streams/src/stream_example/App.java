package stream_example;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		//스티림 예제
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(6);
		numbers.add(2);
		numbers.add(4);

		numbers.forEach(System.out::println);
		
		System.out.println();
		
		//컬렉션 타입은 메소드 stream()을 써서 생성
		numbers.stream().forEach(System.out::println);
			
		
	}

}
