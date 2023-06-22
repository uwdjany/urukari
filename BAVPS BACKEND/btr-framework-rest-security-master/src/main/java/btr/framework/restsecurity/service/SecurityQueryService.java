/**
 * 
 */
package btr.framework.restsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import btr.framework.common.response.Response;
import btr.framework.common.service.AbstractService;
import btr.framework.restsecurity.dao.IPrincipalDao;
import btr.framework.restsecurity.domain.Principal;

/**
 * @author IRANZI Aimable
 *
 */
@Service
@Transactional
public class SecurityQueryService extends AbstractService implements ISecurityQueryService {

	@Autowired
	private IPrincipalDao principalDao;
	
	@Override
	public Response<Optional<Principal>> findPrincipalByEmailAddress(final String emailAddress) {
		try {
			return new Response<>(principalDao.findByEmailAddress(emailAddress), "found");
		} catch (Exception e) {
			throw handleException(e, "Not found");
		}
	}
}
