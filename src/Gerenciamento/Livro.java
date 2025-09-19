package Gerenciamento;

import java.util.Date;

public class Livro {
  private int id;
  private String titulo;
  private Autor autor;
  private boolean disponivel;
  final private Date dataCadastro;
  private Date dataAtualizacao;

  public Livro(int id, String titulo, Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.disponivel = true;
    this.dataCadastro = new Date();
    this.dataAtualizacao = new Date();

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
    this.dataAtualizacao = new Date();
  }


  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  @Override
  public String toString() {
    return "Livro{" +
        "id=" + id +
        ", titulo='" + titulo + '\'' +
        ", autor=" + autor +
        ", disponivel=" + disponivel +
        ", dataCadastro=" + dataCadastro +
        ", dataAtualizacao=" + dataAtualizacao +
        '}';

  }
}
