package view.exemplos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;

import controller.exemplos.ProdutoController;
import model.seletor.exemplos.ProdutoSeletor;
import model.vo.exemplos.Produto;
import javax.swing.JTextField;

public class TelaListagemProdutos extends JFrame {

	private static final String COR_AZUL = "Azul";
	private static final String COR_AMARELO = "Amarelo";
	private static final String COR_PRETO = "Preto";
	private static final String COR_VERDE = "Verde";
	private static final String COR_VERMELHO = "Vermelho";

	private JPanel contentPane;
	private JTable table;
	private JTable tblProdutos;
	private JButton btnGerarXls;
	private JButton btnGerarPdf;
	private JComboBox cbCor;
	private DatePicker dtInicioCadastro;
	private DatePicker dtFimCadastro;

	//Esta lista de produtos é atualizada a cada nova consulta realizada com os filtros.
	//Será a lista usada para gerar os relatórios
	private List<Produto> produtosConsultados;
	private JTextField txtNome;
	private JTextField txtPeso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemProdutos frame = new TelaListagemProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cbCor 
	 */
	public TelaListagemProdutos() {
		setTitle("Consulta de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConsultar = new JButton("Consultar");

		btnConsultar.setBounds(160, 215, 150, 40);
		contentPane.add(btnConsultar);

		String[] cores = {"---Selecione---", TelaListagemProdutos.COR_AZUL, TelaListagemProdutos.COR_AMARELO, 
				TelaListagemProdutos.COR_PRETO,TelaListagemProdutos.COR_VERDE, TelaListagemProdutos.COR_VERMELHO };

		JLabel lblFiltroNome = new JLabel("Nome:");
		lblFiltroNome.setBounds(10, 40, 50, 15);
		contentPane.add(lblFiltroNome);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 462, 14);
		contentPane.add(separator_1);

		JLabel lblFiltrosDeConsulta = new JLabel("Filtros de consulta:");
		lblFiltrosDeConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrosDeConsulta.setBounds(10, 11, 448, 14);
		contentPane.add(lblFiltrosDeConsulta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 194, 345, -100);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBounds(30, 225, 246, -119);
		contentPane.add(table);

		tblProdutos = new JTable();
		tblProdutos.setModel(new DefaultTableModel(
				new String[][] {
					{"Nome", "Marca", "Peso", "Dt. Cadastro"},
				},
				new String[] {
						"Nome", "Marca", "Peso", "Dt. Cadastro"
				}
				));
		tblProdutos.setBounds(10, 259, 462, 174);
		contentPane.add(tblProdutos);

		JLabel lblFiltroCor = new JLabel("Cor:");
		lblFiltroCor.setBounds(255, 40, 46, 14);
		contentPane.add(lblFiltroCor);

		cbCor = new JComboBox(cores);
		cbCor.setBounds(300, 37, 160, 30);

		contentPane.add(cbCor);

		btnGerarXls = new JButton("Gerar XLS");
		btnGerarXls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnGerarXls.setBounds(100, 404, 117, 29);
		contentPane.add(btnGerarXls);

		btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setBounds(248, 404, 117, 29);
		contentPane.add(btnGerarPdf);

		btnGerarXls.setEnabled(false);
		btnGerarPdf.setEnabled(false);

		JLabel lblPeriodoCadastro = new JLabel("Período de cadastro");
		lblPeriodoCadastro.setBounds(10, 110, 170, 20);
		contentPane.add(lblPeriodoCadastro);

		dtInicioCadastro = new DatePicker();
		dtInicioCadastro.setBounds(80, 130, 378, 30);
		contentPane.add(dtInicioCadastro);

		JLabel lblDataInicioCadastro = new JLabel("De:");
		lblDataInicioCadastro.setBounds(10, 140, 61, 16);
		contentPane.add(lblDataInicioCadastro);

		JLabel lblDataFimCadastro = new JLabel("Até:");
		lblDataFimCadastro.setBounds(10, 170, 61, 16);
		contentPane.add(lblDataFimCadastro);

		dtFimCadastro = new DatePicker();
		dtFimCadastro.setBounds(80, 170, 378, 30);
		contentPane.add(dtFimCadastro);

		txtNome = new JTextField();
		txtNome.setBounds(80, 35, 160, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 70, 61, 16);
		contentPane.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(80, 67, 160, 30);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				ProdutoSeletor seletor = new ProdutoSeletor();

				//Preenche os campos de filtro da tela no seletor
				if(cbCor.getSelectedIndex() > -1) {
					seletor.setCorProduto(cbCor.getSelectedItem().toString());
				}
				
				seletor.setNomeProduto(txtNome.getText());
				
				if(txtPeso.getText() != null && !txtPeso.getText().isEmpty()) {
					seletor.setPesoProduto(Double.parseDouble(txtPeso.getText()));	
				}else {
					seletor.setPesoProduto(-1.0);
				}
		
				seletor.setDataInicioCadastro(dtInicioCadastro.getDate());
				seletor.setDataFimCadastro(dtFimCadastro.getDate());

				List<Produto> produtos = controlador.listarProdutos(seletor);
				atualizarTabelaProdutos(produtos);

			}
		});
	}

	protected void atualizarTabelaProdutos(List<Produto> produtos) {
		//atualiza o atributo produtosConsultados
		produtosConsultados = produtos;

		btnGerarXls.setEnabled(produtos != null && produtos.size() > 0);
		btnGerarPdf.setEnabled(produtos != null && produtos.size() > 0);

		//Limpa a tabela
		tblProdutos.setModel(new DefaultTableModel(
				new String[][] {
					{"Nome", "Marca", "Peso", "Dt. Cadastro"},
				},
				new String[] {
						"Nome", "Marca", "Peso", "Dt. Cadastro"
				}));

		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();

		for(Produto produto: produtos) {
			//Crio uma nova linha na tabela
			//Preencher a linha com os atributos do produto
			//na ORDEM do cabeçalho da tabela
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = produto.getDataCadastro().format(formatter);
			
			String[] novaLinha = new String[] {
					produto.getNome(),
					produto.getFabricante(),
					produto.getPeso() + "",
					dataFormatada
			};
			modelo.addRow(novaLinha);
		}

	}
}