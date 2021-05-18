package bridge.spacex.controller;

import bridge.spacex.model.Launches;
import bridge.spacex.service.LaunchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LaunchesController {
    @Autowired
    private LaunchesService service;

    @GetMapping("/launches/{id}")
    public ResponseEntity<Launches> findById(@PathVariable String id){
        Launches launches = this.service.findById(id);
        return ResponseEntity.ok(launches);
    }

    @GetMapping("/launches")
    public ResponseEntity<Flux<Launches>> findAll(){
        Flux<Launches> launchesModel = this.service.findAll();
        return ResponseEntity.ok().body(launchesModel) ;
    }


}
