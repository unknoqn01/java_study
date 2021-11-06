package string_array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		// 문자열과 배열 스트림
		Stream.of("헬로우", "물병", "아프리카").sorted() // 정렬: 한글순
				.findFirst() // 첫번째
				.ifPresent(x -> System.out.println(x));
		// if 존재하면 출력(없으면 x)

		System.out.println();

		String[] items = { "치킨", "원숭이", "고릴라", "치약", "고라니", "치과", "고양이" };
		Stream.of(items).filter(x -> x.startsWith("치")) // predicate 객체 참/거짓으로 필터링
				.sorted().forEach(x -> System.out.print(x + ". "));

		System.out.println();

		Arrays.stream(new int[] { 2, 4, 6, 8, 10 })
				.filter( x -> x < 5)
				.map(x -> x * x) // 제곱을 해서 리턴
				.average() // 평균값
				
				.ifPresent( n -> System.out.println(n));
		
		//배열을 리스트로 Arrays.asList(배열)
		List<String> list = Arrays.asList(items);
		list.stream()
			.filter(x -> x.startsWith("고"))
			.sorted()
			.forEach(x -> System.out.println(x + ", "));

		//배열은 Stream.of(배열) 스트림 생성, 리스트는 stream() 생성
		//filter (x ->조건) 조건이 참이면 남기고 아니면 제외
		//sorted() 정렬
		//map(x -> 리턴값) 아이템 값을 리턴값으로 바꿈
		
		
		
		
		
		
		
		
		
		
		
	}

}
