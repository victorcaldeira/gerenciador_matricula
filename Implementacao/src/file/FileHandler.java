package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import entities.disciplina.Disciplina;
import entities.usuario.Usuario;
import factories.UsuarioFactorie;
import utils.GetTipoUsuario;

public class FileHandler {

	public static Usuario buscarUsuario(int login, String senha) throws Exception {
		try {
			BufferedReader br = retorneBr("usuario/usuarios.txt");
			String[] resultado = null;
			while (br.ready()) {
				String linha = br.readLine();
				String[] parametros = linha.split(";");

				if (parametros[0].contains(String.valueOf(login)) && parametros[1].contains(senha)) {
					resultado = parametros;
					break;
				}
			}
			br.close();
			if (resultado == null) {
				return null;
			}

			Usuario usuarioRetorno = UsuarioFactorie.CriarUmTipoUsuario(Integer.parseInt(resultado[0]), resultado[1],
					resultado[2], Integer.parseInt(resultado[3]), Integer.parseInt(resultado[4]));
			return usuarioRetorno;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void gravarNovoUsuario(Usuario usuario) throws Exception {

		Usuario usuarioCadastrado = buscarUsuario(usuario.getMatricula(), usuario.getSenha());

		if (usuarioCadastrado != null) {
			throw new Exception("Matricula já em uso.");
		}
		try {
			File arquivoUsuario = buscarArquivo("usuario/usuarios.txt");
			FileWriter fw = new FileWriter(arquivoUsuario, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(usuario.toCsv());
			bw.write(GetTipoUsuario.getTipoUsuario(usuario) + ";");
			bw.newLine();
			bw.close();
		} catch (Exception error) {
			throw new Exception(error.getMessage());
		}

	}

//	public static Disciplina buscarDisciplina(int disciplinaId) throws Exception {
//		BufferedReader br = retorneBr("usuario/usuarios.txt");
//	}
	
	private static BufferedReader retorneBr(String caminho) throws Exception {
		File arquivoUsuario = buscarArquivo("usuario/usuarios.txt");
		FileReader fr = new FileReader(arquivoUsuario);
		return new BufferedReader(fr);
	}

	private static File buscarArquivo(String caminho) throws Exception {
		File arquivo = new File(caminho);
		if (arquivo.exists()) {
			return arquivo;
		} else {
			arquivo.createNewFile();
			return arquivo;
		}
	}
}
