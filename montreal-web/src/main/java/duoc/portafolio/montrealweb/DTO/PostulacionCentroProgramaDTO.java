package duoc.portafolio.montrealweb.DTO;

public class PostulacionCentroProgramaDTO extends ResponseDTO {

	private int idPostulacion;
	private int idPrograma;
	private int idCentro;
	private int idEstadoPostulacion;
	private String observacion;

	public PostulacionCentroProgramaDTO() {
		super();
	}

	public PostulacionCentroProgramaDTO(int idPostulacion, int idPrograma, int idCentro, int idEstadoPostulacion,
			String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idPrograma = idPrograma;
		this.idCentro = idCentro;
		this.idEstadoPostulacion = idEstadoPostulacion;
		this.observacion = observacion;
	}
	
	public PostulacionCentroProgramaDTO(int idPrograma, int idCentro, int idEstadoPostulacion, String obs) {
		super();
		this.idPrograma = idPrograma;
		this.idCentro = idCentro;
		this.idEstadoPostulacion = idEstadoPostulacion;
		this.observacion = obs;
	}	

	public int getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public int getIdEstadoPostulacion() {
		return idEstadoPostulacion;
	}

	public void setIdEstadoPostulacion(int idEstadoPostulacion) {
		this.idEstadoPostulacion = idEstadoPostulacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "PostulacionCentroProgramaDTO [idPostulacion=" + idPostulacion + ", idPrograma=" + idPrograma
				+ ", idCentro=" + idCentro + ", idEstadoPostulacion=" + idEstadoPostulacion + ", observacion="
				+ observacion + ", toString()=" + super.toString() + "]";
	}

}
