/**
 * 
 */
package com.bavps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bavps.entity.Urukari;
import com.bavps.repository.UrukariRepository;


/**
 * @author Udjanati
 *
 */
@Service
public class UrukariServiceImpl implements UrukariService {
	
	private UrukariRepository urukariRepository;

	/**
	 * @param urukariRepository
	 */
	public UrukariServiceImpl(UrukariRepository urukariRepository) {
		super();
		this.urukariRepository = urukariRepository;
	}

	@Override
	public Urukari saveVisitors(Urukari urukari) {
		
		return urukariRepository.save(urukari);
	}

	@Override
	public List<Urukari> getAllVisitors() {
		return urukariRepository.findAll();
	}

	@Override
	public boolean deleteVisitors(Long id) {
		Urukari urukari = urukariRepository.findById(id).get();
		urukariRepository.delete(urukari);
		return true;
	}

	

	
	

}
