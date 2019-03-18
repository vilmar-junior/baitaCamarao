package view.aula6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PrimeiraTela {

	private JFrame frmPrimeiraTela;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela window = new PrimeiraTela();
					window.frmPrimeiraTela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrimeiraTela = new JFrame();
		frmPrimeiraTela.setTitle("Primeira Tela");
		frmPrimeiraTela.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmPrimeiraTela.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(0, 86, 45, 14);
		frmPrimeiraTela.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(50, 80, 216, 20);
		frmPrimeiraTela.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		frmPrimeiraTela.setBackground(Color.YELLOW);
		frmPrimeiraTela.setBounds(100, 100, 319, 288);
		frmPrimeiraTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
