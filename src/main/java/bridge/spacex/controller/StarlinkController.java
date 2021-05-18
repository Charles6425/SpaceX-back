package bridge.spacex.controller;

import bridge.spacex.model.Ships;
import bridge.spacex.model.Starlink;
import bridge.spacex.service.StarlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StarlinkController {
    @Autowired
    private StarlinkService service;

    @GetMapping("/starlink/{id}")
    public ResponseEntity<Starlink> findById(@PathVariable String id){
        Starlink starlink = this.service.findById(id);
        return ResponseEntity.ok(starlink);
    }

    @GetMapping("/starlink")
    public ResponseEntity<Flux<Starlink>> findAll(){
        Flux<Starlink> starlink = this.service.findAll();
        return ResponseEntity.ok().body(starlink) ;
    }
}
