package bridge.spacex.service;

import bridge.spacex.model.Launches;
import bridge.spacex.model.Launchpads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LaunchpadsService {
    @Autowired
    private WebClient webClient;

    public Launchpads findById(String id) {
        Mono<Launchpads> monoLaunchpads = this.webClient
                .method(HttpMethod.GET)
                .uri("/launchpads/{id}", id)
                .retrieve()
                .bodyToMono(Launchpads.class);
        Launchpads launchpads = monoLaunchpads.block();
        return launchpads;
    }

    public Flux<Launchpads> findAll() {
        Flux<Launchpads> fluxLaunchpads = this.webClient
                .method(HttpMethod.GET)
                .uri("/launchpads")
                .retrieve()
                .bodyToFlux(Launchpads.class);
        return fluxLaunchpads;

    }
}
