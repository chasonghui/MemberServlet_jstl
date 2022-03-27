package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.dao.memDAO;
import com.ssafy.dao.memDAOImpl;
import com.ssafy.dto.memDTO;

public class MemServiceImpl implements MemService {
	private memDAO mdao;

	public MemServiceImpl() {
		mdao = new memDAOImpl();	
		
	}
	// 회원 등록
	@Override
	public void regMember(memDTO m) throws SQLException {
		mdao.regMember(m);
	}

	// 회원 삭제
	@Override
	public void deleteMember(memDTO m) throws SQLException {
		mdao.deleteMember(m);
	}

	// 회원 수정
	@Override
	public void updateMember(memDTO m) throws SQLException {
		mdao.updateMember(m);
	}

	// 회원 조회
	@Override
	public ArrayList<memDTO> listMember() throws SQLException {
		return mdao.listMember();
	}

	// 로그인
	@Override
	public boolean login(String id, String pw) throws SQLException {
		return mdao.login(id, pw);
	}

}
