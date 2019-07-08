package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador;
import Controladores.Validador;
import Excepciones.ExcepcionNoNumerico;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CargaDenunciaComida extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTelefonoD;
	private JTextField textFieldProvinciaD;
	private JTextField textFieldDistritoD;
	private JTextField textFieldCalleD;
	private JTextField textFieldNombreDenunciante;
	private JTextField textFieldNumeroD;
	private JTextField textFieldCiudadD;
	private JTextField textFieldCodigoPostalD;
	private JTextField textFieldTelefonoV;
	private JTextField textFieldCodigoPostalV;
	private JTextField textFieldProvinciaV;
	private JTextField textFieldDistritoV;
	private JTextField textFieldNumeroV;
	private JTextField textFieldCiudadV;
	private JTextField textFieldCalleV;
	private JTextField textFieldNombreVictima;
	private JTextField textFieldCantVictimas;
	private JTextField textFieldCantEnfermos;
	private JTextField textFieldCantMuertos;
	private JTextField textFieldTelefonoH;
	private JTextField textFieldCodigoPostalH;
	private JTextField textFieldDistritoH;
	private JTextField textFieldProvinciaH;
	private JTextField textFieldCiudadH;
	private JTextField textFieldNumeroH;
	private JTextField textFieldCalleH;
	private JTextField textFieldComida;
	private JTextField textFieldCantInternados;

	
	public static void main(String[] args) {
		try {
			CargaDenunciaComida dialog = new CargaDenunciaComida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CargaDenunciaComida() {
		setTitle("Denuncia Comidas");
		setBounds(300, 0, 670, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDescripciones = new JLabel("Descripciones (*):");
			lblDescripciones.setBounds(25, 40, 114, 20);
			lblDescripciones.setFont(new Font("Calibri", Font.BOLD, 14));
			contentPanel.add(lblDescripciones);
		}
		{
			JLabel lblObservaciones = new JLabel("Observaciones:");
			lblObservaciones.setBounds(25, 105, 103, 20);
			lblObservaciones.setFont(new Font("Calibri", Font.BOLD, 14));
			contentPanel.add(lblObservaciones);
		}
		
		JLabel lblDatosDenunciante = new JLabel("* DATOS DENUNCIANTE");
		lblDatosDenunciante.setBounds(10, 11, 148, 20);
		lblDatosDenunciante.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		contentPanel.add(lblDatosDenunciante);
		
		JTextArea textAreaDescripciones = new JTextArea();
		textAreaDescripciones.setBounds(138, 40, 480, 60);
		textAreaDescripciones.setFont(new Font("Calibri", Font.BOLD, 14));
		textAreaDescripciones.setLineWrap(true);
		contentPanel.add(textAreaDescripciones);
		
		JTextArea textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setBounds(138, 105, 480, 60);
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(textAreaObservaciones);
		
		textFieldTelefonoD = new JTextField();
		textFieldTelefonoD.setBounds(364, 270, 254, 20);
		textFieldTelefonoD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTelefonoD.setColumns(10);
		contentPanel.add(textFieldTelefonoD);
		
		textFieldProvinciaD = new JTextField();
		textFieldProvinciaD.setBounds(364, 245, 254, 20);
		textFieldProvinciaD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldProvinciaD.setColumns(10);
		contentPanel.add(textFieldProvinciaD);
		
		textFieldDistritoD = new JTextField();
		textFieldDistritoD.setBounds(364, 220, 254, 20);
		textFieldDistritoD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldDistritoD.setColumns(10);
		contentPanel.add(textFieldDistritoD);
		
		textFieldCalleD = new JTextField();
		textFieldCalleD.setBounds(87, 195, 531, 20);
		textFieldCalleD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCalleD.setColumns(10);
		contentPanel.add(textFieldCalleD);
		
		textFieldNombreDenunciante = new JTextField();
		textFieldNombreDenunciante.setBounds(170, 170, 448, 20);
		textFieldNombreDenunciante.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNombreDenunciante.setColumns(10);
		contentPanel.add(textFieldNombreDenunciante);
		
		JLabel label_3 = new JLabel("Nombre Denunciante:");
		label_3.setBounds(25, 170, 137, 20);
		label_3.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Calle:");
		label_4.setBounds(25, 195, 103, 20);
		label_4.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Numero:");
		label_5.setBounds(25, 220, 103, 20);
		label_5.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_5);
		
		textFieldNumeroD = new JTextField();
		textFieldNumeroD.setBounds(87, 220, 203, 20);
		textFieldNumeroD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNumeroD.setColumns(10);
		contentPanel.add(textFieldNumeroD);
		
		textFieldCiudadD = new JTextField();
		textFieldCiudadD.setBounds(87, 245, 203, 20);
		textFieldCiudadD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCiudadD.setColumns(10);
		contentPanel.add(textFieldCiudadD);
		
		textFieldCodigoPostalD = new JTextField();
		textFieldCodigoPostalD.setBounds(120, 270, 170, 20);
		textFieldCodigoPostalD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCodigoPostalD.setColumns(10);
		contentPanel.add(textFieldCodigoPostalD);
		
		JLabel label_6 = new JLabel("Telefono:");
		label_6.setBounds(300, 270, 103, 20);
		label_6.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setBounds(300, 245, 103, 20);
		label_7.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Distrito:");
		label_8.setBounds(300, 220, 103, 20);
		label_8.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_8);
		
		JLabel label_9 = new JLabel("Ciudad:");
		label_9.setBounds(25, 245, 103, 20);
		label_9.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_9);
		
		JLabel label_10 = new JLabel("Codigo Postal:");
		label_10.setBounds(25, 270, 103, 20);
		label_10.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_10);
		
		JLabel lblDatosDenuncia = new JLabel("* DATOS DENUNCIA");
		lblDatosDenuncia.setBounds(25, 315, 148, 20);
		lblDatosDenuncia.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		contentPanel.add(lblDatosDenuncia);
		
		JLabel lblNombreVictima = new JLabel("Nombre Victima (*):");
		lblNombreVictima.setBounds(25, 340, 137, 20);
		lblNombreVictima.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblNombreVictima);
		
		textFieldNombreVictima = new JTextField();
		textFieldNombreVictima.setBounds(170, 340, 448, 20);
		textFieldNombreVictima.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNombreVictima.setColumns(10);
		contentPanel.add(textFieldNombreVictima);
		
		textFieldTelefonoV = new JTextField();
		textFieldTelefonoV.setBounds(364, 440, 254, 20);
		textFieldTelefonoV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTelefonoV.setColumns(10);
		contentPanel.add(textFieldTelefonoV);
		
		textFieldCodigoPostalV = new JTextField();
		textFieldCodigoPostalV.setBounds(120, 440, 170, 20);
		textFieldCodigoPostalV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCodigoPostalV.setColumns(10);
		contentPanel.add(textFieldCodigoPostalV);
		
		JLabel label_1 = new JLabel("Telefono:");
		label_1.setBounds(300, 440, 103, 20);
		label_1.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Provincia:");
		label_2.setBounds(300, 415, 103, 20);
		label_2.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_2);
		
		textFieldProvinciaV = new JTextField();
		textFieldProvinciaV.setBounds(364, 415, 254, 20);
		textFieldProvinciaV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldProvinciaV.setColumns(10);
		contentPanel.add(textFieldProvinciaV);
		
		textFieldDistritoV = new JTextField();
		textFieldDistritoV.setBounds(364, 390, 254, 20);
		textFieldDistritoV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldDistritoV.setColumns(10);
		contentPanel.add(textFieldDistritoV);
		
		textFieldNumeroV = new JTextField();
		textFieldNumeroV.setBounds(87, 390, 203, 20);
		textFieldNumeroV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNumeroV.setColumns(10);
		contentPanel.add(textFieldNumeroV);
		
		textFieldCiudadV = new JTextField();
		textFieldCiudadV.setBounds(87, 415, 203, 20);
		textFieldCiudadV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCiudadV.setColumns(10);
		contentPanel.add(textFieldCiudadV);
		
		JLabel label_11 = new JLabel("Ciudad:");
		label_11.setBounds(25, 415, 103, 20);
		label_11.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_11);
		
		JLabel label_12 = new JLabel("Numero:");
		label_12.setBounds(25, 390, 103, 20);
		label_12.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_12);
		
		JLabel label_13 = new JLabel("Distrito:");
		label_13.setBounds(300, 390, 103, 20);
		label_13.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_13);
		
		textFieldCalleV = new JTextField();
		textFieldCalleV.setBounds(87, 365, 531, 20);
		textFieldCalleV.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCalleV.setColumns(10);
		contentPanel.add(textFieldCalleV);
		
		JLabel labelCalleV = new JLabel("Calle:");
		labelCalleV.setBounds(25, 365, 103, 20);
		labelCalleV.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(labelCalleV);
		
		JLabel labelCodigoPostal = new JLabel("Codigo Postal:");
		labelCodigoPostal.setBounds(25, 440, 103, 20);
		labelCodigoPostal.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(labelCodigoPostal);
		
		textFieldCantVictimas = new JTextField();
		textFieldCantVictimas.setBounds(180, 510, 110, 20);
		textFieldCantVictimas.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCantVictimas.setColumns(10);
		contentPanel.add(textFieldCantVictimas);
		
		JLabel lblCantidadVictimas = new JLabel("Cantidad Victimas (*):");
		lblCantidadVictimas.setBounds(25, 510, 137, 20);
		lblCantidadVictimas.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblCantidadVictimas);
		
		JLabel lblCantidadEnfermos = new JLabel("Cantidad Enfermos (*):");
		lblCantidadEnfermos.setBounds(300, 510, 137, 20);
		lblCantidadEnfermos.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblCantidadEnfermos);
		
		textFieldCantEnfermos = new JTextField();
		textFieldCantEnfermos.setBounds(448, 510, 170, 20);
		textFieldCantEnfermos.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCantEnfermos.setColumns(10);
		contentPanel.add(textFieldCantEnfermos);
		
		JLabel lblCantidadInternados = new JLabel("Cantidad Internados (*):");
		lblCantidadInternados.setBounds(25, 535, 148, 20);
		lblCantidadInternados.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblCantidadInternados);
		
		JLabel lblCantidadMuertos = new JLabel("Cantidad Muertos (*):");
		lblCantidadMuertos.setBounds(300, 535, 137, 20);
		lblCantidadMuertos.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblCantidadMuertos);
		
		textFieldCantMuertos = new JTextField();
		textFieldCantMuertos.setBounds(448, 535, 170, 20);
		textFieldCantMuertos.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCantMuertos.setColumns(10);
		contentPanel.add(textFieldCantMuertos);
		
		textFieldTelefonoH = new JTextField();
		textFieldTelefonoH.setBounds(364, 635, 254, 20);
		textFieldTelefonoH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTelefonoH.setColumns(10);
		contentPanel.add(textFieldTelefonoH);
		
		textFieldCodigoPostalH = new JTextField();
		textFieldCodigoPostalH.setBounds(123, 635, 167, 20);
		textFieldCodigoPostalH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCodigoPostalH.setColumns(10);
		contentPanel.add(textFieldCodigoPostalH);
		
		JLabel label_17 = new JLabel("Telefono:");
		label_17.setBounds(300, 635, 103, 20);
		label_17.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_17);
		
		JLabel label_18 = new JLabel("Provincia:");
		label_18.setBounds(300, 610, 103, 20);
		label_18.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_18);
		
		JLabel label_19 = new JLabel("Distrito:");
		label_19.setBounds(300, 585, 103, 20);
		label_19.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_19);
		
		textFieldDistritoH = new JTextField();
		textFieldDistritoH.setBounds(364, 585, 254, 20);
		textFieldDistritoH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldDistritoH.setColumns(10);
		contentPanel.add(textFieldDistritoH);
		
		textFieldProvinciaH = new JTextField();
		textFieldProvinciaH.setBounds(364, 610, 254, 20);
		textFieldProvinciaH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldProvinciaH.setColumns(10);
		contentPanel.add(textFieldProvinciaH);
		
		textFieldCiudadH = new JTextField();
		textFieldCiudadH.setBounds(87, 610, 203, 20);
		textFieldCiudadH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCiudadH.setColumns(10);
		contentPanel.add(textFieldCiudadH);
		
		textFieldNumeroH = new JTextField();
		textFieldNumeroH.setBounds(87, 585, 203, 20);
		textFieldNumeroH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNumeroH.setColumns(10);
		contentPanel.add(textFieldNumeroH);
		
		JLabel label_20 = new JLabel("Numero:");
		label_20.setBounds(25, 585, 103, 20);
		label_20.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_20);
		
		JLabel label_21 = new JLabel("Ciudad:");
		label_21.setBounds(25, 610, 103, 20);
		label_21.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_21);
		
		JLabel label_22 = new JLabel("Codigo Postal:");
		label_22.setBounds(25, 635, 103, 20);
		label_22.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_22);
		
		JLabel label_23 = new JLabel("Calle:");
		label_23.setBounds(25, 560, 103, 20);
		label_23.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(label_23);
		
		textFieldCalleH = new JTextField();
		textFieldCalleH.setBounds(87, 560, 531, 20);
		textFieldCalleH.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCalleH.setColumns(10);
		contentPanel.add(textFieldCalleH);
		
		JLabel lblComida = new JLabel("Comida:");
		lblComida.setBounds(25, 660, 103, 20);
		lblComida.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPanel.add(lblComida);
		
		textFieldComida = new JTextField();
		textFieldComida.setBounds(123, 660, 167, 20);
		textFieldComida.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldComida.setColumns(10);
		contentPanel.add(textFieldComida);
		
		textFieldCantInternados = new JTextField();
		textFieldCantInternados.setBounds(181, 535, 109, 20);
		textFieldCantInternados.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCantInternados.setColumns(10);
		contentPanel.add(textFieldCantInternados);
		
		JLabel lblDatosHospital = new JLabel("* DATOS HOSPITAL");
		lblDatosHospital.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblDatosHospital.setBounds(25, 485, 148, 20);
		contentPanel.add(lblDatosHospital);
		
		{
			JPanel buttonPane = new JPanel();			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!camposVacios(textAreaDescripciones.getText(),textFieldNombreVictima.getText(),textFieldCantVictimas.getText(),textFieldCantEnfermos.getText(),textFieldCantInternados.getText(),textFieldCantMuertos.getText())){
							if(validarCampos(textFieldCantVictimas.getText()) && validarCampos(textFieldCantEnfermos.getText()) && validarCampos(textFieldCantInternados.getText()) && validarCampos(textFieldCantMuertos.getText()) && camposVaciosNumericos(textFieldNumeroD.getText()) && camposVaciosNumericos(textFieldCodigoPostalD.getText()) && camposVaciosNumericos(textFieldNumeroV.getText()) && camposVaciosNumericos(textFieldCodigoPostalV.getText()) && camposVaciosNumericos(textFieldNumeroH.getText()) && camposVaciosNumericos(textFieldCodigoPostalH.getText())){
								Controlador c = new Controlador();
								int resultado = -1;
								try {
									resultado = c.guardarDenunciasComida(textAreaDescripciones.getText(), textAreaObservaciones.getText(), textFieldNombreDenunciante.getText(), textFieldCalleD.getText(), textFieldNumeroD.getText(), textFieldDistritoD.getText(), textFieldCiudadD.getText(), textFieldProvinciaD.getText(), textFieldCodigoPostalD.getText(), textFieldTelefonoD.getText(), textFieldNombreVictima.getText(), textFieldCalleV.getText(), textFieldNumeroV.getText(), textFieldDistritoV.getText(), textFieldCiudadV.getText(), textFieldProvinciaV.getText(), textFieldCodigoPostalV.getText(), textFieldTelefonoV.getText(), textFieldCantVictimas.getText(), textFieldCantEnfermos.getText(), textFieldCantInternados.getText(), textFieldCantMuertos.getText(), textFieldCalleH.getText(), textFieldNumeroH.getText(), textFieldDistritoH.getText(), textFieldCiudadH.getText(), textFieldProvinciaH.getText(), textFieldCodigoPostalH.getText(), textFieldTelefonoH.getText(), textFieldComida.getText());
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								if(resultado < 0){
									JOptionPane.showMessageDialog(null, "ERROR registrando la denuncia." + resultado);
									dispose();
								}
								else{
									JOptionPane.showMessageDialog(null, "Denuncia realizada con EXITO, su numero de denuncia es: " + resultado);
									dispose();
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar");
						}
					}
				});
				guardarButton.setActionCommand("Guardar");
				buttonPane.add(guardarButton);
				getRootPane().setDefaultButton(guardarButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
	}
	public boolean camposVacios(String descripcion, String nombreVictima, String cantVictimas, String cantEnfermos, String cantInternados, String cantMuertos){
		return descripcion.equals("") || nombreVictima.equals("") || cantVictimas.equals("") || cantEnfermos.equals("") || cantInternados.equals("") || cantMuertos.equals("");
	}
	protected boolean validarCampos(String valor) {
		try {
			Validador.validarValoresNumericos(valor);
		} catch (ExcepcionNoNumerico e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + " Por favor, ingrese un numero en los campos donde es numérico");
			return false;
		}
		return true;
	}
	public boolean camposVaciosNumericos(String valor){
		boolean resultado = true;
		if(!valor.equals("")){
			resultado = validarCampos(valor);
		}
		return resultado;
	}
}