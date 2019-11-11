package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Questao;
import model.Questionario;
import model.Usuario;
import resource.Pontuacao;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Questionario questionario = null;
	int contador = 1;

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
		ResultSet RsUsuario = null;
		Usuario usuario = null;
		if ("Logar".equals(action)) {
			String username = req.getParameter("usuario");
			String password = req.getParameter("senha");

			if (username != null && password != null) {

				UserDao userDao = new UserDao();

				try {
					RsUsuario = userDao.userAuth(username, password);
					if (RsUsuario != null) {
						HttpSession session = req.getSession();

						usuario = new Usuario(RsUsuario.getInt("id"), RsUsuario.getString("usuario"),
								RsUsuario.getString("senha"), RsUsuario.getString("autorizacao"));
						session.setAttribute("usuario", usuario.getUsuario());
						session.setAttribute("usuarioId", usuario.getId());

						switch (usuario.getAutorizacao()) {
						case "aluno":
							req.getRequestDispatcher("/WEB-INF/jsp/aluno.jsp").forward(req, resp);
							break;
						case "professor":
							req.getRequestDispatcher("/WEB-INF/jsp/professor.jsp").forward(req, resp);
							break;
						default:
							req.setAttribute("error", usuario.getAutorizacao());
							req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
							break;
						}
					} else {
						req.setAttribute("error", "Usuario ou senha nao cadastrados");
						req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
					}
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(action);
			}
		}

		if ("Deslogar".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.setHeader("Cache-Control", "no-cache");
			resp.setHeader("pragma", "no-cache");
			resp.setHeader("Expires", "-1");
			resp.sendRedirect(("HomeController"));
		}

		if ("Cadastrar".equals(action)) {
			UserDao dao = new UserDao();
			try {
				req.setAttribute("countQuestionario", dao.getQuestionaryCount() + 1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/jsp/cadastrar.jsp").forward(req, resp);

		}

		if ("Ir ao questionario".equals(action)) {
			UserDao dao = new UserDao();
			int questionarioId = Integer.parseInt(req.getParameter("questionarioId"));
			HttpSession session = req.getSession();
			session.setAttribute("questionarioId", questionarioId);
			ResultSet rs = null;
			questionario = new Questionario();
			questionario.setId(questionarioId);

			try {
				rs = dao.getQuestionsOfQuestionary(questionarioId);

				while (rs.next()) {
					Questao questao = new Questao(rs.getInt("id"), rs.getString("pergunta"), rs.getString("resposta1"),
							rs.getString("resposta2"), rs.getString("resposta3"), rs.getString("resposta4"),
							rs.getInt("correta"));

					questionario.addQuestao(questao);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			req.setAttribute("questoes", questionario.getQuestoes());

			req.getRequestDispatcher("/WEB-INF/jsp/questionario.jsp").forward(req, resp);
		}

		if ("Enviar Resposta".equals(action)) {
			int total = 0;

			for (int i = 0; i < questionario.getQuestoes().size(); i++) {
				String resposta = req.getParameter("resposta" + i);

				if (resposta == null) {
					req.setAttribute("error", "Responda corretamente todas as questões!");
					req.setAttribute("questoes", questionario.getQuestoes());
					req.getRequestDispatcher("/WEB-INF/jsp/questionario.jsp").forward(req, resp);
					return;
				} else {

					if (Integer.parseInt(resposta) == questionario.getQuestao(i).getCorreta()) {
						total += 1;
					}
				}
			}
			System.out.println(total);

			Pontuacao pontuacao = new Pontuacao(total, questionario.getId(),
					(Integer) req.getSession().getAttribute("usuarioId"));

			UserDao dao = new UserDao();
			try {
				int i = 1;
				dao.saveScoreOfUser(pontuacao.getPontuacao(), pontuacao.getUsuario(), pontuacao.getQuestionario());
				ResultSet rs = dao.getCorrectAnswers(questionario.getId());

				while (rs.next()) {
					req.setAttribute("correta"+i, rs.getInt("correta"));
					i++;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			req.setAttribute("pontuacao", pontuacao.getPontuacao());
			req.setAttribute("questionarioId", questionario.getId());
			req.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp").forward(req, resp);
		}

		if ("Salvar Pergunta".equals(action)) {
			boolean criado = false;
			UserDao dao = new UserDao();
			for (int i = 1; i <= 4; i++) {
				String pergunta = req.getParameter("pergunta" + i);
				String resposta1 = req.getParameter("resposta" + i + "1");
				String resposta2 = req.getParameter("resposta" + i + "2");
				String resposta3 = req.getParameter("resposta" + i + "3");
				String resposta4 = req.getParameter("resposta" + i + "4");
				String correta = req.getParameter("perg" + i);
				int questionarioId = Integer.parseInt(req.getParameter("questionarioId"));

				if (pergunta == null || pergunta.trim() == "" || resposta1 == null || resposta1.trim() == ""
						|| resposta2 == null || resposta2.trim() == "" || resposta3 == null || resposta3.trim() == ""
						|| resposta4 == null || resposta4.trim() == "" || correta == null || correta.trim() == "") {
					req.setAttribute("error", "Preencha corretamente todos os valores!");
				} else {

					try {
						dao.saveQuestion(criado, pergunta, resposta1, resposta2, resposta3, resposta4,
								Integer.parseInt(correta), questionarioId);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					criado = true;
				}
			}
			req.getRequestDispatcher("/WEB-INF/jsp/professor.jsp").forward(req, resp);
		}

		if ("Resultado Questionario".equals(action)) {
			UserDao dao = new UserDao();
			List<Integer> ids_questionario = new ArrayList<Integer>();
			try {
				ResultSet rs = dao.getQuestionaries();

				while (rs.next()) {
					ids_questionario.add(rs.getInt("id"));
				}

				req.setAttribute("idsQuestionario", ids_questionario);
				req.getRequestDispatcher("/WEB-INF/jsp/resultado_questionario.jsp").forward(req, resp);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ("Checar".equals(action)) {
			UserDao dao = new UserDao();
			List<Integer> pontosPontuacao = new ArrayList<Integer>();
			List<String> usuariosPontuacao = new ArrayList<String>();
			try {
				ResultSet rs = dao.getScoreOfQuestionary(Integer.parseInt(req.getParameter("id")));

				while (rs.next()) {
					pontosPontuacao.add(rs.getInt("pontuacao"));
					usuariosPontuacao.add(rs.getString("usuario"));
				}

				req.setAttribute("pontosPontuacao", pontosPontuacao);
				req.setAttribute("usuariosPontuacao", usuariosPontuacao);
				req.getRequestDispatcher("/WEB-INF/jsp/classificacao.jsp").forward(req, resp);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ("Voltar".equals(action)) {
			req.getRequestDispatcher("/WEB-INF/jsp/aluno.jsp").forward(req, resp);
		}

	}
}
