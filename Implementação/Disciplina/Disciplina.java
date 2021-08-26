package Implementação.Disciplina;

import java.util.ArrayList;
import Implementação.Usuario.Aluno;
import Implementação.Usuario.Professor;

public class Disciplina {
    private int id;
    private String nome;
    private Professor professor;
    private static final int MIN_Inscritos = 3;
    private static final int MAX_Inscritos = 60;
    private boolean optativa;
    private ArrayList<Aluno> alunosMatriculados;
    private int vagas;
    private boolean ativa;

    public Disciplina(String nome, boolean optativa, int id, int vagas, boolean ativa) {
        this.id = id;
        this.nome = nome;
        this.optativa = optativa;
        this.ativa = ativa;

        if (vagas < MAX_Inscritos)
            this.vagas = vagas;
        else
            this.vagas = MAX_Inscritos;
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public boolean getOptativa() {
        return optativa;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void getAlunosMatriculados() {
        System.out.println("Alunos matriculados na disciplina de " + nome + ": ");

        for (Aluno aluno : alunosMatriculados) {
            System.out.println("Nome: " + aluno.getNome() + " | Matricula: " + aluno.getMatricula() + " | Origem: "
                    + aluno.getOrigem() + "\n");
        }
    }

    public int getID() {
        return id;
    }

    public Professor getProf() {
        return professor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOptativa(boolean optativa) {
        this.optativa = optativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setProf(Professor professor) {
        if (professor == null) {
            this.professor = professor;
        } else {
            // Retorna mensagem de erro:
            System.out.println("Já existe professor da disciplina.");
        }
    }
}
