package exceptions;

public class HoldYourHorsesException extends RuntimeException {

	public HoldYourHorsesException(String message) {
		super(message);
	}

	public HoldYourHorsesException(Throwable cause) {
		super(cause);
	}
}
