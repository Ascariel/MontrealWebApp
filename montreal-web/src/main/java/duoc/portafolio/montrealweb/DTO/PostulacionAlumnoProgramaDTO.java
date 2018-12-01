package duoc.portafolio.montrealweb.DTO;

public class PostulacionAlumnoProgramaDTO extends ResponseDTO {

	private int idPostulacion;
	private int idPrograma;
	private int idAlumno;
	private String rut;
	private String nombre;
	private String apellidos;
	private String correo;
	private String fechaNacimiento;
	private String activo;
	private String observacion;
	private EstadoPostulacionDTO estadoPostulacionDTO;

	public PostulacionAlumnoProgramaDTO() {
		super();
	}

	public PostulacionAlumnoProgramaDTO(int idAlumno, String rut, String nombre, String apellidos, String correo,
			String fechaNacimiento, String activo, int idPostulacion, int idPrograma, String observacion,
			EstadoPostulacionDTO estadoPostulacionDTO) {
		super();
		this.idAlumno = idAlumno;
		this.rut = rut;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.idPostulacion = idPostulacion;
		this.idPrograma = idPrograma;
		this.observacion = observacion;
		this.estadoPostulacionDTO = estadoPostulacionDTO;
	}
	
	public String nombreCompletoAlumno() {
		return nombre + " " + apellidos;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EstadoPostulacionDTO getEstadoPostulacionDTO() {
		return estadoPostulacionDTO;
	}

	public void setEstadoPostulacionDTO(EstadoPostulacionDTO estadoPostulacionDTO) {
		this.estadoPostulacionDTO = estadoPostulacionDTO;
	}

	@Override
	public String toString() {
		return "PostulacionAlumnoProgramaDTO [idAlumno=" + idAlumno + ", rut=" + rut + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento
				+ ", activo=" + activo + ", idPostulacion=" + idPostulacion + ", idPrograma=" + idPrograma
				+ ", observacion=" + observacion + ", estadoPostulacionDTO=" + estadoPostulacionDTO + ", toString()="
				+ super.toString() + "]";
	}

}
