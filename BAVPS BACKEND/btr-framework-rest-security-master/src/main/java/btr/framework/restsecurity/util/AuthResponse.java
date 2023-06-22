package btr.framework.restsecurity.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author IRANZI Aimable
 *
 */
@Setter
@Getter
public class AuthResponse {

	private String email;
    private String accessToken;
    
    public AuthResponse() {}
    
    public AuthResponse(String email, String accessToken) {
    	this.email = email;
    	this.accessToken = accessToken;
    }
}
