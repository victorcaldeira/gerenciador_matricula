package menus;

import java.util.Scanner;

import entities.Curso;
import entities.usuario.Aluno;
import file.FileHandler;
import utils.IOClass;

public class MenuAluno {
	public static void MatriculaMenu(Scanner in, Aluno aluno) {
		int cursoId = 0;
		System.out.println("Digite os id do curso que você deseja se matricular. (0 para sair)");
		do {
			try {
				cursoId = IOClass.lerInteiros(in);

				if (cursoId != 0) {

					Curso curso = FileHandler.buscarCurso(cursoId);

					aluno.matricular(curso);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (cursoId != 0);
	}
}
