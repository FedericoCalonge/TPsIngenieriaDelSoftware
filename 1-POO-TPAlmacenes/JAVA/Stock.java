
public class Stock {
	private int existencia;
	private int reserva; //Stock minimo.
	
	public int getExistencia() {return existencia;}
	public void setExistencia(int existencia) {this.existencia = existencia;}
	public int getReserva() {return reserva;}
	public void setReserva(int reserva) {this.reserva = reserva;}

	public Stock(int existencia, int reserva){
		this.existencia=existencia;
		this.reserva=reserva;
	}
}
