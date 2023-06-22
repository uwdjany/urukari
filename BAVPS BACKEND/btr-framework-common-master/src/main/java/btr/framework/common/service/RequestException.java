package btr.framework.common.service;

public class RequestException extends AbstractRequestException{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	public RequestException(String message) {
		super(message);
	}
	
	public RequestException() {
		super();
	}
	
	public RequestException(Exception e) {
		super(e);
	}

}
