/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.ws;

import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Produto;
import br.com.desafioconductorws.model.Sistema;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    public String getLojas() throws Exception {
        Gson gs;
        gs = new Gson();
        Sistema.inicializar();
        List<Loja> lojas = Sistema.listarLojas();
        Sistema.finalizar();
        return gs.toJson(lojas);
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("cliente/list/{cnpj}")
    public String getClientes(@PathParam("cnpj") int cnpj) throws Exception {
        Gson gs;
        gs = new Gson();
        Loja loja = Sistema.buscar_loja(cnpj);
        Sistema.inicializar();
        List<Cliente> clientes = Sistema.listarClientes(loja);
        Sistema.finalizar();
        return gs.toJson(clientes);
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("estoque/{cnpj}/list")
    public String getEstoque(@PathParam("cnpj") int cnpj) throws Exception {
        Gson gs = new Gson();
        Sistema.inicializar();
        Loja loja = Sistema.buscar_loja(cnpj);
        List<Produto> estoque = Sistema.listar_estoque(loja);
        Sistema.finalizar();
        return gs.toJson(estoque);
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("insert")
    public boolean cadastrar_loja(String content) throws Exception {
        try {
            Gson g = new Gson();
            Loja loja = (Loja) g.fromJson(content, Loja.class);
            Sistema.inicializar();
            Sistema.cadastrar_Loja(loja.getName(), loja.getCnpj());
            Sistema.finalizar();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("cliente/insert/{cnpj}")
    public boolean cadastrar_cliente(@PathParam("cnpj") int cnpj, String content) throws Exception {
        try {
            Gson g = new Gson();
            Cliente cliente = g.fromJson(content, Cliente.class);
            Loja loja = Sistema.buscar_loja(cnpj);
            Sistema.inicializar();
            Sistema.cadastrar_Cliente(cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTel(), loja);
            Sistema.finalizar();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("update/{cnpj}")
    public boolean alterar_loja(@PathParam("cnpj") int cnpj, String content) {
        try {
            Gson gs = new Gson();
            Loja aux = gs.fromJson(content, Loja.class);
            Sistema.inicializar();
            Sistema.alterar_Loja(cnpj, aux.getName(), aux.getCnpj());
            Sistema.finalizar();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("cliente/update/{cnpj}")
    public boolean alterar_cliente(@PathParam("cnpj") int cnpj, String content) {
        try {
            Gson gs = new Gson();
            Loja loja = Sistema.buscar_loja(cnpj);
            Cliente aux = gs.fromJson(content, Cliente.class);
            Sistema.inicializar();
            Sistema.alterar_Cliente(aux.getCpf(), aux.getNome(), aux.getCpf(), aux.getEmail(), aux.getTel(), loja);
            Sistema.finalizar();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("find/{cnpj}")
    public String buscar_loja(@PathParam("cnpj") int cnpj) {
        try {
            Sistema.inicializar();
            Loja loja = Sistema.buscar_loja(cnpj);
            Sistema.finalizar();
            Gson gs = new Gson();
            return gs.toJson(loja);
        } catch (Exception ex) {
            return null;
        }

    }
    
    
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("cliente/find/{cnpj}/{cpf}")
    public String buscar_cliente(@PathParam("cnpj") int cnpj, @PathParam("cpf") String cpf) {
        try {
            Sistema.inicializar();
            Cliente cliente = Sistema.buscar_cliente(cpf, cnpj);
            Sistema.finalizar();
            Gson gs = new Gson();
            return gs.toJson(cliente);
        } catch (Exception ex) {
            return null;
        }

    }

    @DELETE
    @Path("delete/{cnpj}")
    public boolean remover_loja(@PathParam("cnpj") int cnpj) {
        try {
            Sistema.inicializar();
            Sistema.remover_Loja(cnpj);
            Sistema.finalizar();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}
