package lambda_Example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

interface Runner {
	void exacute();
}

public class App2 {

	public static void main(String[] args) {
		//직접 함수형 인처페이스를 만들어 람다식 사용
		// 1. 함수형 인터페이스 (메소드가 1개)일때 사용가능
		// 2. 추상메소드의 리턴값과 매개변수를 확인하고 생성한다.
		
		Runner run = () -> System.out.println("헬로우");
		
		run.exacute();
		
	}
	
}
