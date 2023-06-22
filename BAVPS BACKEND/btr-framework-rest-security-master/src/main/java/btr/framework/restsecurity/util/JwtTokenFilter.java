/**
 * 
 */
package btr.framework.restsecurity.util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import btr.framework.restsecurity.domain.Principal;

/**
 * @author IRANZI Aimable
 *
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(!hasAuthorizationBearer(request)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = getAccessToken(request);
		
		if(!jwtUtil.validateAccessToken(token)) {
			filterChain.doFilter(request, response);
			return;
		}
		setAuthenticationContext(token, request);
		filterChain.doFilter(request, response);
		
	}
	
	private boolean hasAuthorizationBearer(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}
		return true;
	}
	
	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}
	
	private void setAuthenticationContext(String token, HttpServletRequest request) {
		UserDetails userDetails = getUserDetails(token);
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}
	
	private UserDetails getUserDetails(String token) {
		Principal principal = new Principal();
		String[] jwtSubject = jwtUtil.getSubject(token).split(",");
		
		principal.setId(Long.valueOf(jwtSubject[0]));
		principal.setEmailAddress(jwtSubject[1]);
		
		return principal;
	}

}
