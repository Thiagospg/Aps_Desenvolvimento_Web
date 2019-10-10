package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Connection con;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("button");

		if ("Logar".equals(action)) {
			String username = req.getParameter("usuario");
			String password = req.getParameter("senha");

			if (username != null && password != null) {

				UserDao userDao = new UserDao();
				String authorization = null;
				try {
					authorization = userDao.userAuth(username, password);
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				switch (authorization) {
				case "aluno":
					req.getRequestDispatcher("/WEB-INF/jsp/aluno.jsp").forward(req, resp);
					break;
				case "professor":
					req.getRequestDispatcher("/WEB-INF/jsp/professor.jsp").forward(req, resp);
					break;
				default:
					req.setAttribute("error", authorization);
					req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
					break;
				}

				System.out.println(action);
			}
		}
	}
}
