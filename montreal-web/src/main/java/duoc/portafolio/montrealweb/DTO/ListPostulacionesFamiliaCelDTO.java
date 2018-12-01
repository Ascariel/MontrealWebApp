package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListPostulacionesFamiliaCelDTO extends ResponseDTO {

	private List<DetalleFamiliaDTO> listDetalleFamilia = new ArrayList<DetalleFamiliaDTO>();

	public ListPostulacionesFamiliaCelDTO() {
		super();
	}

	public ListPostulacionesFamiliaCelDTO(List<DetalleFamiliaDTO> listDetalleFamilia) {
		super();
		this.listDetalleFamilia = listDetalleFamilia;
	}

	public List<DetalleFamiliaDTO> getListDetalleFamilia() {
		return listDetalleFamilia;
	}

	public void setListDetalleFamilia(List<DetalleFamiliaDTO> listDetalleFamilia) {
		this.listDetalleFamilia = listDetalleFamilia;
	}

	@Override
	public String toString() {
		return "ListPostulacionesFamiliaCelDTO [listDetalleFamilia=" + listDetalleFamilia + ", toString()="
				+ super.toString() + "]";
	}

}
