package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListAcuerdoAlumnoFamiliaDTO extends ResponseDTO {

	private List<AcuerdoAlumnoFamiliaDTO> listAcuerdoAlumnoDTO = new ArrayList<AcuerdoAlumnoFamiliaDTO>();

	public ListAcuerdoAlumnoFamiliaDTO() {
		super();
	}

	public ListAcuerdoAlumnoFamiliaDTO(List<AcuerdoAlumnoFamiliaDTO> listAcuerdoAlumnoDTO) {
		super();
		this.listAcuerdoAlumnoDTO = listAcuerdoAlumnoDTO;
	}

	public List<AcuerdoAlumnoFamiliaDTO> getListAcuerdoAlumnoDTO() {
		return listAcuerdoAlumnoDTO;
	}

	public void setListAcuerdoAlumnoDTO(List<AcuerdoAlumnoFamiliaDTO> listAcuerdoAlumnoDTO) {
		this.listAcuerdoAlumnoDTO = listAcuerdoAlumnoDTO;
	}

	@Override
	public String toString() {
		return "ListAcuerdoAlumnoFamiliaDTO [listAcuerdoAlumnoDTO=" + listAcuerdoAlumnoDTO + ", toString()="
				+ super.toString() + "]";
	}

}
