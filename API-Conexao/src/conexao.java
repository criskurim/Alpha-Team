import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	private String sql = "SELECT pg_database.datname, pg_size_pretty(pg_database_size(pg_database.datname)) AS size FROM pg_database;";
	
	conexao(){
		url = "jdbc:postgresql://localhost:5432/teste";
		usuario = "postgres";
		senha = "toto190100";
		// Necessário alterar a url, usuario e senha para o banco que será conectado
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conexão realizada com sucesso!!!");
			
			PreparedStatement pesquisa = con.prepareStatement(sql);
			ResultSet result = pesquisa.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString("datname") + " " + result.getString("size"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		conexao con = new conexao();
	}
}