/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.dao;

import static br.com.desafioconductorws.dao.DAO.manager;
import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Vendedor;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class VendedorDAO extends DAO<Vendedor>{
    public List<Vendedor> listarVendedores(int cnpj) {
        try {
            Query q = manager
                    .createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
            Loja loja = (Loja) q.getSingleResult();
            if(loja != null)
                return loja.getVendedores();
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Vendedor buscarVendedor(String cpf, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Vendedor vendedor : loja.getVendedores()){
                            if(vendedor.getCpf().equals(cpf)){
                                return vendedor;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

}
