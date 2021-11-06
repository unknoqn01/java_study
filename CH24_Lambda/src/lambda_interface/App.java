package lambda_interface;

import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {
		//Predicate는 제네릭 T 타입을 검사해서(test) boolean 리턴
		Predicate<String> p1 = new Predicate<>() {

			@Override
			public boolean test(String t) {
				// 추상메소드 테스트 리턴값(참/거짓) , 문자열 매개변수1
				return t.length() < 4;
			}
		};
		
		System.out.println(p1.test("abcd"));
		System.out.println(p1.test("하나둘"));
		
		Predicate<String> p2 = t -> t.length() < 4;
		
		System.out.println(p2.test("abcd"));
		System.out.println(p2.test("하나둘"));
		
	}

}
