package bridge.spacex.service;

import bridge.spacex.model.History;
import bridge.spacex.model.Landpads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HistoryServices {
    @Autowired
    private WebClient webClient;

    public History findById(String id) {
        Mono<History> monoHistory = this.webClient
                .method(HttpMethod.GET)
                .uri("/history/{id}", id)
                .retrieve()
                .bodyToMono(History.class);
        History history = monoHistory.block();
        return history;
    }

    public Flux<History> findAll() {
        Flux<History> fluxHistory = this.webClient
                .method(HttpMethod.GET)
                .uri("/history")
                .retrieve()
                .bodyToFlux(History.class);
        return fluxHistory;
    }
}
