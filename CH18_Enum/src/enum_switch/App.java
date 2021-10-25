package enum_switch;

public class App {

	public static void main(String[] args) {
		Fruit f1 = Fruit.apple;

		switch(f1) {
		case orange:
			System.out.println("오렌지");
			break;
		case banana:
			System.out.println("바나나");
			break;
		case apple:
			System.out.println("사과");
			break;
		default:
			System.out.println("없는 과일");
			break;
			
			
			
		}
	}

}
