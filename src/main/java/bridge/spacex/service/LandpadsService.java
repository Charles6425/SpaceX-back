package bridge.spacex.service;

import bridge.spacex.model.Landpads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LandpadsService {
    @Autowired
    private WebClient webClient;

    public Landpads findById(String id) {
        Mono<Landpads> monoLandpads = this.webClient
                .method(HttpMethod.GET)
                .uri("/landpads/{id}", id)
                .retrieve()
                .bodyToMono(Landpads.class);
        Landpads landpads = monoLandpads.block();
        return landpads;
    }

    public Flux<Landpads> findAll() {
        Flux<Landpads> fluxLandpads = this.webClient
                .method(HttpMethod.GET)
                .uri("/landpads")
                .retrieve()
                .bodyToFlux(Landpads.class);
        return fluxLandpads;
    }
}
