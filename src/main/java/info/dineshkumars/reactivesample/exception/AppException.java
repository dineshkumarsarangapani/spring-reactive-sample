package info.dineshkumars.reactivesample.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

  HttpStatus httpStatus;
  int code;

  public AppException(final String message) {
    super(message);
  }

  public AppException(final String message, Throwable throwable) {
    super(message, throwable);
  }

  public AppException(final String message, Throwable throwable, HttpStatus status, int code) {
    super(message, throwable);
    this.httpStatus = status;
    this.code = code;
  }

  public AppException(final String message, HttpStatus status, int code) {
    super(message);
    this.httpStatus = status;
    this.code = code;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
