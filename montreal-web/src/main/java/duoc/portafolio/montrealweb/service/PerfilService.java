package duoc.portafolio.montrealweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import duoc.portafolio.montrealweb.DTO.PerfilDTO;

@Service
public class PerfilService {
	private static ArrayList<PerfilDTO> listadoPerfilDTO = new ArrayList<PerfilDTO>();
	
	static {
		listadoPerfilDTO.add(new PerfilDTO(1, "CEM"));
		listadoPerfilDTO.add(new PerfilDTO(1, "CEL"));
		listadoPerfilDTO.add(new PerfilDTO(1, "FAMILIA"));
		listadoPerfilDTO.add(new PerfilDTO(1, "ALUMNO"));
	}
	
	public static PerfilDTO obtenerPerfilPorRol(String rol) {
		for (PerfilDTO perfilDTO : listadoPerfilDTO) {
			if (perfilDTO.getNombre().equalsIgnoreCase(rol)) {
				return perfilDTO;
			}
		}
		return null;
		
	}
	
	
	
}
