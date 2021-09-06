package menus;

import java.util.Scanner;

import entities.Curso;
import entities.disciplina.Disciplina;
import entities.usuario.Secretaria;
import file.FileHandler;
import utils.IOClass;

public class MenuSecretaria {
	public static void MetodosSecretaria(Scanner in, Secretaria secretaria) throws Exception {
		int opcao = 0;
		do {
			System.out.println("Escolha entre uma das opcoes.");
			System.out.println("0 - Sair do menu");
			System.out.println("1 - Cadastrar novo curso");
			System.out.println("2 - Cadastrar nova disciplina");
			opcao = IOClass.lerInteiros(in);
			
			if(opcao == 1) {
				Curso curso = CadastrarCursoMenu.CadastrarCurso(in);
				FileHandler.gravarNovoCurso(curso);
			}
			if(opcao == 2) {
				Disciplina disciplina = CadastrarDisciplinaMenu.CadastrarDisciplina(in);
				FileHandler.gravarDisciplina(disciplina);
			}
		} while(opcao != 0);
	}
}
