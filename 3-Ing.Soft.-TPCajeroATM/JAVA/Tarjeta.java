package ATM;

public class Tarjeta {
	public String numero;
	public String[] cuentas;
	
	public Tarjeta() {
		super();
	}
	
	public Tarjeta(String numero, String[] cuentas) {
		super();
		this.numero = numero;
		this.cuentas = cuentas;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String[] getCuentas() {
		return cuentas;
	}
	public void setCuentas(String[] cuentas) {
		this.cuentas = cuentas;
	}
}

