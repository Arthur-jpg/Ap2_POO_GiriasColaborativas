import data.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gírias Colaborativas");
        System.out.println("===============================");
        
        Usuario usuario1 = new Usuario("u1", "João", "joao@email.com", "senha123", 0, false);
        Usuario usuario2 = new Usuario("u2", "Maria", "maria@email.com", "senha456", 0, false);
        Usuario usuario3 = new Usuario("u3", "Arthur", "maria@email.com", "senha4567", 0, false);
        Usuario admin = new Usuario("adm", "Admin", "admin@sistema.com", "admin123", 100, true);
        
        System.out.println("Usuários criados: " + usuario1 + ", " + usuario2 + ", " + usuario3 + ", " + admin);
        
        Regiao norte = new Regiao("r1", "Norte", "Diversos", "Região Norte do Brasil");
        Regiao nordeste = new Regiao("r2", "Nordeste", "Diversos", "Região Nordeste do Brasil");
        Regiao rj = new Regiao("r3", "Rio de Janeiro", "RJ", "Estado do Rio de Janeiro");
        
        Categoria informal = new Categoria("c1", "Informal", "Linguagem informal do dia a dia");
        Categoria internet = new Categoria("c2", "Internet", "Gírias populares na internet");
        
        Giria giria1 = usuario1.addGiria("g1", "Bora", null, new Categoria[]{informal}, new Regiao[]{norte, nordeste});
        
        Explicacao explicacao1 = usuario2.addExplicacao("e1", "Contração de 'vamos embora', significa vamos, vamos lá", 
                                                      new String[]{"Bora assistir um filme?"}, giria1);
        Explicacao explicacao3 = usuario3.addExplicacao("e3", "Teste", new String[] {"Teste"}, giria1);
        
        Explicacao explicacao2 = admin.addExplicacao("e2", "Usado para incentivar alguém a fazer algo", 
                                                   new String[]{"Bora resolver esse problema!"}, giria1);
        
        usuario1.votar(explicacao3, true);
        
        usuario2.votar(explicacao3, true);

        usuario3.votar(explicacao3, true);
        
        admin.votar(explicacao1, false);
        
        System.out.println("\nGíria: " + giria1.getTermo());
        System.out.println("Autor: " + giria1.getAutor().getNome());
        System.out.println("Explicações:");
        
        for (Explicacao explicacao : giria1.getExplicacoes()) {
            System.out.println("- " + explicacao.getTexto() + " (votos: " + explicacao.getVotos() + ")");
            System.out.println("  Autor: " + explicacao.getAutor().getNome());
            System.out.print("  Exemplos: ");
            for (String exemplo : explicacao.getExemplos()) {
                System.out.print("\"" + exemplo + "\" ");
            }
            System.out.println();
        }
        
        Explicacao maisVotada = giria1.getExplicacaoMaisVotada();
        System.out.println("\nExplicação mais votada: " + maisVotada.getTexto() + " (votos: " + maisVotada.getVotos() + ")");
        
        giria1.editar("Bora!", admin);
        giria1.editar("Teste", usuario3);
        
        System.out.println("\nHistórico de edições da gíria:");
        for (Edicao edicao : giria1.getHistoricoEdicoes()) {
            System.out.println("- Alterado de \"" + edicao.getConteudoAnterior() + "\" para \"" + 
                             edicao.getConteudoNovo() + "\" por " + edicao.getEditor().getNome() + 
                             " em " + edicao.getDataEdicao());
        }
        
        System.out.println("\nReputação dos usuários:");
        System.out.println(usuario1.getNome() + ": " + usuario1.getReputacao());
        System.out.println(usuario2.getNome() + ": " + usuario2.getReputacao());
        System.out.println(admin.getNome() + ": " + admin.getReputacao());
    }
}