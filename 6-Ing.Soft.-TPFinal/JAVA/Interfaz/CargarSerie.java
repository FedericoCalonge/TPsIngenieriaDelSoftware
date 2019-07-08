package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controladores.*;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class CargarSerie extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldTemporadas;
	private JTextField textFieldCapitulos;
	private JComboBox comboBoxPlataforma;
	private String plataforma;
	private JTextField textFieldActor_es;
	private JTextField textFieldActriz_es;
	private Date fechaLectura;
	private JTextField textFieldPuntaje;
	private JTextField textFieldLibro;
	private JTextField textFieldPelicula;
	private boolean finalizada;
	private JTextField textFieldLinks;
	private JTextField textFieldTemporadaActual;
	private JTextField textFieldCapituloActual;
	
	public static void main(String[] args) {
		try {
			CargarSerie dialog = new CargarSerie("profe@gmail.com");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CargarSerie(String idUsuario) {
		setTitle("Cargar Serie");
		this.setResizable(false);
		getContentPane().setBackground(new Color(129,212,250));
		setBounds(100, 100, 390, 545);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(182,255,255));
			buttonPane.setBounds(0, 479, 384, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Validador.campoVacio(textFieldNombre.getText())) {
							boolean resultado = false;

							resultado = Controlador.altaSerie(idUsuario,textFieldNombre.getText(),new Integer (textFieldTemporadas.getText()),new Integer (textFieldCapitulos.getText()),plataforma,textFieldActor_es.getText(),textFieldActriz_es.getText(),textFieldLibro.getText(),textFieldPelicula.getText(),fechaLectura,finalizada,textFieldLinks.getText(),new Integer (textFieldTemporadaActual.getText()),new Integer (textFieldCapituloActual.getText()),new Integer (textFieldPuntaje.getText()));

							if(resultado) {
								JOptionPane.showMessageDialog(null, "Serie cargada correctmente.");
							}
							else {
								JOptionPane.showMessageDialog(null, "ERROR en la Carga");
							}
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		this.setPlataforma("Otros");
		this.setFinalizada(false);
		JLabel lblNombre = new JLabel("Nombre (*): ");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombre.setBounds(28, 30, 101, 20);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(124, 30, 222, 20);
		getContentPane().add(textFieldNombre);
		
		JLabel lblTemporadas = new JLabel("Temporadas:");
		lblTemporadas.setFont(new Font("Calibri", Font.BOLD, 16));
		lblTemporadas.setBounds(28, 70, 101, 20);
		getContentPane().add(lblTemporadas);
		
		textFieldTemporadas = new JTextField();
		textFieldTemporadas.setText("0");
		textFieldTemporadas.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldTemporadas.setColumns(10);
		textFieldTemporadas.setBounds(124, 70, 55, 20);
		getContentPane().add(textFieldTemporadas);
		
		JLabel lblCapitulos = new JLabel("Capitulos:");
		lblCapitulos.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCapitulos.setBounds(213, 70, 81, 20);
		getContentPane().add(lblCapitulos);
		
		textFieldCapitulos = new JTextField();
		textFieldCapitulos.setText("0");
		textFieldCapitulos.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldCapitulos.setColumns(10);
		textFieldCapitulos.setBounds(291, 70, 55, 20);
		getContentPane().add(textFieldCapitulos);
		
		JLabel lblActor_es = new JLabel("Actor/es:");
		lblActor_es.setFont(new Font("Calibri", Font.BOLD, 16));
		lblActor_es.setBounds(28, 110, 81, 20);
		getContentPane().add(lblActor_es);
		
		textFieldActor_es = new JTextField();
		textFieldActor_es.setText("");
		textFieldActor_es.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldActor_es.setColumns(10);
		textFieldActor_es.setBounds(106, 110, 240, 20);
		getContentPane().add(textFieldActor_es);
		
		JLabel lblActriz_es = new JLabel("Actriz/es:");
		lblActriz_es.setFont(new Font("Calibri", Font.BOLD, 16));
		lblActriz_es.setBounds(28, 150, 81, 20);
		getContentPane().add(lblActriz_es);
		
		textFieldActriz_es = new JTextField();
		textFieldActriz_es.setText("");
		textFieldActriz_es.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldActriz_es.setColumns(10);
		textFieldActriz_es.setBounds(106, 150, 240, 20);
		getContentPane().add(textFieldActriz_es);
		
		JLabel lblFechaDeLectura = new JLabel("Fecha en que se vio (*):");
		lblFechaDeLectura.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeLectura.setBounds(28, 190, 196, 20);
		getContentPane().add(lblFechaDeLectura);
		
		final DatePicker datepicker = new DatePicker (new Date ()); 
		fechaLectura = datepicker.getDate ();
		datepicker.setFont(new Font("Calibri", Font.BOLD, 16));
		datepicker.setBounds(196, 190, 150, 20);
		datepicker.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                fechaLectura = datepicker.getDate (); // imprime la fecha actual
            }
        });
		getContentPane().add(datepicker); 
		
		JLabel lblPuntaje = new JLabel("Puntaje (*):");
		lblPuntaje.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPuntaje.setBounds(28, 230, 81, 20);
		getContentPane().add(lblPuntaje);
		
		textFieldPuntaje = new JTextField();
		textFieldPuntaje.setForeground(new Color(0, 0, 0));
		textFieldPuntaje.setBackground(new Color(255, 255, 255));
		textFieldPuntaje.setEditable(false);
		textFieldPuntaje.setHorizontalAlignment(SwingConstants.CENTER);

		JSlider silderPuntaje = new JSlider();
		silderPuntaje.setBackground(new Color(129,212,250));
		silderPuntaje.setSnapToTicks(true);
		silderPuntaje.setMinorTickSpacing(1);
		silderPuntaje.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textFieldPuntaje.setText("" + silderPuntaje.getValue() + "");
			}
		});
		silderPuntaje.setPaintTicks(true);
		silderPuntaje.setPaintLabels(true);
		silderPuntaje.setMajorTickSpacing(1);
		silderPuntaje.setToolTipText("");
		silderPuntaje.setValue(5);
		silderPuntaje.setMaximum(10);
		silderPuntaje.setFont(new Font("Calibri", Font.BOLD, 12));
		silderPuntaje.setBounds(121, 221, 173, 35);
		getContentPane().add(silderPuntaje);
		textFieldPuntaje.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldPuntaje.setColumns(3);
		textFieldPuntaje.setBounds(304, 230, 42, 20);
		getContentPane().add(textFieldPuntaje);
		
		JLabel lblLibro = new JLabel("Libro:");
		lblLibro.setFont(new Font("Calibri", Font.BOLD, 16));
		lblLibro.setBounds(28, 270, 81, 20);
		getContentPane().add(lblLibro);
		
		textFieldLibro = new JTextField();
		textFieldLibro.setText("");
		textFieldLibro.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldLibro.setColumns(10);
		textFieldLibro.setBounds(79, 270, 267, 20);
		getContentPane().add(textFieldLibro);
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		lblPelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPelicula.setBounds(28, 310, 65, 20);
		getContentPane().add(lblPelicula);
		
		textFieldPelicula = new JTextField();
		textFieldPelicula.setText("");
		textFieldPelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldPelicula.setColumns(10);
		textFieldPelicula.setBounds(99, 310, 247, 20);
		getContentPane().add(textFieldPelicula);
		
		JLabel lblLinks = new JLabel("Links:");
		lblLinks.setFont(new Font("Calibri", Font.BOLD, 16));
		lblLinks.setBounds(28, 350, 65, 20);
		getContentPane().add(lblLinks);
		
		textFieldLinks = new JTextField();
		textFieldLinks.setText("");
		textFieldLinks.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldLinks.setColumns(10);
		textFieldLinks.setBounds(79, 350, 267, 20);
		getContentPane().add(textFieldLinks);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPlataforma.setBounds(28, 390, 87, 20);
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plataforma = (String)comboBoxPlataforma.getSelectedItem();
			}
		});
		comboBoxPlataforma.addItem("Otros");
		comboBoxPlataforma.addItem("Netflix");
		comboBoxPlataforma.addItem("HBO");
		comboBoxPlataforma.addItem("FOX Play");
		comboBoxPlataforma.addItem("Flow");
		comboBoxPlataforma.addItem("Crunchyroll");
		comboBoxPlataforma.addItem("Amazon Play");
		comboBoxPlataforma.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		comboBoxPlataforma.setBounds(124, 390, 100, 20);
		getContentPane().add(comboBoxPlataforma);
		
		
		JLabel lblFinalizo = new JLabel("Termino             Si");
		lblFinalizo.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFinalizo.setBounds(234, 380, 140, 20);
		getContentPane().add(lblFinalizo);
		
		JLabel lblDeVerlo = new JLabel("de verlo:         (tilde)");
		lblDeVerlo.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDeVerlo.setBounds(234, 400, 140, 20);
		getContentPane().add(lblDeVerlo);
		
		JRadioButton rdbtnFinalizo = new JRadioButton("");
		rdbtnFinalizo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 finalizada = rdbtnFinalizo.isSelected();
			}
		});
		rdbtnFinalizo.setBackground(new Color(129,212,250));
		rdbtnFinalizo.setFont(new Font("Calibri", Font.BOLD, 16));
		rdbtnFinalizo.setBounds(304, 390, 21, 23);
		getContentPane().add(rdbtnFinalizo);
		
		JLabel lblTemporadas_1 = new JLabel("Temporada");
		lblTemporadas_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblTemporadas_1.setBounds(28, 420, 101, 20);
		getContentPane().add(lblTemporadas_1);
		
		textFieldTemporadaActual = new JTextField();
		textFieldTemporadaActual.setText("0");
		textFieldTemporadaActual.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldTemporadaActual.setColumns(10);
		textFieldTemporadaActual.setBounds(124, 430, 55, 20);
		getContentPane().add(textFieldTemporadaActual);
		
		JLabel lblCapitulo = new JLabel("Capitulo");
		lblCapitulo.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCapitulo.setBounds(213, 420, 81, 20);
		getContentPane().add(lblCapitulo);
		
		textFieldCapituloActual = new JTextField();
		textFieldCapituloActual.setText("0");
		textFieldCapituloActual.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldCapituloActual.setColumns(10);
		textFieldCapituloActual.setBounds(291, 430, 55, 20);
		getContentPane().add(textFieldCapituloActual);
		
		JLabel lblActual = new JLabel("actual:");
		lblActual.setFont(new Font("Calibri", Font.BOLD, 16));
		lblActual.setBounds(60, 440, 101, 20);
		getContentPane().add(lblActual);
		
		JLabel lblActual_1 = new JLabel("actual:");
		lblActual_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblActual_1.setBounds(223, 440, 81, 20);
		getContentPane().add(lblActual_1);
	}

	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public JComboBox getComboBoxPlataforma() {
		return comboBoxPlataforma;
	}
	public void setComboBoxPlataforma(JComboBox comboBoxPlataforma) {
		this.comboBoxPlataforma = comboBoxPlataforma;
	}
}
