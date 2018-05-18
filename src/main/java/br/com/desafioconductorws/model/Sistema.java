package br.com.desafioconductorws.model;

import br.com.desafioconductorws.dao.CategoriaDAO;
import br.com.desafioconductorws.dao.ClienteDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.desafioconductorws.dao.DAO;
import br.com.desafioconductorws.dao.LojaDAO;
import br.com.desafioconductorws.dao.ProdutoDAO;
import br.com.desafioconductorws.dao.VendaDAO;
import br.com.desafioconductorws.dao.VendedorDAO;
import java.util.List;

public class Sistema {

    private static LojaDAO lojaDAO = new LojaDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static VendedorDAO vendedorDAO = new VendedorDAO();
    private static CategoriaDAO categoriaDAO = new CategoriaDAO();
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static VendaDAO vendaDAO = new VendaDAO();

    public Sistema (){
                Sistema.inicializar();
    }
    public static void inicializar() {
        DAO.open();
    }

    public static void finalizar() {
        DAO.close();
    }

    public static void cadastrar_Loja(String nome, int cnpj) throws Exception {
        List<Loja> lojas = lojaDAO.listarLojas();
        for (Loja loja : lojas) {
            if (loja.getCnpj() == cnpj) {
                throw new Exception("CNPJ já cadastrado!");
            }
        }

        Loja nova = new Loja(nome, cnpj);
        System.out.println(nova.getName() + nova.getCnpj());
        DAO.begin();
        lojaDAO.create(nova);
        DAO.commit();
        lojas.add(nova);

    }

    public static void remover_Loja(int cnpj) throws Exception {

        Loja aux = buscar_loja(cnpj);
        lojaDAO.begin();
        lojaDAO.delete(aux);
        lojaDAO.commit();
    }

    public static Loja buscar_loja(int cnpj) throws Exception {
        Loja aux = lojaDAO.buscarLoja(cnpj);
        if (aux == null) {
            return null;
        }
        return aux;
    }

    public static void alterar_Loja(int cnpj, String nome, int novoCnpj) throws Exception {

        Loja aux = buscar_loja(cnpj);
        aux.setName(nome);
        aux.setCnpj(novoCnpj);
        lojaDAO.begin();
        lojaDAO.update(aux);
        lojaDAO.commit();

    }

    public static List<Loja> listarLojas() throws Exception {
        List<Loja> lojas = lojaDAO.listarLojas();
        if (lojas.isEmpty()) {
            throw new Exception("Não existem lojas cadastradas!");
        } else {
            return lojas;
        }

    }

    public static Cliente buscar_cliente(String cpf, int cnpj) throws Exception {

        Cliente aux = clienteDAO.buscarCliente(cpf, cnpj);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }

    }
    
    

    public static Vendedor buscar_vendedor(String cpf, int cnpj) throws Exception {

        Vendedor aux = vendedorDAO.buscarVendedor(cpf, cnpj);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }
    }

    public static void cadastrar_Cliente(String nome, String cpf, String email, String tel, Loja loja)
            throws Exception {

        if (Sistema.buscar_cliente(cpf, loja.getCnpj()) == null) {
            Cliente novo = new Cliente(nome, cpf, email, tel);
            loja.adicionarCliente(novo);
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
            clienteDAO.begin();
            clienteDAO.create(novo);
            clienteDAO.commit();
            

        } else {
            throw new Exception("Cliente já cadastrado!");
        }

    }

    public static void cadastrar_vendedor(String nome, String cpf, String email, String tel, Loja loja)
            throws Exception {

        if (Sistema.buscar_vendedor(cpf, loja.getCnpj()) == null) {
            Vendedor novo = new Vendedor(nome, cpf, email, tel);
            loja.adicionarVendedor(novo);
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
            vendedorDAO.begin();
            vendedorDAO.create(novo);
            vendedorDAO.commit();
            

        } else {
            throw new Exception("Vendedor já cadastrado!");
        }

    }

    public static void alterar_Cliente(String cpfAntigo, String novoNome, String novoCpf, String novoEmail,
            String novoTel, Loja loja) throws Exception {

        Cliente aux = Sistema.buscar_cliente(cpfAntigo, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Cliente não encontrado!");
        }
        loja.removerCliente(aux);
        aux.setNome(novoNome);
        aux.setCpf(novoCpf);
        aux.setEmail(novoEmail);
        aux.setTel(novoTel);
        loja.adicionarCliente(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        clienteDAO.begin();
        clienteDAO.update(aux);
        clienteDAO.commit();
        
    }

    public static void alterar_Vendedor(String cpfAntigo, String novoNome, String novoCpf, String novoEmail,
            String novoTel, Loja loja) throws Exception {

        Vendedor aux = Sistema.buscar_vendedor(cpfAntigo, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Vendedor não encontrado!");
        }
        loja.removerVendedor(aux);
        aux.setNome(novoNome);
        aux.setCpf(novoCpf);
        aux.setEmail(novoEmail);
        aux.setTel(novoTel);
        loja.adicionarVendedor(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        vendedorDAO.begin();
        vendedorDAO.update(aux);
    }

    public static void remover_Cliente(String cpf, Loja loja) throws Exception {

        Cliente aux = Sistema.buscar_cliente(cpf, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Cliente não encontrado!");
        }
        loja.removerCliente(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        clienteDAO.begin();
        clienteDAO.delete(aux);
        clienteDAO.commit();
        
    }

    public static void remover_Vendedor(String cpf, Loja loja) throws Exception {

        Vendedor aux = Sistema.buscar_vendedor(cpf, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Vendedor não encontrado!");
        }
        loja.removerVendedor(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        vendedorDAO.begin();
        vendedorDAO.delete(aux);
        vendedorDAO.commit();
        
    }

    public static List<Cliente> listarClientes(Loja loja) {

        return clienteDAO.listarClientes(loja.getCnpj());
    }

    public static List<Vendedor> listar_vendedores(Loja loja) {

        return vendedorDAO.listarVendedores(loja.getCnpj());
    }

    public static List<Categoria> listarCategorias(Loja loja) {

        return categoriaDAO.listarCategorias(loja.getCnpj());
    }

    public static void cadastrar_Categoria(String titulo, Loja loja) throws Exception {

        if (Sistema.buscar_categoria(titulo, loja.getCnpj()) == null) {
            Categoria nova = new Categoria(titulo);
            loja.adicionarCategoria(nova);
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
            categoriaDAO.begin();
            categoriaDAO.create(nova);
            categoriaDAO.commit();
            

        } else {
            throw new Exception("Vendedor já cadastrado!");
        }

    }

    public static void remover_Categoria(String titulo, Loja loja) throws Exception {

        Categoria aux = Sistema.buscar_categoria(titulo, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Categoria não encontrado!");
        }
        loja.removerCategorias(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        categoriaDAO.begin();
        categoriaDAO.delete(aux);
        categoriaDAO.commit();
        

    }

    public static Categoria buscar_categoria(String titulo, int cnpj) throws Exception {

        Categoria aux = categoriaDAO.buscarCategoria(titulo, cnpj);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }
    }

    public static void cadastrar_Produto(String nome, Categoria categ, double valor, int quantidade,
            Loja loja) throws Exception {
        if (Sistema.buscar_Produto(nome, loja.getCnpj()) == null) {
            if(Sistema.buscar_categoria(categ.getTitulo(), loja.getCnpj()) == null)
                throw new Exception("Categoria ainda não cadastrada!");
            Produto novo = new Produto(nome, categ, valor, quantidade);
            loja.adicionarProduto(novo);
            produtoDAO.begin();
            produtoDAO.create(novo);
            produtoDAO.commit();
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
           
            

        } else {
            throw new Exception("Produto já cadastrado!");
        }

    }

    public static void adicionar_und_Produto(int cod_prod, int quantidade, Loja loja) throws Exception {
        Produto aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
        if (aux != null) {
            loja.removerProduto(aux);
            aux.addUnidade(quantidade);
            loja.adicionarProduto(aux);
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
            produtoDAO.begin();
            produtoDAO.update(aux);
            produtoDAO.commit();
            

        } else {
            throw new Exception("Produto não cadastrado!");
        }
    }

    public static void remover_und_Produto(int cod_prod, int quantidade, Loja loja) throws Exception {
        Produto aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
        if (aux != null) {
            loja.removerProduto(aux);
            aux.removeUnidade(quantidade);
            loja.adicionarProduto(aux);
            lojaDAO.begin();
            lojaDAO.update(loja);
            lojaDAO.commit();
            produtoDAO.begin();
            produtoDAO.update(aux);
            produtoDAO.commit();
            

        } else {
            throw new Exception("Produto não cadastrado!");
        }
    }

    public static void remover_Produto(int cod_prod, Loja loja) throws Exception {
        Produto aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Produto não encontrado!");
        }
        loja.removerProduto(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        produtoDAO.begin();
        produtoDAO.delete(aux);
        produtoDAO.commit();
        
    }

    public static void alterar_Produto(int cod_prod, String nome, Categoria categ, double valor, int quantidade,
            Loja loja) throws Exception {
        Produto aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
        if (aux == null) {
            throw new Exception("Produto não encontrado!");
        }
        loja.removerProduto(aux);
        aux.setCod_prod(aux.getCod_prod());
        aux.setNome(nome);
        aux.setCateg(categ);
        aux.setValor(valor);
        aux.setQuantidade(quantidade);
        produtoDAO.begin();
        produtoDAO.update(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        
    }

    public static List<Produto> listar_estoque(Loja loja) throws Exception {
        return produtoDAO.listarProdutos(loja.getCnpj());
    }

    public static Produto buscar_Produto(String nome, int cnpj) throws Exception {

        Produto aux = produtoDAO.buscarProduto(nome, cnpj);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }
    }

    public static Produto buscar_ProdutoPorCod(int cod_prod, int cnpj) throws Exception {

        Produto aux = produtoDAO.buscarProdutoPorCod(cod_prod, cnpj);
            return aux;
        
    }

    public static Venda buscar_Venda(int cod_venda, int cnpj) throws Exception {

        Venda aux = vendaDAO.buscarVenda(cod_venda, cnpj);
        if (aux == null) {
            return null;
        } else {
            return aux;
        }
    }

    public static Venda realizar_venda(Cliente cliente, List<Produto> carrinho, Vendedor vendedor, Loja loja) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Venda nova = new Venda(cliente, carrinho, vendedor, dateFormat.format(date));
        loja.addVenda(nova);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        vendaDAO.begin();
        vendaDAO.create(nova);
        vendaDAO.commit();
        
          return nova;
}

public static List<Venda> listar_vendas(Loja loja) throws Exception {

       return vendaDAO.listarVendas(loja.getCnpj());
    }

    public static void transferir_produto(Loja loja, int cod_prod, int quantidade, int cnpj) throws Exception {
        Produto aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
        if(aux == null)
            throw new Exception("Produto não encontrado!");
        Loja destinoLoja = Sistema.buscar_loja(cnpj);
        Produto destinoProduto = aux;
        loja.removerProduto(aux);
        destinoProduto.setQuantidade(quantidade);
        aux.removeUnidade(quantidade);
        loja.adicionarProduto(aux);
        lojaDAO.begin();
        lojaDAO.update(loja);
        lojaDAO.commit();
        produtoDAO.begin();
        produtoDAO.update(aux);
        produtoDAO.commit();
        
        if(Sistema.buscar_Produto(destinoProduto.getNome(), destinoLoja.getCnpj()) != null){
        aux = Sistema.buscar_Produto(destinoProduto.getNome(), destinoLoja.getCnpj());
               destinoLoja.removerProduto(aux);
               aux.addUnidade(quantidade);
               destinoLoja.adicionarProduto(aux);
               lojaDAO.begin();
                 lojaDAO.update(destinoLoja);
                lojaDAO.commit();
               produtoDAO.begin();
               produtoDAO.update(aux);
                produtoDAO.commit();
                
    }
        destinoLoja.adicionarProduto(destinoProduto);
        lojaDAO.begin();
        lojaDAO.update(destinoLoja);
        lojaDAO.commit();
        produtoDAO.begin();
        produtoDAO.create(destinoProduto);
        produtoDAO.commit();
        
    }

}
