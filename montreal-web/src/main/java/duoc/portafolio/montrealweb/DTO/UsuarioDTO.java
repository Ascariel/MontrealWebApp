package duoc.portafolio.montrealweb.DTO;

import javax.validation.constraints.Size;

import org.omg.PortableServer.ID_UNIQUENESS_POLICY_ID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import duoc.portafolio.montrealweb.service.CelService;


//@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO extends ResponseDTO{

	private int idUsuario;
	
	@Size(min = 3, max = 30, message = "Usuario: Debe contener de {min} a {max} caracteres")
	private String usuario;
	
	@Size(min = 8, max = 30, message = "Contraseña: Debe contener de {min} a {max} caracteres")
	private String clave;
	
	private String activo;
	private PerfilDTO perfilDTO;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(int idUsuario, String usuario, String clave, String activo, PerfilDTO perfilDTO) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = clave;
		this.activo = activo;
		this.perfilDTO = perfilDTO;
	}
	
	public UsuarioDTO(PerfilDTO perfilDTO2) {
		// TODO Auto-generated constructor stub
		this.perfilDTO = perfilDTO2;
	}

	public static UsuarioDTO defaultUsuarioDTO() {
		return new UsuarioDTO(new PerfilDTO());
	}	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", activo=" + activo
				+ ", perfilDTO=" + perfilDTO + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
	
}
