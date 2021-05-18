package bridge.spacex.service;

import bridge.spacex.model.Payloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PayloadsService {
    @Autowired
    private WebClient webClient;

    public Payloads findById(String id) {
        Mono<Payloads> monoPayloads = this.webClient
                .method(HttpMethod.GET)
                .uri("/payloads/{id}", id)
                .retrieve()
                .bodyToMono(Payloads.class);
        Payloads payloads = monoPayloads.block();
        return payloads;
    }

    public Flux<Payloads> findAll() {
        Flux<Payloads> fluxPayloads = this.webClient
                .method(HttpMethod.GET)
                .uri("/payloads")
                .retrieve()
                .bodyToFlux(Payloads.class);
        return fluxPayloads;

    }
}
