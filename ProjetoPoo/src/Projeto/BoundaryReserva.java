package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Control.ControlReserva;

import Entity.Reserva;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class BoundaryReserva extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtDataReserva;
	private JTextField txtTipoReserva;
	private ControlReserva control = new ControlReserva();
	private JTextField txtClienteReserva;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tbReserva = new JTable(modelo);
	
	private JTextField txtCodReserva;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JScrollPane scrollPane = new JScrollPane(); 
	

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			BoundaryReserva frame = new BoundaryReserva();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}


	public BoundaryReserva() {
		setTitle("Reserva");
		setBounds(100, 100, 484, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCliente = new JLabel("CPF Cliente");
		lblCliente.setBounds(28, 24, 81, 14);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(147, 24, 46, 14);
		
		txtDataReserva = new JTextField();
		txtDataReserva.setBounds(147, 52, 109, 20);
		txtDataReserva.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Pagamento");
		lblNewLabel_1.setBounds(266, 24, 96, 14);
		
		txtTipoReserva = new JTextField();
		txtTipoReserva.setBounds(266, 52, 109, 20);
		txtTipoReserva.setColumns(10);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(0, 128, 0));
		
	
		btnCadastrar.setBounds(28, 97, 94, 23);
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(255, 0, 0));
		
		btnExcluir.setBounds(132, 97, 74, 23);
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(0, 0, 128));
		
		
		btnAtualizar.setBounds(216, 97, 89, 23);
		
		contentPane.setLayout(null);
		contentPane.add(btnCadastrar);
		contentPane.add(btnExcluir);
		contentPane.add(btnAtualizar);
		contentPane.add(lblCliente);
		contentPane.add(lblData);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtDataReserva);
		contentPane.add(txtTipoReserva);
		
		txtClienteReserva = new JTextField();
		txtClienteReserva.setBounds(28, 52, 109, 20);
		contentPane.add(txtClienteReserva);
		txtClienteReserva.setColumns(10);
		
		
		scrollPane.setBounds(10, 131, 448, 176);
		contentPane.add(scrollPane);
		
		
		tbReserva.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cpf Cliente", "Data", "Tipo Pagamento", "Cod Reserva"
			}
		));
		scrollPane.setViewportView(tbReserva);
		
		
		
		JLabel lblCodReserva = new JLabel("Cod Reserva");
		lblCodReserva.setBounds(381, 24, 77, 14);
		contentPane.add(lblCodReserva);
		
		txtCodReserva = new JTextField();
		txtCodReserva.setBounds(385, 52, 73, 20);
		contentPane.add(txtCodReserva);
		txtCodReserva.setColumns(10);
		
		btnCadastrar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnAtualizar.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
			
			if ("Atualizar".equals(e.getActionCommand())) { 
				Reserva reserv = new Reserva();
				reserv.setClienteReserva(Integer.parseInt(txtClienteReserva.getText()));
				try {
					Date d = sdf.parse(txtDataReserva.getText());
					reserv.setDataReserva(d);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				reserv.setTipoReserva(txtTipoReserva.getText());
				reserv.setCodReserva(Integer.parseInt(txtCodReserva.getText()));
				
				control.atualizar( reserv );
				txtClienteReserva.setText("");
				txtDataReserva.setText("");
				txtTipoReserva.setText("");
				txtCodReserva.setText("");
				
				int numCols = tbReserva.getModel().getColumnCount();
                ControlReserva so = new ControlReserva(); 
                List<Reserva> inst = so.ler(null);
                Object [] fila = new Object[numCols]; 
                for (Reserva p: inst) {
                	modelo.addRow(new Object[]{
                	    				        
           			fila[0] = p.getClienteReserva(),
           			fila[1] = p.getDataReserva(),
           			fila[2] = p.getTipoReserva(),
           			fila[3] = p.getCodReserva(),
                	});
                }
				
				 
				 ((DefaultTableModel) tbReserva.getModel()).addRow(fila);
				
			} else 
				if ("Cadastrar".equals(e.getActionCommand())) { 
					
					
					Reserva reserv = new Reserva();
					reserv.setClienteReserva(Integer.parseInt(txtClienteReserva.getText()));
					try {
						Date d = sdf.parse(txtDataReserva.getText());
						reserv.setDataReserva(d);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
					reserv.setTipoReserva(txtTipoReserva.getText());
					reserv.setCodReserva(Integer.parseInt(txtCodReserva.getText()));
					
					control.adicionar( reserv );
					txtClienteReserva.setText("");
					txtDataReserva.setText("");
					txtTipoReserva.setText("");
					txtCodReserva.setText("");
					
					int numCols = tbReserva.getModel().getColumnCount();
	                ControlReserva so = new ControlReserva(); 
	                List<Reserva> inst = so.ler(null);
	                Object [] fila = new Object[numCols]; 
	                for (Reserva p: inst) {
	                	modelo.addRow(new Object[]{
	                	
	    				        
	           			fila[0] = p.getClienteReserva(),
	           			fila[1] = p.getDataReserva(),
	           			fila[2] = p.getTipoReserva(),
	           			fila[3] = p.getCodReserva(),
	                	});
	                }
					
					 
					 ((DefaultTableModel) tbReserva.getModel()).addRow(fila);
					
		} else
			if ("Excluir".equals(e.getActionCommand())) { 
				
				Reserva reserv = new Reserva();
				reserv.setClienteReserva(Integer.parseInt(txtClienteReserva.getText()));			
				
				control.excluir( reserv );
				txtClienteReserva.setText("");
				((DefaultTableModel) tbReserva.getModel()).removeRow(tbReserva.getSelectedRow());
				
				
			} 
		
		
	}
}
