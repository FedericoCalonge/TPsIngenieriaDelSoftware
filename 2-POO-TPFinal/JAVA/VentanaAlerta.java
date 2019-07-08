package TPFinal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaAlerta extends JDialog {
	private static String textoAlerta;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			VentanaAlerta dialog = new VentanaAlerta(textoAlerta);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VentanaAlerta(String textoAlerta) {
		setBounds(100, 100, 243, 139);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblElCuitYa = new JLabel(textoAlerta);
			lblElCuitYa.setHorizontalAlignment(SwingConstants.CENTER);
			lblElCuitYa.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			lblElCuitYa.setBounds(0, 11, 227, 70);
			contentPanel.add(lblElCuitYa);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
