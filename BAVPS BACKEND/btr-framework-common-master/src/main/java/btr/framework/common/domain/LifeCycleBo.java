/**
 * 
 */
package btr.framework.common.domain;

import java.util.Date;
//import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Udjanati
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class LifeCycleBo {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, updatable = false)
//	@Type(type = "pg-uuid")
	private Long id;

	/** The version. */
	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	/** The created date. */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	/** The updated date. */
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	/**
	 * Checks if is new.
	 *
	 * @return true, if is new
	 */

	public boolean isNew() {
		if (this.getId() == null || this.getId().toString().isEmpty()) {
			return true;
		}
		return false;
	}

	public Long getGuid() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
