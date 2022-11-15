package residencia.web.dto;

public class TokenDTO {
    private String type;
    private String token;
    
	public TokenDTO(String type, String token) {
		super();
		this.type = type;
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}