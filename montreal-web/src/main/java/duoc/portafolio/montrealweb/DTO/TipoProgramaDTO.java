package duoc.portafolio.montrealweb.DTO;

public class TipoProgramaDTO extends ResponseDTO{
	
	private int idTipoPrograma;
	private String nombreTipoPrograma;
	
	public TipoProgramaDTO() {
		super();
	}

	public TipoProgramaDTO(int idTipoPrograma, String nombreTipoPrograma) {
		super();
		this.idTipoPrograma = idTipoPrograma;
		this.nombreTipoPrograma = nombreTipoPrograma;
	}

	public int getIdTipoPrograma() {
		return idTipoPrograma;
	}

	public void setIdTipoPrograma(int idTipoPrograma) {
		this.idTipoPrograma = idTipoPrograma;
	}

	public String getNombreTipoPrograma() {
		return nombreTipoPrograma;
	}

	public void setNombreTipoPrograma(String nombreTipoPrograma) {
		this.nombreTipoPrograma = nombreTipoPrograma;
	}

	@Override
	public String toString() {
		return "TipoPogramaDTO [idTipoPrograma=" + idTipoPrograma + ", nombreTipoPrograma=" + nombreTipoPrograma
				+ ", toString()=" + super.toString() + "]";
	}
	
	

	
}
