public class Proveedor extends Empresa{
	//No agrega mas Variables de Instancia, solo tiene las que hereda.
	
    //Hago el constructor llamando al constructor de Empresa (la superclase):
	public Proveedor(String nombre, String direccion, int telefono, String cuil){
		super(nombre, direccion, telefono, cuil);
	}
}
