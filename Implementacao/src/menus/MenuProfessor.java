package menus;

import java.util.Scanner;

import entities.disciplina.Disciplina;
import entities.usuario.Professor;
import file.FileHandler;
import utils.IOClass;

public class MenuProfessor {
	public static void ListarAlunosDisciplinas(Scanner in, Professor professor) {
		try {
			System.out.println("Digite o id da disciplina para listar os alunos matriculados.");
			int id = IOClass.lerInteiros(in);
			
			Disciplina disciplina = FileHandler.buscarDisciplina(id);
			
			disciplina.getAlunosMatriculados();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
