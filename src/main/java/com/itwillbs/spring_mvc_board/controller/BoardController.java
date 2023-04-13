package com.itwillbs.spring_mvc_board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwillbs.spring_mvc_board.service.BoardService;
import com.itwillbs.spring_mvc_board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 글쓰기 폼
	// => 세션 아이디가 존재하지 않으면 "로그인 필수!", "MemberLoginForm.me" 저장 후 success 로 이동
	@GetMapping("/BoardWriteForm.bo")
	public String writeForm(HttpSession session, Model model) {
		if(session.getAttribute("sId") == null) {
			model.addAttribute("msg", "로그인 필수!");
			model.addAttribute("target", "MemberLoginForm.me");
			return "success";
		}
		
		return "board/board_write_form";
	}
	
	//연습삼아 해봄 원래는 VO 객체에 multipart가 있어서 바로vo 파라미터로 주면되지만 가져올값 하나씩 넣어본거임
//	@PostMapping("/BoardWritePro.bo")
//	public String writePro(String board_name, String board_subject, String board_content, MultipartFile file) {
//		System.out.println(board_name + ", " + board_subject + ", " + board_content);
//		System.out.println("업로드 파일명 : " + file.getOriginalFilename());
//		
//		
//		return "";
//	}
	
	//2) 파일을 제외한 나머지 파라미터를 map 타입으로 처리하기
//	@PostMapping("/BoardWritePro.bo")
//	public String writePro(Map<String, String> map, MultipartFile file) {
//		System.out.println(map.get("board_name") + " " + map.get("board_subject") + " " + map.get("board_content"));
//		System.out.println("업로드 파일명 : " + file.getOriginalFilename());
//		
//		
//		return "";
//	}
	
	//3) 결론은 얘를 쓸건데, multipart 타입을 포함하는 boardvo 타입으로 모든 파라미ㅓㅌ를 한번에 처리
	@PostMapping("/BoardWritePro.bo")
	public String writePro(BoardVO board, HttpServletRequest request, HttpSession session) {
//		System.out.println(board);
//		System.out.println("업로드 파일명 : " + board.getFile().getOriginalFilename());
		
		//실제 업로드 처리 부분
		String uploadDir = "/resources/upload";
//		String saveDir = request.getServletContext().getRealPath(uploadDir); //request
//		String saveDir = request.getRealPath(uploadDir); //권장하지 않는 방법
		String saveDir = session.getServletContext().getRealPath(uploadDir); //session
//		실제 업로드 경로 : D:\workspace_sts\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\Spring_MVC_Board\resources\ upload
//		System.out.println("실제 업로드 경로 : " + saveDir);
		
		
		
		
		
		
		
		
		
		return "";
	}
	
}













