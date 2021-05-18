package bridge.spacex.controller;

import bridge.spacex.model.Capsules;
import bridge.spacex.model.Fairings;
import bridge.spacex.service.FairingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FairingsController {
    @Autowired
    private FairingsService service;

    @GetMapping("/fairings/{id}")
    public ResponseEntity<Fairings> findById(@PathVariable String id) {
        Fairings fairings = this.service.findById(id);
        return ResponseEntity.ok(fairings);
    }

    @GetMapping("/fairings")
    public ResponseEntity<Flux<Fairings>> findAll() {
        Flux<Fairings> fairingsFlux = this.service.findAll();
        return ResponseEntity.ok().body(fairingsFlux);

    }
}
