/**
 * 
 */
package btr.framework.restsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class SecurityService extends AbstractService implements ISecurityService {

	@Autowired IPrincipalDao principalDao;
	
	@Override
	public Response<Principal> savePrincipal(Principal principal) {
		try {
			if(principal.isNew()) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String password = passwordEncoder.encode(principal.getPassword());
				principal.setPassword(password);
			}
			return new Response<>(principalDao.save(principal), "saved");
		} catch (Exception e) {
			throw handleException(e, "not saved");
		}
	}
}
