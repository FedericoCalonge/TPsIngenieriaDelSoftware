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

public class CargarPelicula extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldDirector_a;
	private JTextField textFieldActor_es;
	private JTextField textFieldActriz_es;
	private Date fechaLectura;
	private JTextField textFieldPuntaje;
	private JTextField textFieldLibro;
	private JTextField textFieldSerie;

	public static void main(String[] args) {
		try {
			CargarPelicula dialog = new CargarPelicula("profe@gmail.com");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CargarPelicula(String idUsuario) {
		setTitle("Cargar Película");
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
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Validador.campoVacio(textFieldNombre.getText())) {
							boolean resultado = false;
							
							resultado = Controlador.altaPelicula(idUsuario,textFieldNombre.getText(),textFieldDirector_a.getText(),textFieldActor_es.getText(),textFieldActriz_es.getText(),fechaLectura,new Integer (textFieldPuntaje.getText()),textFieldLibro.getText(),textFieldSerie.getText());

							if(resultado) {
								JOptionPane.showMessageDialog(null, "Película cargado correctmente.");
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
		
		JLabel lblNombre = new JLabel("Nombre (*): ");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombre.setBounds(28, 30, 101, 20);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(124, 30, 222, 20);
		getContentPane().add(textFieldNombre);
		
		JLabel lblDirector_a = new JLabel("Director/a:");
		lblDirector_a.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDirector_a.setBounds(28, 70, 81, 20);
		getContentPane().add(lblDirector_a);
		
		textFieldDirector_a = new JTextField();
		textFieldDirector_a.setText("");
		textFieldDirector_a.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldDirector_a.setColumns(10);
		textFieldDirector_a.setBounds(124, 70, 222, 20);
		getContentPane().add(textFieldDirector_a);
		
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
		lblFechaDeLectura.setBounds(28, 190, 180, 20);
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
		
		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSerie.setBounds(28, 310, 65, 20);
		getContentPane().add(lblSerie);
		
		textFieldSerie = new JTextField();
		textFieldSerie.setText("");
		textFieldSerie.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldSerie.setColumns(10);
		textFieldSerie.setBounds(79, 310, 267, 20);
		getContentPane().add(textFieldSerie);
	}

	public Date getFechaLectura() {
		return fechaLectura;
	}
	public void setFechaLectura(Date fechaLectura) {
		this.fechaLectura = fechaLectura;
	}
}
