package duoc.portafolio.montrealweb.DTO;

public class LoginDTO extends ResponseDTO {
    private int idUsuario;
    private String usuario; 
    private String clave;
    private String activo; 
    private PerfilDTO perfilDTO = new PerfilDTO();
    
	public LoginDTO(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public LoginDTO() {
		super();
	} 
	
	public LoginDTO(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	} 	
    
	public LoginDTO(int idUsuario, String usuario, String clave, String activo, PerfilDTO perfilDTO) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = clave;
		this.activo = activo;
		this.perfilDTO = perfilDTO;
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
		return "LoginDTO [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", activo=" + activo
				+ ", perfilDTO=" + perfilDTO + ", toString()=" + super.toString() + "]";
	}
	
	
    
    
}
