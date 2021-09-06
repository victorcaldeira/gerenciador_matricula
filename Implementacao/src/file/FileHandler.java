package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import entities.Curso;
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
	
	public static Usuario buscarUsuarioPeloLogin(int login) throws Exception {
		try {
			BufferedReader br = retorneBr("usuario/usuarios.txt");
			String[] resultado = null;
			while (br.ready()) {
				String linha = br.readLine();
				String[] parametros = linha.split(";");

				if (parametros[0].contains(String.valueOf(login))) {
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

	public static Curso buscarCurso(int id) throws Exception {
		BufferedReader br = retorneBr("curso/cursos.txt");
		Curso curso = null;

		while (br.ready()) {
			String linha = br.readLine();
			String[] parametros = linha.split(";");

			if (String.valueOf(id) == parametros[0]) {
				String[] disciplinaIds = parametros[5].split(",");
				ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
				for (String disciplinaId : disciplinaIds) {
					disciplinas.add(buscarDisciplina(Integer.parseInt(disciplinaId)));
				}
				curso = new Curso(Integer.parseInt(parametros[0]), parametros[1], Integer.parseInt(parametros[2]),
						LocalDate.parse(parametros[3]), LocalDate.parse(parametros[4]), disciplinas);
			}
		}
		if (curso == null) {
			throw new Exception("Curso não encontrado");
		}
		return curso;
	}

	public static void gravarNovoCurso(Curso curso) throws Exception {
		try {
			File arquivoCurso = buscarArquivo("curso/cursos.txt");
			FileWriter fw = new FileWriter(arquivoCurso, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(curso.toCsv());
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static Disciplina buscarDisciplina(int disciplinaId) throws Exception {
		BufferedReader br = retorneBr("disciplina/disciplinas.txt");
		Disciplina disciplina = null;

		while (br.ready()) {
			String linha = br.readLine();
			String[] parametros = linha.split(";");

			if (String.valueOf(disciplinaId) == parametros[0]) {
				int id = Integer.parseInt(parametros[0]);
				String nome = parametros[1];
				boolean optativa = Boolean.parseBoolean(parametros[2]);
				int vagas = Integer.parseInt(parametros[3]);
				boolean ativa = Boolean.parseBoolean(parametros[4]);
				disciplina = new Disciplina(id, nome, optativa, vagas, ativa);
			}
		}
		return disciplina;
	}
	
	public static void gravarDisciplina(Disciplina disciplina) throws Exception {
		try {
			File arquivoCurso = buscarArquivo("disciplina/disciplinas.txt");
			FileWriter fw = new FileWriter(arquivoCurso, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(disciplina.toCsv());
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private static BufferedReader retorneBr(String caminho) throws Exception {
		File arquivoUsuario = buscarArquivo(caminho);
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
