package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5432/teste";
	private String usuario = "postgres";
	private String senha = "toto190100";
	public Connection  con;
	
	public void iniciarConexao() {
		// Necess�rio alterar a url, usuario e senha para o banco que ser� conectado
		try {
			System.setProperty("jdbc.Drivers",driver );
			con = DriverManager.getConnection(caminho,usuario,senha);
				//JOptionPane.showMessageDialog(null, "Conex�o efetuada com sucesso!");
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro de conex�o: \n"+ex.getMessage());
		}

	}
	
	public void desconecta() {
		try {
			con.close();
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar: \n"+ex.getMessage());
		}
	}
}
