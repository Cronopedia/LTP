package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {

    protected String nome;
    protected int idade;
    public ArrayList<Pagina> paginas;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        paginas = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Metodos
    // Criar páginas
    public void criarPaginas(String titulo, String texto, String resumo) {
        Pagina paginaNova = new Pagina(titulo, texto, resumo, this.nome);
        paginas.add(paginaNova);
    }

    // Iterator de páginas
    public void listarPaginas() {
        // Iterator
        Iterator<Pagina> it = paginas.iterator();

        System.out.println("\nPáginas do usuário: " + this.nome);
        System.out.println("numero de páginas: " + paginas.size());

        // Fazendo o loop
        while (it.hasNext()) {
            Pagina page = it.next();
            System.out.println(page.toString());
        }

    }

    // Remover uma página por index
    public void removerPagina(int index) {
        if ((index >= 0 && index <= paginas.size() - 1) && !paginas.isEmpty()) {
            paginas.remove(index);
        } else if (index < 0) {
            System.out.println("Não é válido. Motivo: o index passado é negativo");
        } else if (paginas.isEmpty()) {
            System.out.println("Erro. O usuário não criou nenhuma página ainda");
        } else {
            System.out.println("Não é válido. Motivo: o index passado excedeu o index máximo. Index máximo: "
                    + (paginas.size() - 1));
        }
    }

    // Atualizar página

    // Atualizar Título
    public void atualizarTitulo(int index, String titulo) {
        // Registrando as alterações do titulo no histórico
        Historico.registrar(index, titulo, titulo, nome, "Atualização no Titulo");

        paginas.get(index).setTitulo(titulo);

    }

    // Atualizar Resumo
    public void atualizarResumo(int index, String value) {
        // Pegando a página para ver o seu título
        String titulo = paginas.get(index).titulo;

        // Registrando as alterações do resumo no histórico
        Historico.registrar(index, titulo, value, nome, "Atualização no Resumo");

        paginas.get(index).setResumo(value);
    }

    // Atualizar Texto
    public void atualizarTexto(int index, String texto) {
        // Pegando a página para ver o seu título
        String titulo = paginas.get(index).titulo;

        // Registrando as alterações do texto no histórico
        Historico.registrar(index, titulo, texto, nome, "Atualização no Texto");

        paginas.get(index).setTexto(texto);
    }

    // Visualizar uma página
    public Pagina getPagina(int index) {
        if (paginas.get(index).getVisivel()) {
            return paginas.get(index);
        } else {
            System.out.println("A página foi bloquada por um moderador.");
            return null;
        }
    }

    // public void atualizarPagina(int index , int campo, String value){
    // if((index >= 0 && index <= paginas.size() - 1) && !paginas.isEmpty()){
    // switch(campo){
    // //Atualiza o titulo
    // case 1:
    // paginas.get(index).setTitulo(value);
    // break;

    // //Atualiza o texto
    // case 2:
    // paginas.get(index).setTexto(value);
    // break;

    // //Atualiza o resumo
    // case 3:
    // paginas.get(index).setResumo(value);
    // break;

    // //Quando não for nenhum desses
    // default:
    // System.out.println("O campo passado não é válido");
    // break;
    // }
    // } else if(index < 0){
    // System.out.println("Não é válido. Motivo: o index passado é negativo");
    // } else if(paginas.isEmpty()){
    // System.out.println("Erro. O usuário não criou nenhuma página ainda");
    // } else{
    // System.out.println("Não é válido. Motivo: o index passado excedeu o index
    // máximo. Index máximo: "+(paginas.size()-1));
    // }
    // }

}
