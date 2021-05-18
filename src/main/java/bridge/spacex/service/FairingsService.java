package bridge.spacex.service;

import bridge.spacex.model.Fairings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FairingsService {
    @Autowired
    private WebClient webClient;

    public Fairings findById(String id) {
        Mono<Fairings> monoFairings = this.webClient
                .method(HttpMethod.GET)
                .uri("/fairings/{id}", id)
                .retrieve()
                .bodyToMono(Fairings.class);
        Fairings fairings = monoFairings.block();
        return fairings;
    }

    public Flux<Fairings> findAll() {
        Flux<Fairings> fluxFairings = this.webClient
                .method(HttpMethod.GET)
                .uri("/fairings")
                .retrieve()
                .bodyToFlux(Fairings.class);
        return fluxFairings;
    }
}
