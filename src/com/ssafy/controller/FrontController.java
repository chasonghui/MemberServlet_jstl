package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.memDTO;
import com.ssafy.service.MemService;
import com.ssafy.service.MemServiceImpl;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "index.jsp";
	private MemService memser;

	@Override
	public void init() throws ServletException {
		memser = new MemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서블렛 경로 가져 와
		String path = request.getServletPath();
		System.out.println(path);
		try {
			if (path != null) {
				// 회원 등록 폼
				if (path.equals("/regmemberform.do")) {
					url = "member/regmember.jsp";
				}
				// 회원 등록
				else if (path.equals("/regmember.do")) {
					url = regmember(request, response);
				}
				// 초기 화면
				else if (path.equals("/initpage.do")) {
					url = "redirect: index.jsp";
				}
				// 로그인 폼
				else if (path.equals("/loginform.do")) {
					url = "member/login.jsp";
				}
				// 로그인
				else if (path.equals("/login.do")) {
					url = login(request, response);
				}
				// 로그아웃
				else if (path.equals("/logout.do")) {
					request.getSession().invalidate();
					url = "initpage.do";
				}
				// 회원 리스트 조회
				else if (path.equals("/listmember.do")) {
					url = listMember(request, response);
				}
				// 회원 삭제
				else if (path.equals("/delmember.do")) {
					url = delMember(request, response);
				}
				// 회원 수정
				else if (path.equals("/updatemember.do")) {
					url = updateMember(request, response);
				}
				// 회원 정보
				else if (path.equals("/viewmember.do")) {
					url = "member/viewmember.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 리다이렉트
		if (url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":") + 1);
			// 받은값을 보내
			response.sendRedirect(url);
		}
		// 리다이렉트 아니면 forward
		else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 회원 수정 : 값을 받아서 dao로 넘겨
	private String updateMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		memser.updateMember(new memDTO(request.getParameter("id"), request.getParameter("pass"),
				request.getParameter("name"), request.getParameter("phone")));
		return "redirect:listmember.do";
	}

	// 회원 삭제 : 값을 받아서 dao로 넘겨
	private String delMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		memser.deleteMember(new memDTO(request.getParameter("id"), request.getParameter("pass"),
				request.getParameter("name"), request.getParameter("phone")));
		return "redirect:listmember.do";
	}

	// 회원 조회
	private String listMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		// 리스트에 dao반환값 담아서
		ArrayList<memDTO> list = memser.listMember();
		request.setAttribute("list", list);
		
		return "member/listmember.jsp";
	}

	// 로그인: dao의 로그인 boolean값을 가져와서 세션처리
	private String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		boolean login = memser.login(id, pw);
		if (login) {
			request.getSession().setAttribute("id", id);
			return "initpage.do";
		} else {
			request.setAttribute("res", "로그인 실패");
			return "WEB-INF/result.jsp";
		}
	}

	// 회원등록
	private String regmember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		System.out.printf("%s %s %s %s  \n", id, pw, name, phone);

		// dto로 데이터 받아서 daoimpl에 잇는 함수로 보내
		memser.regMember(new memDTO(id, pw, name, phone));

		return "redirect:loginform.do";
	}
}