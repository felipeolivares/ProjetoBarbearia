package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;

public class BoundaryMenu extends JFrame {

	
	public static void main(String[] args) {
	run();
	}

	public static void run() {
		try {
			BoundaryMenu frame = new BoundaryMenu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoundaryMenu() {
		setBackground(SystemColor.window);
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("Barbearia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmSecretaria = new JMenuItem("Secretaria");
		mntmSecretaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundarySecretaria obj = new BoundarySecretaria();
				obj.main(null);
			}
		});
		mnCadastrar.add(mntmSecretaria);
		
		JSeparator separator = new JSeparator();
		mnCadastrar.add(separator);
		
		JMenuItem mntmCliente = new JMenuItem("Profissional");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryProfissional obj = new BoundaryProfissional();
				obj.main(null);
			}
		});
		mnCadastrar.add(mntmCliente);
		
		JSeparator separator_1 = new JSeparator();
		mnCadastrar.add(separator_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryCliente obj = new BoundaryCliente();
				obj.main(null);
			}
		});
		mnCadastrar.add(mntmNewMenuItem);
		
		JSeparator separator_2 = new JSeparator();
		mnCadastrar.add(separator_2);
		
		JMenuItem mntmReserva = new JMenuItem("Reserva");
		mntmReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryReserva obj = new BoundaryReserva();
				obj.main(null);
			}
		});
		mnCadastrar.add(mntmReserva);
		
		JMenuItem mntmServico = new JMenuItem("Serviço");
		mntmServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryServico obj = new BoundaryServico();
				obj.main(null);
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnCadastrar.add(separator_3);
		mnCadastrar.add(mntmServico);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoundaryProduto obj = new BoundaryProduto();
				obj.main(null);
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		mnCadastrar.add(separator_4);
		mnCadastrar.add(mntmProduto);
	}
}
