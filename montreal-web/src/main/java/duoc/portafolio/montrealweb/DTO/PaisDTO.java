package duoc.portafolio.montrealweb.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PaisDTO extends ResponseDTO {
	private int id;
	private String pais;
	private String codigoPostalPais;
	
	
	public PaisDTO() {
		super();

	}
	
	public PaisDTO(int id, String pais, String codigoPostalPais) {
		super();
		this.id = id;
		this.pais = pais;
		this.codigoPostalPais = codigoPostalPais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostalPais() {
		return codigoPostalPais;
	}

	public void setCodigoPostalPais(String codigoPostalPais) {
		this.codigoPostalPais = codigoPostalPais;
	}

	@Override
	public String toString() {
		return "PaisDTO [id=" + id + ", pais=" + pais + ", codigoPostalPais=" + codigoPostalPais + ", toString()="
				+ super.toString() + "]";
	}


	
}
