package meatShop;

public class User {
	private String userName;
	private String password;
	private int point;
	
	public User(String userName, String password, int point) {
		this.userName = userName;
		this.password = password;
		this.point = point;
	}	
	public String getUserNmame() {
		return userName;
	}
	public void setUserNmame(String userNmame) {
		this.userName = userNmame;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "이름 : " + userName + "\t폰 번호 : " + password + 
				"\t포인트 : " + point + "p\n";
				
	}
	
}
