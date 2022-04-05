package model;

public class Moderador extends Usuario {

    // Metodos exclusivos para o moderador

    public Moderador(String nome, int idade) {
        super(nome, idade);
    }

    // bloqueia uma pagina
    public void bloquearPagina(Pagina pagina) {
        if (pagina.getVisivel()) {
            pagina.setVisivel(false);
        } else {
            pagina.setVisivel(true);
        }
    }

}
