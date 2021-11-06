package shoppingmall;

public class StartShopping {

	public static void main(String[] args) {
		
		MyShop myshop = new MyShop();
		
		myshop.setTitle("11번가");
		myshop.genProduct();
		myshop.setExistingUsers("조재희", "권혁천", myshop.existingUsers);
		myshop.initAlarm();
	}

}
