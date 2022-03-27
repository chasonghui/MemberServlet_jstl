package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.ssafy.dto.memDTO;
import com.ssafy.util.DButil;

public class memDAOImpl implements memDAO {

	@Override
	public void regMember(memDTO m) throws SQLException {
		// db커넥션
		Connection conn = DButil.getConnection();
		// sql문작성
		String sql = "insert into members value(?,?,?,?)";
		// 텍스트 sql 호출
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 매개변수 값대입+유효화 처리
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPass());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getPhone());

		// 실행해
		pstmt.executeUpdate();

		// 역순으로 닫아조
		DButil.close(pstmt, conn);
	}

	@Override
	public void deleteMember(memDTO m) throws SQLException {
		// db커넥션
		Connection conn = DButil.getConnection();
		// sql문작성
		String sql = "delete from members where id = ?";
		// 텍스트 sql 호출
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 매개변수 값대입+유효화 처리
		pstmt.setString(1, m.getId());

		// 실행시켜 ~
		pstmt.executeUpdate();

		// 역순으로 닫아
		DButil.close(pstmt, conn);

	}

	@Override
	public void updateMember(memDTO m) throws SQLException {
		// db커넥션
		Connection conn = DButil.getConnection();
		// sql문작성
		String sql = "update members set pass=?, name=?, phone=? where id=?";
		// 텍스트 sql 호출
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 매개변수 값대입+유효화 처리
		pstmt.setString(1, m.getPass());
		pstmt.setString(2, m.getName());
		pstmt.setString(3, m.getPhone());
		pstmt.setString(4, m.getId());

		// 실행시켜 ~
		pstmt.executeUpdate();

		// 역순으로 닫아
		DButil.close(pstmt, conn);
	}

	@Override
	public ArrayList<memDTO> listMember() throws SQLException {
		// db커넥션
		Connection conn = DButil.getConnection();
		// sql문작성
		String sql = "select id, pass, name, phone from members";
		// 텍스트 sql호출
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 결과값 저장
		ResultSet rs = pstmt.executeQuery();
		// list반환할거 맨들기
		ArrayList<memDTO> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new memDTO(rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("phone")));
		}
		return list;
	}

	@Override
	public boolean login(String id, String pw) throws SQLException {
		// db커넥션
		Connection conn = DButil.getConnection();
		// sql문작성
		String sql = "select 1 from members where id=? and pass=?";
		// 텍스트 sql호출
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		// 결과값 저장
		ResultSet rs = pstmt.executeQuery();
		
		// 결과값이 존재하면 true반환
		while (rs.next()) {
			return true;
		}
		// 결과값 없음
		return false;
	}
}
