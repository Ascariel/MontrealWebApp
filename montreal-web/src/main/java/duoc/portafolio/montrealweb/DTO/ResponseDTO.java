package duoc.portafolio.montrealweb.DTO;

public class ResponseDTO {
	private int code = 9999;
	private String message = "Default Fail";
	
	public ResponseDTO() {
		super();
	}
	
	public ResponseDTO(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", message=" + message + "]";
	}
		

//	public ResponseDTO(int code, String message) {
//		super();
//		this.Code = code;
//		this.Message = message;
//	}
//
//	public int getCode() {
//		return this.Code;
//	}
//
//	public void setCode(int code) {
//		this.Code = code;
//		System.out.println(code);
//		System.out.println(Code);
//	}
//
//	public String getMessage() {
//		return this.Message;
//	}
//
//	public void setMessage(String message) {
//		this.Message = message;
//	}
//
//	@Override
//	public String toString() {
//		return "ResponseDTO [Code=" + Code + ", Message=" + Message + "]";
//	}
//	
//	
	

	
	
	
}
