package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControladoraSobremesa;
import model.vo.SobremesaVO;

public class TelaListagemSobremesa {

	private JFrame frmConsultaDeSobremesas;
	private JTable tblSobremesas;
	private JButton button;
	private JButton btnLimpar;
	private JLabel lblSobremesaSelecionada;
	private ArrayList<SobremesaVO> sobremesas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemSobremesa window = new TelaListagemSobremesa();
					window.frmConsultaDeSobremesas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemSobremesa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeSobremesas = new JFrame();
		frmConsultaDeSobremesas.setTitle("Consulta de sobremesas");
		frmConsultaDeSobremesas.setBounds(100, 100, 520, 390);
		frmConsultaDeSobremesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaDeSobremesas.getContentPane().setLayout(null);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Consultar a lista de sobremesas
				ControladoraSobremesa control = new ControladoraSobremesa();
				sobremesas = control.consultarTodasAsSobremesas();

				// Atualizar a tabela;
				atualizarTabela(sobremesas);
			}
		});
		btnPesquisar.setBounds(10, 10, 280, 25);
		frmConsultaDeSobremesas.getContentPane().add(btnPesquisar);

		tblSobremesas = new JTable();
		tblSobremesas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				selecionarSobremesaNaTabela();
			}
		});
		tblSobremesas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selecionarSobremesaNaTabela();
			}
		});
		limparTabela();

		tblSobremesas.setBounds(10, 46, 485, 169);
		frmConsultaDeSobremesas.getContentPane().add(tblSobremesas);

		button = new JButton("Pesquisar");
		button.setBounds(60, 80, 280, 25);
		frmConsultaDeSobremesas.getContentPane().add(button);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTabela();
			}
		});
		btnLimpar.setBounds(290, 10, 205, 25);
		frmConsultaDeSobremesas.getContentPane().add(btnLimpar);

		JLabel lblTextoSobremesa = new JLabel("Sobremesa selecionada:");
		lblTextoSobremesa.setBounds(10, 248, 159, 92);
		frmConsultaDeSobremesas.getContentPane().add(lblTextoSobremesa);

		lblSobremesaSelecionada = new JLabel("");
		lblSobremesaSelecionada.setBounds(174, 248, 321, 92);
		frmConsultaDeSobremesas.getContentPane().add(lblSobremesaSelecionada);
	}

	protected void selecionarSobremesaNaTabela() {
		int linhaSelecionada = tblSobremesas.getSelectedRow();

		if (linhaSelecionada > 0) {
			// Pegar a sobremesa selecionada
			SobremesaVO sobremesaSelecionada = sobremesas.get(linhaSelecionada - 1);
			lblSobremesaSelecionada.setText(sobremesaSelecionada.toString());
		} else {
			lblSobremesaSelecionada.setText("Nenhuma sobremesa selecionada");
		}
	}

	protected void atualizarTabela(ArrayList<SobremesaVO> sobremesas) {
		// Limpa a tabela
		limparTabela();

		double d = 0.0;
		String valorFormatado = String.valueOf(d);
		valorFormatado = "R$" + valorFormatado.replace(".", ",");

		// Obtém o model da tabela
		DefaultTableModel model = (DefaultTableModel) tblSobremesas.getModel();

		// Percorre as sobremesas para adicionar linha a linha na tabela (JTable)
		for (SobremesaVO sobremesa : sobremesas) {
			String[] novaLinha = new String[4];
			novaLinha[0] = sobremesa.getId() + "";
			novaLinha[1] = sobremesa.getNome();
			novaLinha[2] = "R$" + String.valueOf(sobremesa.getPreco()).replace(".", ",");
			novaLinha[3] = sobremesa.isLight() ? "Sim" : "Não";

			// Adiciona a nova linha na tabela
			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {
		tblSobremesas.setModel(new DefaultTableModel(new Object[][] { { "id", "Nome", "Valor", "Light?" }, },
				new String[] { "id", "Nome", "Valor", "Light?" }));
	}
}
