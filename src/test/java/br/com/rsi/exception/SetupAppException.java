package br.com.rsi.exception;

public class SetupAppException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 6895589724249369135L;

	/**
	 * @param message
	 *            - String
	 */
	public SetupAppException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 *            - String
	 */
	public SetupAppException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            - String
	 * @param cause
	 *            - Throwable
	 */
	public SetupAppException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
