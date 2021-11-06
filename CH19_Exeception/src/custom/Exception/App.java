package custom.Exception;

import custom.Exception.exception.TempoutToHighException;
import custom.Exception.exception.TempoutToLowException;

public class App {

	public static void main(String[] args) throws Exception  {
		// 예외처리를 넘김
		Thermostat stat = new Thermostat();
		
		try {
			stat.setTemperature(40);
		} catch (TempoutToHighException e) {
			//온도가 잦을 경우 처리 코드
			System.out.println(e.getMessage());
		} catch (TempoutToLowException e) {
			//온도가 높을경우 처리 코드
			System.out.println(e.getMessage());
		}
	}
}