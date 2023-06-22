/**
 * 
 */
package btr.framework.restsecurity.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import btr.framework.common.domain.LifeCycleBo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aimable IRANZI
 *
 */
@Entity
@Table(name = "PRINCIPAL", uniqueConstraints = {@UniqueConstraint(columnNames = {"PHONE_NUMBER"}), @UniqueConstraint(columnNames = {"EMAIL_ADDRESS"})})
@Setter
@Getter
public class Principal extends LifeCycleBo implements UserDetails {

	/** The user id. */
	@NotNull
	@Column(name = "USER_ID", nullable = false, length = 50)
	private String userId;

	/** The locked. */
	@Column(name = "LOCKED")
	private Boolean locked = Boolean.FALSE;

	/** The must reset. */
	@Column(name = "MUST_RESET")
	private Boolean mustReset = Boolean.FALSE;

	/** The first name. */
	@NotNull
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	/** The last name. */
	@NotNull
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	/** The common name. */
	@Transient
	private String commonName;

	/** The password. */
	@NotNull
	@Column(name = "PASS_WORD")
	private String password;

	/** The phone number. */
	@NotNull
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;

	/** The email address. */
	@NotNull
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddress;

	/**
	 * Gets the common name.
	 *
	 * @return the common name
	 */
	public String getCommonName() {
		return new StringBuilder().append(firstName).append(" ").append(lastName).toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.emailAddress;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !this.mustReset;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public Boolean getLocked() {
		return locked;
	}

	public Boolean getMustReset() {
		return mustReset;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}


}
