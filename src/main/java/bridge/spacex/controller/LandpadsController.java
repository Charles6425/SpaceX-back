package bridge.spacex.controller;

import bridge.spacex.model.Capsules;
import bridge.spacex.model.Landpads;
import bridge.spacex.service.LandpadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LandpadsController {
    @Autowired
    private LandpadsService service;

    @GetMapping("/landpads/{id}")
    public ResponseEntity<Landpads> findById(@PathVariable String id) {
        Landpads landpads = this.service.findById(id);
        return ResponseEntity.ok(landpads);
    }

    @GetMapping("/landpads")
    public ResponseEntity<Flux<Landpads>> findAll() {
        Flux<Landpads> landpadsFlux = this.service.findAll();
        return ResponseEntity.ok().body(landpadsFlux);

    }



}
