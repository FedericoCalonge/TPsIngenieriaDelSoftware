package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controladores.*;

import com.michaelbaranov.microba.calendar.DatePicker; 
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class CargarLibro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldAutor_es;
	private JTextField textFieldEditorial;
	private JTextField textFieldGenero;
	private Date fechaLectura;
	private JTextField textFieldPuntaje;
	private JTextField textFieldSerie;
	private JTextField textFieldPelicula;

	public static void main(String[] args) {
		try {
			CargarLibro dialog = new CargarLibro("profe@gmail.com");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CargarLibro(String idUsuario) {
		setTitle("Cargar Libro");
		this.setResizable(false);
		getContentPane().setBackground(new Color(129,212,250));
		setBounds(100, 100, 390, 423);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(182,255,255));
			buttonPane.setBounds(0, 357, 384, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				{
					JButton okButton = new JButton("Guardar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!Validador.campoVacio(textFieldNombre.getText())) {
								boolean resultado = false;
								
								resultado = Controlador.altaLibro(idUsuario,textFieldNombre.getText(),textFieldAutor_es.getText(),textFieldEditorial.getText(),textFieldGenero.getText(),fechaLectura,new Integer (textFieldPuntaje.getText()),textFieldSerie.getText(),textFieldPelicula.getText());

								if(resultado) {
									JOptionPane.showMessageDialog(null, "Libro cargado correctmente.");
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
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
		
		JLabel lblNombre = new JLabel("Nombre (*): ");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombre.setBounds(28, 30, 101, 20);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(124, 30, 222, 20);
		getContentPane().add(textFieldNombre);
		
		JLabel lblAutor_es = new JLabel("Autor/es:");
		lblAutor_es.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAutor_es.setBounds(28, 70, 65, 20);
		getContentPane().add(lblAutor_es);
		
		textFieldAutor_es = new JTextField();
		textFieldAutor_es.setText("");
		textFieldAutor_es.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldAutor_es.setColumns(10);
		textFieldAutor_es.setBounds(106, 70, 240, 20);
		getContentPane().add(textFieldAutor_es);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEditorial.setBounds(28, 110, 81, 20);
		getContentPane().add(lblEditorial);
		
		textFieldEditorial = new JTextField();
		textFieldEditorial.setText("");
		textFieldEditorial.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldEditorial.setColumns(10);
		textFieldEditorial.setBounds(106, 110, 240, 20);
		getContentPane().add(textFieldEditorial);
		
		JLabel lblGenero = new JLabel("G\u00E9nero:");
		lblGenero.setFont(new Font("Calibri", Font.BOLD, 16));
		lblGenero.setBounds(28, 150, 81, 20);
		getContentPane().add(lblGenero);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setText("");
		textFieldGenero.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldGenero.setColumns(10);
		textFieldGenero.setBounds(96, 150, 250, 20);
		getContentPane().add(textFieldGenero);
		
		JLabel lblFechaDeLectura = new JLabel("Fecha de lectura (*):");
		lblFechaDeLectura.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeLectura.setBounds(28, 190, 144, 20);
		getContentPane().add(lblFechaDeLectura);
		
		final DatePicker datepicker = new DatePicker (new Date ()); 
		datepicker.setFont(new Font("Calibri", Font.BOLD, 16));
		datepicker.setBounds(182, 190, 164, 20);
		fechaLectura = datepicker.getDate ();
		datepicker.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                fechaLectura = datepicker.getDate ();
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
		
		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSerie.setBounds(28, 270, 81, 20);
		getContentPane().add(lblSerie);
		
		textFieldSerie = new JTextField();
		textFieldSerie.setText("");
		textFieldSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldSerie.setColumns(10);
		textFieldSerie.setBounds(79, 270, 267, 20);
		getContentPane().add(textFieldSerie);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula:");
		lblPelcula.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPelcula.setBounds(28, 310, 65, 20);
		getContentPane().add(lblPelcula);
		
		textFieldPelicula = new JTextField();
		textFieldPelicula.setText("");
		textFieldPelicula.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldPelicula.setColumns(10);
		textFieldPelicula.setBounds(96, 310, 250, 20);
		getContentPane().add(textFieldPelicula);
	}

	public Date getFechaLectura() {
		return fechaLectura;
	}

	public void setFechaLectura(Date fechaLectura) {
		this.fechaLectura = fechaLectura;
	}
}
