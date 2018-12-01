package duoc.portafolio.montrealweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import duoc.portafolio.montrealweb.DTO.AlumnoDTO;
import duoc.portafolio.montrealweb.DTO.CambiarClaveDTO;
import duoc.portafolio.montrealweb.DTO.FamiliaDTO;
import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;
import duoc.portafolio.montrealweb.DTO.UsuarioDTO;
import duoc.portafolio.montrealweb.service.AlumnoService;
import duoc.portafolio.montrealweb.service.CelService;
import duoc.portafolio.montrealweb.service.ProgramaEstudioService;
import duoc.portafolio.montrealweb.service.ValidarLoginService;

@Controller
@SessionAttributes({ "username", "perfil", "id_actor" })
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;
	@Autowired
	ValidarLoginService validarLoginService;
	@Autowired
	ProgramaEstudioService programaService;
	@Autowired
	private CelService celService;		
	
	@InitBinder
	public void dateFormatBinder(WebDataBinder binder) {
		//Date dd/MM/YYYY
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/alumno/editar-alumno")
	public String detalleAlumno(ModelMap model) {
		String username = (String) model.get("username");

		AlumnoDTO alumnoDTO = alumnoService.obtenerAlumnoPorUsario(username);

		model.put("alumnoDTO", alumnoDTO);
		System.out.println(alumnoDTO);
		System.out.println(alumnoDTO.getUsuarioDTO().getClave());

		return "alumno/editar-alumno";
	}

	@PostMapping("/alumno/editar-alumno")
	public String editarAlumnoAction(ModelMap model, @Valid AlumnoDTO alumnoDTO, BindingResult result, @RequestParam int id) {

		if(result.hasErrors()) {
			model.put("errors", result.getAllErrors());
			return "/alumno/editar-alumno";
		}
		
		alumnoService.editarAlumno(alumnoDTO);
		CambiarClaveDTO cambiarClave = (CambiarClaveDTO) validarLoginService.cambiarClave(alumnoDTO.getUsuarioDTO().getClave(), alumnoDTO.getUsuarioDTO().getUsuario());
		
		return "redirect:/alumno/editar-alumno";
	}
	
	
	@GetMapping("/alumno/detalle-alumno")
	public String detalleAlumnoAction(ModelMap model, @RequestParam int id) {
		
		String perfil = (String) model.get("perfil");
		String urlLanding = validarLoginService.obtenerUrlLogin(perfil);
		AlumnoDTO alumnoDTO = alumnoService.obtenerAlumnoPorID(id);
		
		if (alumnoDTO == null) {
			model.put("error", "No se encontro alumno con ID " + id);
			return "login";
		}
		
		model.put("alumnoDTO", alumnoDTO);
		model.put("urlLanding", urlLanding);
		return "/alumno/detalle-alumno";
	}
	
	
	@GetMapping("/crear-alumno")
	public String showCrearAlumnoView(ModelMap model) throws Exception {
		AlumnoDTO alumnoDTO = new AlumnoDTO(UsuarioDTO.defaultUsuarioDTO());
		model.addAttribute("alumnoDTO", alumnoDTO);
		return "/alumno/crear-alumno";
	}
	
	@PostMapping("/crear-alumno")
	public String crearAlumnoAction(@Valid AlumnoDTO alumnoDTO, BindingResult result, ModelMap model) {
		
		
		if(result.hasErrors()) {
			model.put("errors", result.getAllErrors());
			return "alumno/crear-alumno";
		}
			
		
		alumnoDTO = alumnoService.crearAlumno(alumnoDTO);
		
		if (alumnoDTO.getCode() != 0) {
			model.put("error", alumnoDTO.getMessage());
		}		
		return "/login";
	}	
	
	
	@GetMapping("/alumno/listado-programas-postulables")
	public String listarProgramasPostulablesAlumno(ModelMap model) {
		String titulo = "Programas de Estudio Postulables para Alumnos";
		model.put("titulo", titulo);
		
//		List<ProgramaEstudioDTO> programasDTO = programaService.listadoProgramasDTO();
		List<ProgramaEstudioDTO> programasDTO = programaService.programasPostulablesAlumno();
		model.put("programasDTO", programasDTO);

		return "alumno/programas-postulables-alumno";
	}
	
	@GetMapping("/alumno/detalle-programa-postulable-alumno")
	public String detalleProgramaPostulable(ModelMap model, @RequestParam int id) {
//		Es esta vista puedo postular a un programa de estudios especifico, veo todas las familias y cels disponibles
		ProgramaEstudioDTO programaDTO = programaService.obtenerProgramaPorID(id);
		model.put("programaDTO", programaDTO);

//		return "detalle-programa-estudio";
		return "alumno/detalle-programa-postulable-alumno";
	}
	
	@GetMapping("/alumno/detalle-postulacion-alumno-programa")
	public String detallePostulacionAlumnoPrograma() {
//		Puedo ver el programa al que postule, con su estado de postulacion e info asociada
		return "alumno/detalle-postulacion-alumno-programa";
	}
			
//	@GetMapping("/alumno/postulacion-alumno-programa")
//	public postulacionAlumnoPrograma() {
//		
//	}	
}
