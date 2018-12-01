package duoc.portafolio.montrealweb.DTO;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class FamiliaDTO extends ResponseDTO {

	private int idFamilia;
	@Size(min = 3, max = 30, message = "Nombre Familia: Debe contener de {min} a {max} caracteres")
	private String nombreFamilia;

	@Size(min = 3, max = 30, message = "Apellido Familia: Debe contener de {min} a {max} caracteres")
	private String apellidoFamilia;

	@Size(min = 6, max = 12, message = "Teléfono: Debe contener de {min} a {max} digitos")
	private String telefono;

	@Size(min = 3, max = 30, message = "Correo: Debe contener de {min} a {max} caracteres")
	@Email(message = "Utilize un formato de correo válido. Ejemplo mi_correo@gmail.com")
	private String correo;

	@Size(min = 3, max = 45, message = "Dirección: Debe contener de {min} a {max} caracteres")
	private String direccion;
	
	private String activo;
	
	@Valid
	private UsuarioDTO usuarioDTO;
	
	@Valid
	private PaisDTO paisDTO;

	public FamiliaDTO() {
		super();
	}

	public FamiliaDTO(int code, String message, int idFamilia, String nombreFamilia, String apellidoFamilia,
			String telefono, String correo, String direccion, String activo, UsuarioDTO usuarioDTO, PaisDTO paisDTO) {
		super(code, message);
		this.idFamilia = idFamilia;
		this.nombreFamilia = nombreFamilia;
		this.apellidoFamilia = apellidoFamilia;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.activo = activo;
		this.usuarioDTO = usuarioDTO;
		this.paisDTO = paisDTO;
	}

	public FamiliaDTO(UsuarioDTO defaultUsuarioDTO) {
		// TODO Auto-generated constructor stub
		this.usuarioDTO = defaultUsuarioDTO;
	}

	public int getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public String getApellidoFamilia() {
		return apellidoFamilia;
	}

	public void setApellidoFamilia(String apellidoFamilia) {
		this.apellidoFamilia = apellidoFamilia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	@Override
	public String toString() {
		return "FamiliaDTO [idFamilia=" + idFamilia + ", nombreFamilia=" + nombreFamilia + ", apellidoFamilia="
				+ apellidoFamilia + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion
				+ ", activo=" + activo + ", usuarioDTO=" + usuarioDTO + ", paisDTO=" + paisDTO + ", toString()="
				+ super.toString() + "]";
	}

}
