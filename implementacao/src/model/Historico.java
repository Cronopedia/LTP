package model;

import java.util.Date;
import java.util.HashMap;

public class Historico {

    private int index;
    private String titulo, nome, mudanca, campo;

    public Historico() {

    }

    public Historico(int index, String titulo, String nome, String mudanca, String campo) {
        this.index = index;
        this.titulo = titulo;
        this.nome = nome;
        this.mudanca = mudanca;
        this.campo = campo;
    }

    // Getters e Setters
    public int getIndex() {
        return index;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNome() {
        return nome;
    }

    public String getMudanca() {
        return mudanca;
    }

    public String getCampo() {
        return campo;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMudanca(String mudanca) {
        this.mudanca = mudanca;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    // To Sting
    public String toString() {
        return "Id da página que foi alterada: " + this.index + ", Título da Página: " + this.titulo
                + ", Nome de quem atualizou a página: " + this.nome + ", Mudança feita: " + this.mudanca + " - Campo: "
                + this.campo;
    }

    // Criando metodo para registrar as mudanca no historico
    public static void registrar(int index, String titulo, String nome, String mudanca, String campo) {
        
        // Instanciando o hashMap para registrar as mudanca
        Pagina.historico = new HashMap<>();

        // Criando um objeto do tipo Historico
        Historico obj = new Historico(index, titulo, nome, mudanca, campo);

        // Adicionando o objeto no hashMap
        Pagina.historico.put(new Date(System.currentTimeMillis()), obj);

        System.out.println("\nHistorico registrado com sucesso!\n");
    }
}
