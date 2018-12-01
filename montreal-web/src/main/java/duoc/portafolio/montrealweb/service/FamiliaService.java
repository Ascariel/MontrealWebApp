package duoc.portafolio.montrealweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import duoc.portafolio.montrealweb.DTO.CelDTO;
import duoc.portafolio.montrealweb.DTO.FamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListAcuerdoAlumnoFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListCelDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.ResponseDTO;


@Service
public class FamiliaService extends ResponseDTO {

	static String obtenerFamiliaUrl = "http://localhost:49667/api/AdminFamilias/BuscarFamilia";
	static String crearFamiliaUrl = "http://localhost:49667/api/AdminFamilias/CrearFamilia";
	static String editarFamiliaUrl = "http://localhost:49667/api/AdminFamilias/ModificarFamilia";
	static String obtenerCelsPostulablesUrl = "http://localhost:49667/api/AdminCentros/ListarCentrosLocalesDisponibles";
	static String postularCelUrl = "http://localhost:49667/api/Postulaciones/CrearPostulacionFamilia";
	static String buscarPostulacionfamiliaCelPorIDUrl = "http://localhost:49667/api/Postulaciones/BuscarPortulacionFamilia/";
	static String listarAcuerdosAlumnoFamilia = "http://localhost:49667/api/Mantenedor/ListAcuerdoAlumnos/";
	static String cambiarAceptacionfamiliaUrl = "http://localhost:49667/api/Mantenedor/AceptacionAcuerdoFamilia/";

	@Autowired
	private RestTemplate restTemplate;

	public FamiliaDTO obtenerFamiliaPorUsario(String usuario) {
		String url = obtenerFamiliaUrl + "/" + usuario;
		FamiliaDTO familiaDTO = restTemplate.getForObject(url, FamiliaDTO.class);
		return familiaDTO;
	}
	
	public List<CelDTO> obtenerCelsPostulablesUrl(int idPais) {
		String url = obtenerCelsPostulablesUrl + "/" + idPais;
		ListCelDTO listCelDTO = restTemplate.getForObject(url, ListCelDTO.class);
		System.out.println(listCelDTO.getListCel());
		return listCelDTO.getListCel();
	}

	public FamiliaDTO obtenerFamiliaPorID(int idFamilia) {
		// TODO Auto-generated method stub
		return null;
	}

	public FamiliaDTO editarFamilia(FamiliaDTO familiaDTO) {
		FamiliaDTO newFamiliaDTO = restTemplate.postForObject(editarFamiliaUrl, familiaDTO, FamiliaDTO.class);
		return newFamiliaDTO;
	}

	public FamiliaDTO crearFamilia(FamiliaDTO familiaDTO) {
		FamiliaDTO newFamiliaDTO = restTemplate.postForObject(crearFamiliaUrl, familiaDTO, FamiliaDTO.class);
		return newFamiliaDTO;
	}
	
	public PostulacionFamiliaCelDTO postularFamiliaCel(PostulacionFamiliaCelDTO postulacionDTO) {
		postulacionDTO = restTemplate.postForObject(postularCelUrl, postulacionDTO, PostulacionFamiliaCelDTO.class);
		return postulacionDTO;
	}

	public List<PostulacionFamiliaCelOutDTO> listadoPostulacionesFamiliaCel(int idFamilia) {
		String url = buscarPostulacionfamiliaCelPorIDUrl + "/" + idFamilia;
		ListPostulacionFamiliaCelOutDTO listPostulacionFamiliaCelOutDTO = restTemplate.getForObject(url, ListPostulacionFamiliaCelOutDTO.class);
		return listPostulacionFamiliaCelOutDTO.getListPostulacionFamilia();
	}
	
	public PostulacionFamiliaCelOutDTO buscarPostulacionesFamiliaCel(int idFamilia, int idCel) {
		
		for (PostulacionFamiliaCelOutDTO postulacion : listadoPostulacionesFamiliaCel(idFamilia)) {
			if(postulacion.getIdCentro() == idCel) {
				System.out.println(postulacion);
				return postulacion;
			}
		}
		return null;
	}
	
	public ListAcuerdoAlumnoFamiliaDTO listarPostulacionesAlumnoFamilia(int idFamilia) {
		
		String url = listarAcuerdosAlumnoFamilia + idFamilia;
		return restTemplate.getForObject(url, ListAcuerdoAlumnoFamiliaDTO.class);
	}	
	
	public ResponseDTO actualizarAceptacionFamilia(int idAcuerdo, int aceptacion) {
		String url = cambiarAceptacionfamiliaUrl + idAcuerdo + "/" + aceptacion;
		return restTemplate.getForObject(url, ResponseDTO.class);
	}

}
