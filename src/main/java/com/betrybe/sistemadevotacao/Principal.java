package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:\n");

      int opcao = Integer.parseInt(scanner.nextLine());

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa candidata:\n");
        String nomeCandidata = scanner.nextLine();
        System.out.print("Entre com o número da pessoa candidata:\n");
        int numeroCandidata = Integer.parseInt(scanner.nextLine());

        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidata, numeroCandidata);
      } else if (opcao == 2) {
        break;
      }
    }

    // Cadastro de pessoas eleitoras
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:\n");

      int opcao = Integer.parseInt(scanner.nextLine());

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa eleitora:\n");
        String nomeEleitora = scanner.nextLine();
        System.out.print("Entre com o cpf da pessoa eleitora:\n");
        String cpfEleitora = scanner.nextLine();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitora, cpfEleitora);
      } else if (opcao == 2) {
        break;
      }
    }

    // Votação
    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      System.out.print("Escolha a opção:\n");

      int opcao = Integer.parseInt(scanner.nextLine());

      if (opcao == 1) {
        System.out.print("Entre com o cpf da pessoa eleitora:\n");
        String cpfEleitora = scanner.nextLine();
        System.out.print("Entre com o número da pessoa candidata:\n");
        int numeroCandidata = Integer.parseInt(scanner.nextLine());

        gerenciamentoVotacao.votar(cpfEleitora, numeroCandidata);
      } else if (opcao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (opcao == 3) {
        gerenciamentoVotacao.mostrarResultado();
        break;
      }
    }

    scanner.close();
  }
}
