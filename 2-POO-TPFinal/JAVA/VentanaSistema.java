package TPFinal;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaSistema extends JFrame{
	private JPanel contentPane;
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSistema frame = new VentanaSistema();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error SQLException en VentanaSistema-main:"+e.getMessage());
				}
			}
		});
	}

	/* Frame: */
	public VentanaSistema() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministracion = new JButton("Administracion");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va=new VentanaAdmin();
				//VentanaAdrministracion tiene que ser JDIALOG para poder hacer lo de set.Modal.
				va.setModal(true);
				va.setVisible(true);
			}
		});
		
		btnAdministracion.setBounds(61, 135, 130, 23); //eje x, y, largo, alto.
		contentPane.add(btnAdministracion);
		
		JButton btnOT = new JButton("Oficina Tecnica");
		btnOT.setBounds(253, 135, 130, 23);
		contentPane.add(btnOT);
		btnOT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOficinaTecnica vo;
				try {
					vo = new VentanaOficinaTecnica();
					vo.setModal(true);
					vo.setVisible(true);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaSistema-OficinaTecnica:"+e1.getMessage());
				}
			}
		});

		JButton btnProd = new JButton("Produccion");
		btnProd.setBounds(61, 195, 130, 23);
		contentPane.add(btnProd);
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProduccion vo;
				try {
					vo = new VentanaProduccion();
					vo.setModal(true);
					vo.setVisible(true);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaSistema-Produccion:"+e1.getMessage());
				}
			}
		});
		
		JButton btnDesp = new JButton("Despacho");
		btnDesp.setBounds(253, 195, 130, 23);
		contentPane.add(btnDesp);
		
		//JLabel para poner imagen:
		ImageIcon imageIcon=new ImageIcon("PerezHnos.png");
		Image image= imageIcon.getImage();
		Image newimg=image.getScaledInstance(115,115, java.awt.Image.SCALE_SMOOTH); //Ancho, largo.
		imageIcon = new ImageIcon(newimg);
		JLabel labelimagen = new JLabel("");
		labelimagen.setHorizontalAlignment(SwingConstants.CENTER);
		labelimagen.setIcon(imageIcon);
		labelimagen.setBounds(134, 11, 183, 113);
		contentPane.add(labelimagen);
		
		btnDesp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDespacho vd;
				try {
					vd=new VentanaDespacho();
					vd.setModal(true);
					vd.setVisible(true);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaSistema-Despacho:"+e1.getMessage());
				}
			}
		});
	}
}
