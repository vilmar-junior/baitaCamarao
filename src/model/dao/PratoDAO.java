package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.PratoVO;

/**
 * Classe que permite o acesso à tabela Prato.
 * 
 * @author Adriano de Melo
 *
 */
public class PratoDAO {

	public boolean existeRegistroPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM prato WHERE nome like '" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Prato por Nome. Causa:" + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO prato (nome, preco) VALUES ('" + pratoVO.getNome() 
		+ "', " + pratoVO.getPreco() + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Prato. Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<PratoVO> consultarTodosPratosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PratoVO> pratosVO = new ArrayList<PratoVO>();
		String query = "SELECT idprato, nome, preco FROM prato";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				PratoVO pratoVO = new PratoVO();
				pratoVO.setId(Integer.parseInt(resultado.getString(1)));
				pratoVO.setNome(resultado.getString(2));
				pratoVO.setPreco(Double.parseDouble(resultado.getString(3)));
				pratosVO.add(pratoVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Pratos. Causa:" + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pratosVO;
	}

	public PratoVO consultarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		PratoVO prato = new PratoVO();
		
		String query = "SELECT idprato, nome, preco FROM prato WHERE idprato = " + pratoVO.getId();
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				prato.setId(Integer.parseInt(resultado.getString(1)));
				prato.setNome(resultado.getString(2));
				prato.setPreco(Double.parseDouble(resultado.getString(3)));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Prato. Causa:" + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return prato;
	}

	public boolean existeRegistroPorIdPrato(int idPrato) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idprato, nome, preco FROM prato WHERE idprato = " + idPrato;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id. Causa:" + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE prato SET nome = '" + pratoVO.getNome() 
					+ "', preco = " + pratoVO.getPreco() 
					+ " WHERE idprato = " + pratoVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Prato. Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM prato WHERE idprato = " + pratoVO.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Prato. Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
}