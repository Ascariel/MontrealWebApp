package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListPostulacionCentroProgramaOutDTO extends ResponseDTO {
	private List<PostulacionCentroProgramaOutDTO> listPostulacionCentro = new ArrayList<PostulacionCentroProgramaOutDTO>();

	public ListPostulacionCentroProgramaOutDTO() {
		super();
	}

	public ListPostulacionCentroProgramaOutDTO(List<PostulacionCentroProgramaOutDTO> listPostulacionCentro) {
		super();
		this.listPostulacionCentro = listPostulacionCentro;
	}

	public List<PostulacionCentroProgramaOutDTO> getListPostulacionCentro() {
		return listPostulacionCentro;
	}

	public void setListPostulacionCentro(List<PostulacionCentroProgramaOutDTO> listPostulacionCentro) {
		this.listPostulacionCentro = listPostulacionCentro;
	}

	@Override
	public String toString() {
		return "ListPostulacionCentroProgramaOutDTO [listPostulacionCentro=" + listPostulacionCentro + ", toString()="
				+ super.toString() + "]";
	}

}
