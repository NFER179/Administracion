package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.ClienteDTO;

public class VtInfoCliente extends JFrame {

	private JPanel contentPane;

	private JLabel lblNombre;
	private JTextField txtNombre;
	
	/**
	 * Create the frame.
	 */
	public VtInfoCliente(ClienteDTO clte) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.lblNombre = new JLabel("Nombre:");
		this.lblNombre.setBounds(5, 5, 80, 30);
		this.contentPane.add(this.lblNombre);
		
		this.txtNombre = new JTextField(clte.getNombre());
		this.txtNombre.setColumns(10);
		this.txtNombre.setBounds(5, 40, 200, 30);
		this.txtNombre.setEnabled(false);
		//this.txtNombre.setEditable(false);
		this.contentPane.add(this.txtNombre);
	}
}