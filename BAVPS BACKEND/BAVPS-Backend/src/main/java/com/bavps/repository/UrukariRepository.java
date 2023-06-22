/**
 * 
 */
package com.bavps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavps.entity.Urukari;

/**
 * @author Udjanati
 *
 */
@Repository
public interface UrukariRepository extends JpaRepository<Urukari, Long>{

}
