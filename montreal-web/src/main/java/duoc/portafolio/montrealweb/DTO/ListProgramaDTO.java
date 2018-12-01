package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListProgramaDTO extends ResponseDTO{
	
	private List<ProgramaEstudioDTO> listProgramaDTO = new ArrayList<ProgramaEstudioDTO>();

	public ListProgramaDTO(List<ProgramaEstudioDTO> listProgramaDTO) {
		super();
		this.listProgramaDTO = listProgramaDTO;
	}

	public ListProgramaDTO() {
		super();
	}

	public List<ProgramaEstudioDTO> getListProgramaDTO() {
		return listProgramaDTO;
	}

	public void setListProgramaDTO(List<ProgramaEstudioDTO> listProgramaDTO) {
		this.listProgramaDTO = listProgramaDTO;
	}

	@Override
	public String toString() {
		return "ListProgramaDTO [listProgramaDTO=" + listProgramaDTO + ", toString()=" + super.toString() + "]";
	}
	
	
}
