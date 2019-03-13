package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.SobremesaVO;

public class SobremesaDAO {

	public boolean existeRegistroPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM sobremesa WHERE nome like '" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Sobremesa por Nome.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarSobremesaDAO(SobremesaVO sobremesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO sobremesa (nome, preco, light) VALUES ('" + sobremesa.getNome() 
		+ "', " + sobremesa.getPreco() 
		+ "," + sobremesa.isLight() + ")"; //TODO testar o insert
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Sobremesa.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<SobremesaVO> consultarTodos() {
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
			System.out.println("Erro ao executar a Query de Consulta de Sobremesas por tipo.");
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
			System.out.println("Erro ao executar a Query de Consulta de Sobremesa por id.");
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
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarSobremesa(SobremesaVO SobremesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE Sobremesa SET nome = '" + SobremesaVO.getNome() 
					+ "', preco = " + SobremesaVO.getPreco()
					+ "', light = " + SobremesaVO.isLight()
					+ " WHERE id = " + SobremesaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Sobremesa.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirSobremesa(SobremesaVO SobremesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM Sobremesa WHERE id = " + SobremesaVO.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Sobremesa.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
}