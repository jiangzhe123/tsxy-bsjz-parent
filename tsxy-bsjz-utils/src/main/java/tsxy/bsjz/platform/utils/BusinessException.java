package tsxy.bsjz.platform.utils;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4879677283847539655L;

    private String errorMessage;
    
    private String exceptionMessage;
    
    private Exception exception;
    
    
    
    public BusinessException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage,
            Exception exception) {
        super();
        this.errorMessage = errorMessage;
        this.exception = exception;
    }
    
    public BusinessException(String errorMessage,String exceptionMessage) {
        super();
        this.exceptionMessage = exceptionMessage;
        this.errorMessage = errorMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
	
	
}
