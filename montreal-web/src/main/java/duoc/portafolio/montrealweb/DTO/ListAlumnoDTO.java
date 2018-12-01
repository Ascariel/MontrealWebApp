package duoc.portafolio.montrealweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListAlumnoDTO extends ResponseDTO {

	private List<AlumnoDTO> listAlumnos = new ArrayList<AlumnoDTO>();

	public ListAlumnoDTO() {
		super();
	}

	public ListAlumnoDTO(List<AlumnoDTO> listAlumnos) {
		super();
		this.listAlumnos = listAlumnos;
	}

	public List<AlumnoDTO> getListAlumnos() {
		return listAlumnos;
	}

	public void setListAlumnos(List<AlumnoDTO> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}

	@Override
	public String toString() {
		return "ListAlumnoDTO [listAlumnos=" + listAlumnos + ", toString()=" + super.toString() + "]";
	}

}
