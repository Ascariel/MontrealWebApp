package duoc.portafolio.montrealweb.DTO;

public class ProgramaEstudioDTO extends ResponseDTO {

	private int idPrograma;
	private String nombre;
	private String fechaInicioPrograma;
	private String fechaTerminoPrograma;
	private String cantCuposMaximos;
	private String cantCuposMinimos;
	private String codigoPrograma;
	private String activo;	
	
	private EstadoProgramaDTO estadoProgramaDTO;
	private TipoProgramaDTO tipoProgramaDTO;
	private PaisDTO paisDTO;
	
	

	public ProgramaEstudioDTO() {
		super();
	}


	public ProgramaEstudioDTO(int idPrograma, String nombre, String fechaInicioPrograma, String fechaTerminoPrograma,
			String cantCuposMax, String cantCuposMin, String codigoPrograma, String activo,
			EstadoProgramaDTO estadoProgramaDTO, TipoProgramaDTO tipoProgramaDTO, PaisDTO paisDTO) {
		super();
		this.idPrograma = idPrograma;
		this.nombre = nombre;
		this.fechaInicioPrograma = fechaInicioPrograma;
		this.fechaTerminoPrograma = fechaTerminoPrograma;
		this.cantCuposMaximos = cantCuposMax;
		this.cantCuposMinimos = cantCuposMin;
		this.codigoPrograma = codigoPrograma;
		this.activo = activo;
		this.estadoProgramaDTO = estadoProgramaDTO;
		this.tipoProgramaDTO = tipoProgramaDTO;
		this.paisDTO = paisDTO;
	}


	public int getIdPrograma() {
		return idPrograma;
	}


	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFechaInicioPrograma() {
		return fechaInicioPrograma;
	}


	public void setFechaInicioPrograma(String fechaInicioPrograma) {
		this.fechaInicioPrograma = fechaInicioPrograma;
	}


	public String getFechaTerminoPrograma() {
		return fechaTerminoPrograma;
	}


	public void setFechaTerminoPrograma(String fechaTerminoPrograma) {
		this.fechaTerminoPrograma = fechaTerminoPrograma;
	}


	public String getCantCuposMaximos() {
		return cantCuposMaximos;
	}


	public void setCantCuposMaximos(String cantCuposMax) {
		this.cantCuposMaximos = cantCuposMax;
	}


	public String getCantCuposMinimos() {
		return cantCuposMinimos;
	}


	public void setCantCuposMinimos(String cantCuposMin) {
		this.cantCuposMinimos = cantCuposMin;
	}


	public String getCodigoPrograma() {
		return codigoPrograma;
	}


	public void setCodigoPrograma(String codigoPrograma) {
		this.codigoPrograma = codigoPrograma;
	}


	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}


	public EstadoProgramaDTO getEstadoProgramaDTO() {
		return estadoProgramaDTO;
	}


	public void setEstadoProgramaDTO(EstadoProgramaDTO estadoProgramaDTO) {
		this.estadoProgramaDTO = estadoProgramaDTO;
	}


	public TipoProgramaDTO getTipoProgramaDTO() {
		return tipoProgramaDTO;
	}


	public void setTipoProgramaDTO(TipoProgramaDTO tipoProgramaDTO) {
		this.tipoProgramaDTO = tipoProgramaDTO;
	}


	public PaisDTO getPaisDTO() {
		return paisDTO;
	}


	public void setPaisDTO(PaisDTO paisDTO) {
		this.paisDTO = paisDTO;
	}


	@Override
	public String toString() {
		return "ProgramaEstudioDTO [idPrograma=" + idPrograma + ", nombre=" + nombre + ", fechaInicioPrograma="
				+ fechaInicioPrograma + ", fechaTerminoPrograma=" + fechaTerminoPrograma + ", cantCuposMax="
				+ cantCuposMaximos + ", cantCuposMin=" + cantCuposMinimos + ", codigoPrograma=" + codigoPrograma + ", activo="
				+ activo + ", estadoProgramaDTO=" + estadoProgramaDTO + ", tipoProgramaDTO=" + tipoProgramaDTO
				+ ", paisDTO=" + paisDTO + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
