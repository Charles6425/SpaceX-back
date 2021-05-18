package bridge.spacex.service;

import bridge.spacex.model.Rockets;
import bridge.spacex.model.Ships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShipsService {
    @Autowired
    private WebClient webClient;

    public Ships findById(String id) {
        Mono<Ships> monoShips = this.webClient
                .method(HttpMethod.GET)
                .uri("/ships/{id}", id)
                .retrieve()
                .bodyToMono(Ships.class);
        Ships ships = monoShips.block();
        return ships;
    }

    public Flux<Ships> findAll() {
        Flux<Ships> fluxShips = this.webClient
                .method(HttpMethod.GET)
                .uri("/ships")
                .retrieve()
                .bodyToFlux(Ships.class);
        return fluxShips;

    }
}
