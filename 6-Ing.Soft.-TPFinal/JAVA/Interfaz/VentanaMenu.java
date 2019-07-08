package Interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu("profe@gmail.com");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMenu(String idUsuario) {
		setFont(new Font("Calibri", Font.BOLD, 16));
		this.setResizable(false);
		setTitle("Que est\u00E1s leyendo?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imageIcon=new ImageIcon("imagen.jpg");
		Image image= imageIcon.getImage();
		Image newimg=image.getScaledInstance(444, 249, java.awt.Image.SCALE_SMOOTH); //Ancho, largo.
		imageIcon = new ImageIcon(newimg);

		JLabel lblIdUsuario = new JLabel(idUsuario);
		lblIdUsuario.setForeground(new Color(255, 255, 255));
		lblIdUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdUsuario.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIdUsuario.setBounds(10, 222, 414, 20);
		contentPane.add(lblIdUsuario);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(129,212,250));
		setJMenuBar(menuBar);
		
		JMenu mnLibro = new JMenu("Libro");
		mnLibro.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(mnLibro);
		
		JMenuItem mntmCargarLibro = new JMenuItem("Cargar");
		mntmCargarLibro.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmCargarLibro.setBackground(new Color(75,163,199));
		mntmCargarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarLibro altaLibro = new CargarLibro(idUsuario);
				altaLibro.setModal(true);
				altaLibro.setVisible(true);
			}
		});
		
		JMenuItem mntmTop5Libro = new JMenuItem("TOP 5");
		mntmTop5Libro.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmTop5Libro.setBackground(new Color(75,163,199));
		mntmTop5Libro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top5  top5Libro = new Top5("Libro",idUsuario);
				top5Libro.setModal(true);
				top5Libro.setVisible(true);	
			}
		});
		
		JMenuItem mntmLast5Libro = new JMenuItem("LAST 5");
		mntmLast5Libro.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmLast5Libro.setBackground(new Color(75,163,199));
		mntmLast5Libro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last5  last5Libro = new Last5("Libro",idUsuario);
				last5Libro.setModal(true);
				last5Libro.setVisible(true);				
			}
		});
		mnLibro.add(mntmCargarLibro);
		mnLibro.add(mntmTop5Libro);
		mnLibro.add(mntmLast5Libro);
		
		JMenu mnPelicula = new JMenu("Película");
		mnPelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(mnPelicula);
		
		JMenuItem mntmCargarPelicula = new JMenuItem("Cargar");
		mntmCargarPelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmCargarPelicula.setBackground(new Color(75,163,199));
		mntmCargarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarPelicula altaPelicula = new CargarPelicula(idUsuario);
				altaPelicula.setModal(true);
				altaPelicula.setVisible(true);
			}
		});
		
		JMenuItem mntmTop5Pelicula = new JMenuItem("TOP 5");
		mntmTop5Pelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmTop5Pelicula.setBackground(new Color(75,163,199));
		mntmTop5Pelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top5  top5Pelicula = new Top5("Pelicula",idUsuario);
				top5Pelicula.setModal(true);
				top5Pelicula.setVisible(true);	
			}
		});
		
		JMenuItem mntmLast5Pelicula = new JMenuItem("LAST 5");
		mntmLast5Pelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmLast5Pelicula.setBackground(new Color(75,163,199));
		mntmLast5Pelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last5  last5Pelicula = new Last5("Pelicula",idUsuario);
				last5Pelicula.setModal(true);
				last5Pelicula.setVisible(true);
			}
		});
		mnPelicula.add(mntmCargarPelicula);
		mnPelicula.add(mntmTop5Pelicula);
		mnPelicula.add(mntmLast5Pelicula);
		
		JMenu mnSerie = new JMenu("Serie");
		mnSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(mnSerie);
		
		JMenuItem mntmCargarSerie = new JMenuItem("Cargar");
		mntmCargarSerie.setBackground(new Color(75,163,199));
		mntmCargarSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmCargarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarSerie altaSerie = new CargarSerie(idUsuario);
				altaSerie.setModal(true);
				altaSerie.setVisible(true);				
			}
		});
		
		JMenuItem mntmTop5Serie = new JMenuItem("TOP 5");
		mntmTop5Serie.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmTop5Serie.setBackground(new Color(75,163,199));
		mntmTop5Serie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top5  top5Serie = new Top5("Serie",idUsuario);
				top5Serie.setModal(true);
				top5Serie.setVisible(true);	
			}
		});
		
		JMenuItem mntmLast5Serie = new JMenuItem("LAST 5");
		mntmLast5Serie.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmLast5Serie.setBackground(new Color(75,163,199));
		mntmLast5Serie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last5  last5Serie = new Last5("Serie",idUsuario);
				last5Serie.setModal(true);
				last5Serie.setVisible(true);
			}
		});
		mnSerie.add(mntmCargarSerie);
		mnSerie.add(mntmTop5Serie);
		mnSerie.add(mntmLast5Serie);
				
		JMenu mnContacto = new JMenu("Contacto");
		mnContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(mnContacto);
		
		JMenuItem mntmAgregarContacto = new JMenuItem("Agregar");
		mntmAgregarContacto.setFont(new Font("Calibri", Font.BOLD, 16));
		mntmAgregarContacto.setBackground(new Color(75,163,199));
		mntmAgregarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnContacto.add(mntmAgregarContacto);
		
		JLabel labelimagen = new JLabel("");
		labelimagen.setIcon(imageIcon);
		labelimagen.setBounds(0, 0, 444, 249);
		contentPane.add(labelimagen);
		contentPane.setLayout(null);
	}
}
