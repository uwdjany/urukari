/**
 * 
 */
package btr.framework.common.service;

import btr.framework.common.exception.AbstractRequestException;
import btr.framework.common.exception.RequestException;

/**
 * @author Udjanati
 *
 */
public class AbstractService {

	public AbstractRequestException handleException(final Exception e, String message) {
		if(e instanceof AbstractRequestException) {
			return (AbstractRequestException) e;
		}
		return new RequestException(message);
	}
}
