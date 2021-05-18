package bridge.spacex.service;

import bridge.spacex.model.Roadster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoadsterService {
    @Autowired
    private WebClient webClient;

    public Roadster findById(String id) {
        Mono<Roadster> monoRoadster = this.webClient
                .method(HttpMethod.GET)
                .uri("/roadster/{id}", id)
                .retrieve()
                .bodyToMono(Roadster.class);
        Roadster roadster = monoRoadster.block();
        return roadster;
    }

    public Flux<Roadster> findAll() {
        Flux<Roadster> fluxRoadster = this.webClient
                .method(HttpMethod.GET)
                .uri("/roadster")
                .retrieve()
                .bodyToFlux(Roadster.class);
        return fluxRoadster;

    }
}
