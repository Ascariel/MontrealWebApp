package duoc.portafolio.montrealweb.DTO;

public class AcuerdoAlumnoFamiliaDTO extends ResponseDTO {

	private int idAcuerdo;
	private String nombreCompletoAlumno;
	private String correo;
	private String fechaNacimiento;
	private int aceptacionFamilia;
	private int aceptacionAlumno;

	public AcuerdoAlumnoFamiliaDTO() {
		super();
	}

	public AcuerdoAlumnoFamiliaDTO(int idAcuerdo, String nombreCompletoAlumno, String correo, String fechaNacimiento,
			int aceptacionFamilia, int aceptacionAlumno) {
		super();
		this.idAcuerdo = idAcuerdo;
		this.nombreCompletoAlumno = nombreCompletoAlumno;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.aceptacionFamilia = aceptacionFamilia;
		this.aceptacionAlumno = aceptacionAlumno;
	}

	public int getIdAcuerdo() {
		return idAcuerdo;
	}

	public void setIdAcuerdo(int idAcuerdo) {
		this.idAcuerdo = idAcuerdo;
	}

	public String getNombreCompletoAlumno() {
		return nombreCompletoAlumno;
	}

	public void setNombreCompletoAlumno(String nombreCompletoAlumno) {
		this.nombreCompletoAlumno = nombreCompletoAlumno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getAceptacionFamilia() {
		return aceptacionFamilia;
	}

	public void setAceptacionFamilia(int aceptacionFamilia) {
		this.aceptacionFamilia = aceptacionFamilia;
	}

	public int getAceptacionAlumno() {
		return aceptacionAlumno;
	}

	public void setAceptacionAlumno(int aceptacionAlumno) {
		this.aceptacionAlumno = aceptacionAlumno;
	}
	
	public String textoAceptacionAlumno(){
		if (aceptacionAlumno == 1) return "Aceptada" ;
		if (aceptacionAlumno == 0) return "Rechazada" ;
		return "Pendiente";
	}
	
	public String textoAceptacionFamilia(){
		if (aceptacionFamilia == 1) return "Aceptada" ;
		if (aceptacionFamilia == 0) return "Rechazada" ;
		return "Pendiente";
	}	

	@Override
	public String toString() {
		return "AcuerdoAlumnoFamiliaDTO [idAcuerdo=" + idAcuerdo + ", nombreCompletoAlumno=" + nombreCompletoAlumno
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", aceptacionFamilia="
				+ aceptacionFamilia + ", aceptacionAlumno=" + aceptacionAlumno + ", toString()=" + super.toString()
				+ "]";
	}

}
