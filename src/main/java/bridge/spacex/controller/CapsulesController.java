package bridge.spacex.controller;

import bridge.spacex.model.Capsules;
import bridge.spacex.service.CapsulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class CapsulesController {
    @Autowired
    private CapsulesService service;

    @GetMapping("/capsules/{id}")
    public ResponseEntity<Capsules> findById(@PathVariable String id) {
        Capsules capsules = this.service.findById(id);
        return ResponseEntity.ok(capsules);
    }

    @GetMapping("/capsules")
    public ResponseEntity<Flux<Capsules>> findAll() {
        Flux<Capsules> capsulesFlux = this.service.findAll();
        return ResponseEntity.ok().body(capsulesFlux);

    }


}
