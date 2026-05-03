package com.kelvson.orchestration.interfaces.controller;

import com.kelvson.orchestration.application.orchestrator.CreateOrderOrchestrator;
import com.kelvson.orchestration.application.orchestrator.DeleteOrderOrchestrator;
import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;
import com.kelvson.orchestration.util.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.ORDER_BASE_PATH)
@RequiredArgsConstructor
public class OrchestrationController {

    private final CreateOrderOrchestrator orchestrator;
    private final DeleteOrderOrchestrator deleteOrderOrchestrator;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateOrderRequest request){
        orchestrator.execute(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id){
        deleteOrderOrchestrator.execute(id);
        return ResponseEntity.ok().build();
    }
}
