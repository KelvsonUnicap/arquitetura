package com.kelvson.orchestration.interfaces.controller;

import com.kelvson.orchestration.application.orchestrator.CreateOrderOrchestrator;
import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;
import com.kelvson.orchestration.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstants.ORDER_PATH)
public class OrchestrationController {

    private final CreateOrderOrchestrator orchestrator;

    public OrchestrationController(@Autowired CreateOrderOrchestrator orchestrator){
        this.orchestrator = orchestrator;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateOrderRequest request){
        orchestrator.execute(request);
        return ResponseEntity.ok().build();
    }
}
