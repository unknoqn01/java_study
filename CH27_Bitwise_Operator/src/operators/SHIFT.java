package operators;

public class SHIFT {

	public static void main(String[] args) {
		// 비트 쉬프트 ㅇ녀산
		int value = 0b00010001;
		
		System.out.print(toBinaryString(value)+" ");
		System.out.println(value+" ");
		
		int result1 = value <<3;
		
		System.out.print(toBinaryString(result1)+" ");
		System.out.println(result1);
		
		int result2 = result1 >>3;
		
		System.out.print(toBinaryString(result2)+" ");
		System.out.println(result2);
		
		//System.out.println(100 << 2); //곱하기 4
		//System.out.println(100 >>1); //나누기 2
	
	}

	private static String toBinaryString(int n) {
		// 이진수로 보여주기 위한 메소드
		return String.format("%8s", Integer.toBinaryString(n)).replace(" ", "0");
	}
}
