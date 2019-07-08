package ATM;

import java.util.Scanner;

public class ATM {
	private int reservas;
	private static Tarjeta tarjetaActual;
	private boolean interruptor;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int transaccion;
		
		if(iniciarSesion()) {
			
			do{
				transaccion = menuTransacciones();
				
				switch(transaccion) {
				case 0:
					break;
				case 1:
					retirarDinero();
					break;
				default:
					System.out.println(transaccion+" no es una transaccion valida.");
				}
			}while(transaccion!=0);
			
			cerrarSesion();
			reader.close();
		}
	}
	
	public static int menuTransacciones() {
		//Presenta un menu al usuario y retorna la opcion elegida
		
		int eleccion;
		Scanner reader = new Scanner(System.in);
		System.out.println("\nMenu de transacciones \n \n1 - Retirar dinero \n0 - Cerrar Sesion\n");
		System.out.print("Ingrese transaccion: ");
		eleccion = reader.nextInt();

		
		return eleccion;
	}

	public static boolean iniciarSesion() {
		// Retorna true si el usuario inicia sesion y false si no lo hace
		
		int intentos = 0;
		int intentosMax = 3;
		boolean accesoPermitido = false;
		String pin = "";
		Scanner reader = new Scanner(System.in);
		
		//Peticion de tarjeta
		
		System.out.print("Ingrese su tarjeta: ");
    	String nroTarjeta = reader.nextLine();
    	
    	if(InterfazBanco.tarjetaValida(nroTarjeta)) {
    		//Peticion de PIN
        	
        	do {
        		intentos++;
        	
        		if(intentos>1) {
        			System.out.println("PIN Incorrecto. Tiene "+(intentosMax+1-intentos)+" intento(s) restantes.");
        		}
        	
        		System.out.print("Ingrese su PIN: ");
        		pin = reader.nextLine();
        		
        		Logger.crearEntrada(); //Se crea una entrada en el log
        	} while(!validarPin(nroTarjeta, pin) && intentos<intentosMax);
        	
        	
        	// Determinacion del resultado
        	
        	if(!validarPin(nroTarjeta, pin)){//El usuario se quedo sin intentos
        		System.out.print("Se ha quedado sin intentos. Su tarjeta será retenida.");
        		retenerTarjeta();
        		Logger.crearEntrada(); //Se crea una entrada en el log
        	}
        	else {//El usuario pudo ingresar. Se carga la tarjeta en la variable tarjetaActual
        		accesoPermitido = true;
        		tarjetaActual = new Tarjeta();
        		tarjetaActual.setNumero(nroTarjeta);
        		tarjetaActual.setCuentas(InterfazBanco.obtenerCuentas(nroTarjeta));
        		
        		System.out.println("\n¡Bienvenido!");
        		Logger.crearEntrada(); //Se crea una entrada en el log
        	}
    	}
    	else {
    		System.out.println("Tarjeta inexistente.");
    	}
    	
    	//Retorno del acceso
    	
    	return accesoPermitido;
	}
	
	public static boolean validarPin(String usuario, String pin) {
		return InterfazBanco.verificarPIN(usuario, pin);
	}
	
	public static void cerrarSesion() {
		//Borra los datos de la tarjeta actual y crea una entrada en el log
		
		tarjetaActual = new Tarjeta();
		System.out.println("\nFin de la sesion.");
		Logger.crearEntrada();
	}
	
	public static void retirarDinero() {
		//El usuario retira dinero de una cuenta vinculada a su tarjeta
		
		Scanner reader = new Scanner(System.in);
		String cuentaIngresada;
		int montoRetirado;
		
		System.out.println("\nCuentas:"); //Le mostramos al usuario sus cuentas
		
		for(String cuenta:tarjetaActual.cuentas) {
			System.out.println("* "+cuenta);
		}
		
		// Eleccion de cuenta
		
		do {
			System.out.print("Seleccione cuenta (0 para cancelar): ");
			cuentaIngresada = reader.nextLine();
		}while(!validarCuenta(cuentaIngresada) && !cuentaIngresada.equals("0"));
		
		if(cuentaIngresada.equals("0")) { //El usuario cancelo la transaccion
			abortarTransaccion();
			return;
		}
		
		//Ingreso de monto
		
		do {
			System.out.print("\nIngrese monto a retirar (0 para cancelar): ");
			montoRetirado = reader.nextInt();
		}while(!esMultiploDe20(montoRetirado));
		
		if(montoRetirado==0){ //El usuario cancelo la transaccion
			abortarTransaccion();
			return;
		}
		
		//Validacion de monto y efectivizacion de la transaccion
		
		if(InterfazBanco.validarMonto(montoRetirado, cuentaIngresada)){
			InterfazBanco.retirarDinero(montoRetirado, cuentaIngresada);
			System.out.println("\nOperacion exitosa.");
			Logger.crearEntrada();
		}
		else {
			System.out.println("\nSaldo insuficiente.");
		}
	}
	
	public static boolean esMultiploDe20(int monto) {
		return (monto%20)==0;
	}
	
	public static boolean validarCuenta(String cuentaIngresada) {
		//Valida que la cuenta ingresada sea realmente una cuenta de la tarjeta
		
		boolean valida = false;
		
		for(String cuenta:tarjetaActual.cuentas) {
			if(cuentaIngresada.equals(cuenta)) {
				valida = true;
			}
		}
		
		return valida;
	}
	
	public static void abortarTransaccion() {
		//Cancelada la transaccion crea una entrada en el log
		
		Logger.crearEntrada();
		System.out.println("Transaccion cancelada");
	}
	
	public void depositarDinero() {
		
	}
	public void transferirDinero() {
		
	}
	public void consultarSaldo() {
		
	}
	public boolean isInterruptor() {
		return interruptor;
	}
	public void setInterruptor(boolean interruptor) {
		this.interruptor = interruptor;
	}
	public int getReservas() {
		return reservas;
	}
	public void setReservas(int reservas) {
		this.reservas = reservas;
	}
	public void encenderATM() {
		
	}
	public void apagarATM() {
		
	}
	public static void retenerTarjeta() {
		
	}
	
}

/*

Prueba con tarjeta Existente:

Ingrese su tarjeta: 123
Ingrese su PIN: 2525
Â¡Bienvenido!
Menu de transacciones 
1 - Retirar dinero 
0 - Cerrar Sesion
Ingrese transaccion: 1
Cuentas:
* Cuenta 1
* Cuenta 2
* Cuenta 3
Seleccione cuenta (0 para cancelar): Cuenta 1
Ingrese monto a retirar (0 para cancelar): 200
Operacion exitosa.

Menu de transacciones 
1 - Retirar dinero 
0 - Cerrar Sesion
Ingrese transaccion: 0
Fin de la sesion.

*/