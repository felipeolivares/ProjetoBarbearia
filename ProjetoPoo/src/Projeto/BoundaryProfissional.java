package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlProfissional;
import Entity.Profissional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BoundaryProfissional extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeProfissional;
	private JTextField txtCPFProfissional;
	private JTextField txtTelefoneProfissional;
	private JTextField txtEmailProfissional;
	private JTextField txtEspecializacaoProfissional;
	private JTextField txtCodigoProfissional;
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private ControlProfissional control = new ControlProfissional();

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryProfissional frame = new BoundaryProfissional();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoundaryProfissional() {
		setTitle("Profissional");
		setBounds(100, 100, 316, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(43, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeProfissional = new JTextField();
		txtNomeProfissional.setBounds(137, 33, 125, 20);
		contentPane.add(txtNomeProfissional);
		txtNomeProfissional.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(43, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCPFProfissional = new JTextField();
		txtCPFProfissional.setBounds(137, 78, 125, 20);
		contentPane.add(txtCPFProfissional);
		txtCPFProfissional.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(43, 126, 58, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTelefoneProfissional = new JTextField();
		txtTelefoneProfissional.setBounds(137, 123, 125, 20);
		contentPane.add(txtTelefoneProfissional);
		txtTelefoneProfissional.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(43, 171, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEmailProfissional = new JTextField();
		txtEmailProfissional.setBounds(137, 168, 125, 20);
		contentPane.add(txtEmailProfissional);
		txtEmailProfissional.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Especializa\u00E7\u00E3o");
		lblNewLabel_4.setBounds(43, 219, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		txtEspecializacaoProfissional = new JTextField();
		txtEspecializacaoProfissional.setBounds(137, 216, 125, 20);
		contentPane.add(txtEspecializacaoProfissional);
		txtEspecializacaoProfissional.setColumns(10);
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setBackground(new Color(0, 128, 0));
		
		btnSalvar.setBounds(43, 291, 89, 23);
		contentPane.add(btnSalvar);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 0, 0));
		
		btnCancelar.setBounds(173, 291, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCodProfissional = new JLabel("Codigo");
		lblCodProfissional.setBounds(43, 266, 97, 14);
		contentPane.add(lblCodProfissional);
		
		txtCodigoProfissional = new JTextField();
		txtCodigoProfissional.setBounds(137, 263, 125, 20);
		contentPane.add(txtCodigoProfissional);
		txtCodigoProfissional.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("Salvar".equals(e.getActionCommand())) { 
			Profissional prof = new Profissional();
			prof.setNomeProfissional(txtNomeProfissional.getText());
			prof.setCPFProfissional(Integer.parseInt(txtCPFProfissional.getText()));
			prof.setTelefoneProfissional(Integer.parseInt(txtTelefoneProfissional.getText()));
			prof.setEmailProfissional(txtEmailProfissional.getText());
			prof.setEspecializacaoProfissional(txtEspecializacaoProfissional.getText());
			prof.setCodProfissional(Integer.parseInt(txtCodigoProfissional.getText()));
			control.adicionar( prof );
			txtNomeProfissional.setText("");
			txtCPFProfissional.setText("");
			txtTelefoneProfissional.setText("");
			txtEmailProfissional.setText("");
			txtEspecializacaoProfissional.setText("");
			txtCodigoProfissional.setText("");
			
		} else
			if ("Cancelar".equals(e.getActionCommand())) {
				txtNomeProfissional.setText("");
				txtCPFProfissional.setText("");
				txtTelefoneProfissional.setText("");
				txtEmailProfissional.setText("");
				txtEspecializacaoProfissional.setText("");
				txtCodigoProfissional.setText("");
			}
	}
}
