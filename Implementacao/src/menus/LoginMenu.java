package menus;

import java.util.Scanner;

import utils.IOClass;

public class LoginMenu {
	public static int loginMenu(Scanner in) {
		System.out.println("Digite seu login (apenas numeros).");
		try {
			int login = IOClass.lerInteiros(in);
			System.out.println(login);
			return login;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
			return -1;
		}
	}
}
