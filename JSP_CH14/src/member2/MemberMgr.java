package member2;

public class MemberMgr {
	
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//모든 리스트 가져오기
	public ArrayLsit<MemberBean> getMemberList(){
		
	}
	
	//저장하기
	public boolean insertMember(MemberBean bean) {
		
	}
	
	//회원 정보(레코드 한개)
	public MemberBean getMembrt(int id) {
		
	}

	//수정하기
	public boolean upadateMember(MemberBean bean) {
		
	}
	
	//삭제하기
	public boolean deleteMember(int id) {
		
	}

}
