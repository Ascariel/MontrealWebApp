package duoc.portafolio.montrealweb.DTO;

public class EstadoProgramaDTO extends ResponseDTO{
	
	private int idEstadoPrograma;
	private String nombreEstadoPrograma;
	
	
	
	public EstadoProgramaDTO() {
		super();
	}
	
	public EstadoProgramaDTO(int idEstadoPrograma, String nombreEstadoPrograma) {
		super();
		this.idEstadoPrograma = idEstadoPrograma;
		this.nombreEstadoPrograma = nombreEstadoPrograma;
	}
	
	public int getIdEstadoPrograma() {
		return idEstadoPrograma;
	}
	public void setIdEstadoPrograma(int idEstadoPrograma) {
		this.idEstadoPrograma = idEstadoPrograma;
	}
	public String getNombreEstadoPrograma() {
		return nombreEstadoPrograma;
	}
	public void setNombreEstadoPrograma(String nombreEstadoPrograma) {
		this.nombreEstadoPrograma = nombreEstadoPrograma;
	}

	@Override
	public String toString() {
		return "EstadoProgramaDTO [idEstadoPrograma=" + idEstadoPrograma + ", nombreEstadoPrograma="
				+ nombreEstadoPrograma + ", getMessage()=" + getMessage() + "]";
	}
	
	
	

}
