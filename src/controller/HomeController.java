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
		
		if("Cadastrar".equals(action)) {
			UserDao dao = new UserDao();
			try {
				req.setAttribute("countQuestionario", dao.getQuestionaryCount()+1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/jsp/cadastrar.jsp").forward(req, resp);
			
		}
		
		if("Salvar Pergunta".equals(action)) {
			boolean criado = false;
			UserDao dao = new UserDao();
			for(int i = 1; i <= 4; i++) {
				String pergunta = req.getParameter("pergunta"+i);
				String resposta1 = req.getParameter("resposta"+i+"1");
				String resposta2 = req.getParameter("resposta"+i+"2");
				String resposta3 = req.getParameter("resposta"+i+"3");
				String resposta4 = req.getParameter("resposta"+i+"4");
				int correta = Integer.parseInt(req.getParameter("perg"+i));	
				int questionarioId = Integer.parseInt(req.getParameter("questionarioId"));

				try {
					dao.saveQuestion(criado, pergunta, resposta1, resposta2, resposta3, resposta4, correta, questionarioId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				criado = true;
			}
			req.getRequestDispatcher("/WEB-INF/jsp/professor.jsp").forward(req, resp);
		}
	}
}
