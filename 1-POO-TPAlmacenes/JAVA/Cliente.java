public class Cliente extends Empresa{
	private double descuento1;  
    private double descuento2;

    //Getters y setters:
    public double getDescuento1(){return descuento1;}
    public void setDescuento1(int descuento1){this.descuento1=descuento1;}
    public double getDescuento2() {return descuento2;}
	public void setDescuento2(int descuento2) {this.descuento2 = descuento2;}
	
	//Constructor Cliente
	public Cliente(String nombre, String direccion, int telefono, String cuil, int descuento1, int descuento2 ){
		super(nombre,direccion,telefono,cuil);
		this.descuento1=descuento1;
		this.descuento2=descuento2;
	}
	
	//Uso el toString de la superclase con super.toString():^
	public String toString(){
		return super.toString();
	}
	 
}
