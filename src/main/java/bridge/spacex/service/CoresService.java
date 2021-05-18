package bridge.spacex.service;

import bridge.spacex.model.Cores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoresService {
    @Autowired
    private WebClient webClient;

    public Cores findById(String id) {
        Mono<Cores> monoCores = this.webClient
                .method(HttpMethod.GET)
                .uri("/cores/{id}", id)
                .retrieve()
                .bodyToMono(Cores.class);
        Cores cores = monoCores.block();
        return cores;
    }

    public Flux<Cores> findAll() {
        Flux<Cores> fluxCores = this.webClient
                .method(HttpMethod.GET)
                .uri("/cores")
                .retrieve()
                .bodyToFlux(Cores.class);
        return fluxCores;
    }

}
