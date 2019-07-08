public class Articulo {
   private int codigo;
   private String descripcion;
   private Proveedor proveedor;
   private double precioCompra;
   private double margen; //es un porcentaje, me lo dan.
   private double precioVenta; //lo saco a partir del margen.
   private Stock stock;  //El artìculo tiene un stock.

   //Constructor Articulo:
   public Articulo(int codigo, String descripcion, Proveedor proveedor, 
		   double precioCompra, double margen, Stock stock){
   this.codigo=codigo;
   this.descripcion=descripcion;
   this.proveedor=proveedor;
   this.precioCompra=precioCompra;
   this.margen=margen;
   this.precioVenta=(this.precioCompra+((this.precioCompra*this.margen)/100)); //Aca calculo el precio de venta sumandolo el precio compra y el margen que quiero ganar.
   this.stock=stock;
   } 
   
   public void disminuirStock(int cantidad){
	   //Voy a stock. existencia y la disminuyo con la cantidad que se pidio:
	   this.stock.setExistencia(this.stock.getExistencia()-cantidad);
   }

   public String toString(){
	   return "Codigo Prod.: "+this.codigo+". Descripcion: "+this.descripcion+". Precio Compra: "+this.precioCompra+".Precio Venta: "+this.precioVenta;
   }
   //Tambien podrìa hacer un toString para Stock y Proveedor y mostrarlo arriba.
   
   //Getters y setters que necesito:
   public Stock getStock() {return stock;}
   public void setStock(Stock stock) {this.stock = stock;}
   public String getDescripcion() {return descripcion;}
   public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
   public double getPrecioCompra() {return precioCompra;}
   public void setPrecioCompra(double precioCompra) {this.precioCompra = precioCompra;}
   public double getPrecioVenta() {return precioVenta;}
   public void setPrecioVenta(double precioVenta) {this.precioVenta = precioVenta;}
}