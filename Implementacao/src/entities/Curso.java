package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.disciplina.Disciplina;
import entities.usuario.Aluno;

public class Curso {
	private int id;
	private String nome;
	private int creditos;
	private LocalDate inicioMatricula;
	private LocalDate terminoMatricula;
	private ArrayList<Disciplina> disciplinas;
	private static int contadorCurso = 0;
	private ArrayList<Aluno> alunos;

	public Curso(String nome, int creditos, LocalDate inicioMatricula, LocalDate terminoMatricula,
			ArrayList<Disciplina> disciplinas) {
		this.setNome(nome);
		this.setCreditos(creditos);
		this.setID(contadorCurso++);
		this.disciplinas = disciplinas;
		this.inicioMatricula = inicioMatricula;
		this.terminoMatricula = terminoMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public int getId() {
		return id;
	}

	public LocalDate getInicioMatricula() {
		return inicioMatricula;
	}

	public LocalDate getFimMatricula() {
		return terminoMatricula;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public void setID(int id) {
		this.id = id;
	}

	protected void setDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public boolean inserirDisciplina(Disciplina disciplina) {
		return (disciplinas.add(disciplina));
	}

	public void matricularAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void cancelarMatriculaAluno(Aluno aluno) {
		if (this.alunos.remove(aluno)) {
			System.out.println("Aluno desmatriculado do curso: " + this.nome);
		} else {
			System.out.println("Aluno n�o matriculado no curso: " + this.nome);
		}
		;
	}

	// Eu acho que essa funç~]ao simplemente resolve o nosso ponto de criar
	// disciplina
	public void definirPeriodoMatricula(LocalDate inicio, LocalDate termino) {
		if (inicio.compareTo(termino) <= 0) {
			inicioMatricula = inicio;
			terminoMatricula = termino;
		} else {
			// erro a data de inicio não pode ser posterior ao fim.
			System.out.println("Erro, Data de inicio não pode ser posterior ao fim");
		}
	}

	public void listarDisciplinas() {
		System.out.println("Disciplinas do curso de " + nome + ":");
		for (Disciplina disciplina : disciplinas) {
			System.out.println("- " + disciplina.getNome() + "\n");
		}
	}

	public String toCsv() {
		return (this.getNome() + ";" + this.getCreditos() + ";" + this.getId() + ";" + this.getInicioMatricula() + ";"
				+ this.getFimMatricula() + ";"
				+ this.getDisciplinas().stream().map(String::valueOf).collect(Collectors.joining(",")) + ";");
	}
}