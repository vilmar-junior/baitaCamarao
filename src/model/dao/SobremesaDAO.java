package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.SobremesaVO;

/**
 * 
 * @author Vilmar C. Pereira Júnior
 *
 */
public class SobremesaDAO {

	/**
	 * Verifica se há sobremesa cadastrada no banco, dado um nome informado.
	 * 
	 * @param nome o nome da sobremesa
	 * @return true caso exista, false caso contrário
	 */
	public boolean existeRegistroPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM sobremesa WHERE UPPER(nome) = '" + nome.toUpperCase() + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que "
					+ "verifica existência de Sobremesa por Nome. Erro:"
					+ e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	/**
	 * Insere uma nova sobremesa.
	 * 
	 * @param sobremesa o objeto a ser persistido.
	 * @return 1 caso tenha salvo no banco, 0 caso contrário
	 */
	public int cadastrarSobremesaDAO(SobremesaVO sobremesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		int intLight;
		
		// código similar às linhas 61-65:
		// (expressaoBooleana) ? valorCasoTrue : valorCasoFalse; --> if ternário 
		// strLight = sobremesa.isLight() ? "1" : "0"; 
		if(sobremesa.isLight()) {
			intLight = 1;
		}else {
			intLight = 0;
		}
		
		int resultado = 0;
		String query = "INSERT INTO sobremesa (nome, preco, light) VALUES ('" + sobremesa.getNome() 
		+ "', " + sobremesa.getPreco() 
		+ "," + intLight + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Sobremesa. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<SobremesaVO> consultarTodas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<SobremesaVO> sobremesas = new ArrayList<SobremesaVO>();
		String query = "SELECT id, nome, preco, light FROM sobremesa";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				SobremesaVO sobremesaVO = new SobremesaVO();
				sobremesaVO.setId(Integer.parseInt(resultado.getString(1)));
				sobremesaVO.setNome(resultado.getString(2));
				sobremesaVO.setPreco(Double.parseDouble(resultado.getString(3)));
				sobremesaVO.setLight(resultado.getBoolean(4));
				sobremesas.add(sobremesaVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Sobremesas.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sobremesas;
	}
	
	/**
	 * Retorna a lista de sobremesas filtrada pelo tipo (light ou não).
	 * 
	 * @param boolean light indica o tipo da sobremesa
	 * @return uma lista de SobremesaVO
	 */
	public ArrayList<SobremesaVO> consultarSobremesasPorTipo(boolean light) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<SobremesaVO> sobremesas = new ArrayList<SobremesaVO>();
		String query = "SELECT id, nome, preco, light FROM sobremesa"
				+ "WHERE light = " + light;
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				SobremesaVO sobremesaVO = new SobremesaVO();
				sobremesaVO.setId(Integer.parseInt(resultado.getString(1)));
				sobremesaVO.setNome(resultado.getString(2));
				sobremesaVO.setPreco(Double.parseDouble(resultado.getString(3)));
				sobremesaVO.setLight(resultado.getBoolean(4));
				sobremesas.add(sobremesaVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Sobremesas por tipo. Causa: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sobremesas;
	}

	public SobremesaVO consultarSobremesaPorId(int idSobremesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		SobremesaVO sobremesa = new SobremesaVO();
		
		String query = "SELECT id, nome, preco, light FROM Sobremesa WHERE id = " + idSobremesa;
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				sobremesa.setId(Integer.parseInt(resultado.getString(1)));
				sobremesa.setNome(resultado.getString(2));
				sobremesa.setPreco(Double.parseDouble(resultado.getString(3)));
				sobremesa.setLight(resultado.getBoolean(4));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Sobremesa por id. Causa: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sobremesa;
	}
	
	/**
	 * Busca uma sobremesa dado um nome
	 * 
	 * @param nomeSobremesa o nome da sobremesa
	 * @return uma sobremesa caso exista, null caso contrário.
	 */
	public SobremesaVO consultarSobremesaPorNome(String nomeSobremesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		SobremesaVO sobremesa = null;
		
		String query = "SELECT id, nome, preco, light "
				+ "FROM Sobremesa WHERE UPPER(nome) = '" + nomeSobremesa.toUpperCase() + "'";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				sobremesa = new SobremesaVO();
				sobremesa.setId(Integer.parseInt(resultado.getString(1)));
				sobremesa.setNome(resultado.getString(2));
				sobremesa.setPreco(Double.parseDouble(resultado.getString(3)));
				sobremesa.setLight(resultado.getBoolean(4));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Sobremesa por nome. Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sobremesa;
	}
	
	public boolean existeRegistroPorId(int idSobremesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT id, nome, preco, light FROM Sobremesa WHERE id = " + idSobremesa;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id. Causa: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarSobremesa(SobremesaVO sobremesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE Sobremesa SET nome = '" + sobremesaVO.getNome() 
					+ "', preco = " + sobremesaVO.getPreco()
					+ "', light = " + (sobremesaVO.isLight() ? 1 : 0)
					+ " WHERE id = " + sobremesaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Sobremesa. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirSobremesa(SobremesaVO sobremesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM Sobremesa WHERE id = " + sobremesaVO.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Sobremesa. Causa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
}