/**
 * 
 */
package btr.framework.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Udjanati
 *
 */
@Getter
@Setter
public final class Response<T> {

	private T result;
	
	private String message;
	
	public Response(final T res, final String message) throws Exception {
		this.result = res;
		this.message = message;
		
		if(this.result == null) {
			throw new Exception();
		}
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
