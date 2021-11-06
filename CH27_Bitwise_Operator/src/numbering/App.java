package numbering;

public class App {

	public static void main(String[] args) {
		/*
		 * 10진수 : decimal 0-9 
		 *  2진수 : binary 0-1 컴퓨터가 사용
		 *  16진수 : hexadecimal 0-f 이진수를 보기좋게 표시
		 *  예) 1234, 01001, 1B2F
		 */
		
		int value = 123;
		
		System.out.print(Integer.toBinaryString(value)+" "); //2진수 변환
		System.out.println(Integer.toHexString(value)); //16진수 변환
		
		int value255 = 0xFF; //0x는 16진수를 의믜, 0b는 이진수를 의미
		System.out.print(value255+" ");
		System.out.print(Integer.toBinaryString(value255)+" "); //2진수 변환
		System.out.println(Integer.toHexString(value255)); //16진수 변환
		
	}

}
