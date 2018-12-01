package duoc.portafolio.montrealweb.DTO;

public class PostulacionCentroProgramaOutDTO extends ResponseDTO {

	private int idPostulacion;
	private int idCentro;
	private ProgramaEstudioDTO programaDTO;
	private EstadoPostulacionDTO estadoPostulacionDTO;
	private String observacion;

	public PostulacionCentroProgramaOutDTO() {
		super();
	}

	public PostulacionCentroProgramaOutDTO(int idPostulacion, int idCentro, ProgramaEstudioDTO programaDTO,
			EstadoPostulacionDTO estadoPostulacionDTO, String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idCentro = idCentro;
		this.programaDTO = programaDTO;
		this.estadoPostulacionDTO = estadoPostulacionDTO;
		this.observacion = observacion;
	}
	
	public String nombreEstadoPostulacion() {
		return  getEstadoPostulacionDTO().getNombreEstado();
	}
	
	public String textoBtnEstadoPostulacion() {
		if (nombreEstadoPostulacion().equalsIgnoreCase("Finalizada")) return "btn-danger";
		if (nombreEstadoPostulacion().equalsIgnoreCase("En Curso")) return "btn-success";
		return "btn-primary";
	}

	public int getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public ProgramaEstudioDTO getProgramaDTO() {
		return programaDTO;
	}

	public void setProgramaDTO(ProgramaEstudioDTO programaDTO) {
		this.programaDTO = programaDTO;
	}

	public EstadoPostulacionDTO getEstadoPostulacionDTO() {
		return estadoPostulacionDTO;
	}

	public void setEstadoPostulacionDTO(EstadoPostulacionDTO estadoPostulacionDTO) {
		this.estadoPostulacionDTO = estadoPostulacionDTO;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "PostulacionCentroProgramaOutDTO [idPostulacion=" + idPostulacion + ", idCentro=" + idCentro
				+ ", programaDTO=" + programaDTO + ", estadoPostulacionDTO=" + estadoPostulacionDTO + ", observacion="
				+ observacion + ", toString()=" + super.toString() + "]";
	}

}
