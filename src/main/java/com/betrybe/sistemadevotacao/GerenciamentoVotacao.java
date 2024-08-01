package com.betrybe.sistemadevotacao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }

    PessoaCandidata novaCanditada = new PessoaCandidata(nome, numero);

    pessoasCandidatas.add(novaCanditada);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitora : pessoasEleitoras) {
      if (eleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }

    PessoaEleitora novaEleitora = new PessoaEleitora(nome, cpf);

    pessoasEleitoras.add(novaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      boolean candidatoEncontrado = false;
      for (PessoaCandidata candidata : pessoasCandidatas) {
        if (candidata.getNumero() == numeroPessoaCandidata) {
          candidata.receberVoto(); // Assumindo que este método está na classe PessoaCandidata
          cpfsComputados.add(cpfPessoaEleitora);
          candidatoEncontrado = true;
          break; // Para evitar múltiplos votos para o mesmo CPF
        }
      }
      if (!candidatoEncontrado) {
        System.out.println("Número da pessoa candidata não encontrado!");
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    // Criar um mapa para armazenar os votos por candidato
    Map<PessoaCandidata, Integer> votosPorCandidato = new HashMap<>();

    // Inicializar o mapa com candidatos e seus votos
    for (PessoaCandidata candidata : pessoasCandidatas) {
      votosPorCandidato.put(candidata, candidata.getVotos());
    }

    // Calcular o total de votos
    int totalVotos = cpfsComputados.size();

    // Imprimir o resultado
    for (Map.Entry<PessoaCandidata, Integer> entry : votosPorCandidato.entrySet()) {
      PessoaCandidata candidata = entry.getKey();
      int votos = entry.getValue();
      int percentual = (int) Math.round((votos * 100.0) / totalVotos);

      System.out.printf("Nome: %s - %d votos ( %d%% )%n", candidata.getNome(), votos, percentual);
    }

    System.out.println("Total de votos: " + totalVotos);
  }
}
