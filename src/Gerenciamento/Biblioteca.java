package Gerenciamento;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   List<Livro> livros = new ArrayList<Livro>();
   List<Autor> autores = new ArrayList<>();
   List<Emprestimo> emprestimos = new ArrayList<>();

  public void adicionarLivro(Livro livro) {
    livros.add(livro);
  }

  public List<Livro> listarLivros() {
    return livros;
  }

  public List<Livro> listarLivrosDisponiveis() {
    List<Livro> livrosDisponiveis = new ArrayList<>();
    for (Livro livro : livros) {
      if(livro.isDisponivel()){
        livrosDisponiveis.add(livro);
      }
    }
    return livrosDisponiveis;
  }

  public Livro buscarLivroPorId(int id) {
    for (Livro livro : livros) {
      if (livro.getId() == id) {
        return livro;
      }
    }
    return null;
  }

  public void atualizarLivro(int id, String novoTitulo){
    for (Livro livro : livros) {
      if (livro.getId() == id) {
        livro.setTitulo(novoTitulo);
        break;
      }
    }
  }

  public void removerLivro(int id) {
    livros.remove(buscarLivroPorId(id));
  }

  public void adicionarAutor(Autor autor) {
    autores.add(autor);
  }
  public List<Autor> listarAutores() {
    return autores;
  }

  public void atualizarAutor(int id, String novoNome){
    for (Autor autor : autores) {
      if (autor.getId() == id) {
        autor.setNome(novoNome);
        break;
      }
    }
  }

  public void removerAutor(int id) {
    autores.removeIf(autor -> autor.getId() == id);
  }

  public void emprestarLivro(Livro livro, String nomeTitular){
    if (livro.isDisponivel()){
      Emprestimo emprestimo = new Emprestimo(livro, nomeTitular);
      emprestimos.add(emprestimo);
      livro.setDisponivel(false);
    } else {
      System.out.println("Livro " + livro + " não disponível para emprestimo." );
    }
  }

  public void devolverLivro(int idEmprestimo){
    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()) {
        emprestimo.devolverLivro();
        break;
      }
    }
  }

  public List<Emprestimo> listarEmprestimos(){
    return emprestimos;
  }
}
