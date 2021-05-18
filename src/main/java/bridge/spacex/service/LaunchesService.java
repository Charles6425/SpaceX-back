package bridge.spacex.service;

import bridge.spacex.model.Launches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class LaunchesService {
    @Autowired
    private WebClient webClient;

    public Launches findById(String id) {
        Mono<Launches> monoLaunches = this.webClient
                .method(HttpMethod.GET)
                .uri("/launches/{id}", id)
                .retrieve()
                .bodyToMono(Launches.class);
        Launches launches = monoLaunches.block();
        return launches;
    }

    public Flux<Launches> findAll() {
        Flux<Launches> fluxLaunches = this.webClient
                .method(HttpMethod.GET)
                .uri("/launches")
                .retrieve()
                .bodyToFlux(Launches.class);
       return fluxLaunches;

    }
}
