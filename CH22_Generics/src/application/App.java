package application;


import collections.Wrapper;
import hierarchy.Cat;
import hierarchy.Creature;

public class App {

	public static void main(String[] args) {
		//제네릭 타입 클래스는 객체를 만들때 타입을 지정하나
		Wrapper<Cat> Wrapper = new Wrapper<>(); //포장 클래스의 객체를 만듬
		Wrapper<Creature> Wrapper2 = new Wrapper<>(); //포장 클래스의 객체를 만듬
		
		Cat cat = new Cat("마틸다"); //고did이 마틸다 객체를 생성
		Creature creature = new Creature("생물");
		
		Wrapper.set(cat); //포장 객체의 set 메소드에 마틸다 입력
		Wrapper2.set(creature); //포장 객체의 set 메소드에 마틸다 입력
		
		Cat r1 = Wrapper.get();
		Creature r2 =Wrapper2.get();
		
		System.out.println(r1);
		System.out.println(r2);
		
		r1.feed();
		r2.feed();
	}

}
