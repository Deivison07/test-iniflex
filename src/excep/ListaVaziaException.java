package excep;

public class ListaVaziaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ListaVaziaException(String mensagem) {
		super(mensagem);
	}
}
