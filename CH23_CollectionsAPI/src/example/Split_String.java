package example;

public class Split_String {

	public static void main(String[] args) {
		//문자열.split("") => 문자열으 공백(space)로 쪼개서 배열로 리턴
		String text1 = "After all, why else would Manchin call a news conference and tell reporters that he was going to clear up a lot of things? Well, not that, as it turns out.";
		String text2 = "이 차관은 모두발언에서 \"유류세는 정유사 반출단계에서 부과되기 때문에 11월 12일 유류세 인하조치 시행 이후에도 인하 전 반출된 휘발유가 시중에 유통돼 인하 효과 반영까지 시일이 소요될 수 있다\"면서 \"유류세 인하분이 소비자가격에 신속히 반영되도록 유류세 인하 실효성 제고 대책을 철저히 수립·집행하겠다\"고 말했다.";
		
		//String[] words = text1.split("[^a-zA-z]+"); //정규표현식[] ^시작문자
		String[] words = text2.split("[^가-힣]+");
		
		for( String w : words) {
			if( w.length()<2) continue; //한 철자이하는 빼기
			System.out.println(w.toLowerCase()); //전부 소문자로 출력
			
		}
		
		
		
	}

}
