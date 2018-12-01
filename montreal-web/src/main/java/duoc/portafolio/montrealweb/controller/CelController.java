package duoc.portafolio.montrealweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import duoc.portafolio.montrealweb.DTO.CelDTO;
import duoc.portafolio.montrealweb.DTO.DetalleFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.FamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListAcuerdoAlumnoFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListPostulacionAlumnoProgramaDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionCentroProgramaDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionCentroProgramaOutDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;
import duoc.portafolio.montrealweb.service.CelService;
import duoc.portafolio.montrealweb.service.ProgramaEstudioService;
import duoc.portafolio.montrealweb.service.ValidarLoginService;

@Controller
@SessionAttributes({ "username", "perfil", "id_actor" })
public class CelController {

	@Autowired
	CelService celService;
	@Autowired
	private ValidarLoginService validarLoginService;	
	@Autowired
	ProgramaEstudioService programaService;	

	@GetMapping("/detalle-cel")
	public String detalleCel(ModelMap model, @RequestParam int id) {
		CelDTO celDTO = celService.obtenerCelPorId(id);
		model.put("celDTO", celDTO);

		return "/detalle-cel";

	}
	
	@GetMapping("/cel/editar-cel")
	public String editarCel(ModelMap model) {
		String usuario = (String) model.get("username");
		
		CelDTO celDTO = celService.obtenerCelPorUsuario(usuario);
		model.put("celDTO", celDTO);

		return "/cel/editar-cel";
	}
	
	@PostMapping("/cel/editar-cel")
	public String editarFamiliaAction(ModelMap model, @Valid CelDTO celDTO, BindingResult result) {
		
		if (result.hasErrors()) {
			model.put("errors", result.getAllErrors());
			return "cel/editar-cel";
		}
		
		int actor_id = (int) model.get("id_actor");
		celDTO.setId(actor_id);
		CelDTO newCelDTO = celService.editarCel(celDTO);
		
		validarLoginService.cambiarClave(celDTO.getUsuarioDTO().getClave(), celDTO.getUsuarioDTO().getUsuario());
		
		if (newCelDTO.getCode() != 0) {
			model.put("error", newCelDTO.getMessage());
			return "cel/editar-cel";
		}		
				
		return "redirect:editar-cel";
	}
		
	
	@GetMapping("/cel/listado-programas-postulables")
	public String listarProgramasPostulablesCel(ModelMap model) {
		String titulo = "Programas de Estudio Postulables para Centros Locales";
		model.put("titulo", titulo);	
		
		String usuario = (String) model.get("username");
		CelDTO celDTO =  celService.obtenerCelPorUsuario(usuario);
		int idPais = celDTO.getPaisDTO().getId();		
		
		List<ProgramaEstudioDTO> programasDTO = programaService.programasPostulablesCel(idPais);
		model.put("programasDTO", programasDTO);

		return "cel/programas-postulables-cel";
	}	
	
	@GetMapping("/cel/detalle-programa-postulable-cel")
	public String detallePrograma(ModelMap model, @RequestParam int id) {
		int id_cel = (int) model.get("id_actor");
		ProgramaEstudioDTO programaDTO = programaService.obtenerProgramaPorID(id);
		PostulacionCentroProgramaOutDTO postulacionCelPrograma = null;
		
		try {
			postulacionCelPrograma = celService.buscarPostulacionesCelPrograma(id_cel).get(0);
		} catch (Exception e) {};
		
		boolean postulacionExiste = postulacionCelPrograma != null;
		boolean postulacionMismoProgramaExiste = postulacionExiste && postulacionCelPrograma.getProgramaDTO().getIdPrograma() == programaDTO.getIdPrograma();
		boolean postulacionProgramaDistintoExiste = postulacionExiste && !postulacionMismoProgramaExiste;
		
		model.put("programaDTO", programaDTO);
		model.put("postulacionMismoProgramaExiste", postulacionMismoProgramaExiste);
		model.put("postulacionProgramaDistintoExiste", postulacionProgramaDistintoExiste);
		model.put("postulacionExiste", postulacionExiste);
		model.put("tituloPostulacion", "Detalle Programa de Estudio");

		return "cel/detalle-programa-postulable-cel";
	}	
	
	@GetMapping("/cel/detalle-programa-postulado-cel")
	public String detalleProgramaPostuladoCel(ModelMap model) {
		int id_cel = (int) model.get("id_actor");
		PostulacionCentroProgramaOutDTO postulacionCelPrograma;
		ProgramaEstudioDTO programaDTO;
		
		try {
			postulacionCelPrograma = celService.buscarPostulacionesCelPrograma(id_cel).get(0);
			programaDTO = postulacionCelPrograma.getProgramaDTO();
		} catch (Exception e) {
			model.put("mensaje", "No Existen Postulaciones Activas");
			return "/sin-datos";
		};
		
		
		boolean postulacionMismoProgramaExiste = postulacionCelPrograma.getProgramaDTO().getIdPrograma() == programaDTO.getIdPrograma();
		boolean postulacionProgramaDistintoExiste =!postulacionMismoProgramaExiste;
		
		model.put("postulacionMismoProgramaExiste", postulacionMismoProgramaExiste);
		model.put("postulacionProgramaDistintoExiste", postulacionProgramaDistintoExiste);
		model.put("postulacionExiste", true);		
		
		model.put("programaDTO", programaDTO);
		model.put("tituloPostulacion", "Estado Postulacion Programa de Estudio ");
		model.put("postulacionCelPrograma", postulacionCelPrograma);
		return "cel/detalle-programa-postulable-cel";
	}		
	
	@PostMapping("/cel/crear-postulacion-cel-programa")
	public String postularPrograma(ModelMap model, @RequestParam int id) {
		int idCel = (int) model.get("id_actor");
		PostulacionCentroProgramaDTO postulacionCentroProgramaDTO = celService.crearPostulacionCentroPrograma(id, idCel);
		
		if (postulacionCentroProgramaDTO.getCode() != 0) {
			model.put("error", postulacionCentroProgramaDTO.getMessage());
			return "cel/detalle-programa-postulable-cel";
		}		
				
		return "redirect:/cel/detalle-programa-postulable-cel?id=" + id;
	}	
	
	
	@GetMapping("/cel/listado-postulaciones-familias")
	public String postulacionesFamiliasCel(ModelMap model) {
		
		int id_cel = (int) model.get("id_actor");
		List<DetalleFamiliaDTO> listPostulacionFamiliaCelOutDTO = celService.listadoPostulacionesFamiliaCel(id_cel);
		
		model.put("listPostulacionFamiliaCelOutDTO", listPostulacionFamiliaCelOutDTO);
		return "/cel/listado-postulaciones-familias";
	}		
	
	
	@GetMapping("/cel/actualizar-postulacion-familia-cel")
	public String actualizarPostulacionFamiliaCel(ModelMap model, @RequestParam int id_postulacion, int estado) {
		
		PostulacionFamiliaCelDTO postulacionFamiliaCelDTO = new PostulacionFamiliaCelDTO(id_postulacion, estado, ""); 
		postulacionFamiliaCelDTO = celService.actualizarPostulacionFamiliaCel(postulacionFamiliaCelDTO);
		
		if (postulacionFamiliaCelDTO.getCode() != 0) {
			model.put("error", postulacionFamiliaCelDTO.getMessage());
			return "login";
		}	
		return "redirect:/cel/listado-postulaciones-familias";
	}	
	
	@GetMapping("/cel/listado-acuerdos-alumnos")
	public String listadoAcuerdosAlumnoPrograma(ModelMap model) {

		String username = (String) model.get("username");
		int id_cel = (int) model.get("id_actor");
		CelDTO celDTO = celService.obtenerCelPorUsuario(username);
		
		PostulacionCentroProgramaOutDTO postulacionCelPrograma;
		ProgramaEstudioDTO programaDTO;
		
		try {
			postulacionCelPrograma = celService.buscarPostulacionesCelPrograma(id_cel).get(0);
			programaDTO = postulacionCelPrograma.getProgramaDTO();
		} catch (Exception e) {
			model.put("mensaje", "No Existen Postulaciones Activas");
			return "/sin-datos";
		};
				
		
		ListPostulacionAlumnoProgramaDTO listPostulacionAlumnoProgramaDTO = celService.listarAcuerdosAlumnosCel(programaDTO.getIdPrograma());
		
		if (listPostulacionAlumnoProgramaDTO.getCode() != 0 && !listPostulacionAlumnoProgramaDTO.getMessage().equalsIgnoreCase("Sin Datos")) {
			model.put("error", listPostulacionAlumnoProgramaDTO.getMessage());
			return "/login";
		}		
//		System.out.println(response.getListAcuerdoAlumnoDTO());
		
		model.put("listadoAcuerdos", listPostulacionAlumnoProgramaDTO.getListPostAlumnoPrograma());
		model.put("celDTO", celDTO);
		
		String urlAceptacion = "/familia/actualizar-aceptacion-familia?idAcuerdo=";
		model.put("urlAceptacion", urlAceptacion);
		
		return "/cel/listado-acuerdos-alumnos";
	}		


}
