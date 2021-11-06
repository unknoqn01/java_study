package lambda_parameter2;

interface Runner {
	void execute(String name, String text);
}

public class App {

	public static void main(String[] args) {
		// 파라메터2(매개변수) 있는 추상메소드
		Runner run = (n, t) -> System.out.printf("%s님 %s \n", n, t);
		Runner run2 = (n, t) -> System.out.printf("%s %s님 \n", t, n);
		run.execute("펭수", "안녕하세요");
	
		greet(run);
		greet(run2);
	}

	private static void greet(Runner run) {
		run.execute("길동", "아녕하세요");
	}

}
