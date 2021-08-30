package utils;

import entities.usuario.Aluno;
import entities.usuario.Professor;
import entities.usuario.Usuario;
import enums.TipoUsuario;

public class GetTipoUsuario {

	public static int getTipoUsuario(Usuario usuario) {
		if(usuario instanceof Aluno) {
			return TipoUsuario.ALUNO.getValor();
		}
		if(usuario instanceof Professor) {
			return TipoUsuario.PROFESSOR.getValor();
		}
		return TipoUsuario.SECRETARIA.getValor();
	}
}
