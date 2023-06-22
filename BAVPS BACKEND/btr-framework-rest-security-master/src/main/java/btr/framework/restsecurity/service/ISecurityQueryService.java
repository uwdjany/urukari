/**
 * 
 */
package btr.framework.restsecurity.service;

import java.util.Optional;

import btr.framework.common.response.Response;
import btr.framework.restsecurity.domain.Principal;

/**
 * @author IRANZI Aimable
 *
 */
public interface ISecurityQueryService {

	Response<Optional<Principal>> findPrincipalByEmailAddress(final String emailAddress);
}
