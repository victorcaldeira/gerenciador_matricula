package entities.usuario;

import java.time.LocalDate;
import java.util.ArrayList;

import entities.Curso;
import entities.disciplina.Disciplina;

public class Secretaria extends Usuario {

	// Construtor da classe Secretaria
	public Secretaria(int matricula, String senha, String nome, int origem) {
		super(matricula, senha, nome, origem);
	}

	public Curso gerarCurriculoCurso(String nome, int creditos, LocalDate inicioMatricula, LocalDate terminoMatricula,
			ArrayList<Disciplina> listaDisciplinas) {
		return new Curso(nome, creditos, terminoMatricula, terminoMatricula, listaDisciplinas);
	}

	public Disciplina criarNovaDisciplina(String nome, boolean optativa, int vagas, boolean ativa) {
		return new Disciplina(nome, ativa, vagas, ativa);
	}
}