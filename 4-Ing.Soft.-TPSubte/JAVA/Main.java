package com.company;

public class Main {
	
    public static void main(String[] args) {
    	Maquinista jorgeF = new Maquinista("523", "jorge", "flores");
        Subte formacion = new Subte('C', "1234", jorgeF, 1400, "Constitucion");

        reportarPosicion(formacion); //Buscamos y validamos posicion de un subte
        informarAccion(formacion, "Abrir Puerta"); //Enviamos instruccion a un subte
        formacion.ingresarComando(); //(Solo a modo de prueba) Subte realiza accion
    }

    private static void reportarPosicion(Subte formacion){

        float kmActual = formacion.getKilometraje();
        System.out.println("km actual: " + kmActual);

        String estacionActual = buscarEstacion(kmActual);
        System.out.println("estacion actual: "+ estacionActual);

        boolean verificado = verificarPosicion(estacionActual);
        System.out.println("verificado: "+verificado);

        //enviarASGC(formacion, estacionActual);
    }

    private static String buscarEstacion(float kilometraje){

        //Mapa

        String[]distanciasEstaciones = {"Constitucion", "San Juan", "Independencia", "Av de Mayo", "Diagonal Norte"};
        float[] distancias = {0, 800, 1400, 2100, 2700};

        String estacionActual = "Ninguna / En Trayecto";


        //Consulta de Mapa

        for(int i=0; i< 4; i++){
            if (kilometraje == distancias[i]){
                    estacionActual = distanciasEstaciones[i];
            }
        }

        return estacionActual;
    }

    private static boolean verificarPosicion(String estacionActual){

        //Base de Datos

        SensorEstacion sensorSJ = new SensorEstacion("San Juan", false);
        SensorEstacion sensorI = new SensorEstacion("Independencia", true);

        //Funcion


        boolean hayTren;

        switch (estacionActual){

            case "San Juan":
                hayTren = sensorSJ.getHayTren();
                break;

            case "Independencia":
                hayTren = sensorI.getHayTren();
                break;

            default:
                hayTren = false;
                break;
        }

        return hayTren;
    }
    
    public static void informarAccion(Subte formacion, String comando) {
    	//Enviar comando desde el Sistema de Control
    	
    	ControladorSCVF.enviarCodigo(formacion.getNumero(), comando);
    }

}