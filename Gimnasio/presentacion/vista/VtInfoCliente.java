package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VtInfoCliente extends JFrame {

	private JPanel contentPane;

	private JLabel lblNombre;
	
	/**
	 * Create the frame.
	 */
	public VtInfoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		this.lblNombre = new JLabel("Nombre:");
		this.lblNombre.setBounds(x, y, width, height);
		this.contentPane.add(this.lblNombre);
		
		
	}
}