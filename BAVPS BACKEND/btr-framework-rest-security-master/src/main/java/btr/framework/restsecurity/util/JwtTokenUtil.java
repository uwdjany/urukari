/**
 * 
 */
package btr.framework.restsecurity.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import btr.framework.restsecurity.domain.Principal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author Aimable IRANZI
 *
 */
@Component
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
    
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;
    
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    public String generateAccessToken(Principal principal) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", principal.getGuid(), principal.getEmailAddress()))
                .setIssuer("btr")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
                 
    }
    
    public boolean validateAccessToken(String token) {
    	try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			log.error("JWT expired", e.getMessage());
		}catch (IllegalArgumentException e) {
			log.error("Token is null, empty or only whitespace", e.getMessage());
		}catch (MalformedJwtException e) {
			log.error("JWT is invalid", e.getMessage());
		}catch (UnsupportedJwtException e) {
			log.error("JWT is not supported", e.getMessage());
		}catch (SignatureException e) {
			log.error("Signature validation failed", e.getMessage());
		}
    	return false;
    }
    
    public String getSubject(String token) {
    	return parseClaims(token).getSubject();
    }
    
    private Claims parseClaims(String token) {
    	return Jwts.parser()
    			.setSigningKey(SECRET_KEY)
    			.parseClaimsJws(token)
    			.getBody();
    }
}
