package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlFornecedor;
import Entity.Fornecedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class BoundaryFornecedor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtProdutoFornecedor;
	private JTextField txtCnpjFornecedor;
	private JTextField txtCodFornecedor;
	private JTextField txtNomeFornecedor;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private ControlFornecedor control = new ControlFornecedor();
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryFornecedor frame = new BoundaryFornecedor();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public BoundaryFornecedor() {
		setTitle("Fornecedor");
		setBounds(100, 100, 265, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduto = new JLabel("Cod Produto");
		lblProduto.setBounds(10, 26, 85, 14);
		contentPane.add(lblProduto);
		
		txtProdutoFornecedor = new JTextField();
		txtProdutoFornecedor.setBounds(105, 23, 129, 20);
		contentPane.add(txtProdutoFornecedor);
		txtProdutoFornecedor.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 61, 46, 14);
		contentPane.add(lblCnpj);
		
		txtCnpjFornecedor = new JTextField();
		txtCnpjFornecedor.setBounds(105, 58, 129, 20);
		contentPane.add(txtCnpjFornecedor);
		txtCnpjFornecedor.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Cod Fornecedor");
		lblFornecedor.setBounds(10, 92, 98, 14);
		contentPane.add(lblFornecedor);
		
		txtCodFornecedor = new JTextField();
		txtCodFornecedor.setBounds(105, 89, 129, 20);
		contentPane.add(txtCodFornecedor);
		txtCodFornecedor.setColumns(10);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 128, 0));
		
		btnCadastrar.setBounds(10, 162, 98, 23);
		contentPane.add(btnCadastrar);
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setBackground(new Color(0, 0, 128));
		
		btnPesquisar.setBounds(130, 162, 104, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 121, 85, 14);
		contentPane.add(lblNome);
		
		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.setBounds(105, 120, 129, 20);
		contentPane.add(txtNomeFornecedor);
		txtNomeFornecedor.setColumns(10);
		
		btnCadastrar.addActionListener(this);
		btnPesquisar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if ("Cadastrar".equals(e.getActionCommand())) { 
			Fornecedor forn = new Fornecedor();
			forn.setProdutoFornecedor(Integer.parseInt(txtProdutoFornecedor.getText()));
			forn.setCnpjFornecedor(Integer.parseInt(txtCnpjFornecedor.getText()));
			forn.setCodFornecedor(Integer.parseInt(txtCodFornecedor.getText()));
			forn.setNomeFornecedor(txtNomeFornecedor.getText());
			
			control.adicionar( forn );
			
			txtProdutoFornecedor.setText("");
			txtCnpjFornecedor.setText("");
			txtCodFornecedor.setText("");
			txtNomeFornecedor.setText("");
		} else if ("Pesquisar".equals(e.getActionCommand())) {
			Fornecedor lb = 
					control.pesquisarPorCod( txtProdutoFornecedor.getText() );
			txtProdutoFornecedor.setText( String.valueOf(lb.getProdutoFornecedor()) );
			txtCnpjFornecedor.setText( String.valueOf(lb.getCnpjFornecedor()) );
			txtCodFornecedor.setText( String.valueOf(lb.getCodFornecedor()) );
			txtNomeFornecedor.setText( lb.getNomeFornecedor() );
		}
	}

}
