package bridge.spacex.controller;

import bridge.spacex.model.Landpads;
import bridge.spacex.model.Roadster;
import bridge.spacex.service.RoadsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class RoadsterController {
    @Autowired
    private RoadsterService service;

    @GetMapping("/roadster/{id}")
    public ResponseEntity<Roadster> findById(@PathVariable String id) {
        Roadster roadster = this.service.findById(id);
        return ResponseEntity.ok(roadster);
    }

    @GetMapping("/roadster")
    public ResponseEntity<Flux<Roadster>> findAll() {
        Flux<Roadster> roadsterFlux = this.service.findAll();
        return ResponseEntity.ok().body(roadsterFlux);

    }
}
