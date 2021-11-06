package shoppingmall;


import java.util.ArrayList;
import java.util.Scanner;

public class MyShop {

	// 쇼핑몰 이름
	String title;
	
	// 기존 계정 셋팅(메인 함수에서 변경하기)
	String[] existingUsers = new String[2];
	String newUser;
	
	Product[] electronicProducts = new Product[3];
	Product[] clothProducts = new Product[3];
	Product[] sportingProducts = new Product[3];
	
	// 상품 추가를 위한 장바구니
	ArrayList<Product> cart = new ArrayList<Product>();
	
	// 유저가 고른 상품 번호
	int productNo;
	
	// 입력이 중복막기 위함
	Scanner scan = new Scanner(System.in);
	
	// 총 상품 금액
	int total = 0;

	/**
	 * 쇼핑몰 이름 설정(메인 함수에서 설정하기)
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 기존에 존재하던 계정 회원 등록하기
	 * @param firstUser
	 * @param secondUser
	 * @param existingUsers
	 */
	public void setExistingUsers(String firstUser, String secondUser, String[] existingUsers) {
		
		UserList userList = new UserList();
		
		userList.setFirstUser(firstUser);
		userList.setSecondUser(secondUser);
		
		existingUsers[0] = userList.getFirstUser();
		existingUsers[1] = userList.getSecondUser();
	}
	
	/**
	 * 쇼핑몰 시작할 때 콘솔에 기본으로 찍히는 초기 알림
	 */
	public void initAlarm() {
		
		System.out.println("====================================================");
		System.out.println("#  " + title + " 쇼핑몰에 오신것을 환영합니다.  #");
		System.out.println("#  기존에 저희 쇼핑몰을 방문해 보신적이 있으신가요? [y/n]  #");
		System.out.printf("#  방문여부 : ");
		
		String isVisited = scan.next();
		
		switch (isVisited) {
			case "y": 
				
				choiceAccount(); break;
			case "n":
				
				registerAccount(); break;
			default:
				
				System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
				System.exit(0); break;
		}
	}
	
	/**
	 * 기존 방문여부 y를 눌렀을 때, 기존에 존재하던 계정 고르는 메서드 
	 */
	public void choiceAccount() {
		
		System.out.println("====================================================");
		System.out.println("# 데이터 조회 결과, 두 개의 계정이 존재합니다. 원하시는 계정을 선택해주세요.");
		System.out.println("#  회원[1] : " + existingUsers[0]);
		System.out.println("#  회원[2] : " + existingUsers[1]);
		System.out.printf("#  선택 -> ");
		
		int userNo = scan.nextInt();
		
		switch (userNo) {
			case 1:
				
				firstUser(existingUsers[0]); break;
			case 2:
				
				secondUser(existingUsers[1]); break;
			default:
				System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
				System.exit(0); break;
		}
		
	}
	
	/**
	 * 회원가입
	 */
	public void registerAccount() {
		
		System.out.println("====================================================");
		System.out.println("#  회원가입을 진행합니다.");
		System.out.printf("#  성함을 입력해주세요 : ");
		
		newUser = scan.next();
		
		UserList userList = new UserList();
		userList.setNewUser(newUser);
		
		System.out.println("====================================================");
		System.out.println("#  " + userList.getNewUser() + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");
		
		selectCategory();
	}
	
	/**
	 * 기존에 등록된 첫 번째 계정 불러오기
	 * @param firstUser
	 */
	public void firstUser(String firstUser) {
		
		System.out.println("===================================================");
		System.out.println("#  " + firstUser + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");
		
		selectCategory();
	}
	
	/**
	 * 기존에 등록된 두 번째 계정 불러오기
	 * @param secondUser
	 */
	public void secondUser(String secondUser) {
		
		System.out.println("===================================================");
		System.out.println("#  " + secondUser + "님 환영합니다. 원하시는 카테고리를 선택해주세요.");
		
		selectCategory();
	}

	/**
	 * 쇼핑몰 게임 실행 시, 상품 generate
	 */
	public void genProduct() {
		
		Electronic electronic = new Electronic("LG그램", 1500000, 5);
		electronic.setCategoryName("전자기기");
		electronicProducts[0] = electronic;
		electronic = new Electronic("삼성 세탁기", 2000000, 2);
		electronicProducts[1] = electronic;
		electronic = new Electronic("에어팟 2세대", 150000, 3);
		electronicProducts[2] = electronic;
		
		Cloth cloth = new Cloth("가을 코트", 250000, 2);
		cloth.setCategoryName("의류");
		clothProducts[0] = cloth;
		cloth = new Cloth("가을 청자켓", 120000, 2);
		clothProducts[1] = cloth;
		cloth = new Cloth("퓨마 롱패딩", 470000, 2);
		clothProducts[2] = cloth;
		
		SportingItem sportingItem = new SportingItem("나이키 손목밴드", 23000, 5);
		sportingItem.setCategoryName("스포츠용품"); 
		sportingProducts[0] = sportingItem;
		sportingItem = new SportingItem("아디다스 축구화", 40000, 5);
		sportingProducts[1] = sportingItem;
		sportingItem = new SportingItem("유벤투스 유니폼", 100000, 5);
		sportingProducts[2] = sportingItem;
	}
	
	/**
	 * 카테고리 목록 출력하기
	 */
	public void selectCategory() {
		
		System.out.println("┏━━카테고리목록━━┓");
		System.out.println("┃ 1. 전자기기   ┃");
		System.out.println("┃ 2. 의류      ┃");
		System.out.println("┃ 3. 스포츠용품  ┃");
		System.out.println("┗━━━━━━━━━━━━━┛");
		System.out.println("#  [0] : 장바구니 물품을 계산합니다.");
		System.out.printf("#  선택 -> ");
		
		int categoryNo = scan.nextInt();
		
		printProductList(categoryNo);
	}
	
	/**
	 * 카테고리 해당 번호에 맞는 상품 목록 출력
	 * @param categoryNo
	 */
	public void printProductList(int categoryNo) {
		switch(categoryNo) {
			case 0:
				
				checkout(); break;
			case 1:
				
				selectProduct(electronicProducts); break;
			case 2:
				
				selectProduct(clothProducts); break;
			case 3:
				
				selectProduct(sportingProducts); break;
			default:
				
				System.out.println("#  범위를 벗어났습니다. 프로그램이 종료되었습니다.");
				System.exit(0); break;
		}
		
	}

	/**
	 * 	상품을 선택했을 때, 장바구니에 넣기
	 * @param product
	 */
	public void putCart(Product product) {
		
		if (product.getRemainingStock() != 0) {
			
			cart.add(product);
			total += product.getPrice();
			
			product.deductRemainingStock(); 
			
			System.out.printf("#  %s을 선택하셨습니다. 현재 장바구니 총 금액은 %d원 입니다.\n", product.getProductName(), total);
			System.out.println("#  Enter키를 누르시면 카테고리 목록이 출력됩니다.");
		} else {
			
			System.out.println("==================================================");
			System.out.printf("#  선택하신 %s 제품은 재고가 모두 소진되었습니다.\n", product.getProductName());
		}
		
		scan.nextLine();
		scan.nextLine(); // 입력 버퍼 지우기
		
		selectCategory();
	}
	
	/**
	 * 카테고리 해당 번호에 맞는 상품 목록 출력
	 * @param products
	 */
	public void selectProduct(Product[] products) {
		
		System.out.println("=================================================================");
		
		// products[0]의 의미는 0, 1, 2중 아무거나 와도 출력값이 같아서 0으로 설정함
		System.out.println("#  " + products[0].getCategoryName() + " 카테고리에 오신 것을 환영합니다. 원하시는 상품 번호를 입력해주세요.");
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("#  상품명" + (i + 1) + " : %s, 가격 : %d, 남은 재고 : %d\n", 
					products[i].getProductName(), products[i].getPrice(), products[i].getRemainingStock());
		}
		
		System.out.println("#  [0] : 장바구니 물품들을 계산합니다.");
		System.out.printf("#  선택 -> ");
		
		productNo = scan.nextInt();
		
		System.out.println("==================================================================");
		
		if (productNo == 0) {
			
			checkout();
		} else if (productNo == 1 || productNo == 2 || productNo == 3) {
			
			putCart(products[productNo-1]);
		} else {
			
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}
	
	
	/**	
	 * 체크아웃
	 */
	public void checkout() {
		if (total == 0) {
			
			System.out.println("============================================");
			System.out.println("#  장바구니가 비어있습니다. 장바구니에 상품을 담아주세요.");
			
			selectCategory();
		} else {
			
			printShoppingBasket();
			System.out.printf("#  결제하실 총 금액은 %d원 입니다. \n#  ▼ 결제 방법을 선택해주세요 ▼\n", total);
			System.out.println("#  [1] : CASH");
			System.out.println("#  [2] : CARD");
			System.out.printf("#  선택 -> ");
			
			int payment = scan.nextInt();
			
			switch (payment) {
				case 1:
					
					paymentOnCash(); break;
				case 2:
					
					paymentOnCard(); break;
				default:
					
					System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
					System.exit(0); break;
			}
		}
	}

	/**
	 * 체크아웃할 때, 지금까지 장바구니에 넣어놨던 상품 목록들 확인차 출력
	 */
	public void printShoppingBasket() {
		
		System.out.println("=========================================");
		System.out.println("━━━━━━━━━━장바구니 목록━━━━━━━━━━━");
		System.out.println("순번\t   상품\t\t      가격");
		
		for (int i = 0; i < cart.size(); i++) {
			
			System.out.printf(" %d   ┃\t%s   \t┃%d \n",i + 1 ,cart.get(i).getProductName(), cart.get(i).getPrice());
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	/**
	 * 현금 계산
	 */
	public void paymentOnCash() {
		
//		System.out.printf("#  현금 지불을 택하셨습니다. 15% 할인되어 결제하실 최종 금액은 %d원 입니다.\n", total * 0.85);
		System.out.println("=======================================");
		System.out.printf("#  지불하실 현금을 입력해주세요 : ");
		
		int cash = scan.nextInt();
		
		if (cash >= total) {
			
			System.out.println("=======================================");
			System.out.printf("#  %d원을 지불하셨습니다. 거스름돈은 %d원 입니다.\n", cash, cash - total);
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
		} else {
			
			System.out.println("=======================================");
			System.out.printf("#  %d원을 더 지불하셔야 합니다.\n", total - cash);
			
			differencePayment(cash);
		}
		
	}
	
	/**
	 * 현금 차액 지불하기
	 * @param cash
	 */ 
	public void differencePayment(int cash) {
		
		System.out.printf("#  차액 지불하기 : ");
		
		int difference = scan.nextInt();
		
		if (difference == total - cash) {
			
			System.out.println("=====================================");
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
		} else if (difference < total - cash) {
			
			total = (total - cash) - difference; 
			
			System.out.println("=====================================");
			System.out.printf("#  %d원을 더 지불하셔야 합니다.\n", total);
			
			differencePayment(total);
		} else {
			
			System.out.println("=====================================");
			System.out.printf("#  %d원을 지불하셨습니다. 거스름돈은 %d원 입니다.\n", difference , difference - (total - cash));
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
			System.out.println("#  프로그램이 종료되었습니다.");
		}
	}
	
	
	/**
	 * 카드 계산
	 */
	public void paymentOnCard() {
		
		System.out.println("=====================================");
		System.out.println("#  영수증 필요하신가요?(y/n)");
		System.out.printf("#  선택 -> ");
		
		String isNeedRecipt = scan.next();
		
		switch (isNeedRecipt) {
		case "y": 
			
			System.out.println("=====================================");
			System.out.println("#  영수증 발급이 완료되었습니다. 안녕히 가세요.");
			System.out.println("#  프로그램이 종료되었습니다."); break;
		case "n":
			
			System.out.println("=====================================");
			System.out.println("#  계산이 완료되었습니다. 안녕히 가세요.");
			System.out.println("#  프로그램이 종료되었습니다."); break;
		default:
			
			System.out.println("=====================================");
			System.out.println("#  범위를 벗어났습니다. 프로그램을 종료합니다.");
			
			System.exit(0); break;
		}
	}
	
}
