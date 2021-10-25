package exception_example;

public class App {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("하나");
		Thread.sleep(2000); // 1초동안 프로그램 대기
		System.out.println("둘");
	}

}
