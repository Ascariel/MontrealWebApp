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

import duoc.portafolio.montrealweb.DTO.AlumnoDTO;
import duoc.portafolio.montrealweb.DTO.CambiarClaveDTO;
import duoc.portafolio.montrealweb.DTO.CelDTO;
import duoc.portafolio.montrealweb.DTO.FamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ListAcuerdoAlumnoFamiliaDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelDTO;
import duoc.portafolio.montrealweb.DTO.PostulacionFamiliaCelOutDTO;
import duoc.portafolio.montrealweb.DTO.ResponseDTO;
import duoc.portafolio.montrealweb.DTO.UsuarioDTO;
import duoc.portafolio.montrealweb.service.CelService;
import duoc.portafolio.montrealweb.service.FamiliaService;
import duoc.portafolio.montrealweb.service.ValidarLoginService;

@Controller
@SessionAttributes({ "username", "perfil", "id_actor" })
public class FamiliaController {

	@Autowired
	private FamiliaService familiaService;
	@Autowired
	private ValidarLoginService validarLoginService;
	@Autowired
	private CelService celService;

	@GetMapping("/crear-familia")
	public String showCrearFamilia(ModelMap model) {

		FamiliaDTO familiaDTO = new FamiliaDTO(UsuarioDTO.defaultUsuarioDTO());
		model.addAttribute("familiaDTO", familiaDTO);

		return "familia/crear-familia";
	}

	@PostMapping("/crear-familia")
	public String crearFamiliaAction(@Valid FamiliaDTO familiaDTO, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			model.put("errors", result.getAllErrors());
			return "familia/crear-familia";
		}

		FamiliaDTO newFamiliaDTO = familiaService.crearFamilia(familiaDTO);

		if (newFamiliaDTO.getCode() != 0) {
			model.put("error", newFamiliaDTO.getMessage());
			return "familia/crear-familia";
		}
		return "/login";
	}

	@GetMapping("/editar-familia")
	public String showEditarFamilia(ModelMap model) {

		String username = (String) model.get("username");
		FamiliaDTO familiaDTO = familiaService.obtenerFamiliaPorUsario(username);
		model.put("familiaDTO", familiaDTO);

		return "familia/editar-familia";
	}

	@PostMapping("/editar-familia")
	public String editarFamiliaAction(ModelMap model, @Valid FamiliaDTO familiaDTO, BindingResult result) {

		if (result.hasErrors()) {
			model.put("errors", result.getAllErrors());
			return "familia/editar-familia";
		}

		System.out.println(familiaDTO);
		int actor_id = (int) model.get("id_actor");
		familiaDTO.setIdFamilia(actor_id);
		FamiliaDTO newFamiliaDTO = familiaService.editarFamilia(familiaDTO);

		validarLoginService.cambiarClave(familiaDTO.getUsuarioDTO().getClave(),
				familiaDTO.getUsuarioDTO().getUsuario());

		if (newFamiliaDTO.getCode() != 0) {
			model.put("error", newFamiliaDTO.getMessage());
			return "familia/editar-familia";
		}

		return "redirect:editar-familia";
	}

	@GetMapping("/familia/listado-cel-postulables")
	public String listarProgramas(ModelMap model) {

		String usuario = (String) model.get("username");
		FamiliaDTO familiaDTO = familiaService.obtenerFamiliaPorUsario(usuario);
		int idPais = familiaDTO.getPaisDTO().getId();

		List<CelDTO> listadoCelDTO = familiaService.obtenerCelsPostulablesUrl(idPais);
		model.put("listadoCelDTO", listadoCelDTO);

		return "familia/listado-cel-postulables";
	}

	@GetMapping("familia/postular-cel")
	public String detalleCel(ModelMap model, @RequestParam int id) {

		CelDTO celDTO = celService.obtenerCelPorId(id);
		int id_familia = (int) model.get("id_actor");
		boolean postulacionExistente = familiaService.buscarPostulacionesFamiliaCel(id_familia, id) != null;

		model.put("celDTO", celDTO);
		model.put("postulacionExistente", postulacionExistente);
		System.out.println(celDTO);
		System.out.println(postulacionExistente);

		return "familia/postular-cel";
	}

	@PostMapping("/familia/postular-cel")
	public String postularCentroLocal(ModelMap model, CelDTO celDTO) {

		int id_actor = (int) model.get("id_actor");
		String usuario = (String) model.get("username");
		FamiliaDTO familiaDTO = familiaService.obtenerFamiliaPorUsario(usuario);
		int idPais = familiaDTO.getPaisDTO().getId();

		PostulacionFamiliaCelDTO postulacionFamiliaCelDTO = new PostulacionFamiliaCelDTO(celDTO.getId(), id_actor);
		postulacionFamiliaCelDTO = familiaService.postularFamiliaCel(postulacionFamiliaCelDTO);

		if (postulacionFamiliaCelDTO.getCode() != 0) {
			model.put("error", postulacionFamiliaCelDTO.getMessage());
			return "familia/postular-cel";
		}
		return "redirect:/familia/postular-cel?id=" + celDTO.getId();
	}

	@GetMapping("familia/postulaciones-familia-cel")
	public String postulacionesFamiliaCel(ModelMap model) {

		int id_familia = (int) model.get("id_actor");
		List<PostulacionFamiliaCelOutDTO> listPostulacionFamiliaCelOutDTO = familiaService
				.listadoPostulacionesFamiliaCel(id_familia);

		model.put("listPostulacionFamiliaCelOutDTO", listPostulacionFamiliaCelOutDTO);
		return "familia/postulaciones-familia-cel";
	}

	@GetMapping("/familia/listado-acuerdos-alumno-familia")
	public String listadoAcuerdosAlumnoFamilia(ModelMap model) {

		String username = (String) model.get("username");
		int id_familia = (int) model.get("id_actor");

		FamiliaDTO familiaDTO = familiaService.obtenerFamiliaPorUsario(username);

		ListAcuerdoAlumnoFamiliaDTO response = familiaService.listarPostulacionesAlumnoFamilia(id_familia);

		if (response.getCode() != 0 && !response.getMessage().equalsIgnoreCase("Sin Datos")) {
			model.put("error", response.getMessage());
			return "/login";
		}
		System.out.println(response.getListAcuerdoAlumnoDTO());

		model.put("listadoAcuerdos", response.getListAcuerdoAlumnoDTO());
		model.put("familiaDTO", familiaDTO);
		String urlAceptacion = "/familia/actualizar-aceptacion-familia?idAcuerdo=";
		model.put("urlAceptacion", urlAceptacion);

		return "/familia/listado-acuerdos-alumno-familia";
	}

	@GetMapping("familia/actualizar-aceptacion-familia")
	public String actualizarAceptacionFamilia(ModelMap model, @RequestParam int idAcuerdo, int aceptacion) {

//		int id_familia = (int) model.get("id_actor");
		ResponseDTO response = familiaService.actualizarAceptacionFamilia(idAcuerdo, aceptacion);

		return "redirect:/familia/listado-acuerdos-alumno-familia";
	}

}
