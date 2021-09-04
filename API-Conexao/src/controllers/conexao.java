package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.bancoDados;

public class conexao {
	public static String testeConexao(bancoDados banco) {
		
		String url;
		Connection con;
		String senhaDesc = new String(banco.senha);
		
		url = "jdbc:postgresql://localhost:" + banco.porta + "/" + banco.nome;
		// Necessário alterar a url, usuario e senha para o banco que será conectado
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,banco.usuario,senhaDesc);
			
			return "Conexão realizada com sucesso!!!";
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
	} 
}
