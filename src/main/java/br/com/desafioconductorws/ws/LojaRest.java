/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.ws;

import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Produto;
import br.com.desafioconductorws.model.Sistema;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Douglas
 */
@Path("loja")
public class LojaRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DesafioRest
     */
    public LojaRest() {
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("list")
    public String getLojas() throws Exception{
        Gson gs = new Gson();
        Sistema.inicializar();
        List<Loja> lojas = Sistema.listarLojas();
        Sistema.finalizar();
       return gs.toJson(lojas);
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("estoque/{cnpj}/list")
    public String getEstoque(@PathParam("cnpj") int cnpj) throws Exception{
        Gson gs = new Gson();
        Sistema.inicializar();
        Loja loja = Sistema.buscar_loja(cnpj);
        List<Produto> estoque = Sistema.listar_estoque(loja);
        Sistema.finalizar();
       return gs.toJson(estoque);
    }

    @POST
    @Consumes({"application/json"})
    @Path("insert")
    public boolean cadastrarLoja(String content){
        Gson g = new Gson();
        Loja loja = (Loja) g.fromJson(content, Loja.class);
        try {
            Sistema.inicializar();
            Sistema.cadastrar_Loja(loja.getName(), loja.getCnpj());
            Sistema.finalizar();
            return true;
        } catch (Exception ex) {
            return false;
        }
        
    }
    
    @PUT
    @Consumes({"application/json"})
    @Path("update/{cnpj}/{novoNome}/{novoCnpj}")
    public boolean alterarLoja(@PathParam("cnpj") int cnpj, @PathParam("novoNome") String novoNome, @PathParam("novoCnpj") int novoCnpj ){
            try {
            Sistema.inicializar();
            Sistema.alterar_Loja(cnpj, novoNome, novoCnpj);
            Sistema.finalizar();
            return true;
        } catch (Exception ex) {
            return false;
        }
        
    }
    
    
}
