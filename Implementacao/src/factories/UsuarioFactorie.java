package factories;

import entities.usuario.Aluno;
import entities.usuario.Professor;
import entities.usuario.Secretaria;
import entities.usuario.Usuario;

public class UsuarioFactorie {
	public static Usuario CriarUmTipoUsuario(int matricula, String senha, String nome, int origem, int tipo) {
		switch (tipo) {
		case 0: {
			return new Aluno(matricula, senha, nome, origem);
		}
		case 1: {
			return new Professor(matricula, senha, nome, -1);
		}
		default:
			return new Secretaria(matricula, senha, nome, -1);
		}
	}
}
