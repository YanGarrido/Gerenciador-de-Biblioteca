import Gerenciamento.Autor;
import Gerenciamento.Biblioteca;
import Gerenciamento.Livro;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    Scanner sc = new Scanner(System.in);

    Autor autor1 = new Autor(1, "Robert Louis Steveson", new Date());
    Autor autor2 = new Autor(2, "C.S Lewis", new Date());

    biblioteca.adicionarAutor(autor1);
    biblioteca.adicionarAutor(autor2);

    Livro livro1 = new Livro(1,"O médico e o monstro", autor1);
    Livro livro2 = new Livro(2,"Cristianismo Puro e Simples", autor2);
    Livro livro3 = new Livro(3,"A carta de um Diabo ao seu aprendiz", autor2);

    biblioteca.adicionarLivro(livro1);
    biblioteca.adicionarLivro(livro2);
    biblioteca.adicionarLivro(livro3);

    while (true) {
      System.out.println("Deseja verificar os Livros Disponíveis?(sim/nao)");
      String opcao = sc.nextLine().toLowerCase();

      if (opcao.equals("sim")) {

        List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
        if (livrosDisponiveis.isEmpty()) {
          System.out.println("Não há livros disponiveis no momento.");
        } else {
          System.out.println("Livros disponiveis:");
          for (Livro livro : livrosDisponiveis) {
          System.out.println(livro.getId()+ ": " +livro.getTitulo());
          }
            System.out.println("Digite o ID do livro na qual você deseja pegar emprestado");
            int idLivroEmprestado = sc.nextInt();
            sc.nextLine();

            Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivroEmprestado);

            if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
              System.out.println("Digite seu nome: ");
              String nomeTitular = sc.nextLine();

              biblioteca.emprestarLivro(livroSelecionado, nomeTitular);
              System.out.println("O livro " +livroSelecionado.getTitulo() +" foi emprestado ao titular chamado " + nomeTitular);

            } else {
              System.out.println("Livro não encontrado ou não está disponível para emprestimo no momento.");
            }

        } 
      } else if (opcao.equals("nao")) {
        System.out.println("Obrigado por utilizar o sistema da biblioteca.");
        break;
      }else {
        System.out.println("Resposta Inválida. Por favor responda apenas com 'sim' ou 'nao'.");
      }
    }
  sc.close();
  }
}