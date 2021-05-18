package bridge.spacex.controller;

import bridge.spacex.model.Fairings;
import bridge.spacex.model.History;
import bridge.spacex.service.HistoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HistoryController {
    @Autowired
    private HistoryServices service;

    @GetMapping("/history/{id}")
    public ResponseEntity<History> findById(@PathVariable String id) {
        History history = this.service.findById(id);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/history")
    public ResponseEntity<Flux<History>> findAll() {
        Flux<History> historyFlux = this.service.findAll();
        return ResponseEntity.ok().body(historyFlux);

    }
}
