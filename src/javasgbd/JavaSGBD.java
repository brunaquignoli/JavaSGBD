/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javasgbd;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bruna
 */
public class JavaSGBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Produto p = new Produto();

        System.out.println("O que voce quer fazer? \n 1) Cadastrar \n 2) Deletar \n 3) Atualizar");
        int opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao == 1) {
            System.out.println("Cadastrar");
            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }

            System.out.println("Descricao do novo produto: ");
            String descricao = entrada.nextLine();
            System.out.println("Preco do novo produto: ");
            double preco = entrada.nextDouble();
            entrada.nextLine();

            p.setDescricao(descricao);
            p.setPreco(preco);
            try {
                p.cadastrar();
                System.out.println("Cadastrado com sucesso.");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }
            
        } else if (opcao == 2) {

            System.out.println("Deletar");
            
            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }
            
            System.out.println("Qual o id do produto a apagar? ");
            int id = entrada.nextInt();
            entrada.nextLine();

            p.setId(id);
            try {
                p.deletar();
                System.out.println("Deletado com sucesso.");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }

        } else if (opcao == 3) {
            System.out.println("Atualizar");
            
            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }

            System.out.println("Descricao do novo produto: ");
            String descricao = entrada.nextLine();
            System.out.println("Preco do novo produto: ");
            double preco = entrada.nextDouble();
            System.out.println("Qual o id do produto a ser atualizado? ");
            int id = entrada.nextInt();
            entrada.nextLine();

            p.setDescricao(descricao);
            p.setPreco(preco);
            p.setId(id);
            try {
                p.atualizar();
                System.out.println("Atualizado com sucesso.");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            try {
                List<Produto> lista = p.listar();
                System.out.println("\n--- Lista de Produtos ---");
                for (Produto prod : lista) {
                    System.out.println("ID: " + prod.getId()
                            + " | Descricao: " + prod.getDescricao()
                            + " | Preco: R$" + prod.getPreco());
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao listar produtos: " + ex.getMessage());
            }
        }
            

    }
}
