package duoc.portafolio.montrealweb.DTO;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class CelDTO extends ResponseDTO {

	private int id;
	@Size(min = 3, max = 30, message = "Nombre : Debe contener de {min} a {max} caracteres")
	private String nombre;
	
	@Size(min = 3, max = 30, message = "Correo : Debe contener de {min} a {max} caracteres")
	private String correo;
	
	@Size(min = 6, max = 12, message = "Teléfono : Debe contener de {min} a {max} digitos")
	private String telefono;
	
	@Size(min = 3, max = 45, message = "Dirección : Debe contener de {min} a {max} caracteres")
	private String direccion;
	private String activo = "1";
	
	@Valid
	private UsuarioDTO usuarioDTO;
	
	private PaisDTO paisDTO;
	private UsuarioDTO login;

	public CelDTO() {
		super();
	}	
	
	public CelDTO(int id, String nombre, String correo, String telefono, String direccion, String activo,
			UsuarioDTO usuarioDTO, PaisDTO paisDTO, UsuarioDTO login) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.activo = activo;
		this.usuarioDTO = usuarioDTO;
		this.paisDTO = paisDTO;
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public PaisDTO getPaisDTO() {
		return paisDTO;
	}

	public void setPaisDTO(PaisDTO paisDTO) {
		this.paisDTO = paisDTO;
	}

	public UsuarioDTO getLogin() {
		return login;
	}

	public void setLogin(UsuarioDTO login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "CelDTO [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", activo=" + activo + ", usuarioDTO=" + usuarioDTO + ", paisDTO="
				+ paisDTO + ", login=" + login + ", toString()=" + super.toString() + "]";
	}
	
	
}
