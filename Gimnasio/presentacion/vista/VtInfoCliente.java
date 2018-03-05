package vista;

import java.awt.BorderLayout;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.ClienteDTO;
import modelo.UserPlanModelo;

public class VtInfoCliente extends JFrame {

	private JPanel contentPane;

	/* Styles */
	private Font txtFont = new Font(null, 0, 20);
	
	/* Modelos. */
	private UserPlanModelo mdlUP = new UserPlanModelo();
	
	/* Object Position. */
	private int lblDescription = 5;
	private int lblWidth = 180;
	private int txtFieldInformation = 200; 
	
	/* Object View */
		/* Customer´s Information. */
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	
		/* Customer´s plan information. */
	private JLabel lblDiasRestantes;
	private JTextField txtDiasRestantes;
	private JLabel lblFechaVencimiento;
	private JTextField txtFechaVencimiento;
	
	private JTextField txtVencimento;
	
	/**
	 * Create the frame.
	 */
	public VtInfoCliente(ClienteDTO clte) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		/* Name */
		this.lblNombre = new JLabel("Nombre:");
		this.lblNombre.setBounds(this.lblDescription, 5, this.lblWidth, 30);
		this.lblNombre.setFont(this.txtFont);
		this.contentPane.add(this.lblNombre);
		
		this.txtNombre = new JTextField(clte.getNombre());
		this.txtNombre.setColumns(10);
		this.txtNombre.setBounds(this.txtFieldInformation, 5, 200, 30);
		this.txtNombre.setEnabled(false);
		//this.txtNombre.setEditable(false);
		this.txtNombre.setFont(txtFont);
		this.contentPane.add(this.txtNombre);
		
		this.lblApellido = new JLabel("Apellido:");
		this.lblApellido.setBounds(this.lblDescription, 45, this.lblWidth, 30);
		this.lblApellido.setFont(this.txtFont);
		this.contentPane.add(this.lblApellido);
		
		this.txtApellido = new JTextField(clte.getApellido());
		this.txtApellido.setColumns(10);
		this.txtApellido.setBounds(this.txtFieldInformation, 45, 200, 30);
		this.txtApellido.setEnabled(false);
		this.txtApellido.setFont(this.txtFont);
		this.contentPane.add(this.txtApellido);

		/* Customer Information. */
		this.lblDiasRestantes = new JLabel("Dias Restantes:");
		this.lblDiasRestantes.setBounds(this.lblDescription, 90, this.lblWidth, 30);
		this.lblDiasRestantes.setFont(this.txtFont);
		this.contentPane.add(this.lblDiasRestantes);
		
		this.txtDiasRestantes = new JTextField("");
		this.txtDiasRestantes.setColumns(10);
		this.txtDiasRestantes.setBounds(this.txtFieldInformation, 90, 200, 30);
		this.txtDiasRestantes.setEnabled(false);
		this.txtDiasRestantes.setFont(this.txtFont);
		this.contentPane.add(this.txtDiasRestantes);
		
		this.lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
		this.lblFechaVencimiento.setBounds(this.lblDescription, 135, this.lblWidth, 30);
		this.lblFechaVencimiento.setFont(this.txtFont);
		this.contentPane.add(this.lblFechaVencimiento);
		
		this.txtFechaVencimiento = new JTextField("");
		this.txtFechaVencimiento.setColumns(10);
		this.txtFechaVencimiento.setBounds(this.txtFieldInformation, 135, 200, 30);
		this.txtFechaVencimiento.setEnabled(false);
		this.txtFechaVencimiento.setFont(this.txtFont);
		this.contentPane.add(this.txtFechaVencimiento);
		
		this.txtVencimento = new JTextField();
		this.txtVencimento.setColumns(10);
		this.txtVencimento.setBounds(this.txtFieldInformation, 180, 200, 30);
		this.txtVencimento.setFont(txtFont);
		this.txtVencimento.setEnabled(false);
		this.contentPane.add(this.txtVencimento);
	}
	
	public JTextField getTxtDiasRestantes() {
		return txtDiasRestantes;
	}

	public JTextField getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public JTextField getTxtVencimiento() {
		return this.txtVencimento;
	}
}