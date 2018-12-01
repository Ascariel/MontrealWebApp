package duoc.portafolio.montrealweb.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PerfilDTO extends ResponseDTO {
	private int id;
	private String nombre;
	
	public PerfilDTO() {
		super();
	}

	public PerfilDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PerfilDTO [id=" + id + ", nombre=" + nombre + ", toString()=" + super.toString() + "]";
	}
	
	
}
