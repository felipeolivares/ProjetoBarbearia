package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.ControlProduto;

import Entity.Produto;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BoundaryProduto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtReservaProduto;
	private JTextField txtCodProduto;
	private JTextField txtPrecoProduto;
	private JTextField txtDescricaoProduto;
	private JButton btnAdicionar = new JButton("Adicionar");
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tbProduto = new JTable(modelo);
	private ControlProduto control = new ControlProduto();

	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryProduto frame = new BoundaryProduto();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public BoundaryProduto() {
		setTitle("Produto");
		setBounds(100, 100, 507, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodReserva = new JLabel("Cod Reserva");
		lblCodReserva.setBounds(10, 11, 86, 14);
		contentPane.add(lblCodReserva);
		
		txtReservaProduto = new JTextField();
		txtReservaProduto.setBounds(10, 35, 86, 20);
		contentPane.add(txtReservaProduto);
		txtReservaProduto.setColumns(10);
		
		JLabel lblCodProduto = new JLabel("Cod Produto");
		lblCodProduto.setBounds(106, 11, 86, 14);
		contentPane.add(lblCodProduto);
		
		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(106, 35, 86, 20);
		contentPane.add(txtCodProduto);
		txtCodProduto.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(202, 11, 46, 14);
		contentPane.add(lblPreco);
		
		txtPrecoProduto = new JTextField();
		txtPrecoProduto.setBounds(202, 35, 86, 20);
		contentPane.add(txtPrecoProduto);
		txtPrecoProduto.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(298, 11, 68, 14);
		contentPane.add(lblDescricao);
		
		txtDescricaoProduto = new JTextField();
		txtDescricaoProduto.setBounds(298, 35, 86, 20);
		contentPane.add(txtDescricaoProduto);
		txtDescricaoProduto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 470, 152);
		contentPane.add(scrollPane);
		
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Reserva", "Cod Produto", "Preco", "Descricao"
			}
		));
		scrollPane.setViewportView(tbProduto);
		btnAdicionar.setBackground(new Color(0, 128, 0));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		
		btnAdicionar.setBounds(10, 66, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setForeground(new Color(255, 255, 255));
		btnFornecedor.setBackground(new Color(0, 0, 128));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoundaryFornecedor obj = new BoundaryFornecedor();
				obj.main(null);
			}
		});
		btnFornecedor.setBounds(10, 261, 105, 23);
		contentPane.add(btnFornecedor);
		
		btnAdicionar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar".equals(e.getActionCommand())) { 
			Produto prod = new Produto();
			prod.setReservaProduto(Integer.parseInt(txtReservaProduto.getText()));
			prod.setCodProduto(Integer.parseInt(txtCodProduto.getText()));
			prod.setPrecoProduto(Float.parseFloat(txtPrecoProduto.getText()));
			prod.setDescricao(txtDescricaoProduto.getText());
			
			control.adicionar( prod );
			txtReservaProduto.setText("");
			txtCodProduto.setText("");
			txtPrecoProduto.setText("");
			txtDescricaoProduto.setText("");
			
			int numCols = tbProduto.getModel().getColumnCount();
            ControlProduto so = new ControlProduto(); 
            List<Produto> inst = so.ler(null);
            Object [] fila = new Object[numCols]; 
            for (Produto p: inst) {
            	modelo.addRow(new Object[]{
            	
				        
       			fila[0] = p.getReservaProduto(),
       			fila[1] = p.getCodProduto(),
       			fila[2] = p.getPrecoProduto(),
       			fila[3] = p.getDescricao(),
            	});
            }
			
			 
			 ((DefaultTableModel) tbProduto.getModel()).addRow(fila);
			
		} 
	}
}
