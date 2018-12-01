package duoc.portafolio.montrealweb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import duoc.portafolio.montrealweb.DTO.CambiarClaveDTO;
import duoc.portafolio.montrealweb.DTO.LoginDTO;
import duoc.portafolio.montrealweb.DTO.PaisDTO;
import duoc.portafolio.montrealweb.DTO.PerfilDTO;
import duoc.portafolio.montrealweb.DTO.UsuarioDTO;

@Service
public class ValidarLoginService {
	@Autowired
	private RestTemplate restTemplate;

	private static String loginUrl = "http://localhost:49667/api/Usuario/ValidaUsuario";
	private String cambiarClaveUrl = "http://localhost:49667/api/Usuario/CambiarClave";
	
	public UsuarioDTO validarLogin(String usuarioP, String claveP) throws Exception {
		
		LoginDTO loginDTO = new LoginDTO(usuarioP, claveP);
		UsuarioDTO usuarioDTO = restTemplate.postForObject(loginUrl, loginDTO, UsuarioDTO.class);

//		String username = usuarioDTO.getUsuario();
//		String password = usuarioDTO.getClave();
//		ResponseEntity<String> response = restTemplate.postForEntity(loginUrl, loginDTO, String.class);
//		boolean valido = usuarioP.equals(username) && claveP.equals(password);
		
		return usuarioDTO;
	}
	
	public CambiarClaveDTO cambiarClave(String password, String usuario) {
		
		CambiarClaveDTO claveDTO = new CambiarClaveDTO(password, usuario);
		CambiarClaveDTO nuevaClaveDTO = restTemplate.postForObject(cambiarClaveUrl, claveDTO, CambiarClaveDTO.class);
		return nuevaClaveDTO;
	}
	
	public String obtenerUrlLogin(String perfilActor) {
		
		if (perfilActor.equals("ALUMNO")) {
			return "/alumno/listado-programas-postulables";
		}
		else if (perfilActor.equals("FAMILIA") ) {
			return "/familia/listado-cel-postulables";
		}
		else if (perfilActor.equals("CEL")) {
			return "/cel/listado-programas-postulables";
		}
		else {
			return null;
		}
	}
	
	public boolean validarLoginFake1(String usuarioP, String claveP) throws Exception {
		//DEBERIAMOS DEVOLVER EL USUARIO_DTO
//		RestTemplate restTemplate = new RestTemplate();
		UsuarioDTO usuarioDTO = restTemplate.getForObject(loginUrl, UsuarioDTO.class);

		String username = usuarioDTO.getUsuario();
		String password = usuarioDTO.getClave();
		
		boolean valido = usuarioP.equals(username) && claveP.equals(password);
		
		return usuarioP.equals(username) && claveP.equals(password);
	}	


	public UsuarioDTO validarLogin3(String usuarioP, String claveP) throws Exception {
//		RestTemplate restTemplate = new RestTemplate();
		String loginUrl2 = "https://api.myjson.com/bins/19boos"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "";
		ResponseEntity<String> response = restTemplate.getForEntity(loginUrl2, String.class);

		UsuarioDTO usuarioDTO = new ObjectMapper().readValue(response.getBody(), UsuarioDTO.class);
		return usuarioDTO;
	}	
	
//	DOCUMENTACION INTERESANTE
	// https://www.baeldung.com/spring-rest-template-list
	//	https://www.baeldung.com/rest-template

	public UsuarioDTO validarLoginFake(String usuario, String clave) throws Exception {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		boolean valido = usuario.equals("pablo") && clave.equals("passpass");
		
		if (usuario.equals("alumno") && clave.equals("passpass")) {
			usuarioDTO = new UsuarioDTO(1, usuario, clave, null , new PerfilDTO(1, "ALUMNO"));
		}
		else if (usuario.equals("familia") && clave.equals("passpass")) {
			usuarioDTO = new UsuarioDTO(1, usuario, clave, null , new PerfilDTO(1, "FAMILIA"));
		}
		else if (usuario.equals("cel") && clave.equals("passpass")) {
			usuarioDTO = new UsuarioDTO(1, usuario, clave, null , new PerfilDTO(1, "CEL"));
		}
		else if (usuario.equals("pablo") && clave.equals("passpass")) {
			usuarioDTO = new UsuarioDTO(1, usuario, clave, null , new PerfilDTO(1, "ALUMNO"));
		}
		else {
			return new UsuarioDTO();
		}
		
		usuarioDTO.setCode(0);
		return usuarioDTO;
	}	
}
