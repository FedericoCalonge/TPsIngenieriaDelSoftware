package Excepciones;
public class ExcepcionNoNumerico extends Exception {
	private static final long serialVersionUID = 1945817068908922323L;

	public ExcepcionNoNumerico(){
		super("El valor ingresado no es numerico.");
	}
}
