package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// Atributos:
	private static final String url = "jdbc:postgresql://localhost:5433/bd_aula03";
	private static final String user = "postgres";
	private static final String password = "coti";
	private static final String driver = "org.postgresql.Driver";

	// método para abrir e retornar uma conexão com o PostGreSQL
	public static Connection createConnection() throws Exception {
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
		
	}

}
