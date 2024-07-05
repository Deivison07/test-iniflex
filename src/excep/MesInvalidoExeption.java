package excep;

public class MesInvalidoExeption extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MesInvalidoExeption(String mensagem) {
		super(mensagem);
	}
}
