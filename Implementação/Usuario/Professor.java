package Implementação.Usuario;

import java.util.ArrayList;

import Implementação.Disciplina.Disciplina;

public class Professor extends Usuario {

    private ArrayList<Disciplina> disciplinasLecionadas;
    
    //Construtor da classe Professor
    public Professor(int matricula, String senha, String nome, int origem) {
        this.setMatricula(matricula);
        this.setSenha(senha);
        this.setNome(nome);
        this.setOrigem(origem);
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