package Implementação.Usuario;

import java.util.ArrayList;

import Implementação.Disciplina.Disciplina;

public class Aluno extends Usuario {
    private ArrayList<Disciplina> disciplinasEmCurso;

    public ArrayList<Disciplina> getDisciplinasEmCurso() {
        return disciplinasEmCurso;
    }

    // Construtor da classe Aluno
    public Aluno(int matricula, String senha, String nome, int origem) {
        this.setMatricula(matricula);
        this.setSenha(senha);
        this.setNome(nome);
        this.setOrigem(origem); 
    }

    public void matricular() {

    }

    public void cancelarMatricula() {

    }

}