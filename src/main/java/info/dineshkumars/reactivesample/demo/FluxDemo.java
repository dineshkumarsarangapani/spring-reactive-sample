package info.dineshkumars.reactivesample.demo;

import reactor.core.publisher.Flux;

public class FluxDemo {

  public static void main(String[] args) {
    Iterable<String> stringFlux = Flux.just("something", "chain")
        .map(secret -> secret.replaceAll(".", "*"))
        .subscriberContext(ctx -> ctx.put("name", "dinesh"))
        .checkpoint("ctx")
        .map(item -> item.concat("  -> ctx"))
        .doOnNext(i -> System.out.println("On Subscribe  " + i))
        .toIterable();
    stringFlux.forEach(i -> System.out.println(i));


  }
}
