package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlLogin;
import Entity.Login;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class BoundaryLoginCadastro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JButton btnCadastrarse = new JButton("Cadastrar-se");
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryLoginCadastro frame = new BoundaryLoginCadastro();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public BoundaryLoginCadastro() {
		setBounds(100, 100, 373, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(24, 61, 46, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 125, 46, 14);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(101, 58, 219, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(101, 122, 219, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		
		btnCadastrarse.setForeground(new Color(255, 255, 255));
		btnCadastrarse.setBackground(new Color(0, 128, 0));
		btnCadastrarse.setBounds(24, 193, 122, 23);
		contentPane.add(btnCadastrarse);
		btnCadastrarse.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Cadastrar-se".equals(e.getActionCommand())) {
			Login login = new Login();
			login.setUsuario(txtUsuario.getText());
			login.setSenha(txtSenha.getText());
			
			ControlLogin l = new ControlLogin();
			l.adicionar(login);
			
			txtUsuario.setText("");
			txtSenha.setText("");
			
			BoundaryMenu menu = new BoundaryMenu();
			menu.main(null);
			
		}
		
	}

}
