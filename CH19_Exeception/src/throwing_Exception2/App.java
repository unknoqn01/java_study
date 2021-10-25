package throwing_Exception2;

public class App {

	public static void main(String[] args) {
		// 예외처리를 넘김
		Thermostat stat = new Thermostat();
		try {
			stat.setTemperature(36);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}


}
