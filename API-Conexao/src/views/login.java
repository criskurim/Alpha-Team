package views;

import controllers.conexao;
import models.bancoDados;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtPorta;
	private JTextField txtBanco;
	private JTextField txtUsuario;
	private JPasswordField psSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPorta = new JTextField();
		txtPorta.setBounds(119, 59, 58, 20);
		contentPane.add(txtPorta);
		txtPorta.setColumns(10);
		
		txtBanco = new JTextField();
		txtBanco.setBounds(204, 59, 86, 20);
		contentPane.add(txtBanco);
		txtBanco.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(119, 108, 171, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Testar Conex\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result;
				bancoDados banco = new bancoDados();
				
				banco.porta = txtPorta.getText();
				banco.nome = txtBanco.getText();
				banco.usuario = txtUsuario.getText();
				banco.senha = psSenha.getPassword();
			
				
				result = controllers.conexao.testeConexao(banco);
				
				if(result == "Conexão realizada com sucesso!!!") {
					JFrame frame = new JFrame("Mensagem");
					JOptionPane.showMessageDialog(frame, result,"Mensagem", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JFrame frame = new JFrame("Erro");
					JOptionPane.showMessageDialog(frame, result,"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(119, 205, 171, 28);
		contentPane.add(btnNewButton);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(119, 161, 171, 20);
		contentPane.add(psSenha);
		
		JLabel lblNewLabel = new JLabel("Porta");
		lblNewLabel.setBounds(119, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Banco");
		lblNewLabel_1.setBounds(204, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setBounds(119, 94, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(119, 148, 46, 14);
		contentPane.add(lblNewLabel_3);
	}
}
