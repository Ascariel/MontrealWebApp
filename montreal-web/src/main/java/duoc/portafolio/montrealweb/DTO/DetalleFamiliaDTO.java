package duoc.portafolio.montrealweb.DTO;

public class DetalleFamiliaDTO extends ResponseDTO {

	private int idPostulacion;

	private int idCentro;
	private int idFamilia;
	private String nombreFamilia;
	private String apellidoFamilia;
	private String correo;
	private String telefono;
	private String activo;
	private String direccion;
	private PaisDTO paisDTO;
	private EstadoPostulacionDTO estadoPostulacion;
	private String observacion;

	public DetalleFamiliaDTO() {
		super();
	}

	public DetalleFamiliaDTO(int idPostulacion, int idCentro, int idFamilia, String nombreFamilia,
			String apellidoFamilia, String correo, String telefono, String activo, String direccion, PaisDTO paisDTO,
			EstadoPostulacionDTO estadoPostulacion, String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idCentro = idCentro;
		this.idFamilia = idFamilia;
		this.nombreFamilia = nombreFamilia;
		this.apellidoFamilia = apellidoFamilia;
		this.correo = correo;
		this.telefono = telefono;
		this.activo = activo;
		this.direccion = direccion;
		this.paisDTO = paisDTO;
		this.estadoPostulacion = estadoPostulacion;
		this.observacion = observacion;
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

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public PaisDTO getPaisDTO() {
		return paisDTO;
	}

	public void setPaisDTO(PaisDTO paisDTO) {
		this.paisDTO = paisDTO;
	}

	public EstadoPostulacionDTO getEstadoPostulacion() {
		return estadoPostulacion;
	}

	public void setEstadoPostulacion(EstadoPostulacionDTO estadoPostulacion) {
		this.estadoPostulacion = estadoPostulacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "DetalleFamiliaDTO [idPostulacion=" + idPostulacion + ", idCentro=" + idCentro + ", idFamilia="
				+ idFamilia + ", nombreFamilia=" + nombreFamilia + ", apellidoFamilia=" + apellidoFamilia + ", correo="
				+ correo + ", telefono=" + telefono + ", activo=" + activo + ", direccion=" + direccion + ", paisDTO="
				+ paisDTO + ", estadoPostulacion=" + estadoPostulacion + ", observacion=" + observacion
				+ ", toString()=" + super.toString() + "]";
	}

}
