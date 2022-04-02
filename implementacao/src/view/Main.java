package view;

import model.Usuario;
import model.Moderador;

public class Main {
    public static void main(String[] args) throws Exception {
        // Criando um usuário
        Usuario novoUsuario = new Usuario("Marcos", 20);

        // Criando algumas páginas para o usuário
        novoUsuario.criarPaginas("Roma", "O império romano surgiu ....", "Sobre o surgimento de Roma");
        novoUsuario.criarPaginas("Brasil", "O Brasil foi fundado em ....", "Sobre o fundação do Brasil");
        novoUsuario.criarPaginas("JavaScript", "JavaScript é uma linguagem de programação",
                "Sobre a linguagem de programação JavaScript");

        // Listando as páginas do usuário
        novoUsuario.listarPaginas();

        // Atualizar página
        System.out.println("\n");
        System.out.println("Atualizando a página de indice 0");
        novoUsuario.atualizarResumo(0, "Sobre o império romano");
        novoUsuario.listarPaginas();
        novoUsuario.atualizarTexto(0, "O surgimento do império romano se deu em...");

        // Visualizar histórico
        System.out.println("Visualizando o histórico: ");
        novoUsuario.getPagina(0).acessarHistorico();

        // Remover página
        System.out.println("Removendo a página " + novoUsuario.getPagina(0).getTitulo());
        novoUsuario.removerPagina(0);

        // Listando as páginas do usuário
        novoUsuario.listarPaginas();

        // Criando um moderador
        System.out.println("Ocultando a página " + novoUsuario.getPagina(0).getTitulo());
        // Moderador
        Moderador moderador = new Moderador("Moderador", 30);
        moderador.bloquearPagina(novoUsuario, novoUsuario.getPagina(0));

        // Listando as páginas do usuário
        novoUsuario.listarPaginas();

    }
}