package enum_Constructor;

public enum Fruit { //enum은 상수들(변하지 않는 값)들의 집합
	apple("초록색"), banana("노란색"), orange("오렌지색"); //애플, 바나나, 오렌지 열거
	
	private String color;
	
	Fruit(String color) {
		this.color = color;
	}
	
	public String toString() {
		return super.toString() + "(" + color + ")";
	}
}
