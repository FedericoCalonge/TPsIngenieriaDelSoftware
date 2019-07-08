package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setTitle("~(*.*)~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(500, 100, 305, 245);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75,163,199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JButton btnCrearUsuario = new JButton("CREAR USUARIO");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearUsuario nuevoUsuario = new CrearUsuario();
				nuevoUsuario.setModal(true);
				nuevoUsuario.setVisible(true);
			}
		});
		btnCrearUsuario.setBackground(new Color(135, 206, 235));
		btnCrearUsuario.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCrearUsuario.setBounds(60, 30, 175, 60);
		contentPane.add(btnCrearUsuario);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogueoUsuario logueo = new LogueoUsuario();
				logueo.setModal(true);
				dispose();
				logueo.setVisible(true);
			}
		});
		btnIniciarSesion.setFont(new Font("Calibri", Font.BOLD, 16));
		btnIniciarSesion.setBackground(new Color(135, 206, 235));
		btnIniciarSesion.setBounds(60, 111, 175, 60);
		contentPane.add(btnIniciarSesion);
	}
}
