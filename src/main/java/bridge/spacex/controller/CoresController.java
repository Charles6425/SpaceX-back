package bridge.spacex.controller;

import bridge.spacex.model.Cores;
import bridge.spacex.service.CoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CoresController {
    @Autowired
    private CoresService service;

    @GetMapping("/cores/{id}")
    public ResponseEntity<Cores> findById(@PathVariable String id) {
        Cores cores = this.service.findById(id);
        return ResponseEntity.ok(cores);
    }

    @GetMapping("/cores")
    public ResponseEntity<Flux<Cores>> findAll() {
        Flux<Cores> coresFlux = this.service.findAll();
        return ResponseEntity.ok().body(coresFlux);

    }

}
