package custom.Exception;

import custom.Exception.exception.TempoutOfRangeException;
import custom.Exception.exception.TempoutToHighException;
import custom.Exception.exception.TempoutToLowException;

public class Thermostat {
	public void setTemperature(double temperature) throws Exception {
		
		setMachineTemperature(temperature);
		
		System.out.println("온도 세팅 : " + temperature); //온도가 정상일 경우 출력
	}

	private void setMachineTemperature(double temperature) throws TempoutOfRangeException, TempoutToHighException {
		if(temperature < 0) {
			//온도값이 비정상으로 여겨서 예외 처리한다. throw는 일단 예어ㅣ를 나중에 처리(이 메소드를 호출 할때 처리)
			throw new TempoutToLowException("온도가 너무 낮습니다."); //예외를 생성함
		}
		else if(temperature > 35) {
			//온도값이 비정상으로 여겨서 예외 처리한다. throw는 일단 예어ㅣ를 나중에 처리(이 메소드를 호출 할때 처리)
			throw new TempoutToHighException("온도가 너무 높습니다."); //예외를 생성함
		}
		
	}	
}
