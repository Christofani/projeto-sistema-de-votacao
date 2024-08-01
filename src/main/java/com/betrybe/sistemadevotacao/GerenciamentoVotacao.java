package com.betrybe.sistemadevotacao;


import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Instantiates a new Gerenciamento votacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    // Implementação futura
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    // Implementação futura
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    // Implementação futura
  }

  @Override
  public void mostrarResultado() {
    // Implementação futura
  }
}
