package utils;

import java.util.Scanner;

public class IOClass {
	public static int lerInteiros(Scanner in) throws Exception {
		String entrada = in.nextLine();
		try {
			return Integer.parseInt(entrada);
		} catch (Exception e) {
			throw new Exception("Formato de login invalido, por favor tente novamente.");
		}
	}

	public static String lerStrings(Scanner in) throws Exception {
		String entrada = in.nextLine();
		return entrada;
	}
}
