package com.ryzhak.logistics_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import com.ryzhak.logistics_app.dto.ShipmentRequest;
import com.ryzhak.logistics_app.dto.ShipmentResponse;
import jakarta.validation.Valid;

import com.ryzhak.logistics_app.model.Shipment;
import com.ryzhak.logistics_app.model.Status;
import com.ryzhak.logistics_app.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShipmentResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        return service.getAll(page, size);
    }

    @GetMapping("/client/{name}")
    public List<Shipment> getByClient(@PathVariable String name) {
        return service.getByClient(name);
    }

    @GetMapping("/status/{status}")
    public List<Shipment> getByStatus(@PathVariable String status) {
        return service.getByStatus(Status.valueOf(status));
    }

    @PatchMapping("/{id}/status")
    public Shipment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @Operation(summary = "Create new shipment")

    @ApiResponse(
            responseCode = "201",
            description = "Shipment successfully created"
    )

    @PostMapping
    public ResponseEntity<ShipmentResponse> create(
            @Valid @RequestBody ShipmentRequest request) {

        return ResponseEntity.status(201)
                .body(service.create(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}