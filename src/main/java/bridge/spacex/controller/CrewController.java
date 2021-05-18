package bridge.spacex.controller;

import bridge.spacex.model.Crew;
import bridge.spacex.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CrewController {
    @Autowired
    private CrewService service;

    @GetMapping("/crew/{id}")
    public ResponseEntity<Crew> findById(@PathVariable String id) {
        Crew crew = this.service.findById(id);
        return ResponseEntity.ok(crew);
    }

    @GetMapping("/crew")
    public ResponseEntity<Flux<Crew>> findAll() {
        Flux<Crew> crewFlux = this.service.findAll();
        return ResponseEntity.ok().body(crewFlux);

    }
}
