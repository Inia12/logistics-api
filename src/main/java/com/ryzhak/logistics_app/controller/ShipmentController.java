package com.ryzhak.logistics_app.controller;

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
    public List<Shipment> getAll() {
        return service.getAll();
    }

    @GetMapping("/client/{name}")
    public List<Shipment> getByClient(@PathVariable String name) {
        return service.getByClient(name);
    }

    @GetMapping("/status/{status}")
    public List<Shipment> getByStatus(@PathVariable String status) {
        return service.getByStatus(Status.valueOf(status));
    }

    @GetMapping("/{id}/status")
    public Shipment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment shipment) {
        return service.create(shipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}