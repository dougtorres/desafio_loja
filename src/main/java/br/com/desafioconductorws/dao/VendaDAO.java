/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.dao;

import static br.com.desafioconductorws.dao.DAO.manager;
import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Produto;
import br.com.desafioconductorws.model.Venda;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class VendaDAO extends DAO<Venda>{
    
    public List<Venda> listarVendas(int cnpj) {
        try {
            Query q = manager
                    .createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
            Loja loja = (Loja) q.getSingleResult();
            if(loja != null)
                return loja.getVendas();
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Venda buscarVenda(int cod_vend, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Venda venda : loja.getVendas()){
                            if(venda.getCod_venda() == cod_vend){
                                return venda;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
    
}
