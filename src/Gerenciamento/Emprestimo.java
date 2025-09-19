package Gerenciamento;

import java.util.Date;

public class Emprestimo {
  private int id;
  private static int contadorId = 1;
  private Livro livro;
  private String nomeTitular;
  private Date dataEmprestimo;
  private Date dataDevolucao;
  private boolean ativo;

  public Emprestimo(Livro livro, String nomeTitular) {
    this.id = contadorId++;
    this.livro = livro;
    this.nomeTitular = nomeTitular;
    this.dataEmprestimo = new Date();
    this.ativo = true;
  }
  public int getId() {
    return id;
  }

  public Livro getLivro() {
    return livro;
  }

  public String getNomeTitular() {
    return nomeTitular;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }
  public boolean isAtivo() {
    return ativo;
  }

  public void devolverLivro() {
    this.dataDevolucao = new Date();
    this.ativo = false;
    this.livro.setDisponivel(true);

  }

  @Override
  public String toString() {
    return "Emprestimo{" +
        "id=" + id + ", " +
        ", livro=" + livro + ", " +
        ", nomeTitular=" + nomeTitular +
        ", dataEmprestimo=" + dataEmprestimo +
        ", dataDevolucao=" + dataDevolucao +
        ", ativo=" + ativo +'}';
  }
}
