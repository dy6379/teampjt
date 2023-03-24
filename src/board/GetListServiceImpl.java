package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetListServiceImpl implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardService boardservice = BoardService.getInstance();
		List<Board> list = boardservice.getlist();
		
		//list를 request에 넣어 화면에 가져간다
		request.setAttribute("list", list);
	}
}
