/**
 * 
 */
package btr.framework.restsecurity.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import btr.framework.restsecurity.domain.Principal;

/**
 * @author IRANZI Aimable
 *
 */
public interface IPrincipalDao extends CrudRepository<Principal, UUID> {

	Optional<Principal> findByEmailAddress(String emailAddress);
}
