package dto;

import variables.Fecha;
import variables.IdCliente;

public class ClienteDTO {

	private IdCliente _idCliente;
	private String _nombre;
	private String _apellido;
	private String _nacionalidad;
	private String _tipoDoc; 
	private String _numDocumento;
	private Fecha _fechaNacimiento;
	private String _ciudad; 
	private String _localidad;
	
	public ClienteDTO(IdCliente IdCliente, String Nombre, String Apellido, String Nacionalidad,
			String TipoDoc, String NumDoc, Fecha FechaNacimiento, String Ciudad, String Localidad) {
		this._idCliente = IdCliente;
		this._nombre = Nombre;
		this._apellido = Apellido;
		this._nacionalidad = Nacionalidad;
		this._tipoDoc = TipoDoc;
		this._numDocumento = NumDoc;
		this._fechaNacimiento = FechaNacimiento;
		this._ciudad = Ciudad;
		this._localidad = Localidad;
	}

	public IdCliente getIdCliente() {
		return _idCliente;
	}

	public String getNombre() {
		return this._nombre;
	}

	public String getApellido() {
		return this._apellido;
	}

	public String getNacionalidad() {
		return this._nacionalidad;
	}

	public String getTipoDoc() {
		return this._tipoDoc;
	}

	public String getNumDocumento() {
		return this._numDocumento;
	}

	public Fecha getFechaNacimiento() {
		return this._fechaNacimiento;
	}

	public String getCiudad() {
		return this._ciudad;
	}

	public String getLocalidad() {
		return this._localidad;
	}
}