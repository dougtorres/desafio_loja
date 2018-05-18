/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.dao;

import static br.com.desafioconductorws.dao.DAO.manager;
import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Usuario;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class ClienteDAO extends DAO<Usuario> {

    public List<Cliente> listarClientes(int cnpj) {
        try {
            Query q = manager
                    .createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
            Loja loja = (Loja) q.getSingleResult();
            if(loja != null)
                return loja.getClientes();
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Cliente buscarCliente(String cpf, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Cliente cliente : loja.getClientes()){
                            if(cliente.getCpf().equals(cpf)){
                                return cliente;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

}
