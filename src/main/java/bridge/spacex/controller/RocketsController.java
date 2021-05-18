package bridge.spacex.controller;

import bridge.spacex.model.Capsules;
import bridge.spacex.model.Rockets;
import bridge.spacex.service.RocketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class RocketsController {
    @Autowired
    private RocketsService service;

    @GetMapping("/rockets/{id}")
    public ResponseEntity<Rockets> findById(@PathVariable String id) {
        Rockets rockets = this.service.findById(id);
        return ResponseEntity.ok(rockets);
    }

    @GetMapping("/rockets")
    public ResponseEntity<Flux<Rockets>> findAll() {
        Flux<Rockets> rocketsFlux = this.service.findAll();
        return ResponseEntity.ok().body(rocketsFlux);

    }
}
