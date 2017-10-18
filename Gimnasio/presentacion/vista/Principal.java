package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblCodUsuario;
	private JTextField txtCodUsuario;
	
	private JButton btnRegistrarCliente;
	
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public Principal() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		this.contentPane.setLayout(null);
		setContentPane(contentPane);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.lblCodUsuario = new JLabel("Cod Usuario:");
		this.lblCodUsuario.setBounds(5, 5, 80, 30);
		this.contentPane.add(this.lblCodUsuario);
		
		this.txtCodUsuario = new JTextField();
		this.txtCodUsuario.setColumns(10);
		Font txtF = new Font(null, 0, 20);
		this.txtCodUsuario.setFont(txtF);
		this.txtCodUsuario.setBounds(this.lblCodUsuario.getX() + this.lblCodUsuario.getWidth() + 5, 5, 120, 30);
		this.contentPane.add(this.txtCodUsuario);
		
		this.btnRegistrarCliente = new JButton("Registrar Cliente");
		this.btnRegistrarCliente.setBounds(5, 50, 200, 30);
		this.contentPane.add(this.btnRegistrarCliente);
		
		this.btnSalir = new JButton("Salir");
		this.btnSalir.setBounds(5, 100, 100, 30);
		Font f = new Font(null, Font.BOLD, 20);
		this.btnSalir.setFont(f);
		this.btnSalir.setForeground(Color.WHITE);
		this.btnSalir.setBackground(Color.RED);
		this.contentPane.add(this.btnSalir);
	}

	public JTextField getTxtCodUsuario() {
		return this.txtCodUsuario;
	}
	
	public JButton getBtnRegistrarCliente() {
		return this.btnRegistrarCliente;
	}
	
	public JButton getBtnSalir() {
		return this.btnSalir;
	}
}