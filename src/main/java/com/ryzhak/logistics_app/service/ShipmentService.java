package com.ryzhak.logistics_app.service;

import com.ryzhak.logistics_app.model.Shipment;
import com.ryzhak.logistics_app.model.Status;
import com.ryzhak.logistics_app.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public Shipment create(Shipment shipment) {
        shipment.setStatus(Status.CREATED);
        shipment.setCreatedAt(LocalDateTime.now());
        return repository.save(shipment);
    }

    public List<Shipment> getAll() {
        return repository.findAll();
    }

    public List<Shipment> getByClient(String name) {
        return repository.findByClientNameIgnoreCase(name);
    }

    public List<Shipment> getByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Shipment updateStatus(Long id, String status) {

        Shipment shipment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        try {
            shipment.setStatus(Status.valueOf(status));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status");
        }

        return repository.save(shipment);
    }


}