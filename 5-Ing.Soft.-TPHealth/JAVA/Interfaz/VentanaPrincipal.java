package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;

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
		setBounds(100, 100, 525, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon imageIcon=new ImageIcon("pandas.png");
		Image image= imageIcon.getImage();
		Image newimg=image.getScaledInstance(550,400, java.awt.Image.SCALE_SMOOTH); //Ancho, largo.
		imageIcon = new ImageIcon(newimg);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsultas = new JMenu("Consultar");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmEnfermedades = new JMenuItem("Enfermedades");
		mntmEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaEnfermedades consultaEnfermedades = new ConsultaEnfermedades();
				consultaEnfermedades.setModal(true);
				consultaEnfermedades.setVisible(true);
			}
		});
		
		JMenuItem mntmDenuncias = new JMenuItem("Denuncias");
		mntmDenuncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaDenuncias consultaDenuncias = new ConsultaDenuncias();
				consultaDenuncias.setModal(true);
				consultaDenuncias.setVisible(true);
			}
		});
		mnConsultas.add(mntmDenuncias);
		mnConsultas.add(mntmEnfermedades);
		
		JMenuItem mntmEspecialidades = new JMenuItem("Especialidades");
		mntmEspecialidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaEspecialidades consultaEspecialidades = new ConsultaEspecialidades();
				consultaEspecialidades.setModal(true);
				consultaEspecialidades.setVisible(true);
			}
		});
		mnConsultas.add(mntmEspecialidades);
		
		JMenuItem mntmHospitales = new JMenuItem("Hospitales");
		mntmHospitales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaHospitales consultaHospitales = new ConsultaHospitales();
				consultaHospitales.setModal(true);
				consultaHospitales.setVisible(true);
			}
		});
		mnConsultas.add(mntmHospitales);
		
		JMenu mnDenuncias = new JMenu("Denuncias");
		menuBar.add(mnDenuncias);
		
		JMenuItem mntmAnimales = new JMenuItem("Animales");
		mntmAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaDenunciaAnimal altaDenunciaAnimal = new CargaDenunciaAnimal();
				altaDenunciaAnimal.setModal(true);
				altaDenunciaAnimal.setVisible(true);
			}
		});
		mnDenuncias.add(mntmAnimales);
		
		JMenuItem mntmComidas = new JMenuItem("Comidas");
		mntmComidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaDenunciaComida altaDenunciaComida = new CargaDenunciaComida();
				altaDenunciaComida.setModal(true);
				altaDenunciaComida.setVisible(true);
			}
		});
		mnDenuncias.add(mntmComidas);
				
		JMenuItem mntmEspeciales = new JMenuItem("Especiales");
		mntmEspeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaDenunciaEspecial altaDenunciaEspecial = new CargaDenunciaEspecial();
				altaDenunciaEspecial.setModal(true);
				altaDenunciaEspecial.setVisible(true);
			}
		});
		mnDenuncias.add(mntmEspeciales);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAltaEmpleado = new JMenuItem("Alta");
		mntmAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaEmpleado altaEmpleado = new AltaEmpleado();
				altaEmpleado.setModal(true);
				altaEmpleado.setVisible(true);
			}
		});
		mnEmpleados.add(mntmAltaEmpleado);
		
		JMenuItem mntmActualizarEmpleado = new JMenuItem("Actualizar");
		mntmActualizarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarEmpleado buscarEmpleado = new BuscarEmpleado();
				buscarEmpleado.setModal(true);
				buscarEmpleado.setVisible(true);
			}
		});
		mnEmpleados.add(mntmActualizarEmpleado);
		
		JLabel labelimagen = new JLabel("");
		labelimagen.setIcon(imageIcon);
		labelimagen.setBounds(0, 0, 509, 236);
		contentPane.add(labelimagen);
		contentPane.setLayout(null);
	}
}
