package duoc.portafolio.montrealweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import duoc.portafolio.montrealweb.DTO.AlumnoDTO;
import duoc.portafolio.montrealweb.DTO.ListAcuerdoAlumnoFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListAlumnoDTO;
import duoc.portafolio.montrealweb.DTO.ListProgramaDTO;
import duoc.portafolio.montrealweb.DTO.LoginDTO;
import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;
import duoc.portafolio.montrealweb.DTO.UsuarioDTO;

@Service
public class AlumnoService {
	static String obtenerActorUrl = "http://localhost:49667/api/AdminAlumnos/BuscarAlumno";
	static String crearAlumnoUrl = "http://localhost:49667/api/AdminAlumnos/CrearAlumno";
	static String editarAlumnoUrl = "http://localhost:49667/api/AdminAlumnos/ModificarAlumno";
	static String listarAcuerdosAlumnoFamilia = "http://localhost:49667/api/Mantenedor/ListAcuerdoAlumnos/";
	static String listarAlumnos = "http://localhost:49667/api/AdminAlumnos/ListarAlumnos";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public AlumnoDTO obtenerAlumnoPorUsario(String usuario) {

		String url = obtenerActorUrl + "/" + usuario;
		AlumnoDTO alumnoDTO = restTemplate.getForObject(url, AlumnoDTO.class);

		System.out.println(alumnoDTO.getFechaNacimiento());
		return alumnoDTO;
	}
	
	public ListAlumnoDTO listarAlumnos() {
		ListAlumnoDTO listAlumnoDTO = restTemplate.getForObject(listarAlumnos, ListAlumnoDTO.class);		
		return listAlumnoDTO;		
	}

	public AlumnoDTO obtenerAlumnoPorID(int idAlumno) {

		for (AlumnoDTO alumnoDTO : listarAlumnos().getListAlumnos()) {
			
			if (alumnoDTO.getIdAlumno() == idAlumno) {
				return alumnoDTO;
			}
		}
		return null;
	}

	public AlumnoDTO editarAlumno(AlumnoDTO alumnoDTO) {
		
		AlumnoDTO newAlumnoDTO = restTemplate.postForObject(editarAlumnoUrl, alumnoDTO, AlumnoDTO.class);		
		return newAlumnoDTO;
	}

	public AlumnoDTO crearAlumno(AlumnoDTO alumnoDTO) {
		
		alumnoDTO.getUsuarioDTO().getPerfilDTO().setId(2);
		alumnoDTO.getUsuarioDTO().getPerfilDTO().setNombre("ALUMNO");
		AlumnoDTO newAlumnoDTO = restTemplate.postForObject(crearAlumnoUrl, alumnoDTO, AlumnoDTO.class);
		return newAlumnoDTO;
	}
	
//	public ListAcuerdoAlumnoFamiliaDTO listarPostulacionesAlumnoFamilia(int idFamilia) {
//		
//		String url = listarAcuerdosAlumnoFamilia + idFamilia;
//		return restTemplate.getForObject(url, ListAcuerdoAlumnoFamiliaDTO.class);
//	}

	
	
//	EJEMPLO RESPONSE ENTITY
//	String obtenerActorUrl = "https://api.myjson.com/bins/i54ge";
	
//	AlumnoDTO alumnoDTO = restTemplate.postForObject(obtenerActorUrl, usuario, AlumnoDTO.class);
//	ResponseEntity<String> response = restTemplate.getForEntity(obtenerActorUrl, String.class);
//	System.out.println(response);
//	obtenerActorUrl = obtenerActorUrl + "/" + usuario;

	
}
