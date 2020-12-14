package info.dineshkumars.reactivesample.exception;

import java.util.Objects;

public class AppError {

  private int code;
  private String message;

  public AppError(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppError appError = (AppError) o;
    return code == appError.code &&
        Objects.equals(message, appError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }
}
