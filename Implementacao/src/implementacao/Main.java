package implementacao;

import java.util.Scanner;

import entities.usuario.Aluno;
import entities.usuario.Professor;
import entities.usuario.Secretaria;
import entities.usuario.Usuario;
import file.FileHandler;
import menus.LoginMenu;
import menus.MenuAluno;
import menus.MenuProfessor;
import menus.MenuSecretaria;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Usuario usuario = null;

		try {
			do {
				usuario = LoginMenu.loginMenu(in);

				if (usuario instanceof Aluno) {
					MenuAluno.MatriculaMenu(in, (Aluno) usuario);
				}

				if (usuario instanceof Secretaria) {
					MenuSecretaria.MetodosSecretaria(in, (Secretaria) usuario);
				}

				if (usuario instanceof Professor) {
					MenuProfessor.ListarAlunosDisciplinas(in, (Professor) usuario);
				}
			} while (usuario == null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
