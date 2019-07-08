public class Empresa{
    private String nombre; //Nombre de la empresa
    private String direccion;
    private int telefono;
    private String cuil;
    
    public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;	}
	public String getDireccion() {return direccion;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	public int getTelefono() {return telefono;}
	public void setTelefono(int telefono) {this.telefono = telefono;}
	public String getCuil() {return cuil;}
	public void setCuil(String cuil) {this.cuil = cuil;}

	//Los Constructores sirven para darles un valor inicial los atributos de las Clases.
    //Constructor Empresa:
    public Empresa(String nombre, String direccion, int telefono, String cuil){
    	this.nombre=nombre; //con this.nombre hago referencia a mi VI (variable de instancia) nombre --> this es para eliminar la "ambiguedad"
    	this.direccion=direccion;
    	this.telefono=telefono;
    	this.cuil=cuil;
    }
    
    public String toString(){
    	return "Nombre: "+this.getNombre()+". Direccion: "+this.getDireccion()+". Numero "+this.getTelefono()+". CUIL: "+this.getCuil();
    }

}