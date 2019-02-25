package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.BebidaVO;


public class BebidaDAO {

	public boolean existeRegistroPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM bebida WHERE nome like '" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Bebida por Nome.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarBebidaDAO(BebidaVO bebidaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO bebida (nome, preco) VALUES ('" + bebidaVO.getNome() 
		+ "', " + bebidaVO.getPreco() + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro da Bebida.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<BebidaVO> consultarTodasBebidasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<BebidaVO> bebidasVO = new ArrayList<BebidaVO>();
		String query = "SELECT idbebida, nome, preco FROM bebida";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				BebidaVO bebidaVO = new BebidaVO();
				bebidaVO.setIdBebida(Integer.parseInt(resultado.getString(1)));
				bebidaVO.setNome(resultado.getString(2));
				bebidaVO.setPreco(Double.parseDouble(resultado.getString(3)));
				bebidasVO.add(bebidaVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Bebidas.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return bebidasVO;
	}

	public BebidaVO consultarBebidaDAO(BebidaVO bebidaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		BebidaVO bebida = new BebidaVO();
		
		String query = "SELECT idbebida, nome, preco FROM bebida WHERE idbebida = " + bebidaVO.getIdBebida();
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				bebida.setIdBebida(Integer.parseInt(resultado.getString(1)));
				bebida.setNome(resultado.getString(2));
				bebida.setPreco(Double.parseDouble(resultado.getString(3)));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Bebida.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return bebida;
	}

	public boolean existeRegistroPorIdBebida(int idBebida) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idbebida, nome, preco FROM bebida WHERE idbebida = " + idBebida;
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

	public int atualizarBebidaDAO(BebidaVO bebidaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE bebida SET nome = '" + bebidaVO.getNome() 
					+ "', preco = " + bebidaVO.getPreco() 
					+ " WHERE idprato = " + bebidaVO.getIdBebida();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização da Bebida.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirBebidaDAO(BebidaVO bebidaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM bebida WHERE idbebida = " + bebidaVO.getIdBebida();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão da Bebida.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}



}
