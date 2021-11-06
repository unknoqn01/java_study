package linked_HasheSet;

import java.util.LinkedHashSet;


public class App {

	public static void main(String[] args) {
		
		LinkedHashSet<String> fruits = new LinkedHashSet<>();
		
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("오렌지");
		fruits.add("오렌지");
		fruits.add("배");
		fruits.add("사과");
		fruits.add("사과");
	
		System.out.println(fruits.contains("오렌지"));
		
		for(String f : fruits) { 
			System.out.println(f);
		}
	
	
	}

}
