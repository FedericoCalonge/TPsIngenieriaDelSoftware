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

public class CargaDenunciaAnimal extends JDialog {

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
	private JTextField textFieldFecha;
	private JTextField textFieldTipo;
	private JTextField textFieldTelefono;
	private JTextField textFieldCodigoPostal;
	private JTextField textFieldProvincia;
	private JTextField textFieldDistrito;
	private JTextField textFieldNumero;
	private JTextField textFieldCiudad;
	private JTextField textFieldCalle;
	private JTextField textFieldCantidad;

	
	public static void main(String[] args) {
		try {
			CargaDenunciaAnimal dialog = new CargaDenunciaAnimal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CargaDenunciaAnimal() {
		setTitle("Denuncia Animal");
		setBounds(300, 0, 670, 585);
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
		lblDatosDenunciante.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblDatosDenunciante.setBounds(10, 11, 148, 20);
		contentPanel.add(lblDatosDenunciante);
		
		JTextArea textAreaDescripciones = new JTextArea();
		textAreaDescripciones.setFont(new Font("Calibri", Font.BOLD, 14));
		textAreaDescripciones.setLineWrap(true);
		textAreaDescripciones.setBounds(138, 40, 480, 60);
		contentPanel.add(textAreaDescripciones);
		
		JTextArea textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Calibri", Font.BOLD, 14));
		textAreaObservaciones.setBounds(138, 105, 480, 60);
		contentPanel.add(textAreaObservaciones);
		
		textFieldTelefonoD = new JTextField();
		textFieldTelefonoD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTelefonoD.setColumns(10);
		textFieldTelefonoD.setBounds(364, 270, 254, 20);
		contentPanel.add(textFieldTelefonoD);
		
		textFieldProvinciaD = new JTextField();
		textFieldProvinciaD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldProvinciaD.setColumns(10);
		textFieldProvinciaD.setBounds(364, 245, 254, 20);
		contentPanel.add(textFieldProvinciaD);
		
		textFieldDistritoD = new JTextField();
		textFieldDistritoD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldDistritoD.setColumns(10);
		textFieldDistritoD.setBounds(364, 220, 254, 20);
		contentPanel.add(textFieldDistritoD);
		
		textFieldCalleD = new JTextField();
		textFieldCalleD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCalleD.setColumns(10);
		textFieldCalleD.setBounds(87, 195, 531, 20);
		contentPanel.add(textFieldCalleD);
		
		textFieldNombreDenunciante = new JTextField();
		textFieldNombreDenunciante.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNombreDenunciante.setColumns(10);
		textFieldNombreDenunciante.setBounds(170, 170, 448, 20);
		contentPanel.add(textFieldNombreDenunciante);
		
		JLabel label_3 = new JLabel("Nombre Denunciante:");
		label_3.setFont(new Font("Calibri", Font.BOLD, 14));
		label_3.setBounds(25, 170, 137, 20);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Calle:");
		label_4.setFont(new Font("Calibri", Font.BOLD, 14));
		label_4.setBounds(25, 195, 103, 20);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Numero:");
		label_5.setFont(new Font("Calibri", Font.BOLD, 14));
		label_5.setBounds(25, 220, 103, 20);
		contentPanel.add(label_5);
		
		textFieldNumeroD = new JTextField();
		textFieldNumeroD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNumeroD.setColumns(10);
		textFieldNumeroD.setBounds(87, 220, 203, 20);
		contentPanel.add(textFieldNumeroD);
		
		textFieldCiudadD = new JTextField();
		textFieldCiudadD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCiudadD.setColumns(10);
		textFieldCiudadD.setBounds(87, 245, 203, 20);
		contentPanel.add(textFieldCiudadD);
		
		textFieldCodigoPostalD = new JTextField();
		textFieldCodigoPostalD.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCodigoPostalD.setColumns(10);
		textFieldCodigoPostalD.setBounds(120, 270, 170, 20);
		contentPanel.add(textFieldCodigoPostalD);
		
		JLabel label_6 = new JLabel("Telefono:");
		label_6.setFont(new Font("Calibri", Font.BOLD, 14));
		label_6.setBounds(300, 270, 103, 20);
		contentPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setFont(new Font("Calibri", Font.BOLD, 14));
		label_7.setBounds(300, 245, 103, 20);
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Distrito:");
		label_8.setFont(new Font("Calibri", Font.BOLD, 14));
		label_8.setBounds(300, 220, 103, 20);
		contentPanel.add(label_8);
		
		JLabel label_9 = new JLabel("Ciudad:");
		label_9.setFont(new Font("Calibri", Font.BOLD, 14));
		label_9.setBounds(25, 245, 103, 20);
		contentPanel.add(label_9);
		
		JLabel label_10 = new JLabel("Codigo Postal:");
		label_10.setFont(new Font("Calibri", Font.BOLD, 14));
		label_10.setBounds(25, 270, 103, 20);
		contentPanel.add(label_10);
		
		JLabel lblDatosDenuncia = new JLabel("* DATOS DENUNCIA");
		lblDatosDenuncia.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblDatosDenuncia.setBounds(25, 315, 148, 20);
		contentPanel.add(lblDatosDenuncia);
		
		JLabel lblTipo = new JLabel("Tipo (*):");
		lblTipo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblTipo.setBounds(25, 340, 103, 20);
		contentPanel.add(lblTipo);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(364, 340, 254, 20);
		contentPanel.add(textFieldFecha);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(87, 340, 203, 20);
		contentPanel.add(textFieldTipo);
		
		JLabel lblFecha = new JLabel("Fecha (*):");
		lblFecha.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFecha.setBounds(300, 340, 103, 20);
		contentPanel.add(lblFecha);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(364, 465, 254, 20);
		contentPanel.add(textFieldTelefono);
		
		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCodigoPostal.setColumns(10);
		textFieldCodigoPostal.setBounds(123, 465, 167, 20);
		contentPanel.add(textFieldCodigoPostal);
		
		JLabel label_1 = new JLabel("Telefono:");
		label_1.setFont(new Font("Calibri", Font.BOLD, 14));
		label_1.setBounds(300, 465, 103, 20);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Provincia:");
		label_2.setFont(new Font("Calibri", Font.BOLD, 14));
		label_2.setBounds(300, 440, 103, 20);
		contentPanel.add(label_2);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldProvincia.setColumns(10);
		textFieldProvincia.setBounds(364, 440, 254, 20);
		contentPanel.add(textFieldProvincia);
		
		textFieldDistrito = new JTextField();
		textFieldDistrito.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldDistrito.setColumns(10);
		textFieldDistrito.setBounds(364, 415, 254, 20);
		contentPanel.add(textFieldDistrito);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(87, 415, 203, 20);
		contentPanel.add(textFieldNumero);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(87, 440, 203, 20);
		contentPanel.add(textFieldCiudad);
		
		JLabel label_11 = new JLabel("Ciudad:");
		label_11.setFont(new Font("Calibri", Font.BOLD, 14));
		label_11.setBounds(25, 440, 103, 20);
		contentPanel.add(label_11);
		
		JLabel label_12 = new JLabel("Numero:");
		label_12.setFont(new Font("Calibri", Font.BOLD, 14));
		label_12.setBounds(25, 415, 103, 20);
		contentPanel.add(label_12);
		
		JLabel label_13 = new JLabel("Distrito:");
		label_13.setFont(new Font("Calibri", Font.BOLD, 14));
		label_13.setBounds(300, 415, 103, 20);
		contentPanel.add(label_13);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCalle.setColumns(10);
		textFieldCalle.setBounds(87, 390, 531, 20);
		contentPanel.add(textFieldCalle);
		
		JLabel labelCalle = new JLabel("Calle:");
		labelCalle.setFont(new Font("Calibri", Font.BOLD, 14));
		labelCalle.setBounds(25, 390, 103, 20);
		contentPanel.add(labelCalle);
		
		JLabel labelCodigoPostal = new JLabel("Codigo Postal:");
		labelCodigoPostal.setFont(new Font("Calibri", Font.BOLD, 14));
		labelCodigoPostal.setBounds(25, 465, 103, 20);
		contentPanel.add(labelCodigoPostal);
		
		JLabel lblCantidad = new JLabel("Cantidad (*):");
		lblCantidad.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCantidad.setBounds(25, 365, 103, 20);
		contentPanel.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(123, 365, 167, 20);
		contentPanel.add(textFieldCantidad);
		{
			JPanel buttonPane = new JPanel();			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//
						if(!camposVacios(textAreaDescripciones.getText(),textFieldTipo.getText(),textFieldCantidad.getText(),textFieldFecha.getText())){
							if(validarCampos(textFieldCantidad.getText()) && camposVaciosNumericos(textFieldNumeroD.getText()) && camposVaciosNumericos(textFieldCodigoPostalD.getText()) && camposVaciosNumericos(textFieldNumero.getText()) && camposVaciosNumericos(textFieldCodigoPostal.getText())){
								Controlador c = new Controlador();
								int resultado = -1;
								try {
									resultado = c.guardarDenunciaAnimal(textAreaDescripciones.getText(),textAreaObservaciones.getText(),textFieldNombreDenunciante.getText() ,textFieldCalleD.getText(),textFieldNumeroD.getText(),textFieldDistritoD.getText(),textFieldCiudadD.getText(),textFieldProvinciaD.getText(),textFieldCodigoPostalD.getText(),textFieldTelefonoD.getText(),textFieldTipo.getText(),textFieldCantidad.getText(),textFieldFecha.getText(),textFieldCalle.getText(),textFieldNumero.getText(),textFieldDistrito.getText(),textFieldCiudad.getText(),textFieldProvincia.getText(),textFieldCodigoPostal.getText(),textFieldTelefono.getText());
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
	public boolean camposVacios(String descripcion, String tipo, String cantidad, String fecha){
		return descripcion.equals("") || tipo.equals("") || cantidad.equals("") || fecha.equals("");
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
