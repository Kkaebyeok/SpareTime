package service.member;

import vo.member.MemberVo;

public interface MemberService {
	// 회원가입
	public int signup(MemberVo vo);
	// 로그인
	public int login(String id, String pw);
	// 회원탈퇴
	public void deleteMember(String id);
	// 회원 가입여부 체크
	public boolean isMember(String id);
}
