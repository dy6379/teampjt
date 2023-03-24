package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.DeleteServiceImpl;
import board.GetContentServiceImpl;
import board.GetListServiceImpl;
import board.IBoardService;
import board.RegistServiceImpl;
import board.UpHitServiceImpl;
import board.UpdateServiceImpl;


@WebServlet("*.board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // URI값
		String path = request.getContextPath(); // 컨텍스트 경로
		
		String command = uri.substring(path.length()); // 요청 분기
		
		System.out.println(command);
		
		IBoardService service;
		
		if(command.equals("/board/list.board")) {//글목록 가져오기
			service = new GetListServiceImpl();
			service.execute(request,response);
			request.getRequestDispatcher("/WEB-INF/views/board_list.jsp").forward(request, response);
			
		} else if(command.equals("/board/write.board")) { //글쓰기 가져오기
			request.getRequestDispatcher("/WEB-INF/views/board_write.jsp").forward(request, response);
			
		} else if(command.equals("/board/regist.board")) { //글등록 가져오기
			service = new RegistServiceImpl();
			service.execute(request,response);
			response.sendRedirect("list.board");
			
		} else if(command.equals("/board/getContent.board")) {
			//조회수 증가
			service = new UpHitServiceImpl();
			service.execute(request, response);
			//게시글 정보조회
			service = new GetContentServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/views/board_content.jsp").forward(request, response);
		
		} else if (command.equals("/board/modify.board")) { // 글 수정요청
			// getContentServiceImpl 재활용
			service = new GetContentServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/views/board_modify.jsp").forward(request, response);
		
		} else if (command.equals("/board/update.board")){// 글 수정 완료
			/*
			 *  1. UpdateServiceImpl 클래스를 생성하고 execute()메서드 실행.
			 *  2. 서비스 영역에서 bno, title, content를 받아서 DAO의 update() 메서드 실행
			 *  3. update()는 sql문을 이용해서 해당 글 번호의 내용을 수정.
			 *  4. 컨트롤러에서는 Content화면으로 이동. (content가 필요한 값을 자바측에서 전송)
			 */
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			// forward 로 넘길 경우. 주소값이 변경되지 않아서 새로고침 하는 순간 다시 update로 넘어오게 됌
			response.sendRedirect("getContent.board?bno=" + request.getParameter("bno")); // 수정완료된 글로 이동
		
			} else if (command.equals("/board/delete.board")) { // 글 삭제 요청
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.board");
		}
		
	}
}
