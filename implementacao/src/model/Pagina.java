package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Pagina {

    private String titulo, texto, resumo, nome;
    static HashMap<Date, Historico> historico;
    private boolean visivel;

    public Pagina(String titulo, String texto, String resumo, String nome) {
        this.titulo = titulo;
        this.texto = texto;
        this.resumo = resumo;
        this.nome = nome;
        this.visivel = true;
        historico = new HashMap<>();
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(boolean b) {
        this.visivel = b;
    }

    // metodos
    public String toString() {
        if (this.visivel) {
            return "Titulo: " + titulo + " - Resumo: " + resumo + " - Criado por: " + nome + " - Visivel: " + visivel;
        } else {
            return "A página: " + titulo + " do usuário: " + nome + " foi oculta por moderadores";
        }
    }

    // acesar histórico
    public void acessarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Não há histórico para esta página.");
        } else {
            Iterator<Entry<Date, Historico>> it = historico.entrySet().iterator();
            while (it.hasNext()) {
                Entry<Date, Historico> pair = it.next();
                System.out.println(pair.getValue());
            }
        }
    }

}
