package bridge.spacex.controller;

import bridge.spacex.model.Launches;
import bridge.spacex.model.Launchpads;
import bridge.spacex.service.LaunchesService;
import bridge.spacex.service.LaunchpadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LaunchpadsController {
    @Autowired
    private LaunchpadsService service;

    @GetMapping("/launchpads/{id}")
    public ResponseEntity<Launchpads> findById(@PathVariable String id){
        Launchpads launchpads = this.service.findById(id);
        return ResponseEntity.ok(launchpads);
    }

    @GetMapping("/launchpads")
    public ResponseEntity<Flux<Launchpads>> findAll(){
        Flux<Launchpads> launchpads = this.service.findAll();
        return ResponseEntity.ok().body(launchpads) ;
    }
}
