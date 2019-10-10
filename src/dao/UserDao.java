package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private Connection con = null;

	public String userAuth(String username, String password) throws SQLException, ClassNotFoundException {
		con = ConexaoBanco.conectar();
		ResultSet rs = getUserData(con, username);

		if(username == null || username == "" || password == null || password == "") 
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

}
