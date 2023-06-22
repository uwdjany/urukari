package btr.framework.common.service;

public abstract class AbstractRequestException extends RuntimeException{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	public AbstractRequestException() {
		super();
	}
	
	public AbstractRequestException(String message) {
		super(message);
	}
	
	public AbstractRequestException(Exception exception) {
		super(exception);
	}

}
