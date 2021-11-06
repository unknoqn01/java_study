package custom.Exception.exception;

//온도가 낮거나 너무 높을 경우 발생하는 예외 상위 클래스
public class TempoutOfRangeException extends Exception {
	private static final long serialVersionUID = 1L;

	public TempoutOfRangeException(String message) {
		//생성자 예외 메세지를 상위 예외클래스에 처리
		super(message); //예외클래스에 메세지명으로 예외를 생성
	}
}
