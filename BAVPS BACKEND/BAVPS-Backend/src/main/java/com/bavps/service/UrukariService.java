/**
 * 
 */
package com.bavps.service;

import java.util.List;

import com.bavps.entity.Urukari;

/**
 * @author Udjanati
 *
 */

public interface UrukariService {

	Urukari saveVisitors( Urukari urukari);

	List<Urukari> getAllVisitors();
	
	boolean deleteVisitors(Long id);

}
