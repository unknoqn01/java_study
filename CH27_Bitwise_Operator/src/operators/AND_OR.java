package operators;

public class AND_OR {

	public static void main(String[] args) {
		// 비트연산 AND ,OR
		
		//System.out.println(toBinaryString(15));
		
		int value1 = 0b01010011;
		int value2 = 0b11010110;
		
		//int result1 = value1 & value2;
		int result2 = value1 | value2;
		
		
		System.out.println(toBinaryString(value1));
		System.out.println(toBinaryString(value2));
		System.out.println(toBinaryString(result2));
	
	}

	private static String toBinaryString(int n) {
		// 이진수로 보여주기 위한 메소드
		return String.format("%8s", Integer.toBinaryString(n)).replace(" ", "0");
	}

}
