package view.aula6;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import view.exemplos.JNumberFormatField;

/**
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class TelaComponentesComMascaras extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComponentesComMascaras frame = new TelaComponentesComMascaras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaComponentesComMascaras() {
		setTitle("Exemplos de Máscaras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			MaskFormatter mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			MaskFormatter mascaraPlaca = new MaskFormatter("UUU-####");

			JFormattedTextField formattedTextFieldPlaca = new JFormattedTextField(mascaraPlaca);
			formattedTextFieldPlaca.setBounds(100, 22, 100, 20);
			contentPane.add(formattedTextFieldPlaca);

			JLabel lblPlaca = new JLabel("Placa:");
			lblPlaca.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPlaca.setBounds(10, 25, 75, 14);
			contentPane.add(lblPlaca);

			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefone.setBounds(10, 55, 75, 14);
			contentPane.add(lblTelefone);

			JFormattedTextField formattedTextFieldTelefone = new JFormattedTextField(mascaraTelefone);
			formattedTextFieldTelefone.setBounds(94, 53, 95, 20);
			contentPane.add(formattedTextFieldTelefone);

			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCpf.setBounds(199, 25, 61, 14);
			contentPane.add(lblCpf);

			JLabel lblCnpj = new JLabel("CNPJ:");
			lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCnpj.setBounds(199, 56, 61, 14);
			contentPane.add(lblCnpj);

			JLabel lblCep = new JLabel("CEP:");
			lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCep.setBounds(10, 86, 74, 14);
			contentPane.add(lblCep);

			JFormattedTextField formattedTextFieldCep = new JFormattedTextField(mascaraCep);
			formattedTextFieldCep.setBounds(94, 83, 95, 20);
			contentPane.add(formattedTextFieldCep);

			JFormattedTextField formattedTextFieldCpf = new JFormattedTextField(mascaraCpf);
			formattedTextFieldCpf.setBounds(270, 22, 154, 20);
			contentPane.add(formattedTextFieldCpf);

			JFormattedTextField formattedTextFieldCnpj = new JFormattedTextField(mascaraCnpj);
			formattedTextFieldCnpj.setBounds(270, 53, 154, 20);
			contentPane.add(formattedTextFieldCnpj);

			JLabel lblValorEmReais = new JLabel("R$:");
			lblValorEmReais.setHorizontalAlignment(SwingConstants.RIGHT);
			lblValorEmReais.setBounds(199, 83, 61, 14);
			contentPane.add(lblValorEmReais);

			JNumberFormatField txtValorEmReais = new JNumberFormatField(2);
			txtValorEmReais.setBounds(270, 86, 155, 20);
			contentPane.add(txtValorEmReais);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
