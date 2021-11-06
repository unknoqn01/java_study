package stream_example;

import java.util.stream.Stream;

public class Geneating_Stream {

	public static void main(String[] args) {
		// Stream.of() -> 스트림생성
		Stream.of(1,2,3).forEachOrdered(System.out::println);
		Stream.of("하나","둘","셋").forEachOrdered(System.out::println);
	
		//Stream.generate(람다식)
		Stream.generate(() -> "헬로우").limit(5).forEach(System.out::println);
		
		
	}

}
