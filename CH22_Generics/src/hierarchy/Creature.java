package hierarchy;

public class Creature {
	private String name;
	
	public Creature(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public void feed() {
		System.out.println("생물 피드");
	}
}
