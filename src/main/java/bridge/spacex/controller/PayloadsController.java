package bridge.spacex.controller;

import bridge.spacex.model.Launchpads;
import bridge.spacex.model.Payloads;
import bridge.spacex.service.PayloadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PayloadsController {
    @Autowired
    private PayloadsService service;

    @GetMapping("/payloads/{id}")
    public ResponseEntity<Payloads> findById(@PathVariable String id){
        Payloads payloads = this.service.findById(id);
        return ResponseEntity.ok(payloads);
    }

    @GetMapping("/payloads")
    public ResponseEntity<Flux<Payloads>> findAll(){
        Flux<Payloads> payloads = this.service.findAll();
        return ResponseEntity.ok().body(payloads) ;
    }
}
