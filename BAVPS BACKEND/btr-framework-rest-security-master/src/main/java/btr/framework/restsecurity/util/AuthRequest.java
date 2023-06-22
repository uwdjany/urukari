/**
 * 
 */
package btr.framework.restsecurity.util;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aimable IRANZI
 *
 */
@Setter
@Getter
public class AuthRequest {

	@NotNull @Email @Length(min = 5, max = 50)
    private String emailAddress;
     
    @NotNull @Length(min = 5, max = 10)
    private String password;
}
