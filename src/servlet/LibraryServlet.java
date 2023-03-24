package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hall.HallService;
import library.LibraryService;

@WebServlet(name = "LibraryServlet", value = "/library")
public class LibraryServlet extends HttpServlet {
	
	LibraryService libraryService = new LibraryService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("librarys", libraryService.getLibrarys());
		request.getRequestDispatcher("/WEB-INF/views/library.jsp").forward(request, response);
	}

}
