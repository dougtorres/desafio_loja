/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.dao;

import static br.com.desafioconductorws.dao.DAO.manager;
import br.com.desafioconductorws.model.Categoria;
import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class CategoriaDAO extends DAO<Categoria> {
    
    public List<Categoria> listarCategorias(int cnpj) {
        try {
            Query q = manager
                    .createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
            Loja loja = (Loja) q.getSingleResult();
            if(loja != null)
                return loja.getCategorias();
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Categoria buscarCategoria(String titulo, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Categoria categoria : loja.getCategorias()){
                            if(categoria.getTitulo().equals(titulo)){
                                return categoria;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
}
