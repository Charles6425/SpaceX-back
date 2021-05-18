package bridge.spacex.service;

import bridge.spacex.model.Dragons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DragonsService {
    @Autowired
    private WebClient webClient;

    public Dragons findById(String id) {
        Mono<Dragons> monoDragons = this.webClient
                .method(HttpMethod.GET)
                .uri("/dragons/{id}", id)
                .retrieve()
                .bodyToMono(Dragons.class);
        Dragons dragons = monoDragons.block();
        return dragons;
    }

    public Flux<Dragons> findAll() {
        Flux<Dragons> fluxDragons = this.webClient
                .method(HttpMethod.GET)
                .uri("/dragons")
                .retrieve()
                .bodyToFlux(Dragons.class);
        return fluxDragons;

    }
}
