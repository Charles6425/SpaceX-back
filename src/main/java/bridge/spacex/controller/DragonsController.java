package bridge.spacex.controller;

import bridge.spacex.model.Dragons;
import bridge.spacex.service.DragonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DragonsController {
    @Autowired
    private DragonsService service;

    @GetMapping("/dragons/{id}")
    public ResponseEntity<Dragons> findById(@PathVariable String id) {
        Dragons dragons = this.service.findById(id);
        return ResponseEntity.ok(dragons);
    }

    @GetMapping("/dragons")
    public ResponseEntity<Flux<Dragons>> findAll() {
        Flux<Dragons> dragonsFlux = this.service.findAll();
        return ResponseEntity.ok().body(dragonsFlux);

    }
}
