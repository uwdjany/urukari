/**
 * 
 */
package com.bavps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import btr.framework.common.domain.LifeCycleBo;
import lombok.Getter;
import lombok.Setter;



/**
 * @author Udjanati
 *
 */
@Entity
@Table(name ="urukari")
@Getter
@Setter
public class Urukari extends LifeCycleBo{

	@Column(name = "names", nullable = false)
	private String names;
	
	@Column(name = "age", nullable = false)
	private String age;
	
	@Column(name = "sex", nullable = false)
	private String sex;
		
	@Column(name = "profession", nullable = false)
	private String profession;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "interest", nullable = false)
	private String interest;
	
	@Column(name = "continent", nullable = false)
	private String continent;
	
}

