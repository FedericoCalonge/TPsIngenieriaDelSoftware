package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import Controladores.*;
import Excepciones.ExcepcionNoNumerico;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldContrase�a;
	private JTextField textFieldIdEmpleado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLogin() {
		setTitle("Login Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 196);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a:");
		lblContrase�a.setFont(new Font("Calibri", Font.BOLD, 16));
		lblContrase�a.setBounds(28, 57, 117, 20);
		contentPane.add(lblContrase�a);
		
		textFieldContrase�a = new JPasswordField(); //Clase para los **** en la pass. 
		textFieldContrase�a.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldContrase�a.setBounds(139, 57, 224, 20);
		contentPane.add(textFieldContrase�a);
		textFieldContrase�a.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!camposVacios(textFieldIdEmpleado.getText(),textFieldContrase�a.getText())) {
					if(validarCampos(textFieldIdEmpleado.getText())){
						if(verificarDatos(textFieldIdEmpleado.getText(),textFieldContrase�a.getText())) { //Aca entraria la verificacion de ID y contrase�a
							VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
							ventanaPrincipal.setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null, "El ID o la contrase�as NO es correcta.");
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar.");
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setBounds(262, 98, 100, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNombreDeUsuario = new JLabel("ID empleado:");
		lblNombreDeUsuario.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(28, 23, 158, 20);
		contentPane.add(lblNombreDeUsuario);
		
		textFieldIdEmpleado = new JTextField();
		textFieldIdEmpleado.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldIdEmpleado.setColumns(10);
		textFieldIdEmpleado.setBounds(189, 23, 174, 20);
		contentPane.add(textFieldIdEmpleado);
	}
	public boolean camposVacios(String idEmpleado, String contrase�a){
		return idEmpleado.equals("") || contrase�a.equals("");
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
	private boolean verificarDatos(String idEmpleado, String contrasenia) {
		return Controlador.verificarDatos(idEmpleado, contrasenia);
	}
	
}