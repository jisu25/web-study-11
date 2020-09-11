package web_study_11.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class CustomSQLException extends RuntimeException {

	public CustomSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomSQLException(Throwable cause) {
		super(cause);
	}

}