package entities.usuario;

import java.util.ArrayList;

import entities.disciplina.Disciplina;

public class Professor extends Usuario {

    private ArrayList<Disciplina> disciplinasLecionadas;
    
    //Construtor da classe Professor
    public Professor(int matricula, String senha, String nome, int origem) {
     super(matricula, senha, nome, origem);
    }

    //Professor consulta os nomes dos alunos cadastrados em uma disciplina
    public void consultarAlunosMatriculados (int matriculaDisciplina) {
        for (Disciplina disciplina : disciplinasLecionadas) {
            if (disciplina.getID() == matriculaDisciplina)
                disciplina.getAlunosMatriculados();
        }        
    }

    public void addDisciplinaLecionada(Disciplina disciplina){ 
        disciplinasLecionadas.add(disciplina);
    }
} 