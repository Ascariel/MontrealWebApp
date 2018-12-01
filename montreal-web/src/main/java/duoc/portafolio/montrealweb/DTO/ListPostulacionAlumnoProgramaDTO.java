package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListPostulacionAlumnoProgramaDTO extends ResponseDTO {
	private List<PostulacionAlumnoProgramaDTO> listPostAlumnoPrograma = new ArrayList<PostulacionAlumnoProgramaDTO>();

	public ListPostulacionAlumnoProgramaDTO() {
		super();
	}

	public ListPostulacionAlumnoProgramaDTO(List<PostulacionAlumnoProgramaDTO> listPostAlumnoPrograma) {
		super();
		this.listPostAlumnoPrograma = listPostAlumnoPrograma;
	}

	public List<PostulacionAlumnoProgramaDTO> getListPostAlumnoPrograma() {
		return listPostAlumnoPrograma;
	}

	public void setListPostAlumnoPrograma(List<PostulacionAlumnoProgramaDTO> listPostAlumnoPrograma) {
		this.listPostAlumnoPrograma = listPostAlumnoPrograma;
	}

	@Override
	public String toString() {
		return "ListPostulacionAlumnoProgramaDTO [listPostAlumnoPrograma=" + listPostAlumnoPrograma + ", toString()="
				+ super.toString() + "]";
	}

}
