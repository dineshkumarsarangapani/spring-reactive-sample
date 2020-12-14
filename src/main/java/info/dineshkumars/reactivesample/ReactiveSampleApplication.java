package info.dineshkumars.reactivesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class ReactiveSampleApplication {

  public static void main(String[] args) {
    ReactorDebugAgent.init();
    SpringApplication.run(ReactiveSampleApplication.class, args);
  }

  //public MongoClients getReactiveMongoFactor(){
  //new MongoClients.create()
  //}

}
