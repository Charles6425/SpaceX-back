package bridge.spacex.controller;

import bridge.spacex.model.Payloads;
import bridge.spacex.model.Ships;
import bridge.spacex.service.ShipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ShipsController {
    @Autowired
    private ShipsService service;

    @GetMapping("/ships/{id}")
    public ResponseEntity<Ships> findById(@PathVariable String id){
        Ships ships = this.service.findById(id);
        return ResponseEntity.ok(ships);
    }

    @GetMapping("/ships")
    public ResponseEntity<Flux<Ships>> findAll(){
        Flux<Ships> ships = this.service.findAll();
        return ResponseEntity.ok().body(ships) ;
    }
}
