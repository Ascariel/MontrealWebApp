package duoc.portafolio.montrealweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO;
import duoc.portafolio.montrealweb.service.ProgramaEstudioService;

@Controller
@SessionAttributes({ "username", "password", "perfil", "id_actor" })
public class ProgramaEstudiosController {

	@Autowired
	ProgramaEstudioService programaService;

//	@GetMapping("/")
//	public String inicio(ModelMap model) {
//		int a = 1;
//		String username = (String) model.get("username");
//		String perfil = (String) model.get("perfil");
//
//		if (username != null) {
//			int id_actor = (int) model.get("id_actor");
//			String perfil_url = "/" + perfil.toLowerCase() + "/ver-perfil?id=" + id_actor;
//			return "redirect:" + perfil_url;
//		}
//		return "redirect:login";
//	}
	
	@GetMapping("/detalle-programa-estudio")
	public String detallePrograma(ModelMap model, @RequestParam int id) {
		ProgramaEstudioDTO programaDTO = programaService.obtenerProgramaPorID(id);
		model.put("programaDTO", programaDTO);

		return "detalle-programa-estudio";
	}	

	@GetMapping("listado-programas")
	public String listarProgramas(ModelMap model) {
		String titulo = "Listado de Programas de Estudio";
		model.put("titulo", titulo);
		
		List<ProgramaEstudioDTO> programasDTO = programaService.listadoProgramasDTO();
		model.put("programasDTO", programasDTO);

		return "alumno/listado-programas";
	}


}
