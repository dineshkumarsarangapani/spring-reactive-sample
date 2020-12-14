package info.dineshkumars.reactivesample.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component

public class DataBufferWriter {
  private final ObjectMapper objectMapper;

  public DataBufferWriter(@Autowired ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public <T> Mono<Void> write(ServerHttpResponse httpResponse, T object) {
    return httpResponse
        .writeWith(Mono.fromSupplier(() -> {

          DataBufferFactory bufferFactory = httpResponse.bufferFactory();

          try {
            return bufferFactory.wrap(objectMapper.writeValueAsBytes(object));
          } catch (Exception ex) {
            return bufferFactory.wrap(new byte[0]);
          }
        }));
  }
}
