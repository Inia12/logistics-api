package com.ryzhak.logistics_app.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ryzhak.logistics_app.dto.ShipmentRequest;
import com.ryzhak.logistics_app.dto.ShipmentResponse;

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

    public ShipmentResponse create(ShipmentRequest request) {

        Shipment shipment = new Shipment();

        shipment.setClientName(request.getClientName());
        shipment.setAddress(request.getAddress());

        shipment.setStatus(Status.CREATED);
        shipment.setCreatedAt(LocalDateTime.now());

        Shipment savedShipment = repository.save(shipment);

        ShipmentResponse response = new ShipmentResponse();

        response.setId(savedShipment.getId());
        response.setClientName(savedShipment.getClientName());
        response.setAddress(savedShipment.getAddress());
        response.setStatus(savedShipment.getStatus());
        response.setCreatedAt(savedShipment.getCreatedAt());

        return response;
    }

    public List<ShipmentResponse> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        List<Shipment> shipments =
                repository.findAll(pageable).getContent();

        return shipments.stream().map(shipment -> {

            ShipmentResponse response = new ShipmentResponse();

            response.setId(shipment.getId());
            response.setClientName(shipment.getClientName());
            response.setAddress(shipment.getAddress());
            response.setStatus(shipment.getStatus());
            response.setCreatedAt(shipment.getCreatedAt());

            return response;

        }).toList();
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