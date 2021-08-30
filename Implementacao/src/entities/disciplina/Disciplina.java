package entities.disciplina;

import java.util.ArrayList;

import entities.usuario.Aluno;
import entities.usuario.Professor;

public class Disciplina {
	private int id;
	private String nome;
	private Professor professor;
	private final int MIN_Inscritos = 3;
	private final int MAX_Inscritos = 60;
	private boolean optativa;
	private ArrayList<Aluno> alunosMatriculados;
	private int vagas;
	private boolean ativa;
	private static int contadorDisciplinas = 0;

	public Disciplina(String nome, boolean optativa, int vagas, boolean ativa) {
		this.id = contadorDisciplinas++;
		this.nome = nome;
		this.optativa = optativa;
		this.ativa = ativa;

		if (vagas < MAX_Inscritos)
			this.setVagas(vagas);
		else
			this.setVagas(MAX_Inscritos);
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

	public void matricularAluno(Aluno aluno) {
		if (this.alunosMatriculados.contains(aluno)) {
			System.out.println("Aluno já matriculado.");
		} else {
			this.alunosMatriculados.add(aluno);
		}
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

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getMIN_Inscritos() {
		return MIN_Inscritos;
	}
	
}