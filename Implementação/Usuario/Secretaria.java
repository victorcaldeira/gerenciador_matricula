package Implementação.Usuario;

public class Secretaria extends Usuario{
    
    //Construtor da classe Secretaria
    public Secretaria(int matricula, String senha, String nome, int origem) {
        this.setMatricula(matricula);
        this.setSenha(senha);
        this.setNome(nome);
        this.setOrigem(origem);
    }

}