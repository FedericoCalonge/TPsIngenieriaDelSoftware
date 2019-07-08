package com.company;

import java.util.Scanner;

public class Subte {

    private char linea;
    private String numero;
    private Maquinista conductor;
    private float kilometraje;
    private String estacionInicial;

    public Subte(char linea, String numero, Maquinista conductor, float kilometraje, String estacionInicial) {
        this.linea = linea;
        this.numero = numero;
        this.conductor = conductor;
        this.kilometraje = kilometraje;
        this.estacionInicial = estacionInicial;
    }

    public char getLinea() {
        return linea;
    }

    public void setLinea(char linea) {
        this.linea = linea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }



    public Maquinista getConductor() {
		return conductor;
	}

	public void setConductor(Maquinista conductor) {
		this.conductor = conductor;
	}

	public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstacionInicial() {
        return estacionInicial;
    }

    public void setEstacionInicial(String estacionInicial) {
        this.estacionInicial = estacionInicial;
    }

    public void ingresarComando() {
    	//Enviar comando desde el Subte
    	
    	Scanner reader = new Scanner(System.in);
    	System.out.println("Ingresar comando: ");
    	
    	String comando = reader.nextLine();
    	reader.close();
    	
    	ControladorSCVF.enviarCodigo(this.getNumero(), comando);
    }
    
    @Override
    public String toString() {
        return "Formacion #"+this.numero+" - Linea "+this.linea+".";
    }
}
