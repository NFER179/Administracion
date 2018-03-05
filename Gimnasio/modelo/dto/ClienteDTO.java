package dto;

import variables.Fecha;
import variables.IdCliente;

public class ClienteDTO {

	private IdCliente idCliente;
	private String sNombre;
	private String sApellido;
	private String sNacionalidad;
	private String sTipoDoc; 
	private String sNumDocumento;
	private Fecha daeFechaNacimiento;
	private String sCiudad; 
	private String sLocalidad;
	private Fecha dateSignon;
	
	/*public ClienteDTO(IdCliente IdCliente, String Nombre, String Apellido, String Nacionalidad,
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
	}*/
	
	public ClienteDTO(IdCliente IdCliente, String Nombre, String Apellido, String NumDoc
			, Fecha FechaNacimiento, Fecha Signon) {
		this.idCliente = IdCliente;
		this.sNombre = Nombre;
		this.sApellido = Apellido;
		this.sNumDocumento = NumDoc;
		this.daeFechaNacimiento = FechaNacimiento;
		this.dateSignon = Signon;
	}

	public IdCliente getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return this.sNombre;
	}

	public String getApellido() {
		return this.sApellido;
	}

	public String getNacionalidad() {
		return this.sNacionalidad;
	}

	public String getTipoDoc() {
		return this.sTipoDoc;
	}

	public String getNumDocumento() {
		return this.sNumDocumento;
	}

	public Fecha getFechaNacimiento() {
		return this.daeFechaNacimiento;
	}

	public String getCiudad() {
		return this.sCiudad;
	}

	public String getLocalidad() {
		return this.sLocalidad;
	}
	
	public Fecha getSignon() {
		return this.dateSignon;
	}
}