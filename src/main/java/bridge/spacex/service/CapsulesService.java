package bridge.spacex.service;

import bridge.spacex.model.Capsules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CapsulesService {
    @Autowired
    private WebClient webClient;

    public Capsules findById(String id) {
        Mono<Capsules> monoCapsules = this.webClient
                .method(HttpMethod.GET)
                .uri("/capsules/{id}", id)
                .retrieve()
                .bodyToMono(Capsules.class);
        Capsules capsules = monoCapsules.block();
        return capsules;
    }

    public Flux<Capsules> findAll() {
        Flux<Capsules> fluxCapsules = this.webClient
                .method(HttpMethod.GET)
                .uri("/capsules")
                .retrieve()
                .bodyToFlux(Capsules.class);
        return fluxCapsules;
    }

}
