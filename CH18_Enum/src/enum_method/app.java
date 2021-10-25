package enum_method;

import enum_example.Fruit;

public class app {

	public static void main(String[] args) {
		//values() 메소드 해당 enum의 모든 상수를 저장한 배열을 리턴
		//Fruit[] fruits = Fruit.values();
		
		for(Fruit f : Fruit.values()) {
			System.out.println(f);
		}
		
		//ordinal 메소드는 상수의 순서(인덱스 0부터 시작)를 리턴
		System.out.println(Fruit.apple.ordinal());
		System.out.println(Fruit.banana.ordinal());
		System.out.println(Fruit.orange.ordinal());
		
		//valueOf("값")메소드 값과 가튼 상수를 찾아서 리턴
		Fruit f1 = Fruit.valueOf("orange"); //문자열 orange와 같은 값을 가진 enum 상수를 찾음
		System.out.println(f1);
		System.out.println(f1 == Fruit.orange);
		
	}

}
