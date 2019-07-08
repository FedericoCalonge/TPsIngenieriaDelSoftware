//Agregado teorico:
//Las clases me permiten ENCAPSULAR los estados (codificados en atributos) y el comportamiento (codificados en metodos)
//de cada una de estas. Y si tengo que modificar algun mètodo de la clase sòlo modifico este metodo y nada màs (Se logra mayor "eficiencia").
//Las clases tambien me permiten OCULTAR la informaciòn, por ejemplo a las V.I. (variables de instancia)
//cuando les pongo como metodo de acceso PRIVATE. Y para acceder a estos desde otra clase tengo que usar
//los mètodos getter/setter PUBLICOS para dicha V.I.

//Herencia:
//Cliente y Proveedor son subclases de Empresa. O sea que estos heredan las V.I. y los mètodos de Empresa.
//Ademàs pueden agregar nuevos metodos y nuevas V.I. como asì tambien SOBREESCRIBIR los metodos de Empresa
//para su propia implementacion. HERENCIA implica una relacion "es un" de la subclase a la superclase. 

//Con this.metodoòvariable referencio al metodo ò variable de mi propio objeto y con this() a mi propio constructor.
//Con super.metodoòvariable referencio al metodo ò variable de la superclase. Y con super() al constructor de la superclase.
//--> Por ej. en #Cliente hago super.toString(); y super(nombre,direccion,telefono,cuil); para el constructor. 

//Sobreescritura y sobrecarga:
//En este programa sobreescribi el metodo toString (que esta en Object) en #Articulo y en #Cliente para que me muestren sus datos
//Al sobreescribir implemento un metodo en la SUBCLASE con la misma firma.
//La diferencia con sobrecargar, es que esto se hace dentro de la MISMA clase, donde el metodo tiene distinta firma 
//(tiene igual tipo de retorno e igual nombre pero cambian los tipos y la cantidad de sus parametros).
//Si quiero implementar un equals para comparar dos fechas, voy a usar sobrecarga seguramente.

public class TestMain {
	public static void main(String[] args) {
		//FINAL porque van a ser constantes, no van a cambiar.
		final int topeProveedor=2;
		final int topeCliente=2;
		final int topeStock=3;
		final int topeArticulo=3;
		final int topePedidos=3; //Es el tope del sistema donde hago los pedidos
		
		//Empresa y proveedor --> nombre, direccion, telefono, cuil (En String mejor dijo el profe). 
		Proveedor proveedores[]=new Proveedor[topeProveedor];
		proveedores[0]=new Proveedor("Imanols Inc.","Winskonsin 1344",42345652,"20545735632"); 
		proveedores[1]=new Proveedor("Suarezs Inc.", "Jorge 3000",42910830,"20643634632");
		
		//Cliente --> igual que Empresa y Proveedor + desc1 y desc2.
		Cliente clientes[]=new Cliente[topeCliente];
		clientes[0]=new Cliente("Federicio Inc.", "Washington 4323", 42345656, "2035964532",50,30);
		clientes[1]=new Cliente("FootballClub", "Alsina 23", 42353465, "2035564532",20,30); 
				
		//Stock -->existencia y reserva.
		Stock stocks[]=new Stock[topeStock];
		stocks[0]=new Stock(100,10); //Stock de mesas
		stocks[1]=new Stock(50,5);   //Stock PCs escritorio
		stocks[2]=new Stock(100,10); //Stock Notebooks  
		
		//Articulo--> codigo int, descripcion, proveedor, precioCompra, margen float, stock.
		Articulo articulos[]=new Articulo[topeArticulo];
		articulos[0]=new Articulo(01, "Mesa Ratona",proveedores[0],1000,10,stocks[0]);
		articulos[1]=new Articulo(02, "PC Escritorio",proveedores[0],5000,10,stocks[1]);
		articulos[2]=new Articulo(03, "Notebook",proveedores[0],12000,10,stocks[2]);
		
		//Sistema donde hago los pedidos-->Cliente, articulo, cantidad.
		Sistema sistema[]=new Sistema[topePedidos];
		sistema[0]=new Sistema(clientes[0],articulos[0],100);
		sistema[1]=new Sistema(clientes[1],articulos[1],50);
		sistema[2]=new Sistema(clientes[0],articulos[2],500);
	 
		sistema[0].pedir(); //Imprimo el articulo con las alertas
		sistema[1].pedir();
		sistema[2].pedir();
		
		sistema[0].cobrar(); //Imprimo el cliente, articulo y el TOTAL.
		sistema[1].cobrar();
		sistema[2].cobrar();
		}
}

/*Prueba de ejecucion:
Quedan pocos del articulo: Mesa Ratona en Existencia/Stock
Quedan pocos del articulo: PC Escritorio en Existencia/Stock
No hay Stock/Existencia disponible de: Notebook.
El cliente Nombre: Federicio Inc.. Direccion: Washington 4323. Numero 42345656. CUIL: 2035964532 pidio una cantidad de 100 del articulo Codigo Prod.: 1. Descripcion: Mesa Ratona. Precio Compra: 1000.0.Precio Venta: 1100.0
. El total a cobrar es: 38500.0
El cliente Nombre: FootballClub. Direccion: Alsina 23. Numero 42353465. CUIL: 2035564532 pidio una cantidad de 50 del articulo Codigo Prod.: 2. Descripcion: PC Escritorio. Precio Compra: 5000.0.Precio Venta: 5500.0
. El total a cobrar es: 154000.0
El cliente Nombre: Federicio Inc.. Direccion: Washington 4323. Numero 42345656. CUIL: 2035964532 pidio una cantidad de 500 del articulo Codigo Prod.: 3. Descripcion: Notebook. Precio Compra: 12000.0.Precio Venta: 13200.0
. El total a cobrar es: 2310000.0
*/
