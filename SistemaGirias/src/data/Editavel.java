package data;

public interface Editavel {
    boolean editar(String novoConteudo, Usuario editor);
    Edicao[] getHistoricoEdicoes();
    String getConteudo();

}
