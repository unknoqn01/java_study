package ch14;

public class MemberBean {
	
	//현재 커서가 있는 한줄 복사 : catrl + alt + 방향키
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String team;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	//getter + setter
	//get변수명, set변수명 : getId, setId
	
}
