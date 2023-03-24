package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {

	//doAction 가져옴
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
