package menus;

import java.util.Scanner;

import entities.disciplina.Disciplina;
import entities.usuario.Professor;
import file.FileHandler;
import utils.IOClass;

public class CadastrarDisciplinaMenu {
	public static Disciplina CadastrarDisciplina(Scanner in) {
		int id, vagas, matriculaProfessor, opcao;
		String nome;
		boolean optativa;
		Disciplina disciplina = null;
		Professor professor = null;

		try {
			System.out.println("Digite o Id da disciplina");
			id = IOClass.lerInteiros(in);

			disciplina = FileHandler.buscarDisciplina(id);

			if (disciplina != null) {
				throw new Exception("Id já em uso por outra disciplina");
			}

			System.out.println("Digite o nome da disciplina");
			nome = IOClass.lerStrings(in);

			System.out.println("Digite a matricula do professor que irá lessionar a disciplina");
			matriculaProfessor = IOClass.lerInteiros(in);

			professor = (Professor) FileHandler.buscarUsuarioPeloLogin(matriculaProfessor);

			if (professor == null) {
				throw new Exception("Professor não encontrado");
			}

			System.out.println("Digite se a disciplina é optativa. (1 para sim, 2 para não)");
			opcao = IOClass.lerInteiros(in);

			optativa = opcao == 1;

			System.out.println("Digite a quantidade de vagas da disciplina");
			vagas = IOClass.lerInteiros(in);

			disciplina = new Disciplina(id, nome, optativa, vagas, true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return disciplina;
	}
}
