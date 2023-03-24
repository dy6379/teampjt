package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hall.Hall;
import hall.HallService;
import hall.PageVO;

@WebServlet(name = "hallServlet", value = "/hall")
public class HallServlet extends HttpServlet {
	
	HallService hallService = new HallService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = 1;//첫 페이지
        int amount = 10;
        if(request.getParameter("pageNum") != null && request.getParameter("amount") != null){
        	pageNum = Integer.parseInt(request.getParameter("pageNum"));
        	amount = Integer.parseInt(request.getParameter("amount"));
        }
		
        List<Hall> halls = hallService.getList(pageNum, amount);
        int total = hallService.getTotal();
        PageVO pageVO = new PageVO(pageNum, amount, total);
        
        request.setAttribute("pageVO", pageVO);
		request.setAttribute("halls", halls);
        request.getRequestDispatcher("/WEB-INF/views/hall.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum = 1;//첫 페이지
        int amount = 10;
        if(request.getParameter("pageNum") != null && request.getParameter("amount") != null){
        	pageNum = Integer.parseInt(request.getParameter("pageNum"));
        	amount = Integer.parseInt(request.getParameter("amount"));
        }
        
        List<Hall> halls = hallService.getList(pageNum, amount);
        int total = hallService.getTotal();
        PageVO pageVO = new PageVO(pageNum, amount, total);
        
        request.setAttribute("pageVO", pageVO);
		request.setAttribute("halls", halls);
        request.getRequestDispatcher("/WEB-INF/views/hall.jsp").forward(request,response);
        

	}
}
