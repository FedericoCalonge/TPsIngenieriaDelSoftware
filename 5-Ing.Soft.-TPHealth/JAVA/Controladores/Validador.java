package Controladores;

import Excepciones.ExcepcionNoNumerico;

public class Validador {
	public static void validarValoresNumericos(String valor) throws ExcepcionNoNumerico{
		try{
			new Integer(valor);
		} catch(Exception e){
			throw new ExcepcionNoNumerico();
		}
	}
}