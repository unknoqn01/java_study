package product;

public class Product {
	private String number;
	private String meatName;
	private int weight;
	private int price;
	private int remainStock;
	
	public Product(String number, String meatName, int weight, int price, int remainStock) {
		this.number = number;
		this.meatName = meatName;
		this.weight = weight;
		this.price = price;
		this.remainStock = remainStock;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMeatName() {
		return meatName;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}


	public int getRemainStock() {
		return remainStock;
	}

	public void reduceRemainStock() {
		this.remainStock--;
	} 
	
	public String print() {
		return ". " + meatName +" "+ weight + "g " +
				+ price + "원";
	}
	
	@Override
	public String toString() {
		return number + ". " + meatName +" "+ weight + "g " +
				+ price + "원 수량: " + remainStock;
	}
	
}
