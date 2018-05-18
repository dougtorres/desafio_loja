package br.com.desafioconfuctorws.app;

import br.com.desafioconductorws.model.*;
import static br.com.desafioconductorws.model.Sistema.listar_vendas;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        Sistema.inicializar();
        Aplicacao exec = new Aplicacao();
        Sistema.finalizar();

    }

    public Aplicacao() {
        processaMenu();
    }

    public void exibeMenu() {

        System.out.println("\nOl�, seja bem vindo.");
        System.out.println("\nSelecione uma opcao: ");
        System.out.println("\n1 - Cadastrar Loja");
        System.out.println("2 - Remover Loja");
        System.out.println("3 - Alterar Loja");
        System.out.println("4 - Listar Lojas");
        System.out.println("5 - Acessar loja");
        System.out.println("0 - Sair");
        System.out.print("\nOpcao: ");

    }

    public void exibeMenuLoja() {

        System.out.println("----------------------------");
        System.out.println("MENU LOJA");
        System.out.println("----------------------------");
        System.out.println("\n1 - Cadastrar Cliente");
        System.out.println("2 - Alterar Cliente");
        System.out.println("3 - Remover Cliente");
        System.out.println("4 - Listar Clientes");
        System.out.println("5 - Cadastrar Vendedor");
        System.out.println("6 - Alterar Vendedor");
        System.out.println("7 - Remover Vendedor");
        System.out.println("8 - Listar Vendedores");
        System.out.println("9 - Buscar Cliente");
        System.out.println("10 - Cadastrar Produto");
        System.out.println("11 - Adicionar Unidades de um Produto");
        System.out.println("12 - Alterar Produto");
        System.out.println("13 - Remover Produto");
        System.out.println("14 - Listar Produtos em Estoque");
        System.out.println("15 - Buscar Produto no Estoque");
        System.out.println("16 - Cadastrar Categoria de Produto");
        System.out.println("17 - Remover Categoria de Produto");
        System.out.println("18 - Listar Categorias Cadastradas");
        System.out.println("19 - Realizar Venda");
        System.out.println("20 - Listar vendas");
        System.out.println("21 - Transferir Produto");
        System.out.println("0 - Sair");
        System.out.print("\nOpcao: ");

    }

    public void processaMenu() {
        String entrada;
        int opcao;
        do {

            exibeMenu();
            try {
                entrada = teclado.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        cadastrar_loja();
                        break;
                    case 2:
                        remover_loja();
                        break;
                    case 3:
                        alterar_loja();
                        break;
                    case 4:
                        listar_lojas();
                        break;
                    case 5:
                        acessar_loja();
                        break;
                    default:
                        System.out.println("Opcao Invalida \n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite somente numero! \n");
                opcao = -1;
            } catch (Exception e) {
                System.out.println("erro:" + e.getMessage());
                opcao = -1;
            }

        } while (opcao != 0);

    }

    public void processaMenuLoja(Loja loja) {
        String entrada;
        int opcao;
        do {

            exibeMenuLoja();
            try {
                entrada = teclado.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        cadastrar_cliente(loja);
                        break;
                    case 2:
                        alterar_cliente(loja);
                        break;
                    case 3:
                        remover_cliente(loja);
                        break;
                    case 4:
                        listar_clientes(loja);
                        break;
                    case 5:
                        cadastrar_vendedor(loja);
                         break;
                    case 6:
                        alterar_vendedor(loja);
                         break;
                    case 7:
                        remover_vendedor(loja);
                         break;
                    case 8:
                        listar_vendedores(loja);
                         break;
                    case 9:
                        buscar_cliente(loja);
                         break;
                    case 10:
                        cadastrar_produto(loja);
                         break;
                    case 11:
                        adicionar_und_produto(loja);
                         break;
                    case 12:
                        alterar_produto(loja);
                         break;
                    case 13:
                        remover_produto(loja);
                         break;
                    case 14:
                        listar_estoque(loja);
                         break;
                    case 15:
                        buscar_produto(loja);
                         break;
                    case 16:
                        cadastrar_categoria(loja);
                         break;
                    case 17:
                        remover_categoria(loja);
                         break;
                    case 18:
                        listar_categorias(loja);
                         break;
                    case 19:
                        realizar_venda(loja);
                         break;
                    case 20:
                        listar_vendas(loja);
                        break;
                    case 21:
                        transferir_produto(loja);
                        break;
                    default:
                        System.out.println("Opcao Invalida \n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite somente numero! \n");
                opcao = -1;
            } catch (Exception e) {
                System.out.println("erro:" + e.getMessage());
                opcao = -1;
            }

        } while (opcao != 0);

    }

    public void cadastrar_loja() {
        String nome;
        int cnpj;
        try {
            System.out.println("----------------------------");
            System.out.println("CADASTRAR LOJA");
            System.out.println("----------------------------");
            System.out.println("Digite o nome da loja: ");
            nome = teclado.nextLine();
            System.out.println("Digite o CNPJ: ");
            cnpj = Integer.parseInt(teclado.nextLine());
            Sistema.cadastrar_Loja(nome, cnpj);
            System.out.println("Loja cadastrada com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrar_cliente(Loja loja) {
        String nome;
        String cpf;
        String email;
        String tel;
        try {
            System.out.println("----------------------------");
            System.out.println("CADASTRAR CLIENTE");
            System.out.println("----------------------------");
            System.out.println("Digite o nome do cliente: ");
            nome = teclado.nextLine();
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextLine();
            System.out.println("Digite o email: ");
            email = teclado.nextLine();
            System.out.println("Digite o telefone: ");
            tel = teclado.nextLine();
            Sistema.cadastrar_Cliente(nome, cpf, email, tel, loja);
            System.out.println("Cliente cadastrado com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar_lojas() {

        try {
            System.out.println("----------------------------");
            System.out.println("LISTA DE LOJAS CADASTRADAS");
            System.out.println("----------------------------");
            for (Loja loja : Sistema.listarLojas()) {
                System.out.println("Nome: " + loja.getName() + " CNPJ: " + loja.getCnpj());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover_loja() {
        teclado.nextLine();
        int cnpj;
        try {
            System.out.println("----------------------------");
            System.out.println("REMOVER LOJA");
            System.out.println("----------------------------");
            System.out.println("Digite o CNPJ: ");
            cnpj = Integer.parseInt(teclado.nextLine());
            Sistema.remover_Loja(cnpj);
            System.out.println("Loja removida com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterar_loja() {
        int cnpj;
        int novoCnpj;
        String novoNome;
        try {
            System.out.println("----------------------------");
            System.out.println("ALTERAR LOJA");
            System.out.println("----------------------------");
            System.out.println("Digite o CNPJ: ");
            cnpj = Integer.parseInt(teclado.nextLine());
            System.out.println("Digite o novo nome: ");
            novoNome = teclado.nextLine();
            System.out.println("Digite o novo CNPJ: ");
            novoCnpj = Integer.parseInt(teclado.nextLine());
            Sistema.alterar_Loja(cnpj, novoNome, novoCnpj);
            System.out.println("Loja alterada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void acessar_loja() {
        int cnpj;
        Loja aux;
        try {
            System.out.println("----------------------------");
            System.out.println("ACESSAR LOJA");
            System.out.println("----------------------------");
            System.out.println("Digite o CNPJ da loja");
            cnpj = Integer.parseInt(teclado.nextLine());
            aux = Sistema.buscar_loja(cnpj);
            if(aux==null)
            System.out.println("Loja não encontrada");
            processaMenuLoja(aux);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar_clientes(Loja loja) {
        try {
            System.out.println("----------------------------");
            System.out.println("LISTA DE CLIENTES CADASTRADOS");
            System.out.println("----------------------------");
            for (Cliente cliente : Sistema.listarClientes(loja)) {
                System.out.println("Nome: " + cliente.getNome() + " CPF: " + cliente.getCpf() + " Email: " + cliente.getEmail() + " Tel: " + cliente.getTel());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrar_vendedor(Loja loja) {
        String nome;
        String cpf;
        String email;
        String tel;
        try {
            System.out.println("----------------------------");
            System.out.println("CADASTRAR VENDEDOR");
            System.out.println("----------------------------");
            System.out.println("Digite o nome do vendedor: ");
            nome = teclado.nextLine();
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextLine();
            System.out.println("Digite o email: ");
            email = teclado.nextLine();
            System.out.println("Digite o telefone: ");
            tel = teclado.nextLine();
            Sistema.cadastrar_vendedor(nome, cpf, email, tel, loja);
            System.out.println("Vendedor cadastrado com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar_vendedores(Loja loja) {
        try {
            System.out.println("----------------------------");
            System.out.println("LISTA DE VENDEDORES CADASTRADOS");
            System.out.println("----------------------------");
            for (Vendedor vendedor : Sistema.listar_vendedores(loja)) {
                System.out.println("Nome: " + vendedor.getNome() + " CPF: " + vendedor.getCpf() + " Email: " + vendedor.getEmail() + " Tel: " + vendedor.getTel());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrar_produto(Loja loja) {
        int cod_prod;
        String nome;
        Categoria categ;
        double valor;
        int quantidade;
        
        try {
            System.out.println("----------------------------");
            System.out.println("CADASTRAR PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o nome do produto: ");
            nome = teclado.nextLine();
            System.out.println("Digite a categoria: ");
            categ = Sistema.buscar_categoria(teclado.nextLine(), loja.getCnpj());
            if(categ == null)
                throw new Exception("Categoria ainda não cadastrada!");
            System.out.println("Digite o valor: ");
            valor = Double.parseDouble(teclado.nextLine());
            System.out.println("Digite a quantidade: ");
            quantidade = Integer.parseInt(teclado.nextLine());
            Sistema.cadastrar_Produto(nome, categ, valor, quantidade, loja);
            System.out.println("Produto cadastrado com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterar_cliente(Loja loja) {
        String cpf;
        String novoNome;
        String novoEmail;
        String novoTel;
        String novoCpf;
        try {
            System.out.println("----------------------------");
            System.out.println("ALTERAR CLIENTE");
            System.out.println("----------------------------");
            System.out.println("Digite o CPF do cliente a ser alterado: ");
            cpf = teclado.nextLine();
            System.out.println("Digite o novo nome: ");
            novoNome = teclado.nextLine();
            System.out.println("Digite o novo CPF: ");
            novoCpf = teclado.nextLine();
            System.out.println("Digite o novo e-mail: ");
            novoEmail = teclado.nextLine();
            System.out.println("Digite o novo telefone: ");
            novoTel = teclado.nextLine();
            Sistema.alterar_Cliente(cpf, novoNome, novoCpf, novoEmail, novoTel, loja);
            System.out.println("Cliente alterado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover_cliente(Loja loja) {
        String cpf;
        try {
            System.out.println("----------------------------");
            System.out.println("REMOVER CLIENTE");
            System.out.println("----------------------------");
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextLine();
            Sistema.remover_Cliente(cpf, loja);
            System.out.println("Cliente removido com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void buscar_cliente(Loja loja) {
        String cpf;
        Cliente cliente;
        try {
            System.out.println("----------------------------");
            System.out.println("BUSCAR CLIENTE");
            System.out.println("----------------------------");
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextLine();
            cliente = Sistema.buscar_cliente(cpf, loja.getCnpj());
            System.out.println("Nome: " + cliente.getNome() + " CPF: " + cliente.getCpf() + " Email: " + cliente.getEmail() + " Tel: " + cliente.getTel());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void alterar_vendedor(Loja loja) {
        String cpf;
        String novoNome;
        String novoEmail;
        String novoTel;
        String novoCpf;
        try {
            System.out.println("----------------------------");
            System.out.println("ALTERAR VENDEDOR");
            System.out.println("----------------------------");
            System.out.println("Digite o CPF do vendedor a ser alterado: ");
            cpf = teclado.nextLine();
            System.out.println("Digite o novo nome: ");
            novoNome = teclado.nextLine();
            System.out.println("Digite o novo CPF: ");
            novoCpf = teclado.nextLine();
            System.out.println("Digite o novo e-mail: ");
            novoEmail = teclado.nextLine();
            System.out.println("Digite o novo telefone: ");
            novoTel = teclado.nextLine();
            Sistema.alterar_Vendedor(cpf, novoNome, novoCpf, novoEmail, novoTel, loja);
            System.out.println("Vendedor alterado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover_vendedor(Loja loja) {
        String cpf;
        try {
            System.out.println("----------------------------");
            System.out.println("REMOVER VENDEDOR");
            System.out.println("----------------------------");
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextLine();
            Sistema.remover_Vendedor(cpf, loja);
            System.out.println("Vendedor removido com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cadastrar_categoria(Loja loja) {
        String titulo;
        try {
            System.out.println("----------------------------");
            System.out.println("CADASTRAR CATEGORIA");
            System.out.println("----------------------------");
            System.out.println("Digite o nome da categoria: ");
            titulo = teclado.nextLine();
            Sistema.cadastrar_Categoria(titulo, loja);
            System.out.println("Categoria cadastrada com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void remover_categoria(Loja loja) {
        String titulo;
        try {
            System.out.println("----------------------------");
            System.out.println("REMOVER CATEGORIA");
            System.out.println("----------------------------");
            System.out.println("Digite o titulo da categoria: ");
            titulo = teclado.nextLine();
            Sistema.remover_Categoria(titulo, loja);
            System.out.println("Categoria removida com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void listar_categorias(Loja loja) {
        try {
            System.out.println("----------------------------");
            System.out.println("LISTA DE CATEGORIAS CADASTRADAS");
            System.out.println("----------------------------");
            for (Categoria categoria : Sistema.listarCategorias(loja)) {
                System.out.println("Titulo: " + categoria.getTitulo());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void adicionar_und_produto(Loja loja) {
        int cod_prod;
        int quantidade;
        
        try {
            System.out.println("----------------------------");
            System.out.println("ADICIONAR UNIDADE DE PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o codigo do produto: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            System.out.println("Digite a quantidade: ");
            quantidade = Integer.parseInt(teclado.nextLine());
            Sistema.adicionar_und_Produto(cod_prod, quantidade, loja);
            System.out.println("Unidade adicionada com sucesso!\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void alterar_produto(Loja loja) {
        int cod_prod;
        String novoNome;
        Categoria novaCateg;
        double novoValor;
        int novoQuantidade;
        try {
            System.out.println("----------------------------");
            System.out.println("ALTERAR PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o codigo do produto a ser alterado: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            System.out.println("Digite o novo nome: ");
            novoNome = teclado.nextLine();
            System.out.println("Digite a nova categoria: ");
            novaCateg = Sistema.buscar_categoria(teclado.nextLine(), loja.getCnpj());
            System.out.println("Digite o novo valor: ");
            novoValor = Double.parseDouble(teclado.nextLine());
            System.out.println("Digite a quantidade: ");
            novoQuantidade = Integer.parseInt(teclado.nextLine());
            Sistema.alterar_Produto(cod_prod, novoNome, novaCateg, novoValor, novoQuantidade, loja);
            System.out.println("Produto alterado com sucesso!\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void remover_produto(Loja loja) {
        int cod_prod;
        try {
            System.out.println("----------------------------");
            System.out.println("REMOVER PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o codigo do produto: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            Sistema.remover_Produto(cod_prod, loja);
            System.out.println("Produto removido com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void listar_estoque(Loja loja) {
        try {
            System.out.println("----------------------------");
            System.out.println("LISTA PRODUTOS NO ESTOQUE");
            System.out.println("----------------------------");
            for (Produto produto : Sistema.listar_estoque(loja)) {
                System.out.println("Cod: "+produto.getCod_prod()+" Nome: " + produto.getNome()+" Categoria: "+produto.getCateg().getTitulo()+" Valor: "+produto.getValor()+" Quantidade: "+produto.getQuantidade());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public void listar_vendas(Loja loja) {
        try {
            System.out.println("----------------------------");
            System.out.println("LISTA DE VENDAS");
            System.out.println("----------------------------");
            for (Venda venda : Sistema.listar_vendas(loja)) {
                System.out.println("Cod: "+venda.getCod_venda()+" Cliente: " + venda.getCliente().getNome()+" Valor: "+venda.getValor()+" Data: "+venda.getDataVenda());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public void buscar_produto(Loja loja) {
        String nome;
        Produto produto;
        try {
            System.out.println("----------------------------");
            System.out.println("BUSCAR PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o nome do produto");
            nome = teclado.nextLine();
            produto = Sistema.buscar_Produto(nome, loja.getCnpj());
            System.out.println("Cod: "+produto.getCod_prod()+" Nome: " + produto.getNome()+" Categoria: "+produto.getCateg().getTitulo()+" Valor: "+produto.getValor()+" Quantidade: "+produto.getQuantidade());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public void realizar_venda(Loja loja) {
        Venda venda;
        ArrayList<Produto> carrinho = new ArrayList<Produto>();
        String cpfCliente;
        String cpfVendedor;
        int cod_prod;
        String op;
        Produto aux;
        try {
            System.out.println("----------------------------");
            System.out.println("REALIZAR VENDA");
            System.out.println("----------------------------");
            System.out.println("Digite o codigo do produto pra adicionar ao carrinho: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
            carrinho.add(aux);
            do{
            System.out.println("Adicionar outro produto? s/n ");
            op = teclado.nextLine().toUpperCase();
            if(op.equals("S"))
            {
            System.out.println("Digite o codigo do produto pra adicionar ao carrinho: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            aux = Sistema.buscar_ProdutoPorCod(cod_prod, loja.getCnpj());
            carrinho.add(aux);
            }
            }while(!op.equals("N")); 
            System.out.println("Digite o CPF do cliente: ");
            cpfCliente = teclado.nextLine();
            System.out.println("Digite o CPF do vendedor: ");
            cpfVendedor = teclado.nextLine();
            venda = Sistema.realizar_venda(Sistema.buscar_cliente(cpfCliente, loja.getCnpj()), carrinho, Sistema.buscar_vendedor(cpfVendedor, loja.getCnpj()), loja);
            System.out.println("Compra realizada sucesso! Valor: "+venda.getValor()+"\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
        public void transferir_produto(Loja loja) {

        int cod_prod;
        int cnpj;
        int cnpjDestino;
        int quantidade;

        try {
            System.out.println("----------------------------");
            System.out.println("TRANSFERIR PRODUTO");
            System.out.println("----------------------------");
            System.out.println("Digite o codigo do produto a ser transferido: ");
            cod_prod = Integer.parseInt(teclado.nextLine());
            System.out.println("Digite o cnpj da loja de destino: ");
            cnpjDestino = Integer.parseInt(teclado.nextLine());
            System.out.println("Digite a quantidade: ");
            quantidade = Integer.parseInt(teclado.nextLine());
            Sistema.transferir_produto(loja, cod_prod, quantidade, cnpjDestino);
            System.out.println("Produto transferido com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
