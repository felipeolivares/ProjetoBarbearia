package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import Control.ControlServico;

import Entity.Servico;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;


public class BoundaryServico extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtReservaServico;
	private JTextField txtCodServico;
	private JTextField txtPrecoServico;
	private JTextField txtTipoServico;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tbServico = new JTable(modelo);
	private JButton btnAdicionar = new JButton("Adicionar");
	private ControlServico control = new ControlServico();
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		try {
			BoundaryServico frame = new BoundaryServico();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoundaryServico() {
		setTitle("Servico");
		setBounds(100, 100, 507, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodReserva = new JLabel("Cod Reserva");
		lblCodReserva.setBackground(new Color(0, 0, 0));
		lblCodReserva.setBounds(10, 11, 86, 14);
		contentPane.add(lblCodReserva);
		
		txtReservaServico = new JTextField();
		txtReservaServico.setBounds(10, 35, 86, 20);
		contentPane.add(txtReservaServico);
		txtReservaServico.setColumns(10);
		
		JLabel lblCodServico = new JLabel("Cod Servico");
		lblCodServico.setBounds(106, 11, 68, 14);
		contentPane.add(lblCodServico);
		
		txtCodServico = new JTextField();
		txtCodServico.setBounds(106, 35, 86, 20);
		contentPane.add(txtCodServico);
		txtCodServico.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(202, 11, 46, 14);
		contentPane.add(lblPreco);
		
		txtPrecoServico = new JTextField();
		txtPrecoServico.setBounds(202, 35, 86, 20);
		contentPane.add(txtPrecoServico);
		txtPrecoServico.setColumns(10);
		
		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setBounds(298, 11, 46, 14);
		contentPane.add(lbltipo);
		
		txtTipoServico = new JTextField();
		txtTipoServico.setBounds(298, 35, 86, 20);
		contentPane.add(txtTipoServico);
		txtTipoServico.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 470, 152);
		contentPane.add(scrollPane);
		
		tbServico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Reserva", "Cod Servico", "Preco", "Tipo"
			}
		));
		scrollPane.setViewportView(tbServico);
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBackground(new Color(0, 128, 0));
		
		btnAdicionar.setBounds(10, 66, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnAdicionar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar".equals(e.getActionCommand())) { 
			Servico serv = new Servico();
			serv.setReservaServico(Integer.parseInt(txtReservaServico.getText()));
			serv.setCodServico(Integer.parseInt(txtCodServico.getText()));
			serv.setPrecoServico(Float.parseFloat(txtPrecoServico.getText()));
			serv.setTipoServico(txtTipoServico.getText());
			
			control.adicionar( serv );
			txtReservaServico.setText("");
			txtCodServico.setText("");
			txtPrecoServico.setText("");
			txtTipoServico.setText("");
			
			int numCols = tbServico.getModel().getColumnCount();
            ControlServico so = new ControlServico(); 
            List<Servico> inst = so.ler(null);
            Object [] fila = new Object[numCols]; 
            for (Servico p: inst) {
            	modelo.addRow(new Object[]{
            	
				        
       			fila[0] = p.getReservaServico(),
       			fila[1] = p.getCodServico(),
       			fila[2] = p.getPrecoServico(),
       			fila[3] = p.getTipoServico(),
            	});
            }
			
			 
			 ((DefaultTableModel) tbServico.getModel()).addRow(fila);
		} 
		
	}
}
