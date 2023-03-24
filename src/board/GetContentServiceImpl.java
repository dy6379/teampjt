package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		
		BoardService boardservice = BoardService.getInstance();
		Board board = boardservice.getContent(bno);
		
		request.setAttribute("board", board);
	}

}
