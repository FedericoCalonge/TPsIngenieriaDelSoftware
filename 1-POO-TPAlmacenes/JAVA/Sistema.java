public class Sistema {
	private Cliente cliente;
	private Articulo articulo;
	private int cantidad;
	
	//Constructor Sistema:
	public Sistema(Cliente cliente, Articulo articulo, int cantidad){
		this.cliente=cliente;
		this.articulo=articulo;
		this.cantidad=cantidad;
	}
	
	//Al hacer el pedido, resto el stock (la existencia) --> SI se puede hacer--> PUEDE QUEDAR NEGATIVO!
	public void pedir(){
		//Primero que todo disminuyo el stock:
		this.articulo.disminuirStock(this.cantidad);
		//Aca controlo si NO hay stock disponible o si la existencia es menor a la reserva.
		//No hay stock si la reserva <0:
		if (this.articulo.getStock().getExistencia()<0){
			System.out.println("No hay Stock/Existencia disponible de: "+this.articulo.getDescripcion()+".");
		}
		//Si hay stock de reserva...
		else{  
			//Pero la existencia es menor a la reserva...
			if( (this.articulo.getStock().getExistencia())<(this.articulo.getStock().getReserva()) ){
				System.out.println("Quedan pocos del articulo: " +this.articulo.getDescripcion() + " en Existencia/Stock");
			}
		}
	}
	//Aca solo imprimo el cliente, el articulo que se pidio, y el TOTAL que lo calculo aparte: 
	public void cobrar(){
		System.out.println("El cliente "+this.cliente.toString()+" pidio una cantidad de "+this.cantidad+" del articulo "+this.articulo.toString());
		System.out.println(". El total a cobrar es: "+this.total());				
	}
	//Si tengo tiempo hacer TOstring en articulo.
	
	public double total(){
		//Creo variables locales para mayor entendimiento:
		double precioventa=this.articulo.getPrecioVenta();
		double descuento1cliente=this.cliente.getDescuento1();
		double descuento2cliente=this.cliente.getDescuento2();
		return(this.cantidad*precioventa*(1-descuento1cliente/100)*(1-descuento2cliente/100)); //cantidad*precioventa*0.8(si el descuento es del 20%)*0.5(si el descuento es del 50%).
	}
	
}
