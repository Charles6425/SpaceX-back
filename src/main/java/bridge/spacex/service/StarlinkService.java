package bridge.spacex.service;

import bridge.spacex.model.Ships;
import bridge.spacex.model.Starlink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StarlinkService {
    @Autowired
    private WebClient webClient;

    public Starlink findById(String id) {
        Mono<Starlink> monoStarlink = this.webClient
                .method(HttpMethod.GET)
                .uri("/starlink/{id}", id)
                .retrieve()
                .bodyToMono(Starlink.class);
        Starlink starlink = monoStarlink.block();
        return starlink;
    }

    public Flux<Starlink> findAll() {
        Flux<Starlink> fluxStarlink = this.webClient
                .method(HttpMethod.GET)
                .uri("/starlink")
                .retrieve()
                .bodyToFlux(Starlink.class);
        return fluxStarlink;

    }
}
