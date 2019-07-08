package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controladores.*;
import Excepciones.ExcepcionNoNumerico;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

public class AltaEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldReingreseContraseña;
	private JTextField textFieldContraseña;
	private JTextField textFieldNombre;
	private JTextField textFieldIdEmpleado;

	
	public static void main(String[] args) {
		try {
			AltaEmpleado dialog = new AltaEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AltaEmpleado() {
		setTitle("Alta Empleado");
		setBounds(300, 0, 422, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(25, 40, 114, 20);
			lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
			contentPanel.add(lblNombre);
		}
		
		JLabel lblDatosEmpleado = new JLabel("* DATOS EMPLEADO:");
		lblDatosEmpleado.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblDatosEmpleado.setBounds(10, 11, 148, 20);
		contentPanel.add(lblDatosEmpleado);
		
		textFieldReingreseContraseña = new JPasswordField(); //Clase para los **** en la pass.
		textFieldReingreseContraseña.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldReingreseContraseña.setColumns(10);
		textFieldReingreseContraseña.setBounds(170, 115, 210, 20);
		contentPanel.add(textFieldReingreseContraseña);
		
		textFieldContraseña = new JPasswordField(); //Clase para los **** en la pass.
		textFieldContraseña.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(170, 90, 210, 20);
		contentPanel.add(textFieldContraseña);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Calibri", Font.BOLD, 14));
		lblContraseña.setBounds(25, 90, 137, 20);
		contentPanel.add(lblContraseña);
		
		JLabel lblReingreseContrasea = new JLabel("Reingrese contrase\u00F1a:");
		lblReingreseContrasea.setFont(new Font("Calibri", Font.BOLD, 14));
		lblReingreseContrasea.setBounds(25, 115, 133, 20);
		contentPanel.add(lblReingreseContrasea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(87, 40, 293, 20);
		contentPanel.add(textFieldNombre);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblId.setBounds(25, 65, 133, 20);
		contentPanel.add(lblId);
		
		textFieldIdEmpleado = new JTextField();
		textFieldIdEmpleado.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldIdEmpleado.setColumns(10);
		textFieldIdEmpleado.setBounds(87, 65, 293, 20);
		contentPanel.add(textFieldIdEmpleado);
		{
			JPanel buttonPane = new JPanel();			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(!camposVacios(textFieldIdEmpleado.getText(),textFieldNombre.getText(),textFieldContraseña.getText(),textFieldReingreseContraseña.getText())) {
							if(validarCampos(textFieldIdEmpleado.getText())){
								if(!Controlador.verificarDatos(textFieldIdEmpleado.getText())){
									if(validarContraseña(textFieldContraseña.getText(),textFieldReingreseContraseña.getText())) { 
										Controlador c = new Controlador();
										int resultado = -1;
										try {
											resultado = c.guardarAltaEmpleado(new Integer(textFieldIdEmpleado.getText()),textFieldNombre.getText(),textFieldContraseña.getText());
										} catch (SQLException e1) {
											e1.printStackTrace();
										}
										if(resultado < 0){
											JOptionPane.showMessageDialog(null, "ERROR registrando al empleado.");
											dispose();
										}
										else{
											JOptionPane.showMessageDialog(null, "Alta realizada con EXITO, del empleado con ID: " + resultado);
											dispose();
										}
									}
									else{
										JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales.");
									}
								}
								else{
									JOptionPane.showMessageDialog(null, "ERROR registrando al empleado, ID ya existente.");
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar.");
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
	protected boolean validarContraseña(String contraseña, String rContraseña) {
		return contraseña.equals(rContraseña);
	}

	public boolean camposVacios(String idEmpleado, String nombre, String contraseña, String rContraseña){
		return idEmpleado.equals("") || nombre.equals("") || contraseña.equals("") || rContraseña.equals("");
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
}