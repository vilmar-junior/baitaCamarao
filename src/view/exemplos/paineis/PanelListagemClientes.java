package view.exemplos.paineis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelListagemClientes extends JPanel {
	private JTextField txtNome;
	private JTable tblResultados;

	/**
	 * Create the panel.
	 */
	public PanelListagemClientes() {
		setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 30, 46, 25);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(75, 30, 260, 25);
		add(txtNome);
		txtNome.setColumns(10);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 30, 130, 25);
		add(btnFiltrar);

		tblResultados = new JTable();
		tblResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tblResultados.getSelectedRow();

			}
		});
		tblResultados
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "#", "New column", "New column" }));
		tblResultados.setBounds(30, 60, 450, 250);
		add(tblResultados);
	}
}