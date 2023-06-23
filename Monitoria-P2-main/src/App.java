import java.util.ArrayList;

// Observe o código a seguir, ele contém alguns erros. Você deve:
// - Corrigir todos os erros para que ele funciona corretamente
// - Para cada erro encontrado, você deve dizer qual é o tipo do erro
//     - Erro de compilação (o programa não compila)
//     - Erro de execução (o programa compila, mas não executa)
//     - Erro de lógica/comportamento (o programa compila e executa, mas não funciona como deveria)
// - Para cada erro você deve explicar por quê esse erro ocorreu
// - Para cada erro você deve explicar como corrigiu
// - Ao fim, você deve demonstrar o seu programa executando corretamente

// Busque usar os termos corretos, 
// explicar tudo com suas palavras
// e de forma tranquila clara e objetiva.

public class App {
    public static void main(String[] args) throws Exception {
        Perfil p1 = new Perfil("João Jorge", "jj");
        Perfil p2 = new Perfil("Maria José", "mj");
        Perfil p3 = new Perfil("José João", "jjao");
        Perfil p4 = new Perfil("Juli Joana Jurema", "jjj");

        PerfilComercial pc1 = new PerfilComercial("Mariana Malu", "mm", "mm@email.com");
        PerfilComercial pc2 = new PerfilComercial("Mauro Mirlos", "mm2", "mmir@email.com");

        // Adicionando seguidores (entrava em loop causado pela forma como cada vez que adicionava um seguidor apontava para o proximo e a terceira interação de adicionar seguidor chamava o primeiro de novo entrando em loop infinito)
        p1.addSeguidor(new Perfil("Maria José", "mj"));//2
        p1.addSeguidor(new Perfil("José João", "jjao"));//3
        p1.addSeguidor(new Perfil("Juli Joana Jurema", "jjj"));//4
        p2.addSeguidor(new Perfil("José João", "jjao"));//3
        p3.addSeguidor(new PerfilComercial("Mauro Mirlos", "mm2", "mmir@email.com"));//pc2
        p3.addSeguidor(new Perfil("João Jorge", "jj"));//1
        pc1.addSeguidor(new Perfil("João Jorge", "jj"));//1
        pc1.addSeguidor(new Perfil("Maria José", "mj"));//2
        pc1.addSeguidor(new Perfil("José João", "jjao"));//3
        pc1.addSeguidor(new Perfil("Juli Joana Jurema", "jjj"));//4
        pc2.addSeguidor(new PerfilComercial("Mariana Malu", "mm", "mm@email.com"));//pc1
        pc2.addSeguidor(new Perfil("Maria José", "mj"));//2

        ArrayList<Perfil> perfis = new ArrayList<Perfil>();

        perfis.add(p1);
        perfis.add(p2);
        perfis.add(p3);
        perfis.add(p4);
        perfis.add(pc1);
        perfis.add(pc2);

        // Mostrando todos os perfis
        for (Perfil perfil : perfis) {
            perfil.imprimirDados();
            System.out.println();
        }

        // Mostrando todas as árvore de seguidores
        for (Perfil perfil : perfis) {
            perfil.mostrarÁrvoreSeguidores(0);

            // Limpando as marcações de impressão
            for (Perfil temp : perfis) {
              temp.imprimiu = false;
            }

            System.out.println();
            System.out.println();
        }        
    }
}
