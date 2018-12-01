package duoc.portafolio.montrealweb.DTO;

public class PostulacionFamiliaCelDTO extends ResponseDTO{

	private int idPostulacion;
	private int idCentro;
	private int idFamilia;
	private int idEstado;
	private String observacion;
	
	public PostulacionFamiliaCelDTO() {
		super();
	}
	
	
	public PostulacionFamiliaCelDTO(int idPostulacion, int idEstado, String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idEstado = idEstado;
		this.observacion = observacion;
	}


	public PostulacionFamiliaCelDTO(int idPostulacion, int idCentro, int idFamilia, int idEstado, String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idCentro = idCentro;
		this.idFamilia = idFamilia;
		this.idEstado = idEstado;
		this.observacion = observacion;
	}
	
	public PostulacionFamiliaCelDTO(int idCentro, int idFamilia) {
		super();
		this.idPostulacion = 0;
		this.idCentro = idCentro;
		this.idFamilia = idFamilia;
		this.idEstado = 1;
		this.observacion = "";
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
	public int getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "PostulacionFamiliaCelDTO [idPostulacion=" + idPostulacion + ", idCentro=" + idCentro + ", idFamilia="
				+ idFamilia + ", idEstado=" + idEstado + ", observacion=" + observacion + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
