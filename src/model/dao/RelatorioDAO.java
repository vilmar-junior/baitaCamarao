package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dto.ProdutoDTO;
import model.dto.VendaDTO;

/**
 * Classe que permite que consulta tabelas distintas
 * para gerar relatórios.
 * 
 * @author Adriano de Melo
 *
 */
public class RelatorioDAO {
	
	//TODO incluir sobremesas
	public ArrayList<ProdutoDTO> gerarRelatorioProdutosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ProdutoDTO> listaProdutosDTO = new ArrayList<ProdutoDTO>();
		String query = "select @linha:=@linha+1 as idProduto, nome "
				+ " from (select nome from prato union select nome from bebida) as produtos, "
				+ " (select @linha:=0) as tabela_auxiliar order by nome";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				ProdutoDTO produtoDTO = new ProdutoDTO();
				produtoDTO.setIdProduto(Integer.parseInt(resultado.getString(1)));
				produtoDTO.setNome(resultado.getString(2));
				listaProdutosDTO.add(produtoDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Produtos.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaProdutosDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> listaVendasDTO = new ArrayList<VendaDTO>();
		String query = "select 'PRATO' as TIPO, p.nome as DESCRICAO, p.preco as PRECO, ip.quantidade as QTDE, "
				+ " (p.preco * ip.quantidade) as SUBTOTAL "
				+ " from prato p, venda v, itemprato ip "
				+ " where ip.IDVENDA = v.IDVENDA "
				+ " and ip.IDPRATO = p.IDPRATO "
				+ " and v.FLAGVENDACANCELADA = 1 "
				+ " union "
				+ " select 'BEBIDA' as TIPO, b.nome as DESCRICAO, b.preco as PRECO, ib.quantidade as QTDE, "
				+ " (b.preco * ib.quantidade) as SUBTOTAL "
				+ " from bebida b, venda v, itembebida ib "
				+ " where ib.IDVENDA = v.IDVENDA "
				+ " and ib.IDBEBIDA = b.IDBEBIDA "
				+ " and v.FLAGVENDACANCELADA = 1 "
				+ " order by DESCRICAO;";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo(resultado.getString(1));
				vendaDTO.setDescricao(resultado.getString(2));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(3)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(4)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(5)));
				listaVendasDTO.add(vendaDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Relatório de Vendas Canceladas.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVendasDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasRealizadasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> listaVendasDTO = new ArrayList<VendaDTO>();
		String query = "select 'PRATO' as TIPO, p.nome as DESCRICAO, p.preco as PRECO, ip.quantidade as QTDE, "
				+ " (p.preco * ip.quantidade) as SUBTOTAL "
				+ " from prato p, venda v, itemprato ip "
				+ " where ip.IDVENDA = v.IDVENDA "
				+ " and ip.IDPRATO = p.IDPRATO "
				+ "and v.FLAGVENDACANCELADA = 0 "
				+ " union "
				+ " select 'BEBIDA' as TIPO, b.nome as DESCRICAO, b.preco as PRECO, ib.quantidade as QTDE, "
				+ " (b.preco * ib.quantidade) as SUBTOTAL "
				+ " from bebida b, venda v, itembebida ib "
				+ " where ib.IDVENDA = v.IDVENDA "
				+ " and ib.IDBEBIDA = b.IDBEBIDA "
				+ " and v.FLAGVENDACANCELADA = 0 "
				+ " order by DESCRICAO;";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo(resultado.getString(1));
				vendaDTO.setDescricao(resultado.getString(2));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(3)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(4)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(5)));
				listaVendasDTO.add(vendaDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Relatório de Vendas Realizadas.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVendasDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendaEspecifica(int idVenda) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> listaVendasDTO = new ArrayList<VendaDTO>();
		String query = "select 'PRATO' as TIPO, p.nome as DESCRICAO, p.preco as PRECO, ip.quantidade as QTDE, "
				+ " (p.preco * ip.quantidade) as SUBTOTAL "
				+ " from prato p, venda v, itemprato ip "
				+ " where v.idvenda = " + idVenda
				+ " and ip.IDVENDA = v.IDVENDA "
				+ " and ip.IDPRATO = p.IDPRATO "
				+ "and v.FLAGVENDACANCELADA = 0 "
				+ " union "
				+ " select 'BEBIDA' as TIPO, b.nome as DESCRICAO, b.preco as PRECO, ib.quantidade as QTDE, "
				+ " (b.preco * ib.quantidade) as SUBTOTAL "
				+ " from bebida b, venda v, itembebida ib "
				+ " where v.idvenda = " + idVenda
				+ " and ib.IDVENDA = v.IDVENDA "
				+ " and ib.IDBEBIDA = b.IDBEBIDA "
				+ " and v.FLAGVENDACANCELADA = 0 "
				+ " order by DESCRICAO;";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo(resultado.getString(1));
				vendaDTO.setDescricao(resultado.getString(2));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(3)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(4)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(5)));
				listaVendasDTO.add(vendaDTO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Relatório de Venda Específica.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVendasDTO;
	}
}