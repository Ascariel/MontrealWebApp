package duoc.portafolio.montrealweb.DTO;

public class CambiarClaveDTO extends ResponseDTO{

	
    public String claveNueva;
    public String usuario;
    public String activo = "1";
    
    
	public CambiarClaveDTO(String claveNueva, String usuario) {
		super();
		this.claveNueva = claveNueva;
		this.usuario = usuario;
	}
	
	


	public CambiarClaveDTO() {
		super();
	}




	public CambiarClaveDTO(String claveNueva, String usuario, String activo) {
		super();
		this.claveNueva = claveNueva;
		this.usuario = usuario;
		this.activo = activo;
	}


	public String getClaveNueva() {
		return claveNueva;
	}


	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}


	@Override
	public String toString() {
		return "CambiarClaveDTO [claveNueva=" + claveNueva + ", usuario=" + usuario + ", activo=" + activo
				+ ", toString()=" + super.toString() + "]";
	}
	
	

    
    
}
