package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.vo.VendaVO;

public class VendaDAO {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

	public boolean existeRegistroVenda(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idVenda FROM venda WHERE senhaPedido = " 
				+ vendaVO.getSenhaPedido() + " and dataVenda = '" + df.format(vendaVO.getDataVenda()) + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Venda.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int retorno = 0;
		ResultSet resultado = null;
		String query = "INSERT INTO venda (dataVenda, senhaPedido, flagVendaCancelada) VALUES ('" + df.format(vendaVO.getDataVenda()) 
		+ "', " + vendaVO.getSenhaPedido() + ", " + vendaVO.isFlagVendaCancelada() + ")";
		try {
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				retorno = resultado.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro da Venda.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean cadastrarItemPratoDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		int contador = 0;
		String query = "";
		boolean retorno = false;
		try {
			for(int i = 0; i < vendaVO.getItensPratos().size(); i++){
				query = "INSERT INTO itemprato (idprato, idvenda, quantidade) VALUES (" 
						+ vendaVO.getItensPratos().get(i).getIdPrato() + ", " 
						+ vendaVO.getIdVenda() + ", " 
						+ vendaVO.getItensPratos().get(i).getQuantidade() + ")";
				
				resultado = stmt.executeUpdate(query);
				if(resultado == 1){
					contador++;
				}
			}
			if(contador == vendaVO.getItensPratos().size()){
				retorno = true;
			} else {
				System.out.println("Nem todos os pratos do pedido foram cadastrados!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Item Prato.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean cadastrarItemBebidaoDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		int contador = 0;
		String query = "";
		boolean retorno = false;
		try {
			for(int i = 0; i < vendaVO.getItensBebidas().size(); i++){
				query = "INSERT INTO itembebida (idbebida, idvenda, quantidade) VALUES (" 
						+ vendaVO.getItensBebidas().get(i).getIdBebida() + ", " 
						+ vendaVO.getIdVenda() + ", " 
						+ vendaVO.getItensBebidas().get(i).getQuantidade() + ")";
				
				resultado = stmt.executeUpdate(query);
				if(resultado == 1){
					contador++;
				}
			}
			if(contador == vendaVO.getItensBebidas().size()){
				retorno = true;
			} else {
				System.out.println("Nem todos os pratos do pedido foram cadastrados!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Item Bebida.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean existeRegistroVendaPorID(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idVenda FROM venda WHERE idVenda = " + vendaVO.getIdVenda();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Venda por ID.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cancelarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE venda SET flagvendacancelada = 1 WHERE idVenda = " + vendaVO.getIdVenda();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que cancela a Venda.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

}
