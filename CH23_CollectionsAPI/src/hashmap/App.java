package hashmap;

import java.util.HashMap;

public class App {

	public static void main(String[] args) {

		HashMap<Integer, String> people = new HashMap<>();
	
		people.put(0, "펭수");
		people.put(1, "길동");
		people.put(3, "라이언");
		people.put(4, "프레드"); // 4번 키에 value값을 "마이클"로 수정
		people.put(4, "마이클");
		people.put(10, "수지");
		
		people.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
		
		System.out.println(people.get(4));
		
		String person = people.get(10);
		System.out.println(person);
		
		}

}
