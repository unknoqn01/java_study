package arrayList;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		//어레이 리스트
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(7);
		list.add(9);
		list.add(123);
		list.add(9999);
		
		//출력
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}

}
