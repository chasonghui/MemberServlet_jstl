package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.dto.memDTO;

public interface MemService {
	// 회원 등록 수정 삭제
	public void regMember(memDTO m) throws SQLException;

	public void deleteMember(memDTO m) throws SQLException;

	public void updateMember(memDTO m) throws SQLException;

	// 회원 조회
	public ArrayList<memDTO> listMember() throws SQLException;

	// 로그인
	public boolean login(String id, String pw) throws SQLException;

}
