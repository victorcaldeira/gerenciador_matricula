import entities.usuario.Aluno;
import file.FileHandler;

public class Main {

	public static void main(String[] args) throws Exception {
		// Sprint 4 escrever menus e serializar Classe curso e Disciplina
		Aluno pedro = new Aluno(123456, "senha", "Pedro", 1);

		try {
			FileHandler.gravarNovoUsuario(pedro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
