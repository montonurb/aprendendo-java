package vendas.produtos.crud;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Carrinho {

    ArrayList<Produto> produtosCarrinho = new ArrayList<>();

    public void adicionarProdutoCarrinho(Estoque estoque) {
        Scanner entradaCodigo = new Scanner(System.in);
        int codigo;
        int quantidade;
        Produto produtoEscolhido;
        int adicionarProduto;

        do {
            estoque.visualizarEstoque();
            do {
                System.out.print("Informe o codigo do produto: ");
                codigo = Integer.parseInt(entradaCodigo.nextLine());

                if (estoque.produtos.containsKey(codigo)) {
                    do {
                        produtoEscolhido = estoque.produtos.get(codigo);
                        System.out.println(produtoEscolhido);
                        System.out.print("Quantidade: ");
                        quantidade = Integer.parseInt(entradaCodigo.nextLine());
                        if (quantidade > produtoEscolhido.getQuantidade()) {
                            System.out.println("Quantidade maior do que o estoque.");
                        }
                        System.out.println("Q: " + produtoEscolhido.getQuantidade());
                    } while (quantidade > estoque.produtos.get(codigo).getQuantidade());
                    estoque.diminuirEstoque(codigo, quantidade, produtoEscolhido);
                    produtosCarrinho.add(new Produto(produtoEscolhido.getNome(), quantidade, produtoEscolhido.getValorParaVenda()));
                    System.out.println("CARRINHO: " + produtosCarrinho);

                } else {
                    System.out.println("opcao invalida! Informe um codigo do produto que esteja cadastrado.");
                    estoque.visualizarEstoque();
                }
            } while (!estoque.produtos.containsKey(codigo));

            System.out.println("TESTEEEEE");
            
            produtoAdicionado();
            
            for(Map.Entry produtoObjeto : estoque.produtos.entrySet()) {
                Object produto = produtoObjeto.getValue();
                System.out.println("T: " + produtoObjeto.getValue());
                
            }

            System.out.println("Deseja adicionar outro produto?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO");
            System.out.print("Opcao: ");
            
            adicionarProduto = Integer.parseInt(entradaCodigo.nextLine());
        } while (adicionarProduto == 1);
    }

    public void produtoAdicionado() {
        System.out.println("\n***********************");
        System.out.println("* Produto adicionado! *");
        System.out.println("***********************");
    }

    public void getCarrinho() {
        for (Produto produto : produtosCarrinho) {
            System.out.println("* " + produto + "*");
        }
    }
}
