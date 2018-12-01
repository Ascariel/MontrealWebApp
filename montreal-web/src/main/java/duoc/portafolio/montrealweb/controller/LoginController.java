package duoc.portafolio.montrealweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;

import duoc.portafolio.montrealweb.DTO.UsuarioDTO;
import duoc.portafolio.montrealweb.service.AlumnoService;
import duoc.portafolio.montrealweb.service.CelService;
import duoc.portafolio.montrealweb.service.FamiliaService;
import duoc.portafolio.montrealweb.service.PaisService;
import duoc.portafolio.montrealweb.service.ValidarLoginService;

@Controller
@SessionAttributes({ "username", "perfil", "id_actor" })
public class LoginController {

	@Autowired
	private ValidarLoginService validarLoginService;
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private FamiliaService familiaService;	
	@Autowired
	private CelService celService;		

	@GetMapping("/login")
	public String login() {
		return "login";
	}	
	
	@GetMapping("/")
	public String home() {
		return "login";
	}	
	

	@PostMapping("/iniciar_sesion")
	public String iniciarSesion(@RequestParam String usuario, @RequestParam String clave, ModelMap model)
			throws Exception {
		
		UsuarioDTO usuarioDTO = validarLoginService.validarLogin(usuario, clave);
//		UsuarioDTO usuarioDTO = validarLoginService.validarLoginFake(usuario, clave);
		

		if (usuarioDTO.getCode() != 0) {
			System.out.println("LoginError: " + usuarioDTO.getMessage());
			model.put("error", "Usuario/Clave Invalidos");
			return "login";
		}
		String nombrePerfil = usuarioDTO.getPerfilDTO().getNombre();
		int id_actor = 0;
		
		if (nombrePerfil.equals("ALUMNO")) {
			id_actor = alumnoService.obtenerAlumnoPorUsario(usuario).getIdAlumno();
		} else if (nombrePerfil.equals("FAMILIA")){
			id_actor = familiaService.obtenerFamiliaPorUsario(usuario).getIdFamilia();
		} else if(nombrePerfil.equals("CEL")) {
			id_actor = celService.obtenerCelPorUsuario(usuario).getId();
		} else {
			throw new Exception("Usuario/Perfil No Encontrado");
		}
		
		model.put("username", usuario);
		model.put("perfil", nombrePerfil);
		model.put("id_actor", id_actor);
		System.out.println(usuarioDTO);
		
		String urlAfterLogiRedirect = validarLoginService.obtenerUrlLogin(nombrePerfil);
//		String urlAfterLogiRedirect = validarLoginService.obtenerUrlLogin(nombrePerfil);
//		return "listado-programas";
		return "redirect:" + urlAfterLogiRedirect;
	}

	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:login";
	}

	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}

}
