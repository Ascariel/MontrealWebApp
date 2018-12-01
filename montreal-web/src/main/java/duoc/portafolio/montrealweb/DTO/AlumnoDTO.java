package duoc.portafolio.montrealweb.DTO;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class AlumnoDTO extends ResponseDTO {

	private int idAlumno;
	
	@Size(min = 3, max = 30, message = "Nombre : Debe contener de {min} a {max} caracteres")
	private String nombre;
	
//	@Size(min = 8, max = 9, message = "Rut : Debe contener de {min} a {max} caracteres")
	private String rut;
	
	@Size(min = 3, max = 30, message = "Apellido : Debe contener de {min} a {max} caracteres")
	private String apellidos;

	private String activo;

	@Size(min = 3, max = 30, message = "Correo : Debe contener de {min} a {max} caracteres")
	private String correo;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//	private Date fechaNacimiento;
	
	private String fechaNacimiento;

	@Valid
	private UsuarioDTO usuarioDTO;

	public AlumnoDTO() {
		super();
	}

	public AlumnoDTO(int idAlumno, String nombre, String rut, String apellidos, String activo, String correo,
			String fechaNacimiento, UsuarioDTO usuarioDTO) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.rut = rut;
		this.apellidos = apellidos;
		this.activo = activo;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.usuarioDTO = usuarioDTO;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public AlumnoDTO(UsuarioDTO usuarioDTO) {
		super();
		this.usuarioDTO = usuarioDTO;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		System.out.println("Get Fecha");
		System.out.println(fechaNacimiento);
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fecha_nacimiento) {
		System.out.println("Set Fecha");
		System.out.println(fecha_nacimiento);
		this.fechaNacimiento = fecha_nacimiento;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	@Override
	public String toString() {
		return "AlumnoDTO [idAlumno=" + idAlumno + ", nombre=" + nombre + ", rut=" + rut + ", apellidos=" + apellidos
				+ ", activo=" + activo + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", usuarioDTO="
				+ usuarioDTO + ", toString()=" + super.toString() + "]";
	}

}
