package stream_example;

import java.util.stream.IntStream;

public class Int_Stream {
	public static void main(String[] args) {
		//정수형 스트림 IntStream
		IntStream
			.range(1, 10)
			.skip(5)	
			.forEach(x -> System.out.println(x));
	
		System.out.println();
		
		int val = IntStream.range(1,  101).sum();
		System.out.println(val);
	
	
	}		

}
