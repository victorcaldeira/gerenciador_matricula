package entities.usuario;

import java.util.ArrayList;

import entities.Curso;
import entities.disciplina.Disciplina;

public class Aluno extends Usuario {
    private ArrayList<Disciplina> disciplinasEmCurso;

    public ArrayList<Disciplina> getDisciplinasEmCurso() {
        return disciplinasEmCurso;
    }

    // Construtor da classe Aluno
    public Aluno(int matricula, String senha, String nome, int origem) {
        super(matricula, senha, nome, origem);
    }

    public void matricular(Curso curso) {
    	curso.matricularAluno(this);
    }

    public void cancelarMatricula(Curso curso) {
    	curso.cancelarMatriculaAluno(this);
    }

}
