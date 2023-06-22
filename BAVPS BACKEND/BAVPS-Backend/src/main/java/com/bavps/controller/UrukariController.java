/**
 * 
 */
package com.bavps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavps.entity.Urukari;
import com.bavps.service.UrukariService;

/**
 * @author Udjanati
 *
 */
@RestController
@RequestMapping("/urukari/visitors")
@CrossOrigin(origins = "http://localhost:3000")
public class UrukariController {
	
	private UrukariService urukariService;

	/**
	 * @param urukariService
	 */
	public UrukariController(UrukariService urukariService) {
		super();
		this.urukariService = urukariService;
	}
	
	@PostMapping
	public ResponseEntity<Urukari> saveVisitors(@RequestBody Urukari urukari){
		return new ResponseEntity<Urukari>(urukariService.saveVisitors(urukari), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Urukari> getAllVisitors(){
		return urukariService.getAllVisitors();
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVisitors(@PathVariable Long id){
		boolean deleted = false;
		deleted = urukariService.deleteVisitors(id);		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Sucessfully!!", deleted);
		return ResponseEntity.ok(response);
	}	

}
