package data;

public interface Votavel {
    int getVotos();
    void adicionarVoto(boolean tipoDeVoto);
    void removerVoto(boolean tipoDeVoto);
}
