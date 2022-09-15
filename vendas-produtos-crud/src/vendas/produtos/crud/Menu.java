package vendas.produtos.crud;

import java.util.Scanner;

public class Menu {

    public void escolhaDoUsuario(int opcao) {

        switch (opcao) {
            case 0:
                System.out.println("Voce saiu!");
                break;
            case 1:
                realizarVenda();
                break;
            case 2:
                verCarrinho();
                break;
            case 3:
                finalizarVenda();
                break;
            case 4:
                int codigo;
                String nome;
                int quantidade;
                double valorParaVenda;
                Scanner dadosEntradaProduto = new Scanner(System.in);
                
                System.out.print("Informe o codigo do produto: ");
                codigo = Integer.parseInt(dadosEntradaProduto.nextLine());
                
                System.out.print("Informe o nome do produto: ");
                nome = dadosEntradaProduto.nextLine();
                
                System.out.print("Informe a quantidade de itens do produto: ");
                quantidade = Integer.parseInt(dadosEntradaProduto.nextLine());
                
                String valor;
                
                do {
                    System.out.print("Informe o valor unitario do produto: ");
                    valor = dadosEntradaProduto.nextLine();
                    if (valor.contains(",")) {
                        System.out.println("Utilize o . (ponto) ao invés de , (virgula). | Ex.: 4.99 |");
                    }
                } while (valor.contains(","));
                valorParaVenda = Double.parseDouble(valor);
                cadastrarProduto(codigo, nome, quantidade, valorParaVenda);
                break;
            case 5:
                cadastrarFuncionario();
                break;
            case 6:
                cadastrarCliente();
                break;
            default:
                System.out.println("opcao invalida!");
                break;
        }
    }
    
    public void realizarVenda() {
        System.out.println("Comecar venda!");
    }

    public void verCarrinho() {
        System.out.println("****************CARRINHO****************");
        System.out.println("******************FIM******************");
    }

    public void finalizarVenda() {
        System.out.println("**************************VENDA********************");
        System.out.println("*****************VENDA FINALIZADA*****************");
    }

    public void cadastrarProduto(int codigo, String nome, int quantidade, double valorParaVenda) {
        Estoque estoque = new Estoque();
        estoque.cadastrarProduto(codigo, nome, quantidade, valorParaVenda);
    }

    public void cadastrarFuncionario() {
        System.out.println("Cadastrando Funcionario..");
    }

    public void cadastrarCliente() {
        System.out.println("Cadastrando Cliente...");
    }
    
}
