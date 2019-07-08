package com.company;

public class ControladorSCVF {
	
    public static void enviarCodigo(String numSubte, String comando) {
    	//Traducir comando a codigo y enviarlo al SCVF
    	
    	String codigo;
    	
    	switch(comando) {
    	
    	case "Frenar":
    		codigo = "C3PO";
    		break;
    	
    	case "Abrir Puerta":
    		codigo = "ASDKJ";
    		break;
    	
    	default:
    		codigo = "ERROR";
    	}
    	
    	System.out.println("Comando: "+comando+" - Codigo: "+codigo+" - Subte Num "+numSubte);
    	//enviarAccionSCVF(numSubte, codigo);
    }

}
