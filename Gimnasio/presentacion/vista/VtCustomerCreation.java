package vista;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import variables.Fecha;
import visual.NBtnAcept;
import visual.NBtnCancel;

public class VtCustomerCreation extends JFrame{

	private JPanel contentPane;
	
	/* Object Position. */
	private int lblDescription = 5;
	private int lblWidth = 180;
	private int txtFieldInformation = 150;
	
	/* Object View */
	/* lastname */
	private JLabel lblApellido;
	private JTextField txtApellido;
	/* name */
	private JLabel lblNombre;
	private JTextField txtNombre;
	/* document */
	private JLabel lblDocumento;
	private JTextField txtDocumento;
	/* birthday */
	private JLabel lblFechaNacimiento;
	private JComboBox<String> cmbDia;
	private JLabel lblSeparation1;
	private JComboBox<String> cmbMes;
	private JLabel lblSeparation2;
	private JComboBox<String> cmbAño;
	
	/* buttons */
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	
	public VtCustomerCreation() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 350);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.lblApellido = new JLabel("Apellido:");
		this.lblApellido.setBounds(this.lblDescription, 8, this.lblWidth, 23);
		this.contentPane.add(this.lblApellido);
		
		this.txtApellido = new JTextField();
		this.txtApellido.setBounds(this.txtFieldInformation, 8, 300, 23);
		this.txtApellido.setColumns(10);
		this.contentPane.add(this.txtApellido);
		
		this.lblNombre = new JLabel("Nombres:");
		this.lblNombre.setBounds(this.lblDescription, 38, this.lblWidth, 23);
		this.contentPane.add(this.lblNombre);
		
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(this.txtFieldInformation, 38, 300, 23);
		this.txtNombre.setColumns(10);
		this.contentPane.add(this.txtNombre);
		
		this.lblDocumento = new JLabel("Documento:");
		this.lblDocumento.setBounds(this.lblDescription, 68, this.lblWidth, 23);
		this.contentPane.add(this.lblDocumento);
		
		this.txtDocumento = new JTextField();
		this.txtDocumento.setBounds(this.txtFieldInformation, 68, 300, 23);
		this.txtDocumento.setColumns(10);
		this.contentPane.add(this.txtDocumento);
		
		this.lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		this.lblFechaNacimiento.setBounds(this.lblDescription, 98, this.lblWidth, 23);
		this.contentPane.add(this.lblFechaNacimiento);
		
		this.cmbDia = new JComboBox<>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
		this.cmbDia.setBounds(this.txtFieldInformation, 98, 40, 23);
		this.contentPane.add(this.cmbDia);
		
		this.lblSeparation1 = new JLabel("/");
		this.lblSeparation1.setBounds(this.txtFieldInformation + 45, 98, 30, 23);
		this.contentPane.add(this.lblSeparation1);
		
		this.cmbMes = new JComboBox<>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
		this.cmbMes.setBounds(this.txtFieldInformation + 55, 98, 40, 23);
		this.contentPane.add(this.cmbMes);
		
		this.lblSeparation2 = new JLabel("/");
		this.lblSeparation2.setBounds(this.txtFieldInformation + 100, 98, 30, 23);
		this.contentPane.add(this.lblSeparation2);
		
		this.cmbAño = new JComboBox<>(Fecha.getLastHundredArrayList());
		this.cmbAño.setBounds(this.txtFieldInformation + 110, 98, 55, 23);
		this.contentPane.add(this.cmbAño);
		
		this.btnGuardar = new NBtnAcept("Guardar");
		this.btnGuardar.setBounds(this.getWidth() - 450, this.getHeight() - 70, 200, 30);
		this.contentPane.add(this.btnGuardar);
		
		this.btnCancelar = new NBtnCancel("cancelar");
		this.btnCancelar.setBounds(this.getWidth() - 230, this.getHeight() - 70, 200, 30);
		this.contentPane.add(this.btnCancelar);
	}

	/**
	 * method that return all action components.
	 */
	public JButton[] getAllAction() {
		return new JButton[] {this.btnGuardar,  this.btnCancelar};
	}

	public JButton getBtnGuardar() {
		return this.btnGuardar;
	}

	public JButton getBtnCancelar() {
		return this.btnCancelar;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public Fecha getDateFechaNacimiento() {
		Fecha birthday = Fecha.getFecha( this.cmbAño.getSelectedItem() + "-" + this.cmbMes.getSelectedItem() + "-"+ this.cmbDia.getSelectedItem());
		return birthday;
	}
}