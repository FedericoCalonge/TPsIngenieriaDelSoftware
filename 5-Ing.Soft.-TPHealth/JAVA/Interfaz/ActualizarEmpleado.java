package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador;
import Controladores.Validador;
import Excepciones.ExcepcionNoNumerico;

public class ActualizarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldReingreseContrase�aN;
	private JTextField textFieldContrase�aN;
	private JTextField textFieldNombre;
	private JTextField textFieldIdEmpleado;
	private JTextField textFieldContrase�aVieja;

	public static void main(String[] args) {
		try {
			ActualizarEmpleado dialog = new ActualizarEmpleado("","","");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ActualizarEmpleado(String idEmpleado, String nombre, String contrase�aOficial) {
		setTitle("Actualizar Empleado");
		setBounds(300, 0, 422, 245);
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
		
		textFieldReingreseContrase�aN = new JPasswordField(); //Clase para los **** en la pass.
		textFieldReingreseContrase�aN.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldReingreseContrase�aN.setColumns(10);
		textFieldReingreseContrase�aN.setBounds(170, 140, 210, 20);
		contentPanel.add(textFieldReingreseContrase�aN);
		
		textFieldContrase�aN = new JPasswordField(); //Clase para los **** en la pass.
		textFieldContrase�aN.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldContrase�aN.setColumns(10);
		textFieldContrase�aN.setBounds(170, 115, 210, 20);
		contentPanel.add(textFieldContrase�aN);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a nueva:");
		lblContrase�a.setFont(new Font("Calibri", Font.BOLD, 14));
		lblContrase�a.setBounds(25, 115, 137, 20);
		contentPanel.add(lblContrase�a);
		
		JLabel lblReingreseContrasea = new JLabel("Reingrese contrase\u00F1a:");
		lblReingreseContrasea.setFont(new Font("Calibri", Font.BOLD, 14));
		lblReingreseContrasea.setBounds(25, 140, 133, 20);
		contentPanel.add(lblReingreseContrasea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText(nombre);
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(87, 40, 293, 20);
		contentPanel.add(textFieldNombre);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblId.setBounds(25, 65, 133, 20);
		contentPanel.add(lblId);
		
		textFieldIdEmpleado = new JTextField();
		textFieldIdEmpleado.setText(idEmpleado);
		textFieldIdEmpleado.setEditable(false);
		textFieldIdEmpleado.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldIdEmpleado.setColumns(10);
		textFieldIdEmpleado.setBounds(87, 65, 293, 20);
		contentPanel.add(textFieldIdEmpleado);
		
		JLabel lblContrase�aVieja = new JLabel("Contrase\u00F1a vieja:");
		lblContrase�aVieja.setFont(new Font("Calibri", Font.BOLD, 14));
		lblContrase�aVieja.setBounds(25, 90, 137, 20);
		contentPanel.add(lblContrase�aVieja);
		
		
		textFieldContrase�aVieja = new JPasswordField(); //Clase para los **** en la pass.
		textFieldContrase�aVieja.setFont(new Font("Calibri", Font.BOLD, 14));
		textFieldContrase�aVieja.setColumns(10);
		textFieldContrase�aVieja.setBounds(170, 90, 210, 20);
		contentPanel.add(textFieldContrase�aVieja);
		{
			JPanel buttonPane = new JPanel();			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//
						if(!camposVacios(textFieldNombre.getText(),textFieldContrase�aVieja.getText(),textFieldContrase�aN.getText(),textFieldReingreseContrase�aN.getText())) {
							if(validarContrase�a(contrase�aOficial.toString(),textFieldContrase�aVieja.getText())) {
								if(validarContrase�a(textFieldContrase�aN.getText(),textFieldReingreseContrase�aN.getText())) { 
									Controlador c = new Controlador();
									int resultado = -1;
									try {
										resultado = c.guardarEmpleadoActualizado(new Integer(textFieldIdEmpleado.getText()),textFieldNombre.getText(),textFieldContrase�aN.getText());
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									if(resultado < 0){
										JOptionPane.showMessageDialog(null, "ERROR registrando al empleado." + resultado);
										dispose();
									}
									else{
										JOptionPane.showMessageDialog(null, "Modificaci�n realizada con EXITO");
										dispose();
									}
								}
								else{
									JOptionPane.showMessageDialog(null, "Las contrase�as nuevas no son iguales.");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Las contrase�a vieja ingresada NO es v�lida.");
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
	protected boolean validarContrase�a(String contrase�a, String rContrase�a) {
		return contrase�a.equals(rContrase�a);
	}

	public boolean camposVacios(String idEmpleado, String nombre, String contrase�a, String rContrase�a){
		return idEmpleado.equals("") || nombre.equals("") || contrase�a.equals("") || rContrase�a.equals("");
	}
	protected boolean validarCampos(String valor) {
		try {
			Validador.validarValoresNumericos(valor);
		} catch (ExcepcionNoNumerico e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + " Por favor, ingrese un numero en los campos donde es num�rico");
			return false;
		}
		return true;
	}
}

