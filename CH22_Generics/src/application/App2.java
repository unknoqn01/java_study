package application;


import collections.Pair;
import collections.Wrapper;
import hierarchy.Cat;
import hierarchy.Creature;

public class App2 {

	public static void main(String[] args) {
		// Integer는 숫자 int의 클래스형
		Pair<Integer, Cat> pair = new Pair(5, new Cat("마틸다"));
		
		System.out.println(pair);
		
		System.out.println(pair.getOne());
		System.out.println(pair.getTwo());
		
		
	}

}
