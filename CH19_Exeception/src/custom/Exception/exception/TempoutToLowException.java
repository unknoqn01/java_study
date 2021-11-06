package custom.Exception.exception;

// 온도가 너무 낮을 경우 발생시킬 예외
public class TempoutToLowException extends TempoutOfRangeException {
	private static final long serialVersionUID = 1L;

	public TempoutToLowException(String message) {
		//생성자 예외 메세지를 상위 예외클래스에 처리
		super(message); //예외클래스에 메세지명으로 예외를 생성
	}
}
