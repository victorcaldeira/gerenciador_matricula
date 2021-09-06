package menus;

import java.util.Scanner;

import entities.usuario.Usuario;
import file.FileHandler;
import utils.IOClass;

public class LoginMenu {
	public static Usuario loginMenu(Scanner in) {
		try {
			System.out.println("Digite seu login (apenas numeros).");
			int login = IOClass.lerInteiros(in);
			System.out.println("Digite sua senha.");
			String senha = IOClass.lerStrings(in);
			return FileHandler.buscarUsuario(login, senha);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
