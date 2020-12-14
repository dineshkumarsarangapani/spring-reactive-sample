package info.dineshkumars.reactivesample.router;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import info.dineshkumars.reactivesample.controller.DemoController;
import info.dineshkumars.reactivesample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ApplicationRouter {

  @Autowired
  DemoController demoController;

  @Bean
  RouterFunction<ServerResponse> routerFunction() {
    return route()
        .GET("/demo", request -> demoController.getSampleDemo())
        .GET("/demo/list", request -> demoController.getNames())
        .POST("/demo/insert",
            request -> demoController.insertStudent(request.bodyToMono(Student.class)))
        .build();
  }
}
