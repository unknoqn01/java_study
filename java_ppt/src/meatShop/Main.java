package meatShop;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import product.Chicken;
import product.Cow;
import product.Pig;
import product.Product;

import java.util.Random;

public class Main {

	private final String ADMIN_ID = "admin"; // 관리자 id
	private final String ADMIN_PASS = "12345678"; // 관리자 패스워드
	private Scanner scanner = new Scanner(System.in);

	// 회원
	private LinkedList<User> userList = new LinkedList<>();

	// 장바구니
	private ArrayList<String> cart = new ArrayList<>();

	private Product[] cowMeat = new Product[3];
	private Product[] pigMeat = new Product[3];
	private Product[] chickenMeat = new Product[3];
	private String[] services = { "볶음밥", "물냉면", "비빔냉면" };

	String un; //포인트 적립시 유저 네임
	String pn; //포인트 적립식 폰 번호
	int ptotal = 0; //포인트 적립
	int total = 0; // 총 금액
	boolean isRunning = true;

	public void run() throws InterruptedException {
		
		genProduct();
		setExistingUsers();
		while (isRunning) {
			display();
		}
	}

	/**
	 * 시작 화면
	 * 
	 * @throws InterruptedException
	 */
	private void display() throws InterruptedException {
		System.out.println("어서 오세요");
		System.out.println("정육 샵입니다\n");
		Thread.sleep(400);
		System.out.println("처음 이신가요? y / n");
		System.out.print("방문 여부 : ");

		String isVisted = scanner.nextLine();

		signUp(isVisted);

	}

	/**
	 * 방문 여부 && 회원 등록
	 * 
	 * @param isVisted
	 */
	private void signUp(String isVisted) {
		switch (isVisted) {

		case "y":
			registerAccount();
			break;
		case "n":
			selectCategory();
			break;
		default:
			exit();
		}
	}

	/**
	 * 회원 등록
	 */
	private void registerAccount() {

		System.out.println("==========================");
		System.out.println("회원등록을 진행합니다");

		String userName = input(1);
		String password = input(2);

		System.out.println("등록이 완료되었습니다\n");
		userList.add(2, new User(userName, password, 0));

		System.out.println(userName + "님 환영합니다");

		selectCategory();

	}

	// 회원등록 이름 || 비번 확인
	private String input(int i) {

		String result = null;

		switch (i) {
		case 1:
			while (true) {
				System.out.print("성함을 입력해주세요 : ");

				result = scanner.nextLine();

				if (result.trim().isBlank()) {
					System.out.println("성함이 공백입니다");
				} else
					break;
			}
			break;

		case 2:
			while (true) {
				System.out.print("휴대폰 번호 8자리를 입력해주세요 : ");

				try {
					result = Integer.toString(scanner.nextInt());
				} catch (Exception e) {
					exit();
				}
				
				System.out.print("번호 확인용 휴대폰 번호 8자리를 한번 더 입력하세요 : ");
				scanner.nextLine();
				String passwordCheck = scanner.nextLine();

				if (result.trim().isBlank() || passwordCheck.trim().isBlank()) {
					System.out.println("폰 번호 또는 번호 확인용이 공백입니다");
				} else if (result.length() != 8)
					System.out.println("8자리가 아닙니다");
				else if (!result.equals(passwordCheck))
					System.out.println("폰 번호가 맞지 않습니다");
				else
					break;
			}
			break;

		case 3:
			while (true) {
				System.out.print("폰 번호를 입력하세요 : ");
				result = scanner.nextLine();
				
				if (result.length() != 8)
					System.out.println("8자리가 아닙니다");
				else if (result.trim().isBlank()) {
					System.out.println("폰 번호가 공백입니다");
				} 
				break;
			}
			break;
		}
		return result;
	}

	/**
	 * 카테고리 선택
	 * 
	 */
	private void selectCategory() {

		System.out.println("==========================");
		System.out.println("카테고리를 선택해주세요");
		System.out.println("|----목록---|");
		System.out.println("| 1.정육    |");
		System.out.println("| 2.관리자   |");
		System.out.println("|----------|");
		System.out.println("[0] 장바구니 및 계산");
		System.out.print("선택 -> ");

		String categoryNo = scanner.nextLine();

		category(categoryNo);
	}

	/**
	 * 카테고리
	 * 
	 * @param categoryNo
	 */
	private void category(String categoryNo) {
		switch (categoryNo) {
		case "1":
			meatList();
			break;
		case "2": admin();
			break;
		case "0":
			getCart();
			break;
		default:
			exit();
		}
	}
	
	 private void admin() {
		 
		 	System.out.println("==========================");
	        System.out.println("관리자 계정입니다");

	        String id = input(1);
	        String password = input(3);
	        
	        if (id.equals(ADMIN_ID) && password.equals(ADMIN_PASS)) {
	            System.out.println("회원 정보는 다음과 같습니다.");
	            userList.forEach(n -> System.out.println(n));
	            System.out.println("Enter키를 누르면 목록으로 돌아갑니다");
	            scanner.nextLine();
	            selectCategory();
	        } else {
	            System.out.println("성함 또는 폰 번호가 올바르지 않습니다!");
	            selectCategory();
	        }
	    }
	/**
	 * 고기 목록
	 * 
	 */
	private void meatList() {

		System.out.println("==== 고기 종류 ===============");
		System.out.println("|-----------|");
		System.out.println("| 1. 소고기   |");
		System.out.println("| 2. 돼지고기  |");
		System.out.println("| 3. 닭고기   |");
		System.out.println("|-----------|");
		System.out.println("[0] 장바구니 및 계산");
		System.out.println("[4] 카테고리 목록");
		System.out.print("선택 -> ");

		String meatNumber = scanner.nextLine();

		meatKinds(meatNumber);

	}

	/**
	 * 정육 종류
	 * 
	 * @param meatList
	 */
	private void meatKinds(String meatNumber) {

		switch (meatNumber) {
		case "1":
			selectMeat(cowMeat);
			break;
		case "2":
			selectMeat(pigMeat);
			break;
		case "3":
			selectMeat(chickenMeat);
			break;
		case "0":
			getCart();
			break;
		case "4":
			selectCategory();
			break;
		default:
			exit();
		}

	}

	/**
	 * 고기 선택
	 * 
	 */
	private void selectMeat(Product[] Meat) {

		System.out.println("==========================");
		for (Product meat : Meat) {
			System.out.println(meat.toString());
		}
		System.out.println("[0] 장바구니 및 계산");
		System.out.println("[4] 카테고리 목록");
		System.out.print("선택 -> ");

		String number = scanner.nextLine();

		switch (number) {
		case "0":
			getCart();
			break;
		case "1":
			putCart(Meat, 0);
			break;
		case "2":
			putCart(Meat, 1);
			break;
		case "3":
			putCart(Meat, 2);
			break;
		case "4":
			selectCategory();
			break;
		default:
			exit();
		}
	}

	/**
	 * 장바구니 담기
	 * 
	 */
	private void putCart(Product[] Meat, int number) {

		System.out.println("==========================");
		if (Meat[number].getRemainStock() != 0) {

			cart.add(Meat[number].print());
			total += Meat[number].getPrice();
			Meat[number].reduceRemainStock();
			System.out.println();
			System.out.println(Meat[number].getMeatName() + "을(를) 담았습니다. 총 금액은" + total);
			System.out.println("Enter키를 누르시면 고기 목록이 출력됩니다.");
			scanner.nextLine();
			meatList();
		} else {
			System.out.println("재고가 모두 소진되었습니다");
			meatList();
		}
	}

	private void getCart() {

		System.out.println("==========================");
		System.out.println("---------장바구니 목록--------");

		if (total == 0) {
			System.out.println("상품을 담아주세요");
		}
		int count = 0;
		for (String c : cart) {
			count++;
			System.out.println(count + c);
		}
		System.out.println("==========================");
		System.out.printf("총 금액은 %d원 입니다\n", total);
		System.out.println("계산하시겠습니까? y / n");
		System.out.print("선택 : ");
		String s = scanner.nextLine();
		selectCheckOut(s);
	}

	/**
	 * 계산 선택
	 * 
	 */
	private void selectCheckOut(String s) {

		switch (s) {
		case "y":
			checkout();
			break;
		case "n":
			meatList();
			break;
		default:
			exit();
		}
	}

	/**
	 * 계산
	 * 
	 */
	private void checkout() {
		System.out.println("==========================");
		System.out.printf("결제하실 총 금액은 %d원 입니다\n", total);
		ptotal = (total*2)/10;
		point();
		System.out.println("결제 방식을 선택 하세요");
		System.out.println("[1] CARD");
		System.out.println("[2] CASH");
		System.out.print("선택 -> ");

		String checkOutInput = scanner.nextLine();

		if (checkOutInput.equals("1"))
			payOnCard(checkOutInput);
		else if (checkOutInput.equals("2"))
			payOnCash();
		else
			exit();

	}

	/**포인트 
	 * 
	 */
	private void point() {
		
		boolean isExist = false;
			
		for (User list : userList) {
			while(!isExist) {			
			String pw = list.getPassword();
			String un = input(1);
			String pn = input(3);
			
			returnUn(un);
			returnPn(pn);
			
			if (pn.equals("66778899")) pw = "66778899"; else pw = pn;
			
			if (pn.equals(pw)) {
				System.out.printf("현재 포인트는 %dp입니다\n",list.getPoint());
				System.out.println("포인트를 쓰겠습니까? y / n ");
				System.out.print("선택 -> ");
				
				String selectPoint = scanner.nextLine();
					switch (selectPoint) {
					
					case "y":	payPoint();
								isExist = true;	break;
						
					case "n" :  isExist = true;	break;	
					
					default: exit();
					} break;
					
			} else System.out.println("등록되지 않은 회원입니다"); isExist = false;
			} break;
		}
		
	}
	
	/**
	 * 포인트 지불
	 */
	private void payPoint() {
		System.out.print("사용할 포인트 : 개발중\n"); exit();
		
		/*
		String to = scanner.nextLine();
		
		if (to instanceof String) {
			try { int payPointInput = Integer.parseInt(to);
					boolean many = false;
						
					for (User list : userList) {
						while(!many) {
							int nowPoint = list.getPoint();
							
						} break;
					} 
			} catch (Exception e) {exit();};
		}
		*/
	}

	/**
	 * 유저네임 리턴
	 */
	private String returnUn(String un) {
		 return this.un = un; 
	}
	
	/**
	 * 폰 번호 리턴
	 */
	private String returnPn(String pn) {
		 return this.pn = pn; 
	}
	
	/**
	 * 포인트 적립
	 */
	private void payacc() {
		
		switch (pn) {
			case "11223344" : userList.add(0, new User("권영민", "11223344", 10000));
				break;
			case "66778899" : userList.add(1, new User("박민혁", "66778899", 100000));
				break;
			default : userList.add(2, new User(un, pn, ptotal));
		}
		System.out.println(ptotal+"p 적립되었습니다");
	}
	
	
	/**
	 * 카드 결재
	 * 
	 * @param checkOutInput
	 */
	private void payOnCard(String checkOutInput) {

		if (checkOutInput.equals("1")) {
			System.out.println("영수증을 발급하시겠습니까? y / n");
			System.out.print("선택 -> ");
			String input = scanner.nextLine();

			if (input.equals("y")) {
				System.out.println("영수증이 발급되었습니다");
			} else if (input.equals("n")) {

			} else exit();
			System.out.println("결재가 완료 되었습니다");
			payacc();
			service();
			System.out.println("안녕히 가십시오");
			isRunning = false;
		}
	}

	/**
	 * 현금 결재
	 * 
	 */
	private void payOnCash() {
		
		System.out.print("지불하실 금액을 입력하세요 : ");
		String cashInput = scanner.nextLine();

		if (cashInput instanceof String) {
			try {
			int cash = Integer.parseInt(cashInput);
			if (cash > total || cash == total) {

				System.out.println("계산이 완료 되었습니다");
				System.out.printf("결재하신 금액은 %d원 이고, 잔돈은 %d원 입니다\n", cash, cash - total);
				payacc();
				service();
				System.out.println("안녕히 가십시오");
				isRunning = false;
			} else if (cash < total) differentCash(total - cash);
			} catch (Exception e) {exit();}
			
		} 
	}

	/** 차액 지불
	 * 
	 */
	private void differentCash(int total) {
		
		while (total != 0) {
			System.out.printf("%d원 남았습니다\n", total);
			System.out.println();
			System.out.print("지불하실 금액 : ");
			String diffcash = scanner.nextLine();
			
			if (diffcash instanceof String) {
				
				try {
					int intdiffcash = Integer.parseInt(diffcash);
					if (intdiffcash > total || intdiffcash == total) {
						
						System.out.println("계산이 완료 되었습니다");
						System.out.printf("결재하신 금액은 %d원 이고, 잔돈은 %d원 입니다\n", intdiffcash, intdiffcash - total);
						service();
						System.out.println("안녕히 가십시오");
						total = 0;
					} else if (intdiffcash < total) {
						total -= intdiffcash;
					}
				} catch (Exception e) {exit();}
			} 
		}
		isRunning = false;
	}
	
	
	/**
	 * 서비스
	 * 
	 */
	private void service() {
		Random random = new Random();
		System.out.println(services[random.nextInt(2)] + "은 서비스입니다");
	}

	/**
	 * 시작시 상품 보충
	 *
	 */
	private void genProduct() {
		cowMeat[0] = new Cow("1", "꽃등심", 300, 36000, 5);
		cowMeat[1] = new Cow("2", "안심", 300, 33000, 4);
		cowMeat[2] = new Cow("3", "채끝", 300, 36000, 3);

		pigMeat[0] = new Pig("1", "오겹살", 300, 6000, 5);
		pigMeat[1] = new Pig("2", "항정살", 300, 12000, 4);
		pigMeat[2] = new Pig("3", "삼겹살", 300, 6000, 3);

		chickenMeat[0] = new Chicken("1", "날개", 300, 3000, 5);
		chickenMeat[1] = new Chicken("2", "장각", 300, 3000, 4);
		chickenMeat[2] = new Chicken("3", "목", 300, 1200, 3);
	}

	/**
	 * 기존 유저
	 * 
	 */
	private void setExistingUsers() {
		userList.add(0, new User("권영민", "11223344", 10000));
		userList.add(1, new User("박민혁", "66778899", 100000));
	}

	/**
	 * 프로그램 종료
	 * 
	 */
	private void exit() {
		System.out.println("지정된 범위를 벗아났습니다.");
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

}
