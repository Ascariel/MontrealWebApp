package duoc.portafolio.montrealweb.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.taglibs.standard.tag.rt.core.ForEachTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import duoc.portafolio.montrealweb.DTO.ListProgramaDTO;
import duoc.portafolio.montrealweb.DTO.PaisDTO;
import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;

@Service
public class ProgramaEstudioService {
	
	private static String listarProgramasPostulablesAlumnoUrl = "http://localhost:49667/api/AdminPrograma/ListarProgramas";
	private static String listarProgramasPorPais = "http://localhost:49667/api/AdminPrograma/ListarProgramasDisponiblesCel";
	private static String listadoProgramasPostulablesCel = "http://localhost:49667/api/AdminPrograma/ListarProgramasDisponiblesCel";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<ProgramaEstudioDTO> listadoProgramasDTO(){
		return restTemplate.getForObject(listarProgramasPostulablesAlumnoUrl, ListProgramaDTO.class).getListProgramaDTO();	
	}
	

	public List<ProgramaEstudioDTO> programasPostulablesAlumno(){
		return listadoProgramasDTO();	

	}	
	
	public List<ProgramaEstudioDTO> programasPostulablesCel(int idPais){
		String url = listadoProgramasPostulablesCel + "/" + idPais;
		return restTemplate.getForObject(url, ListProgramaDTO.class).getListProgramaDTO();	

	}	
	
	public ProgramaEstudioDTO obtenerProgramaPorID(int id) {		
		for (ProgramaEstudioDTO programa : listadoProgramasDTO()) {
			if (programa.getIdPrograma() == id) {
				return programa;
			}
		}
		return null;
	}	
	


}
