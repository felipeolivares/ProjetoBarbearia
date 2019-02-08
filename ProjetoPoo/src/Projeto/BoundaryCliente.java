package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlCliente;
import Entity.Cliente;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BoundaryCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCPFCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtEmailCliente;
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private ControlCliente control = new ControlCliente();
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryCliente frame = new BoundaryCliente();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public BoundaryCliente() {
		setTitle("Cliente");
		setBounds(100, 100, 316, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(34, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(34, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(34, 154, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(34, 197, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(110, 61, 149, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCPFCliente = new JTextField();
		txtCPFCliente.setBounds(110, 105, 149, 20);
		contentPane.add(txtCPFCliente);
		txtCPFCliente.setColumns(10);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(110, 151, 149, 20);
		contentPane.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(110, 194, 149, 20);
		contentPane.add(txtEmailCliente);
		txtEmailCliente.setColumns(10);
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBackground(new Color(0, 128, 0));
		
		btnSalvar.setBounds(34, 258, 89, 23);
		contentPane.add(btnSalvar);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 0, 0));

		btnCancelar.setBounds(170, 258, 89, 23);
		contentPane.add(btnCancelar);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("Salvar".equals(e.getActionCommand())) { 
			Cliente client = new Cliente();
			client.setNomeCliente(txtNomeCliente.getText());
			client.setCPFCliente(Integer.parseInt(txtCPFCliente.getText()));
			client.setTelefoneCliente(Integer.parseInt(txtTelefoneCliente.getText()));
			client.setEmailCliente(txtEmailCliente.getText());
			
			control.adicionar( client );
			txtNomeCliente.setText("");
			txtCPFCliente.setText("");
			txtTelefoneCliente.setText("");
			txtEmailCliente.setText("");
		} else 
			if ("Cancelar".equals(e.getActionCommand())) { 
				txtNomeCliente.setText("");
				txtCPFCliente.setText("");
				txtTelefoneCliente.setText("");
				txtEmailCliente.setText("");
			}
	}

}
