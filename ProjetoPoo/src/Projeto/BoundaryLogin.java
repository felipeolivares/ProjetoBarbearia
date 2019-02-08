package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class BoundaryLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	JButton btnCadastrar = new JButton("Cadastrar");
	JButton btnLogin = new JButton("Login");
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		try {
			BoundaryLogin frame = new BoundaryLogin();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoundaryLogin() {
		setTitle("Login");
		setBounds(100, 100, 379, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(25, 66, 46, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(25, 129, 46, 14);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(93, 63, 231, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(93, 126, 231, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(0, 0, 128));
		btnCadastrar.setBounds(25, 214, 102, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(222, 214, 102, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Cadastrar".equals(e.getActionCommand())) { 
			BoundaryLoginCadastro log = new BoundaryLoginCadastro();
			log.main(null);
				
		} else if ("Login".equals(e.getActionCommand())) {
			
			BoundaryMenu menu = new BoundaryMenu();
			menu.main(null);
			txtUsuario.setText("");
			txtSenha.setText("");
			
		}
	}
}
