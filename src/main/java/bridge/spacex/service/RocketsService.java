package bridge.spacex.service;

import bridge.spacex.model.Roadster;
import bridge.spacex.model.Rockets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RocketsService {
    @Autowired
    private WebClient webClient;

    public Rockets findById(String id) {
        Mono<Rockets> monoRockets = this.webClient
                .method(HttpMethod.GET)
                .uri("/rockets/{id}", id)
                .retrieve()
                .bodyToMono(Rockets.class);
        Rockets rockets = monoRockets.block();
        return rockets;
    }

    public Flux<Rockets> findAll() {
        Flux<Rockets> fluxRockets = this.webClient
                .method(HttpMethod.GET)
                .uri("/rockets")
                .retrieve()
                .bodyToFlux(Rockets.class);
        return fluxRockets;

    }
}
