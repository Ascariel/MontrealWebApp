package duoc.portafolio.montrealweb.DTO;

public class EstadoPostulacionDTO extends ResponseDTO {

	private int idEstadoPostulacion;
	private String nombreEstado;
	
	public EstadoPostulacionDTO() {
		super();
	}
	
	public EstadoPostulacionDTO(int idEstadoPostulacion, String nombreEstado) {
		super();
		this.idEstadoPostulacion = idEstadoPostulacion;
		this.nombreEstado = nombreEstado;
	}

	public int getIdEstadoPostulacion() {
		return idEstadoPostulacion;
	}

	public void setIdEstadoPostulacion(int idEstadoPostulacion) {
		this.idEstadoPostulacion = idEstadoPostulacion;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	
	public String textoBtnEstadoPostulacion() {
		System.out.println("");
		System.out.println("");
		System.out.println(idEstadoPostulacion);
		System.out.println("");
//		if (nombreEstado.equalsIgnoreCase("Finalizada")) return "btn-danger";
		if (nombreEstado.equalsIgnoreCase("Finalizado")) return "btn-danger";
		if (nombreEstado.equalsIgnoreCase("En Curso")) return "btn-success";
		

		return "btn-primary";
	}
	

	@Override
	public String toString() {
		return "EstadoPostulacionDTO [idEstadoPostulacion=" + idEstadoPostulacion + ", nombreEstado=" + nombreEstado
				+ ", toString()=" + super.toString() + "]";
	}
	
	


}
