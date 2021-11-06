package hashSet_union_intersection;

import java.util.HashSet;

public class App {

	public static void main(String[] args) {
		
		HashSet<String> fruits1 = new HashSet<>();
		fruits1.add("사과");
		fruits1.add("배");
		fruits1.add("딸기");
		fruits1.add("수박");
	
		HashSet<String> fruits2 = new HashSet<>();
		fruits2.add("체리");
		fruits2.add("배");
		fruits2.add("사과");
		fruits2.add("오랜지");
	
		HashSet<String> union = new HashSet<>(fruits1);
	
		union.forEach(System.out::println);
	
		union.addAll(fruits2);
		
		System.out.println();
		union.forEach(System.out::println);
	
		HashSet<String> intersection = new HashSet<>(fruits1);
		
		intersection.retainAll(fruits2);
	
		System.out.println();
		intersection.forEach(System.out::println);
		
		
		HashSet<String> minus = new HashSet<>(fruits1);
		minus.removeAll(fruits2);
		
		System.out.println();
		minus.forEach(System.out::println);
		
		
		
		
	}
}



	


