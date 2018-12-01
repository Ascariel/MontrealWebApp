package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListCelDTO extends ResponseDTO{
	
	private List<CelDTO> listCel = new ArrayList<CelDTO>();

	public ListCelDTO(List<CelDTO> listCel) {
		super();
		this.listCel = listCel;
	}

	public ListCelDTO() {
		super();
	}

	public List<CelDTO> getListCel() {
		return listCel;
	}

	public void setListCel(List<CelDTO> listCel) {
		this.listCel = listCel;
	}

	@Override
	public String toString() {
		return "ListCelDTO [listCel=" + listCel + ", toString()=" + super.toString() + "]";
	}
	
	
}
