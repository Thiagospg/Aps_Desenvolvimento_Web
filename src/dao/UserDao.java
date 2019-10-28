package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private static Connection con = null;

	public String userAuth(String username, String password) throws SQLException, ClassNotFoundException {
		con = ConexaoBanco.conectar();
		ResultSet rs = getUserData(con, username);

		if (username == null || username == "" || password == null || password == "")
			return "Preencha os campos corretamente.";
		if (rs.next()) {
			if (rs.getString("senha").equals(password))
				return rs.getString("autorizacao");
		}

		return "Senha inválida ou usuário inexistente";
	}

	private ResultSet getUserData(Connection con, String username) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user where usuario= ?");
		stmt.setString(1, username);

		ResultSet rs = stmt.executeQuery();
		return rs;
	}

	public void saveQuestion(boolean criado, String pergunta, String resp1, String resp2, String resp3, String resp4, int correta,
			int questionarioId) throws SQLException {

		if(criado == false)
			createQuestionary(questionarioId);

		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO question (pergunta, resposta1, resposta2, resposta3, resposta4, correta, questionario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, pergunta);
		stmt.setString(2, resp1);
		stmt.setString(3, resp2);
		stmt.setString(4, resp3);
		stmt.setString(5, resp4);
		stmt.setInt(6, correta);
		stmt.setInt(7, questionarioId);

		int result = stmt.executeUpdate();

		System.out.println("Linhas afetadas: " + result);
	}

	private void createQuestionary(int questionarioId) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("INSERT INTO questionario (id) VALUES (?)");
		stmt.setInt(1, questionarioId);
		stmt.executeUpdate();
	}

	public int getQuestionaryCount() throws SQLException {
		int total = 0;
		PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) AS total FROM questionario");
		ResultSet rs = stmt.executeQuery();

		if (rs.next())
			total = rs.getInt("total");

		return total;
	}

}
