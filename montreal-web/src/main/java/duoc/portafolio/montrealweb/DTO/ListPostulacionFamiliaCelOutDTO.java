package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListPostulacionFamiliaCelOutDTO extends ResponseDTO{
	
	private List<PostulacionFamiliaCelOutDTO> listPostulacionFamilia = new ArrayList<PostulacionFamiliaCelOutDTO>();

	public ListPostulacionFamiliaCelOutDTO() {
		super();
	}

	
	public ListPostulacionFamiliaCelOutDTO(List<PostulacionFamiliaCelOutDTO> listPostulacionFamiliaCelOutDTO) {
		super();
		this.listPostulacionFamilia = listPostulacionFamiliaCelOutDTO;
	}


	public List<PostulacionFamiliaCelOutDTO> getListPostulacionFamilia() {
		return listPostulacionFamilia;
	}


	public void setListPostulacionFamilia(List<PostulacionFamiliaCelOutDTO> listPostulacionFamilia) {
		this.listPostulacionFamilia = listPostulacionFamilia;
	}


	@Override
	public String toString() {
		return "ListPostulacionFamiliaCelOutDTO [listPostulacionFamiliaCelOutDTO=" + listPostulacionFamilia
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
