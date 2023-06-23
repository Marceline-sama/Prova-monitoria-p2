import java.util.ArrayList;

public class Perfil {
  private String nome;
  private String ig;
  private ArrayList<Perfil> seguidores;  
  boolean imprimiu;// Removido o modificador "private" para tornar "imprimiu" visível fora da classe Perfil

  /**
   * Construtor da classe Perfil
   * @param nome Nome do perfil
   * @param ig Instagram do perfil
   */
  public Perfil(String nome, String ig) {
  this.nome = nome;
  this.ig = ig;
  this.imprimiu = false;
  this.seguidores = new ArrayList<>(); // Adiciona a inicialização da lista de seguidores
}
  /**
   * Construtor vazio da classe Perfil
   */
  public Perfil() {
    this.seguidores = new ArrayList<>();

  }
  /**
   * Adiciona um seguidor ao perfil
   * @param seguidor Perfil do seguidor
   */
  public void addSeguidor(Perfil seguidor) {
    seguidores.add(seguidor);
  }
  /**
   * Remove      um seguidor do perfil
   * @param seguidor Perfil do seguidor a ser removido
   */
  public void removeSeguidor(Perfil seguidor) {
    seguidores.remove(seguidor);
  }
  /**
   * Imprime os dados do perfil
   */
  public void imprimirDados() {
    System.out.println("Nome: " + nome);
    System.out.println("IG: " + ig);
    System.out.println("Nº seguidores: " + seguidores.size());
  }
  /**
   * Mostra a árvore de seguidores do perfil
   * @param nivel Nível da árvore de seguidores
   */
  public void mostrarÁrvoreSeguidores(int nivel) {
    // if(this.imprimiu == true) { // Verificação desnecessária, removida
      // this.imprimiu = false; // Comentado, pois não é necessário resetar a flag
      for (int i = 0; i < nivel; i++) {
        System.out.print("---");
      }
      System.out.println(nome);
      for (Perfil seguidor : seguidores) {
        seguidor.mostrarÁrvoreSeguidores(nivel + 1);
      }
    // }
  }
}
