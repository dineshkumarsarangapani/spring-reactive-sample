package info.dineshkumars.reactivesample.exception;

import info.dineshkumars.reactivesample.writer.DataBufferWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

  @Autowired
  private DataBufferWriter bufferWriter;

  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    AppError appError = ErrorCode.GENERIC;

    if (ex instanceof AppException) {
      AppException ae = (AppException) ex;
      status = ae.getHttpStatus();
      appError = new AppError(ae.getCode(), ae.getMessage());
    } else {

    }

    if (exchange.getResponse().isCommitted()) {
      return Mono.error(ex);
    }

    exchange.getResponse().setStatusCode(status);
    exchange.getResponse().getHeaders().add(HttpHeaders.CONTENT_TYPE,
        MediaType.APPLICATION_JSON_VALUE);
    return bufferWriter.write(exchange.getResponse(), appError);
  }

}
