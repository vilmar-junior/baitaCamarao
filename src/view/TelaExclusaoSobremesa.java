package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControladoraSobremesa;
import model.vo.SobremesaVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoSobremesa {

	private JFrame frmExclusaoDeSobremesa;
	private JComboBox cbSobremesas;
	private ArrayList<SobremesaVO> sobremesas = new ArrayList<SobremesaVO>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoSobremesa window = new TelaExclusaoSobremesa();
					window.frmExclusaoDeSobremesa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExclusaoSobremesa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExclusaoDeSobremesa = new JFrame();
		frmExclusaoDeSobremesa.setTitle("Exclusão de sobremesa");
		frmExclusaoDeSobremesa.setBounds(100, 100, 356, 163);
		frmExclusaoDeSobremesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExclusaoDeSobremesa.getContentPane().setLayout(null);
		
		cbSobremesas = new JComboBox(sobremesas.toArray());
		consultarSobremesas();
		cbSobremesas.setBounds(10, 11, 323, 39);
		frmExclusaoDeSobremesa.getContentPane().add(cbSobremesas);
		cbSobremesas.setSelectedIndex(-1);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladoraSobremesa controladora = new ControladoraSobremesa();
				String mensagem = controladora.excluir((SobremesaVO)cbSobremesas.getSelectedItem());
				JOptionPane.showMessageDialog(null, mensagem);
				
				consultarSobremesas();
			}
		});
		btnExcluir.setBounds(110, 75, 131, 38);
		frmExclusaoDeSobremesa.getContentPane().add(btnExcluir);
	}
	
	private void consultarSobremesas() {
		ControladoraSobremesa controller = new ControladoraSobremesa();
		sobremesas = controller.consultarTodasAsSobremesas();
		cbSobremesas.setModel(new DefaultComboBoxModel(sobremesas.toArray()));
		cbSobremesas.setSelectedIndex(-1);
	}
}
