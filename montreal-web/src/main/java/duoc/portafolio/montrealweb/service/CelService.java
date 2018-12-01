package duoc.portafolio.montrealweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import duoc.portafolio.montrealweb.DTO.AlumnoDTO;
import duoc.portafolio.montrealweb.DTO.CelDTO;
import duoc.portafolio.montrealweb.DTO.DetalleFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.FamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListAcuerdoAlumnoFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionAlumnoProgramaDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionCentroProgramaOutDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionesFamiliaCelDTO;
import duoc.portafolio.montrealweb.DTO.ListProgramaDTO;
import duoc.portafolio.montrealweb.DTO.PaisDTO;
import duoc.portafolio.montrealweb.DTO.PerfilDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionCentroProgramaDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionCentroProgramaOutDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;
import duoc.portafolio.montrealweb.DTO.UsuarioDTO;

@Service
public class CelService {
	
	private static String obtenerCelPorUsuarioUrl = "http://localhost:49667/api/AdminCentros/BuscarCentroLocal";
	private static String obtenerCelPorIdUrl = "http://localhost:49667/api/AdminCentros/ObtenerDetalleCentroLocal";
	private static String editarCelUrl = "http://localhost:49667/api/AdminCentros/ModificarCentroLocal";
	private static String postularProgramaUrl = "http://localhost:49667/api/Postulaciones/CrearPostulacionCentro";
	private static String buscarPostulacionesCentroUrl = "http://localhost:49667/api/Postulaciones/BuscarPostulacionCentro/";
	private static String listarPostulacionesFamiliaCelUrl = "http://localhost:49667/api/Postulaciones/DetallePostulacionFamilia/";
	private static String actualizarPostulacionFamiliaCelUrl = "http://localhost:49667/api/Postulaciones/ModificarPostulacionFamilia";
	private static String listarAcuerdosAlumnoPrograma = "http://localhost:49667/api/Postulaciones/DetalleAlumnoPrograma/";
	
	
	
	@Autowired
	private RestTemplate restTemplate;


	public List<CelDTO> listadoCelDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	public CelDTO obtenerCelPorUsuario(String usuario) {
		String url = obtenerCelPorUsuarioUrl + "/" + usuario;
		CelDTO celDTO = restTemplate.getForObject(url, CelDTO.class);		
		
		return celDTO;
	}
	
	public CelDTO obtenerCelPorId(int idCel) {
		String url = obtenerCelPorIdUrl + "/" + idCel;
		CelDTO celDTO = restTemplate.getForObject(url, CelDTO.class);		
		
		return celDTO;
	}


	public CelDTO editarCel(CelDTO celDTO) {
		CelDTO newCelDTO = restTemplate.postForObject(editarCelUrl, celDTO, CelDTO.class);
		return newCelDTO;
	}
	
	public PostulacionCentroProgramaDTO crearPostulacionCentroPrograma(int idPrograma, int idCentro) {
		PostulacionCentroProgramaDTO postulacion = new PostulacionCentroProgramaDTO(idPrograma, idCentro, 1, "");
		postulacion = restTemplate.postForObject(postularProgramaUrl, postulacion, PostulacionCentroProgramaDTO.class);
		return postulacion;
	}
	
	public  List<PostulacionCentroProgramaOutDTO> buscarPostulacionesCelPrograma(int idCentro) {
		
		String url = buscarPostulacionesCentroUrl + idCentro;
		ListPostulacionCentroProgramaOutDTO listPostulacionCentroProgramaOutDTO = restTemplate.getForObject(url, ListPostulacionCentroProgramaOutDTO.class);
		
		return listPostulacionCentroProgramaOutDTO.getListPostulacionCentro();
	}	

	public PostulacionCentroProgramaOutDTO buscarPostulacionCelPrograma(int idCel, int idPrograma) {
		
		for (PostulacionCentroProgramaOutDTO postulacion : buscarPostulacionesCelPrograma(idCel)) {
			if(postulacion.getProgramaDTO().getIdPrograma() == idPrograma) {
				System.out.println(postulacion);
				return postulacion;
			}
		}
		return null;
	}
	
	public List<DetalleFamiliaDTO> listadoPostulacionesFamiliaCel(int idCel) {
		String url = listarPostulacionesFamiliaCelUrl + idCel;
		ListPostulacionesFamiliaCelDTO listPostulacionFamiliaCelOutDTO = restTemplate.getForObject(url, ListPostulacionesFamiliaCelDTO.class);
		return listPostulacionFamiliaCelOutDTO.getListDetalleFamilia();
	}	
	
	public PostulacionFamiliaCelDTO actualizarPostulacionFamiliaCel(PostulacionFamiliaCelDTO postulacionDTO) {
		postulacionDTO = restTemplate.postForObject(actualizarPostulacionFamiliaCelUrl, postulacionDTO, PostulacionFamiliaCelDTO.class);
		return postulacionDTO;
	}

	public ListPostulacionAlumnoProgramaDTO listarAcuerdosAlumnosCel(int id_programa_estudio) {

		String url = listarAcuerdosAlumnoPrograma + id_programa_estudio;
		return restTemplate.getForObject(url, ListPostulacionAlumnoProgramaDTO.class);
	}	
	

}
