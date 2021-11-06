package example;

interface Greeter{ 
	void greet(); // 추상메소드
}

public class App {
		

	public static void main(String[] args) {
		// 메소드 레퍼런스로 람다식 대체
		Greeter g = App::sayHello; //() -> System.out.println("헬로우");
		
		g.greet( );	
		
	}
	
	private static void sayHello() {
		System.out.println("헬로우~");
	}

}
