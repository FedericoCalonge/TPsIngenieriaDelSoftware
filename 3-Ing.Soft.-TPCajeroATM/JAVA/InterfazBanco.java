package ATM;

public class InterfazBanco {
	
	public static String pinTarjeta(String usuario){
		String pinTarjeta = "";
		
		/*Esta funcion busca el pin de la tarjeta del usuario en la base de datos
		del banco. Retorna una cadena vacia si no hay coincidencia.*/
		
		//Base de datos
		
		String[] usuarios = {"123", "124", "111"};
		String[] pines = {"2525", "9999", "1111"};
		
		//Consulta
		
		for(int i=0; i<3; i++){
            if (usuario.equals(usuarios[i])){
                    pinTarjeta = pines[i];
            }
        }
		
		return pinTarjeta;
	}
	
	public static boolean verificarPIN(String usuario, String pinIngresado){
		/*Recibe el numero de la tarjeta y el pin ingresado por el usuario para
		compararlo con el pin real mediante una consulta al banco*/
		
		String pinTarjetaBanco = pinTarjeta(usuario);
		
		return pinIngresado.equals(pinTarjetaBanco);
	}
	
	public static boolean tarjetaValida(String nroTarjeta) {
		/* Recibe un numero de tarjeta y retorna true si la tarjeta existe
		 * dentro de la base de datos. Caso contrario retorna false.
		 */
		
		boolean existe = false;
		
		//Base de datos
			String[] usuarios = {"123", "124", "111"};
				
			for(String aux:usuarios) {
				if (aux.equals(nroTarjeta)) {
					existe = true;
				}
			}
		
		return existe;
	}
	
	public static boolean validarMonto(int monto, String cuenta){
		/*Verifica que la cuenta tenga saldo suficiente. En este caso, a fines practicos,
		siempre retorna true.*/
		
		return true;
	}

	public static String[] obtenerCuentas(String nroTarjeta) {
		/* Recibe un numero de tarjeta y retorna un array de cuentas vinculado a la
		 * tarjeta. En este caso, a fines practicos, retorna el mismo array para todas
		 * las tarjetas.
		 */
		
		return new String[] {"Cuenta 1", "Cuenta 2", "Cuenta 3"};
	}

	public static void retirarDinero(int montoRetirado, String cuentaIngresada) {
	}
}