/**
 * 
 */
package btr.framework.restsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import btr.framework.restsecurity.domain.Principal;
import btr.framework.restsecurity.service.ISecurityService;
import btr.framework.restsecurity.util.AuthRequest;
import btr.framework.restsecurity.util.AuthResponse;
import btr.framework.restsecurity.util.JwtTokenUtil;

/**
 * @author IRANZI Aimable
 *
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired 
	private ISecurityService securityService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmailAddress(), request.getPassword())
            );

			Principal principal = (Principal) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(principal);
            AuthResponse response = new AuthResponse(principal.getEmailAddress(), accessToken);
			
			return ResponseEntity.ok().body(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid Principal principal) {
		try {
			Principal newPrincipal =  securityService.savePrincipal(principal).getResult();
			String accessToken = jwtTokenUtil.generateAccessToken(newPrincipal);
            AuthResponse response = new AuthResponse(principal.getEmailAddress(), accessToken);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
