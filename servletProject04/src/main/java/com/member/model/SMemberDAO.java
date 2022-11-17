package com.member.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface SMemberDAO {
//추가
	public void memberJoin(SMemberDTO member);
	//전체보기
	public ArrayList<SMemberDTO>getMember();
	//삭제
	public int memberDelete(String userid);
	//수정
	public  int memberUpdate(SMemberDTO member);
	//상세보기
	
	public SMemberDTO findById(String userid);
	
	//회원수
	public int memberCount();
	//아이디 중복확인
	public String memberIdCheck(String userid);
	//로그인
	public SMemberDTO memberLoginCheck(String userid,String pwd);
	
}
