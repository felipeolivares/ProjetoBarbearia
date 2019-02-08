package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlSecretaria;
import Entity.Secretaria;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BoundarySecretaria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeSecretaria;
	private JTextField txtCPFSecretaria;
	private JTextField txtTelefoneSecretaria;
	private JTextField txtEmailSecretaria;
	private JTextField txtHorarioSecretaria;
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");
	private ControlSecretaria control = new ControlSecretaria();
	private JTextField txtCodSecretaria;

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundarySecretaria frame = new BoundarySecretaria();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoundarySecretaria() {
		setTitle("Secretária");
		setBounds(100, 100, 316, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 36, 46, 14);
		contentPane.add(lblNome);

		txtNomeSecretaria = new JTextField();
		txtNomeSecretaria.setBounds(113, 33, 132, 20);
		contentPane.add(txtNomeSecretaria);
		txtNomeSecretaria.setColumns(10);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(57, 81, 46, 14);
		contentPane.add(lblCPF);

		txtCPFSecretaria = new JTextField();
		txtCPFSecretaria.setBounds(113, 78, 132, 20);
		contentPane.add(txtCPFSecretaria);
		txtCPFSecretaria.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(57, 126, 55, 14);
		contentPane.add(lblTelefone);

		txtTelefoneSecretaria = new JTextField();
		txtTelefoneSecretaria.setBounds(113, 123, 132, 20);
		contentPane.add(txtTelefoneSecretaria);
		txtTelefoneSecretaria.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(57, 171, 46, 14);
		contentPane.add(lblEmail);

		txtEmailSecretaria = new JTextField();
		txtEmailSecretaria.setBounds(113, 168, 132, 20);
		contentPane.add(txtEmailSecretaria);
		txtEmailSecretaria.setColumns(10);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(57, 216, 46, 14);
		contentPane.add(lblHorario);

		txtHorarioSecretaria = new JTextField();
		txtHorarioSecretaria.setBounds(113, 213, 132, 20);
		contentPane.add(txtHorarioSecretaria);
		txtHorarioSecretaria.setColumns(10);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setForeground(new Color(255, 255, 255));

		btnSalvar.setBounds(57, 297, 89, 23);
		contentPane.add(btnSalvar);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 0, 0));

		btnCancelar.setBounds(156, 297, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(57, 261, 46, 14);
		contentPane.add(lblCodigo);

		txtCodSecretaria = new JTextField();
		txtCodSecretaria.setBounds(113, 258, 132, 20);
		contentPane.add(txtCodSecretaria);
		txtCodSecretaria.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if ("Salvar".equals(e.getActionCommand())) {
			Secretaria secreta = new Secretaria();
			secreta.setNomeSecretaria(txtNomeSecretaria.getText());
			secreta.setCPFSecretaria(Integer.parseInt(txtCPFSecretaria.getText()));
			secreta.setTelSecretaria(Integer.parseInt(txtTelefoneSecretaria.getText()));
			secreta.setEmailSecretaria(txtEmailSecretaria.getText());
			secreta.setCodSecretaria(Integer.parseInt(txtCodSecretaria.getText()));
			try {
				Date d = sdf.parse(txtHorarioSecretaria.getText());
				secreta.setHorarioSecretaria(d);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			control.adicionar(secreta);
			txtNomeSecretaria.setText("");
			txtCPFSecretaria.setText("");
			txtTelefoneSecretaria.setText("");
			txtEmailSecretaria.setText("");
			txtHorarioSecretaria.setText("");
			txtCodSecretaria.setText("");
		} else
			if ("Cancelar".equals(e.getActionCommand())) {
				txtNomeSecretaria.setText("");
				txtCPFSecretaria.setText("");
				txtTelefoneSecretaria.setText("");
				txtEmailSecretaria.setText("");
				txtHorarioSecretaria.setText("");
				txtCodSecretaria.setText("");

			}
	}
}
