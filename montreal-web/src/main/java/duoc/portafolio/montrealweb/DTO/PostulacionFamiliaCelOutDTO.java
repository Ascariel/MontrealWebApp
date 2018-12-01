package duoc.portafolio.montrealweb.DTO;

public class PostulacionFamiliaCelOutDTO extends ResponseDTO{

    private int idPostulacion;
    private int idFamilia;
    private int idCentro;
    
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private PaisDTO paisDTO;
    private EstadoPostulacionDTO estadoPostulacion;
    private String observacion;
    
	public PostulacionFamiliaCelOutDTO() {
		super();
	}  
    
	
	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public PostulacionFamiliaCelOutDTO(int idPostulacion, int idFamilia, int idCentro, String nombre, String correo,
			String telefono, String direccion, PaisDTO paisDTO, EstadoPostulacionDTO estadoPostulacion,
			String observacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idFamilia = idFamilia;
		this.idCentro = idCentro;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.paisDTO = paisDTO;
		this.estadoPostulacion = estadoPostulacion;
		this.observacion = observacion;
	}


	public PostulacionFamiliaCelOutDTO(int idPostulacion, int idFamilia, int idCentro, String nombre, String correo,
			String telefono, String direccion, PaisDTO paisDTO, EstadoPostulacionDTO estadoPostulacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idFamilia = idFamilia;
		this.idCentro = idCentro;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.paisDTO = paisDTO;
		this.estadoPostulacion = estadoPostulacion;
	}
	
	public int getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public int getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}
	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	@Override
	public String toString() {
		return "PostulacionFamiliaCelOutDTO [idPostulacion=" + idPostulacion + ", idFamilia=" + idFamilia
				+ ", idCentro=" + idCentro + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", paisDTO=" + paisDTO + ", estadoPostulacion=" + estadoPostulacion
				+ ", toString()=" + super.toString() + "]";
	}
    
    
}
