package bridge.spacex.service;

import bridge.spacex.model.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CrewService {
    @Autowired
    private WebClient webClient;

    public Crew findById(String id) {
        Mono<Crew> monoCrew = this.webClient
                .method(HttpMethod.GET)
                .uri("/crew/{id}", id)
                .retrieve()
                .bodyToMono(Crew.class);
        Crew crew = monoCrew.block();
        return crew;
    }

    public Flux<Crew> findAll() {
        Flux<Crew> fluxCrew = this.webClient
                .method(HttpMethod.GET)
                .uri("/crew")
                .retrieve()
                .bodyToFlux(Crew.class);
        return fluxCrew;
    }
}
