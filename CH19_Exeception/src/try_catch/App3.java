package try_catch;

import java.util.Scanner;

public class App3 {
	private static Scanner scanner = new Scanner(System.in);
	
private static int getNumber() {
		
		int number = 0;
		boolean isNumber = false;
		
	do {
		System.out.print("숫자를 입력 : ");
		String line = scanner.nextLine();
		
		try { //에러가 날수 있는 코드를 try문 안에 넣는다.
		
			number = Integer.parseInt(line);
			isNumber = true;
			scanner.close();
		}
		 catch (Exception e) { //try에서 에러 발생시 catch 문에서 처리
			System.out.println("숫자 입력이 아닙니다");
		 }
		 
		} while(!isNumber);
		return number;
	
}
	
	public static void main(String[] args) {
		
		getNumber();
			
	}

	
}
