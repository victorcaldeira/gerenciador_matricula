package enums;

public enum TipoUsuario {
	ALUNO(0), PROFESSOR(1), SECRETARIA(2);

	private final int valor;
	TipoUsuario(int i) {
		valor = i;
	}
	
	public int getValor() {
		return this.valor;
	}
}
