/**
 * 
 */
package btr.framework.restsecurity.service;

import btr.framework.common.response.Response;
import btr.framework.restsecurity.domain.Principal;

/**
 * @author IRANZI Aimable
 *
 */
public interface ISecurityService {

	Response<Principal> savePrincipal(final Principal principal);
}
