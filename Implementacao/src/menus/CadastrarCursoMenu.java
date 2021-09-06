package menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Curso;
import entities.disciplina.Disciplina;
import file.FileHandler;
import utils.IOClass;

public class CadastrarCursoMenu {
	public static Curso CadastrarCurso(Scanner in) throws Exception {
		try {
			int id, creditos, dia, mes, ano, idDisciplina = 0;
			String nome;
			LocalDate inicioMatricula, terminoMatricula;
			ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

			System.out.println("Digite o id do curso.");
			id = IOClass.lerInteiros(in);
			System.out.println("Digite o nome do curso.");
			nome = IOClass.lerStrings(in);
			System.out.println("Digite os creditos do curso.");
			creditos = IOClass.lerInteiros(in);
			System.out.println("Digite o dia de inicio de matricula do curso (1 a 31).");
			dia = IOClass.lerInteiros(in);
			System.out.println("Digite o mês de inicio da matricula do curso (1 a 12).");
			mes = IOClass.lerInteiros(in);
			System.out.println("Digite o ano de inicio da matricula do curso.");
			ano = IOClass.lerInteiros(in);

			inicioMatricula = LocalDate.of(ano, mes, dia);

			System.out.println("Digite o dia de fim de matricula do curso (1 a 31).");
			dia = IOClass.lerInteiros(in);
			System.out.println("Digite o mês de fim da matricula do curso (1 a 12).");
			mes = IOClass.lerInteiros(in);
			System.out.println("Digite o ano de fim da matricula do curso.");
			ano = IOClass.lerInteiros(in);

			terminoMatricula = LocalDate.of(ano, mes, dia);

			do {
				System.out.println("Digite o id das disciplina que sera adicionada ao curso (Digite 0 para sair).");
				try {
					idDisciplina = IOClass.lerInteiros(in);
					Disciplina disciplina = FileHandler.buscarDisciplina(idDisciplina);
					disciplinas.add(disciplina);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} while (idDisciplina != 0);

			Curso curso = new Curso(id, nome, creditos, inicioMatricula, terminoMatricula, disciplinas);
			return curso;
		} catch (Exception e) {
			throw new Exception("Falha ao cadastrar curso");
		}

	}
}
