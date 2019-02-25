package model.bo;

import model.dao.VendaDAO;
import model.vo.VendaVO;

public class VendaBO {

	public void cadastrarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		if(vendaDAO.existeRegistroVenda(vendaVO)){
			System.out.println("\nVenda já Cadastrada!");
		} else {
			int resultado = vendaDAO.cadastrarVendaDAO(vendaVO);
			if(resultado != 0){
				vendaVO.setIdVenda(resultado);
				boolean resultadoPrato = vendaDAO.cadastrarItemPratoDAO(vendaVO);
				if(resultadoPrato){
					boolean resultadoBebida = vendaDAO.cadastrarItemBebidaoDAO(vendaVO);
					if(resultadoBebida){
						System.out.println("\nVenda cadastrada com Sucesso!");
					} else {
						System.out.println("\nNão foi possível incluir o pedido de Bebidas.");
					}
				} else {
					System.out.println("\nNão foi possível incluir o pedido de Pratos.");
				}
			} else {
				System.out.println("\nNão foi possível cadastrar a Venda.");
			}
		}
	}

	public void cancelarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		if(vendaDAO.existeRegistroVendaPorID(vendaVO)){
			int resultado = vendaDAO.cancelarVendaDAO(vendaVO);
			if(resultado == 1){
				System.out.println("\nVenda cancelada com Sucesso!");
			} else {
				System.out.println("\nNão foi possível canelar a venda.");
			}
		} else {
			System.out.println("\nVenda não existe na base de dados!");
		}
	}

}
