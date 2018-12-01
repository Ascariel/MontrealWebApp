package duoc.portafolio.montrealweb.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import duoc.portafolio.montrealweb.DTO.PaisDTO;

@Service
public class PaisService {
	
	//private static String urlPaises = "http://localhost:49667/api/Mantenedor/ListarPaises";
	private static String urlPaises2 = "https://api.myjson.com/bins/11lstw";
	
	public List<PaisDTO>listarPaises() throws JsonParseException, JsonMappingException, IOException, UnirestException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = Unirest.get(urlPaises2).asString().getBody();
		
		JsonNode jsonTree = objectMapper.readTree(json); //FUNCIONAAAA
		JsonNode paisesNode = jsonTree.path("listPais");
		
		List<PaisDTO> paises = objectMapper.readValue(
				objectMapper.treeAsTokens(paisesNode), 
				objectMapper.getTypeFactory().constructType(new TypeReference<List<PaisDTO>>(){}));	
		
		return paises;
	}
	
	
}
